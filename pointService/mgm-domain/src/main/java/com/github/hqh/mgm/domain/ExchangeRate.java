package com.github.hqh.mgm.domain;


import com.github.hqh.mgm.domain.moneyaccount.Money;
import com.github.hqh.mgm.domain.pointsaccount.Points;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author ：huqinghua
 * @description：
 */
@Getter
public class ExchangeRate {
    private final BigDecimal exchangeMoney2Point;

    public ExchangeRate(BigDecimal exchangeMoney2Point) {
        this.exchangeMoney2Point = exchangeMoney2Point;
    }


    public Money exchangeTo(Points points) {
        Long pointsCount = points.getAmount();
        BigDecimal amount = new BigDecimal(pointsCount);
        BigDecimal sourceAmount = amount.divide(exchangeMoney2Point);
        return new Money(sourceAmount);
    }
}
