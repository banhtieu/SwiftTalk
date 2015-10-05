package com.banhtieu.swiftTalk.services;

import com.banhtieu.swiftTalk.message.MessageProcessor;
import com.banhtieu.swiftTalk.model.Message;
import com.banhtieu.swiftTalk.model.User;
import com.banhtieu.swiftTalk.repository.MessageRepository;
import com.banhtieu.swiftTalk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * The message service that handle
 * Created by banhtieu on 10/4/2015.
 */
@RestController
public class MessageService {

    /**
     * The user repository
     */
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private MessageRepository messageRepository;


    /***
     * Instantiate  a message service
     */
    public MessageService(){
        processors = new ArrayList<>();
    }

    /**
     * List of message processors
     */
    private List<MessageProcessor> processors;

    /**
     * Send a message
     * @param principal the user who sends the message
     * @param messageText text message
     */
    @RequestMapping(value = "message", method = RequestMethod.POST)
    public Message sendMessage(Principal principal, String messageText) {
        User user = userRepository.findOne(principal.getName());

        Message message = new Message();
        message.setText(messageText);
        message.setSender(user);

        for (MessageProcessor processor: processors) {
            processor.handleMessage(message);
        }

        messageRepository.save(message);
        return message;
    }

}
