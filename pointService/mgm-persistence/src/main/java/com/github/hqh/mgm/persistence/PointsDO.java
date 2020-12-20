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
@Table(name="points")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PointsDO {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private Long point;

}
