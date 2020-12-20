package com.github.hqh.mgm.domain.moneyaccount;

import com.github.hqh.mgm.domain.user.UserId;

/**
 * @author ：huqinghua
 * @description：
 */
public interface MoneyAccountRemoteRepository {
    IMoneyAccount find(MoneyAccountId id);
    IMoneyAccount find(UserId userId);
    IMoneyAccount save(IMoneyAccount account);
}
