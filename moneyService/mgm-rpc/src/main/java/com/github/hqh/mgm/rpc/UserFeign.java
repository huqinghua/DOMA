package com.github.hqh.mgm.rpc;

import com.github.hqh.mgm.common.response.GenericResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name= "mgm-user-service")
public interface UserFeign {

    @GetMapping("/user/identificate")
    GenericResponse<String> identificate(@RequestBody UserIdentifyVO vo);
}
