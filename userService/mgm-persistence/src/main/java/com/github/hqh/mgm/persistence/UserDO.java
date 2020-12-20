package com.github.hqh.mgm.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ：huqinghua
 * @description：
 */
@Entity
@Table(name="user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String pwd;

}