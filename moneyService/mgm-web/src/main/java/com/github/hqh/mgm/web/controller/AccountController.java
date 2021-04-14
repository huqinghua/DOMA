package com.github.hqh.mgm.web.controller;

import java.math.BigDecimal;

import com.github.hqh.mgm.domain.moneyaccount.Money;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountRepository;
import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;
import com.github.hqh.mgm.domain.user.IUser;
import com.github.hqh.mgm.domain.user.UserId;
import com.github.hqh.mgm.domain.user.UserRemoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.hqh.mgm.application.AccountSerivce;
import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.common.response.GenericResponse;
/**
 * @author ：huqinghua
 * @description：
 */
@RequestMapping("/account")
@RestController
public class AccountController {
	
    @Autowired
    UserRemoteRepository userRepository;
    
    @Autowired
    MoneyAccountRepository moneyAccountRepository;
    
    @Autowired
    AccountSerivce accountService;
    
    @Autowired
    AccountSerivce accountSerivce;

    // curl -H "Content-Type:application/json" -X POST -d '{"sourceUserId": 12345, "destUserId":12346, "moneyFen":10, "pwd":"123456"}' http://localhost:8081/account/transferMoney
    @RequestMapping(value = "/transferMoney", method = RequestMethod.POST)
    public GenericResponse<String> transferMoney(@RequestBody TransferMoneyVO transferMoneyVO) {
        GenericResponse<String> res = new GenericResponse<>();

        if (transferMoneyVO.getMoneyFen() <= 0) {
        	throw new MgmException(MgmErrorCode.CHECK_PARAMS_ERR);
        }
        
        // 用户验证
        UserId userId = new UserId(transferMoneyVO.getSourceUserId());
        IUser user = userRepository.find(userId);
        if (null == user) {
            throw new MgmException(MgmErrorCode.CHECK_PARAMS_ERR);
        }
        if (!user.identificate(transferMoneyVO.getPwd())) {
            throw new MgmException(MgmErrorCode.PASSWORD_ERROR);
        }
        
        UserId destUserId = new UserId(transferMoneyVO.getDestUserId());
        IUser destUser = userRepository.find(destUserId);
        if (null == destUser) {
            throw new MgmException(MgmErrorCode.CHECK_PARAMS_ERR);
        }
        
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
