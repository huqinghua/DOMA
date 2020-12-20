package com.github.hqh.mgm.persistence;


import com.github.hqh.mgm.domain.pointsaccount.PointsAccountAccount;
import com.github.hqh.mgm.domain.pointsaccount.PointsAccountRepository;
import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class PointsAccountRepositoryImpl implements PointsAccountRepository {
    @Autowired
    private PointsDORepo pointsDORepo;
    @Autowired
    private PointsBuilder pointsBuilder;


    @Override
    public PointsAccountAccount find(Long id) {
        PointsDO pointsDO = pointsDORepo.findById(id).get();
        return pointsBuilder.toPoints(pointsDO);
    }

    @Override
    public PointsAccountAccount find(UserId userId) {
        PointsDO pointsDO = pointsDORepo.findByUserId(userId.getId());
        return pointsBuilder.toPoints(pointsDO);
    }

    @Override
    public PointsAccountAccount save(PointsAccountAccount pointsAccount) {
        PointsDO pointsDO = pointsBuilder.fromPoints(pointsAccount);
        pointsDORepo.saveAndFlush(pointsDO);

        return pointsAccount;
    }
}
