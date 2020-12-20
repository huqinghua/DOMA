package com.github.hqh.mgm.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ：huqinghua
 * @description：积分冻结表
 */
@Entity
@Table(name="freeze_points")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FreezePointsDO {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long freezePoint;
    private Boolean del;
}

