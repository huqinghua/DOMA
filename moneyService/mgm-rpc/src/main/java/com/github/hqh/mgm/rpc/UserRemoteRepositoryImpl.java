package com.github.hqh.mgm.rpc;


import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.domain.user.IUser;
import com.github.hqh.mgm.domain.user.UserRemoteRepository;
import com.github.hqh.mgm.domain.user.UserId;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class UserRemoteRepositoryImpl implements UserRemoteRepository {

    @Override
    public IUser find(UserId id) {
        UserStub user = new UserStub(id);
        return user;
    }

    @Override
    public IUser save(IUser user) {
        throw new MgmException(MgmErrorCode.NOT_IMPLETMENT);
    }
}
