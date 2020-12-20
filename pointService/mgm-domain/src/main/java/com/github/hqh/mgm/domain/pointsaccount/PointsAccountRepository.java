package com.github.hqh.mgm.domain.pointsaccount;

import com.github.hqh.mgm.domain.user.UserId;

/**
 * @author ：huqinghua
 * @description：
 */
public interface PointsAccountRepository {
    PointsAccountAccount find(UserId userId);
    PointsAccountAccount save(PointsAccountAccount pointsAccount);
    PointsAccountAccount find(Long id);
}
