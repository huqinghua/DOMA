package com.github.hqh.mgm.domain.moneyaccount;

import lombok.Getter;

/**
 * @author ：huqinghua
 * @description：
 */
@Getter
public class MoneyAccountId {
    private final Long value;

    public MoneyAccountId(Long value) {
        this.value = value;
    }
}
