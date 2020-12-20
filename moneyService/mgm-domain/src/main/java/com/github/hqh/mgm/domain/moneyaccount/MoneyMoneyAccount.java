package com.github.hqh.mgm.domain.moneyaccount;

import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.util.Assert;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author ：huqinghua
 * @description：
 */
@Getter
@AllArgsConstructor
public class MoneyMoneyAccount implements IMoneyAccount {
    private MoneyAccountId id;
    private UserId userId;
    private Money money;

    @Override
    public void deposit(Money money) {
    	Assert.isTrue(money.isBiggerThan(0L), "ERROR：存钱金额<0");
    	
        this.money = this.money.add(money);
    }

    @Override
    public void withdraw(Money money) {
    	Assert.isTrue(money.isBiggerThan(0L), "ERROR：取款金额<=0");
    	Assert.isTrue(this.money.isNotLessThan(money), "ERROR：取款超支");

        this.money = this.money.sub(money);
    }
}
