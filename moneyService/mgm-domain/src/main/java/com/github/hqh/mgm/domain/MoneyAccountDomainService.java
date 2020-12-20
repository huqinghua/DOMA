package com.github.hqh.mgm.domain;

import com.github.hqh.mgm.domain.moneyaccount.Money;
import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;
import org.springframework.stereotype.Service;

/**
 * @author ：huqinghua
 * @description：
 */

@Service
public class MoneyAccountDomainService {
	public void transferMoney(MoneyMoneyAccount source, MoneyMoneyAccount dest, Money money) {
		source.withdraw(money);
		source.deposit(money);
	}
}
