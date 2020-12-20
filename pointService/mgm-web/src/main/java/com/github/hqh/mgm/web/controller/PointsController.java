/**   
 * @Description: 
 * @author huqinghua
 */
package com.github.hqh.mgm.web.controller;

import com.github.hqh.mgm.application.PointsService;
import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.common.response.GenericResponse;
import com.github.hqh.mgm.domain.pointsaccount.Points;
import com.github.hqh.mgm.domain.user.IUser;
import com.github.hqh.mgm.domain.user.UserId;
import com.github.hqh.mgm.domain.user.UserRemoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author ：huqinghua
 * @description：
 */
@RequestMapping("/points")
@RestController
public class PointsController {

    @Autowired
    PointsService pointsService;
    
    @Autowired
    UserRemoteRepository userRepository;

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public GenericResponse<String> deposit(@RequestBody RedeemPointsVO redeemPointsVO) {
        GenericResponse<String> res = new GenericResponse<>();

        if (redeemPointsVO.getPoint() <= 0) {
        	throw new MgmException(MgmErrorCode.CHECK_PARAMS_ERR);
        }
        
        // 用户验证
        UserId userId = new UserId(redeemPointsVO.getUserId());
        Points points = new Points(redeemPointsVO.getPoint());
        IUser user = userRepository.find(userId);
        if (!user.identificate(redeemPointsVO.getPwd())) {
            throw new MgmException(MgmErrorCode.PASSWORD_ERROR);
        }
        
        pointsService.redeemPoints(user, points);

        return res;
    }

    @RequestMapping(value = "/deposit_asyn", method = RequestMethod.POST)
    public GenericResponse<String> depositAsyn(@RequestBody RedeemPointsVO redeemPointsVO) {
        GenericResponse<String> res = new GenericResponse<>();

        if (redeemPointsVO.getPoint() <= 0) {
            throw new MgmException(MgmErrorCode.CHECK_PARAMS_ERR);
        }
        Points points = new Points(redeemPointsVO.getPoint());

        // 用户验证
        UserId userId = new UserId(redeemPointsVO.getUserId());
        IUser user = userRepository.find(userId);
        if (!user.identificate(redeemPointsVO.getPwd())) {
            throw new MgmException(MgmErrorCode.PASSWORD_ERROR);
        }

        pointsService.redeemPointsAsyn(user, points);

        return res;
    }

    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    public GenericResponse<String> getAppVersion() {
        GenericResponse<String> res = new GenericResponse<>();
        
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        DateFormat df7 = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
        String date3 = df3.format(new Date());
        String time3 = df7.format(new Date());

        res.setContent(date3 + " " + time3);

        return res;
    }
}
