package com.github.hqh.mgm.application.impl;

import com.github.hqh.mgm.application.AccountTrans;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountRepository;
import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountTransImpl implements AccountTrans {

    @Autowired
    MoneyAccountRepository moneyAccountRepository;

    @Transactional
    public void saveMoney(MoneyMoneyAccount source, MoneyMoneyAccount dest) {
        moneyAccountRepository.save(source);
        moneyAccountRepository.save(dest);
    }

    @Transactional
    public void saveMoney(MoneyMoneyAccount moneyAccount) {
        moneyAccountRepository.save(moneyAccount);
    }
}
