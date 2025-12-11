package com.renderreceiver.services;

import com.renderreceiver.config.MessageConfig;
import com.renderreceiver.dto.MessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

    @RabbitListener(queues = MessageConfig.QUEUE)
    public void consumeMessageFromQueue(MessageDto orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
    }
}
