package com.github.hqh.mgm.application.impl;

import com.github.hqh.mgm.application.AccountSerivce;
import com.github.hqh.mgm.common.transaction.Procedure;
import com.github.hqh.mgm.common.transaction.TransactionHelper;
import com.github.hqh.mgm.domain.moneyaccount.Money;
import com.github.hqh.mgm.domain.message.DepositResultMessage;
import com.github.hqh.mgm.domain.message.DepositResultMessageProducer;
import com.github.hqh.mgm.domain.MoneyAccountDomainService;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountRepository;
import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @auther huqinghua
 */
@Service
public class AccountSerivceImpl implements AccountSerivce {
	
	@Autowired
	MoneyAccountDomainService moneyAccountDomainService;
	
    @Autowired
    private PlatformTransactionManager transactionManager;
    
    @Autowired
	MoneyAccountRepository moneyAccountRepository;

    @Autowired
	DepositResultMessageProducer depositResultMessageProducer;

	
    /**
     * 转账 
     */
	@Override
	public void transferMoney(MoneyMoneyAccount source, MoneyMoneyAccount dest, Money money) {
		moneyAccountDomainService.transferMoney(source, dest, money);
		
        TransactionHelper.processAroundTransaction(transactionManager, new Procedure() {
        	@Override
        	public void process() {
            	moneyAccountRepository.save(source);
            	moneyAccountRepository.save(dest);
        	}
        });
	}
	
	@Override
	public void deposit(Long id, MoneyMoneyAccount moneyAccount, Money money) {
		moneyAccount.deposit(money);
		
        TransactionHelper.processAroundTransaction(transactionManager, new Procedure() {
        	@Override
        	public void process() {
        		moneyAccountRepository.save(moneyAccount);
        	}
        });

		// 发送成功消息
		DepositResultMessage message = new DepositResultMessage(id, moneyAccount.getUserId(),
				 money, Boolean.TRUE);
		depositResultMessageProducer.send(message);
	}
	
}
