package com.github.hqh.mgm.domain.moneyaccount;

import com.github.hqh.mgm.domain.user.UserId;

/**
 * @author ：huqinghua
 * @description：
 */
public interface MoneyAccountRepository {
    MoneyMoneyAccount find(MoneyAccountId id);
    MoneyMoneyAccount find(UserId userId);
    MoneyMoneyAccount save(MoneyMoneyAccount moneyAccount);
}
