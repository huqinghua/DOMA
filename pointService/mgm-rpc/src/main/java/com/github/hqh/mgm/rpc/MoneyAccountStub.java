package com.github.hqh.mgm.rpc;

import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountId;
import com.github.hqh.mgm.domain.moneyaccount.IMoneyAccount;
import com.github.hqh.mgm.domain.moneyaccount.Money;
import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：huqinghua
 * @description：
 */
public class MoneyAccountStub implements IMoneyAccount {
    private MoneyAccountId id;
    private UserId userId;
    private Money money;

    @Override
    public void deposit(Long id, Money money) {
        Assert.isTrue(money.isBiggerThan(0L), "ERROR：存钱金额<0");

        this.money = this.money.add(money);

        // 调用资金服务保持money
        RestTemplate restTemplate = new RestTemplate();
        DepositVO depositVO = new DepositVO();
        depositVO.setId(id);
        depositVO.setMoney(money.getValue());
        depositVO.setUserId(userId.getId());
        restTemplate.postForObject("http://HELLO-SERVICE/money/deposit", depositVO, String.class);

        // todo 判断结果
    }

    @Override
    public void withdraw(Money money) {
        Assert.isTrue(money.isBiggerThan(0L), "ERROR：取款金额<=0");
        Assert.isTrue(this.money.isNotLessThan(money), "ERROR：取款超支");

        // todo 调用资金服务取现
//        RestTemplate restTemplate = new RestTemplate();
    }
}
