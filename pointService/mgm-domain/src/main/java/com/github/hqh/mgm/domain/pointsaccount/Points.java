package com.github.hqh.mgm.domain.pointsaccount;

import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;

import lombok.Getter;

/**
 * @author ：huqinghua
 * @description：
 */
@Getter
public class Points implements Comparable<Points> {
    private Long amount;

    public Points(Long amount) {
    	if (amount < 0) {
    		throw new MgmException(MgmErrorCode.CHECK_PARAMS_ERR);
    	}
        this.amount = amount;
    }

    public Points(int amount) {
        this.amount = Long.valueOf(amount);
    }

    public Points add(Points points) {
        return new Points(this.amount + points.amount);
    }

    public Points sub(Points points) {
        return new Points(this.amount - points.amount);
    }

    @Override
    public int compareTo(Points o) {
        return amount.compareTo(o.getAmount());
    }
}
