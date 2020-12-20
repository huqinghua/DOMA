package com.github.hqh.mgm.domain.moneyaccount;

/**
 * @author ：huqinghua
 * @description：
 */
public interface IMoneyAccount {
    void deposit(Long id, Money money);

    void withdraw(Money money);
}
