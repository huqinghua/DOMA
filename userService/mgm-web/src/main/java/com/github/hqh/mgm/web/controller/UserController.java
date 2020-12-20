package com.github.hqh.mgm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.common.response.GenericResponse;
import com.github.hqh.mgm.domain.user.User;
import com.github.hqh.mgm.domain.user.UserId;
import com.github.hqh.mgm.domain.user.UserRepository;

/**
 * @author ：huqinghua
 * @description：
 */
@RequestMapping("/user")
@RestController
public class UserController {
	
    @Autowired
    UserRepository userRepository;
    
    @RequestMapping(value = "/identificate", method = RequestMethod.POST)
    public GenericResponse<String> identificate(@RequestBody UserIdentifyVO userIdentifyVO) {
        GenericResponse<String> res = new GenericResponse<>();

        // 用户验证
        UserId userId = new UserId(userIdentifyVO.getUserId());
        User user = userRepository.find(userId);
        if (!user.identificate(userIdentifyVO.getPwd())) {
            throw new MgmException(MgmErrorCode.PASSWORD_ERROR);
        }

        return res;
    }

}
