package com.github.hqh.mgm.message;

import com.github.hqh.mgm.domain.message.DepositMessage;
import com.github.hqh.mgm.domain.message.DepositMessageProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class DepositMessageProducerImpl implements DepositMessageProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void send(DepositMessage message) {

        rabbitTemplate.convertAndSend("deposit", DepositMessage.serialize(message));
    }

}
