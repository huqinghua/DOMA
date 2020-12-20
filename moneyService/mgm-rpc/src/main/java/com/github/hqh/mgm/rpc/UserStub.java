package com.github.hqh.mgm.rpc;


import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.common.response.GenericResponse;
import com.github.hqh.mgm.domain.user.IUser;
import com.github.hqh.mgm.domain.user.UserId;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

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
        UserIdentifyVO vo = new UserIdentifyVO();
        vo.setPwd(pwd);
        vo.setUserId(getId());
        RestTemplate restTemplate = new RestTemplate();
        GenericResponse<String> response = new GenericResponse<>();
        response = restTemplate.postForObject("http://HELLO-SERVICE/user/identificate", vo,  response.getClass());

//        AsyncRestTemplate template = new AsyncRestTemplate();
//        String url = "http://localhost:8080/async/fivetime";
//        ListenableFuture<ResponseEntity<String>> forEntity = template.getForEntity(url, String.class);
//        forEntity.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
//
//            @Override
//            public void onFailure(Throwable ex) {
//            }
//
//            @Override
//            public void onSuccess(ResponseEntity<String> result) {
//            }
//        });

        throw new MgmException(MgmErrorCode.NOT_IMPLETMENT);
    }


}
