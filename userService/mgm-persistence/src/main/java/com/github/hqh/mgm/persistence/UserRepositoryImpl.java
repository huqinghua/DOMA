package com.github.hqh.mgm.persistence;


import com.github.hqh.mgm.domain.user.User;
import com.github.hqh.mgm.domain.user.UserId;
import com.github.hqh.mgm.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserDORepo userDORepo;
    @Autowired
    private UserBuilder userBuilder;


    @Override
    public User find(UserId id) {
        UserDO usersDO = userDORepo.findById(id.getId()).get();
        return userBuilder.toUser(usersDO);
    }

    @Override
    public User save(User user) {
        UserDO usersDO = userBuilder.fromUser(user);
        userDORepo.saveAndFlush(usersDO);

        return user;
    }
}
