package com.github.hqh.mgm.domain.moneyaccount;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author ：huqinghua
 * @description：
 */

@Getter
public class Money {
    private final BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value;
    }

    public Money add(Money money) {
        return new Money(value.add(money.value));
    }

    public Money sub(Money money) {
        return new Money(value.subtract(money.value));
    }

    public Boolean isNotLessThan(Long fen) {
    	return value.compareTo(new BigDecimal(fen)) >= 0;
    }
    
    public Boolean isBiggerThan(Long fen) {
    	return value.compareTo(new BigDecimal(fen)) > 0;
    }
    
    public Boolean isBiggerThan(Money money) {
    	return value.compareTo(money.value) > 0;
    }
    
    public Boolean isNotLessThan(Money money) {
    	return value.compareTo(money.value) >= 0;
    }
}
