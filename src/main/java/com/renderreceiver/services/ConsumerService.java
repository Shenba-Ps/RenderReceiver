package com.renderreceiver.services;

import com.renderreceiver.config.MessageConfig;
import com.renderreceiver.dto.MessageDto;
import com.renderreceiver.dto.Users;
import com.renderreceiver.repo.UsersRepo;
import com.renderreceiver.util.PasswordUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Autowired
    private UsersRepo usersRepo;
    @RabbitListener(queues = MessageConfig.QUEUE)
    public String consumeMessageFromQueue(MessageDto orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
        Users user = new Users();
        if(orderStatus.getUser().getId() != null) {
            user.setId(orderStatus.getUser().getId());
            user.setUserName(orderStatus.getUser().getUserName());
            user.setName(orderStatus.getUser().getName());
            user.setPassword(PasswordUtil.getEncryptedPassword(orderStatus.getUser().getPassword()));
            user.setEmail(orderStatus.getUser().getEmail());
            user.setRole(orderStatus.getUser().getRole());
            usersRepo.saveAndFlush(user);
        }
        return "User saved successfully with ID: " + user.getId();

    }
}
