package dev.fernanda;

import dev.fernanda.service.Selector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("dev.fernanda")
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Selector selector = context.getBean(Selector.class);

        selector.run();
        context.close();
    }

}





