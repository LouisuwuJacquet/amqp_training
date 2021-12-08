package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext =
            new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate template = appContext.getBean(RabbitTemplate.class);
        template.setRoutingKey("chat_messages");
        final Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Input a message, we will send it for you (q for quit) ");
            String message = in.next();
            template.convertAndSend(message);
            System.out.println("Message sent.Input a message, we will send it for you");
        }
    }
}
