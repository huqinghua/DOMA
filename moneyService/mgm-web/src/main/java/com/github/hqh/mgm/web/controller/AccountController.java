package com.github.hqh.mgm.web.controller;

import java.math.BigDecimal;

import com.github.hqh.mgm.domain.moneyaccount.Money;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountRepository;
import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;
import com.github.hqh.mgm.domain.user.IUser;
import com.github.hqh.mgm.domain.user.UserId;
import com.github.hqh.mgm.domain.user.UserRemoteRepository;
import com.github.hqh.mgm.rpc.UserFeign;
import com.github.hqh.mgm.rpc.UserIdentifyVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.hqh.mgm.application.AccountSerivce;
import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.common.response.GenericResponse;
/**
 * @author ：huqinghua
 * @description：
 */
@Slf4j
@RequestMapping("/account")
@RestController
public class AccountController {
	
    @Autowired
    UserFeign userFeign;
    
    @Autowired
    MoneyAccountRepository moneyAccountRepository;
    
    @Autowired
    AccountSerivce accountService;
    
    @Autowired
    AccountSerivce accountSerivce;

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "hello";
    }

    // curl -H "Content-Type:application/json" -X POST -d '{"sourceUserId": 12345, "destUserId":12346, "moneyFen":10, "pwd":"123456"}' http://localhost:8089/account/transferMoney
    @RequestMapping(value = "/transferMoney", method = RequestMethod.POST)
    public GenericResponse<String> transferMoney(@RequestBody TransferMoneyVO transferMoneyVO) {
        GenericResponse<String> res = new GenericResponse<>();

        if (transferMoneyVO.getMoneyFen() <= 0) {
        	throw new MgmException(MgmErrorCode.CHECK_PARAMS_ERR);
        }

        UserIdentifyVO vo = new UserIdentifyVO();
        vo.setUserId(transferMoneyVO.getSourceUserId());
        vo.setPwd(transferMoneyVO.getPwd());
        GenericResponse<String> response = userFeign.identificate(vo);
        if (!response.isSuccess() || !response.getContent().equalsIgnoreCase("authrized")) {
            throw new MgmException(MgmErrorCode.PASSWORD_ERROR);
        }

        UserId userId = new UserId(transferMoneyVO.getSourceUserId());
        UserId destUserId = new UserId(transferMoneyVO.getDestUserId());
        MoneyMoneyAccount sourceMoneyAccount = moneyAccountRepository.find(userId);
        MoneyMoneyAccount destMoneyAccount = moneyAccountRepository.find(destUserId);
        accountService.transferMoney(sourceMoneyAccount, destMoneyAccount, new Money(new BigDecimal(transferMoneyVO.getMoneyFen())));

        return res;
    }
    
    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public GenericResponse<String> deposit(@RequestBody DepositVO depositVO) {
        GenericResponse<String> res = new GenericResponse<>();
        
        // 用户验证
        UserId userId = new UserId(depositVO.getUserId());     
        MoneyMoneyAccount sourceMoneyAccount = moneyAccountRepository.find(userId);
        if (null == sourceMoneyAccount) {
            throw new MgmException(MgmErrorCode.CHECK_PARAMS_ERR);
        }
        accountSerivce.deposit(depositVO.getId(), sourceMoneyAccount, new Money(depositVO.getMoney()));

        return res;
    }
    
    
}
