package com.github.hqh.mgm.domain.pointsaccount;

import com.github.hqh.mgm.domain.user.UserId;

/**
 * @author ：huqinghua
 * @description：
 */
public interface FreezePointsRepository {
	FreezePoints find(UserId userId);
	FreezePoints save(FreezePoints points);
	FreezePoints find(Long id);
}
