package com.example.websocket_demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")//ezt szeretnem nezni
    @SendTo("/topic/greetings")//ide kapom az udvozlest, ide jon a JSON adat
    public Greeting greet(HelloMessage message) throws InterruptedException {
        Thread.sleep(2000);
        return new Greeting("Hello " +
                HtmlUtils.htmlEscape(message.getName()));
    }
}
