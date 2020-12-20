package com.github.hqh.mgm.persistence;


import com.github.hqh.mgm.domain.user.User;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class UserBuilder {
    public User toUser(UserDO userDO) {
        return new User(userDO.getId(), userDO.getName(), userDO.getPwd());
    }

    public UserDO fromUser(User user) {
        return new UserDO(user.getId(), user.getName(), user.getPwd());
    }
}
