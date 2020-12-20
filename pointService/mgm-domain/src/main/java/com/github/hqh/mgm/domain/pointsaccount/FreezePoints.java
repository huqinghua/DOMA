package com.github.hqh.mgm.domain.pointsaccount;

import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;

import com.github.hqh.mgm.domain.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：huqinghua
 * @description：
 */
@Data
@AllArgsConstructor
public class FreezePoints {

    private Long id;
    private UserId userId;
    private Points points;
    private Boolean del;


    public void addPoint(Points points) {
        this.points = this.points.add(points);
    }

    public void subPoint(Points points) {
        if (this.points.compareTo(points) < 0) {
            throw new MgmException(MgmErrorCode.POINTS_OVERRUN);
        }

        this.points = this.points.sub(points);
    }
}

