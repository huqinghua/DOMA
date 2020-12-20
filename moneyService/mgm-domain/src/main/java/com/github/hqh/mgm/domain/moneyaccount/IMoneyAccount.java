package com.github.hqh.mgm.domain.moneyaccount;

/**
 * @author ：huqinghua
 * @description：
 */
public interface IMoneyAccount {
    void deposit(Money money);

    void withdraw(Money money);
}
