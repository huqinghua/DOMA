package com.github.hqh.mgm.message;

import com.github.hqh.mgm.domain.message.DepositResultMessage;
import com.github.hqh.mgm.domain.message.DepositResultMessageProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ：huqinghua
 * @description：
 */
@Component
public class DepositResultMessageProducerImpl implements DepositResultMessageProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void send(DepositResultMessage message) {

        rabbitTemplate.convertAndSend("depositResult", DepositResultMessage.serialize(message));
    }

}
