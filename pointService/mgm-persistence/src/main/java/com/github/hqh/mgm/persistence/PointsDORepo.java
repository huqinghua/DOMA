package com.github.hqh.mgm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author ：huqinghua
 * @description：积分表
 */
@Component
public interface PointsDORepo extends JpaRepository<PointsDO, Long> {
    @Override
    Optional<PointsDO> findById(Long value);

    PointsDO findByUserId(Long id);

    @Override
    PointsDO saveAndFlush(PointsDO pointsDO);

}
