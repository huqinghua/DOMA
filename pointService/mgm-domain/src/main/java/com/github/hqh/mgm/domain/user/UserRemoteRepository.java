package com.github.hqh.mgm.domain.user;

/**
 * @author ：huqinghua
 * @description：
 */
public interface UserRemoteRepository {
    IUser find(UserId userId);

    IUser save(IUser user);
}
