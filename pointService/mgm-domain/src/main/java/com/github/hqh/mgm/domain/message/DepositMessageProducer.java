package com.github.hqh.mgm.domain.message;

/**
 * @author ：huqinghua
 * @description：
 */

public interface DepositMessageProducer {
	void send(DepositMessage message);
}
