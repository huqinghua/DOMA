package com.github.hqh.mgm.persistence;


import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountId;
import com.github.hqh.mgm.domain.moneyaccount.Money;
import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class AccountBuilder {
    public MoneyMoneyAccount toAccount(AccountDO accountDO) {
        return new MoneyMoneyAccount(new MoneyAccountId(accountDO.getId()),
                new UserId(accountDO.getUserId()), new Money(accountDO.getCurrency()));
    }

    public AccountDO fromAccount(MoneyMoneyAccount moneyAccount) {
        return new AccountDO(moneyAccount.getId().getValue(),
                moneyAccount.getUserId().getId(), moneyAccount.getMoney().getValue());
    }
}
