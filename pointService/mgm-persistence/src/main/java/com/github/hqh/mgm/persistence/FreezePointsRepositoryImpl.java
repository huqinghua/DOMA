package com.github.hqh.mgm.persistence;


import com.github.hqh.mgm.domain.pointsaccount.FreezePoints;
import com.github.hqh.mgm.domain.pointsaccount.FreezePointsRepository;
import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class FreezePointsRepositoryImpl implements FreezePointsRepository {
    @Autowired
    private FreezePointsRepo pointsDORepo;
    @Autowired
    private FreezePointsBuilder pointsBuilder;


    @Override
    public FreezePoints find(Long id) {
    	FreezePointsDO pointsDO = pointsDORepo.findById(id).get();
        return pointsBuilder.toPointsFreeze(pointsDO);
    }

    @Override
    public FreezePoints find(UserId userId) {
    	FreezePointsDO pointsDO = pointsDORepo.findByUserId(userId.getId());
        return pointsBuilder.toPointsFreeze(pointsDO);
    }

    @Override
    public FreezePoints save(FreezePoints points) {
    	FreezePointsDO pointsDO = pointsBuilder.fromFreezePoints(points);
        pointsDO = pointsDORepo.saveAndFlush(pointsDO);
        FreezePoints newPoints = pointsBuilder.toPointsFreeze(pointsDO);

        return newPoints;
    }

}
