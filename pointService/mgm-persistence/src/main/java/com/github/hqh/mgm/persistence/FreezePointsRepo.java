package com.github.hqh.mgm.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
/**
 * @author ：huqinghua
 * @description：
 */
@Component
public interface FreezePointsRepo extends JpaRepository<FreezePointsDO, Long> {
    @Override
    Optional<FreezePointsDO> findById(Long value);

    FreezePointsDO findByUserId(Long id);

    @Override
    FreezePointsDO saveAndFlush(FreezePointsDO freezePointsDO);

}
