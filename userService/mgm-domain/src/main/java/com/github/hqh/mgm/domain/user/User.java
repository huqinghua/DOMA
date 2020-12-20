package com.github.hqh.mgm.domain.user;

import com.github.hqh.mgm.common.utils.Md5Util;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ：huqinghua
 * @description：
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements IUser{
    private Long id;
    private String name;
    private String pwd;

    User(Long id) {
        this.id = id;
    }

    @Override
    public Boolean identificate(String pwd) {
        return Md5Util.md5Digest(pwd).equals(this.pwd);
    }

}
