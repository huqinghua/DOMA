package com.github.hqh.mgm.application;

import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;

public interface AccountTrans {
    void saveMoney(MoneyMoneyAccount source, MoneyMoneyAccount dest);
    void saveMoney(MoneyMoneyAccount moneyAccount);
}
