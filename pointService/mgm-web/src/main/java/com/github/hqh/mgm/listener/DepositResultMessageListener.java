package com.github.hqh.mgm.listener;

import com.github.hqh.mgm.application.PointsService;
import com.github.hqh.mgm.domain.message.DepositResultMessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther huqinghua
 */
@Component
@RabbitListener(queues = "depositResult")
public class DepositResultMessageListener {

	@Autowired
	PointsService pointsService;

	@RabbitHandler
	public void process(String depositResult) {
		DepositResultMessage result = DepositResultMessage.deserialize(depositResult);

		pointsService.redeemPointsResultProcess(result.getId(), result.getUserId(), result.getStatus());
	}

}
