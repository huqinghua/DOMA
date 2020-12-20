package com.github.hqh.mgm.domain.user;

/**
 * @author ：huqinghua
 * @description：
 */
public interface IUser {
    Long getId();
    Boolean identificate(String pwd);
}
