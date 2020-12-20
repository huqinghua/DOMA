package com.github.hqh.mgm.application.impl;

import com.github.hqh.mgm.application.PointsService;
import com.github.hqh.mgm.common.transaction.Procedure;
import com.github.hqh.mgm.common.transaction.TransactionHelper;
import com.github.hqh.mgm.domain.*;
import com.github.hqh.mgm.domain.message.DepositMessage;
import com.github.hqh.mgm.domain.message.DepositMessageProducer;
import com.github.hqh.mgm.domain.moneyaccount.IMoneyAccount;
import com.github.hqh.mgm.domain.moneyaccount.Money;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountRemoteRepository;
import com.github.hqh.mgm.domain.pointsaccount.*;
import com.github.hqh.mgm.domain.user.IUser;
import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.math.BigDecimal;

/**
 * 积分兑换
 * @auther huqinghua
 */
@Service
public class PointsServiceImpl implements PointsService {

    @Autowired
    private PointsAccountRepository pointsAccountRepository;

    @Autowired
    private FreezePointsRepository freezePointsRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;
    
    @Autowired
    private DepositMessageProducer depositMessageProducer;

    @Autowired
    private MoneyAccountRemoteRepository accountRpc;
    
    static final BigDecimal exchangeMoney2Point = new BigDecimal(100);
    
    /**
     * 积分兑换
     */
    @Override
    public void redeemPoints(IUser user, Points points) {
        UserId userId = user.getUserId();

        // 积分兑现
        ExchangeRate exchangeRate = new ExchangeRate(exchangeMoney2Point);
        Money money = exchangeRate.exchangeTo(points);

        PointsAccountAccount pointsAccount = pointsAccountRepository.find(userId);
        pointsAccount.subPoint(points);

        FreezePoints freezePoints = new FreezePoints(null, userId, points, Boolean.FALSE);

        // 冻结积分
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            pointsAccountRepository.save(pointsAccount);
            freezePoints = freezePointsRepository.save(freezePoints);
            transactionManager.commit(status);
        } catch (Throwable throwable) {
            transactionManager.rollback(status);
            throw throwable;
        }

        // 调用资金服务
        IMoneyAccount account = accountRpc.find(userId);
        account.deposit(freezePoints.getId(), money);
    }

    /**
     * 积分兑换
     */
    @Override
    public void redeemPointsAsyn(IUser user, Points points) {
        UserId userId = user.getUserId();

        // 积分兑现
        ExchangeRate exchangeRate = new ExchangeRate(exchangeMoney2Point);
        Money money = exchangeRate.exchangeTo(points);

        PointsAccountAccount pointsAccount = pointsAccountRepository.find(userId);
        pointsAccount.subPoint(points);

        FreezePoints freezePoints = new FreezePoints(null, userId, points, Boolean.FALSE);

        // 冻结积分
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            pointsAccountRepository.save(pointsAccount);
            freezePoints = freezePointsRepository.save(freezePoints);
            transactionManager.commit(status);
        } catch (Throwable throwable) {
            transactionManager.rollback(status);
            throw throwable;
        }

        // 向资金服务发消息，给用户增加金额
        DepositMessage message = new DepositMessage(freezePoints.getId(), freezePoints.getUserId(), money);
        depositMessageProducer.send(message);

    }

    @Override
    public void redeemPointsResultProcess(Long processId, UserId userId, Boolean status) {
        FreezePoints freezePoints = freezePointsRepository.find(processId);
        PointsAccountAccount pointsAccount = pointsAccountRepository.find(userId);

        TransactionHelper.processAroundTransaction(transactionManager, new Procedure() {
            @Override
            public void process() {
                if (!status) {
                    // 恢复积分
                    pointsAccount.addPoint(freezePoints.getPoints());
                }
                freezePoints.setDel(Boolean.TRUE);

                pointsAccountRepository.save(pointsAccount);
                freezePointsRepository.save(freezePoints);
            }
        });
    }

}
