package com.github.hqh.mgm.application;

import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;
import com.github.hqh.mgm.domain.moneyaccount.Money;

/**
 * @auther huqinghua
 */
public interface AccountSerivce {
	void transferMoney(MoneyMoneyAccount source, MoneyMoneyAccount dest, Money money);
	void deposit(Long id, MoneyMoneyAccount moneyAccount, Money money);
}
