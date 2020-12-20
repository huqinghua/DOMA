package com.github.hqh.mgm.persistence;

import org.springframework.stereotype.Component;

import com.github.hqh.mgm.domain.pointsaccount.FreezePoints;
import com.github.hqh.mgm.domain.pointsaccount.Points;
import com.github.hqh.mgm.domain.user.UserId;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class FreezePointsBuilder {
    public FreezePoints toPointsFreeze(FreezePointsDO freezePointsDO) {
        return new FreezePoints(freezePointsDO.getId(),
                new UserId(freezePointsDO.getUserId()), new Points(freezePointsDO.getFreezePoint()), freezePointsDO.getDel());
    }

    public FreezePointsDO fromFreezePoints(FreezePoints points) {
        return new FreezePointsDO(points.getId(),
                points.getUserId().getId(), points.getPoints().getAmount(), points.getDel());
    }
}

