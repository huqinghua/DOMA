package com.github.hqh.mgm.domain.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author ：huqinghua
 * @description：
 */
@Getter
@EqualsAndHashCode
@ToString
public class UserId {
    private final Long id;

    public UserId(Long id) {
        this.id = id;
    }
}
