package com.banhtieu.swiftTalk.talk;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * Created by banhtieu on 9/8/15.
 * A greeting service
 */
@Controller
public class GreetingService {


    @MessageMapping("/hello")
    @SendTo("/topic/greeting")
    public String handle(String greeting) {

        System.out.println("Hello Received");
        return "[" + new Date() + ": " + greeting;
    }
}
