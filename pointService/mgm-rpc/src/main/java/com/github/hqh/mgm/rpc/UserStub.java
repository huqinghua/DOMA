package com.github.hqh.mgm.rpc;


import com.github.hqh.mgm.domain.user.IUser;
import com.github.hqh.mgm.domain.user.UserId;
import lombok.Data;

/**
 * @author ：huqinghua
 * @description：
 */
@Data
public class UserStub implements IUser {

    private UserId userId;

    UserStub(UserId userId) {
        this.userId = userId;
    }

    @Override
    public Long getId() {
        return userId.getId();
    }

    @Override
    public Boolean identificate(String pwd) {
        // todo 调用rest用户服务验证密码
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.postForObject("http://HELLO-SERVICE/user/identificate", pwd, String.class);

        return true;
//        throw new MgmException(MgmErrorCode.NOT_IMPLETMENT);
    }


}
