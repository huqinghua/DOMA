package com.github.hqh.mgm.listener;

import com.github.hqh.mgm.application.AccountSerivce;
import com.github.hqh.mgm.common.exception.MgmErrorCode;
import com.github.hqh.mgm.common.exception.MgmException;
import com.github.hqh.mgm.domain.message.DepositMessage;
import com.github.hqh.mgm.domain.moneyaccount.MoneyAccountRepository;
import com.github.hqh.mgm.domain.moneyaccount.MoneyMoneyAccount;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther huqinghua
 */
@Component
@RabbitListener(queues = "deposit")
public class DepositMessageListener {

	@Autowired
	MoneyAccountRepository moneyAccountRepository;

	@Autowired
	AccountSerivce accountSerivce;

	@RabbitHandler
	public void process(String deposit) {
		DepositMessage msg = DepositMessage.deserialize(deposit);
		// 用户验证
		MoneyMoneyAccount sourceMoneyAccount = moneyAccountRepository.find(msg.getUserId());
		if (null == sourceMoneyAccount) {
			throw new MgmException(MgmErrorCode.CHECK_PARAMS_ERR);
		}
		accountSerivce.deposit(msg.getId(), sourceMoneyAccount, msg.getMoney());
	}

}
