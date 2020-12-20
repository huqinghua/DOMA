package com.github.hqh.mgm.web.controller;

import lombok.Data;

/**
 * @Description: 
 * @author huqinghua
 */
@Data
public class TransferMoneyVO {
    private Long sourceUserId;
    private Long destUserId;
    private Long moneyFen;
    private String pwd;
}

