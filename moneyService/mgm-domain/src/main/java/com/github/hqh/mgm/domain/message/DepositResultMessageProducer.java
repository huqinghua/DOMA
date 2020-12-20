package com.github.hqh.mgm.domain.message;

/**
 * @author ：huqinghua
 * @description：
 */

public interface DepositResultMessageProducer {
	void send(DepositResultMessage message);
}
