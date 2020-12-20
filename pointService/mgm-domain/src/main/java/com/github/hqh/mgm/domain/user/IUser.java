package com.github.hqh.mgm.domain.user;

/**
 * @author ：huqinghua
 * @description：
 */
public interface IUser {
    Long getId();
    UserId getUserId();
    Boolean identificate(String pwd);
}
