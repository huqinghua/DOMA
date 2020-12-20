package com.github.hqh.mgm.application;

import com.github.hqh.mgm.domain.user.IUser;
import com.github.hqh.mgm.domain.pointsaccount.Points;
import com.github.hqh.mgm.domain.user.UserId;

/**
 * @Description: 
 * @author huqinghua
 */
public interface PointsService {
    /**
     * 积分兑现
     */
    void redeemPoints(IUser user, Points points);

    void redeemPointsAsyn(IUser user, Points points);

    void redeemPointsResultProcess(Long processId, UserId userId, Boolean status);
}
