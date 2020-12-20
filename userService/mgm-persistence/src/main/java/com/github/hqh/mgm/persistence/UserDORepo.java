package com.github.hqh.mgm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public interface UserDORepo extends JpaRepository<UserDO, Long> {
    @Override
    Optional<UserDO> findById(Long value);

    @Override
    UserDO saveAndFlush(UserDO userDO);

}
