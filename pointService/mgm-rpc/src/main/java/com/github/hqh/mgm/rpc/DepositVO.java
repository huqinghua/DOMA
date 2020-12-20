package com.github.hqh.mgm.rpc;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: 
 * @author huqinghua
 */
@Data
public class DepositVO {
    private Long id;
    private Long userId;
    private BigDecimal money;
}
