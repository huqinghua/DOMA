package com.github.hqh.mgm.persistence;


import com.github.hqh.mgm.domain.pointsaccount.Points;
import com.github.hqh.mgm.domain.pointsaccount.PointsAccountAccount;
import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class PointsBuilder {
    public PointsAccountAccount toPoints(PointsDO pointsDO) {
        return new PointsAccountAccount(pointsDO.getId(),
                new UserId(pointsDO.getUserId()), new Points(pointsDO.getPoint()));
    }

    public PointsDO fromPoints(PointsAccountAccount pointsAccount) {
        return new PointsDO(pointsAccount.getId(),
                pointsAccount.getUserId().getId(), pointsAccount.getPoints().getAmount());
    }
}
