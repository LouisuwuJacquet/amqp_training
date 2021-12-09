
package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class,args);
        var ctx= new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        Scanner sc =new Scanner(System.in);
        System.out.println("Input a message, we will send it for you (q for quit)");
        String S=sc.nextLine();
        while (!(S.equals("q")))
        {
            System.out.println("\n message sent Input a message, we will send it for you (q for quit)");
            template.convertAndSend("","chat_messages",S);
            S=sc.nextLine();
        }
        System.out.println("Bye");
        ctx.close();

    }
}
