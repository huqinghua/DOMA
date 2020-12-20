package com.github.hqh.mgm.domain.user;

/**
 * @author ：huqinghua
 * @description：
 */
public interface UserRepository {
    User find(UserId userId);

    User save(User user);
}
