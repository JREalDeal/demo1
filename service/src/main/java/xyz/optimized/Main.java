package xyz.optimized;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import xyz.optimized.service.MyService;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Main.class, args);

        System.out.println("Hello, World!");
        System.out.println(new MyService().getMessage());
        System.out.println(new MyService().getPlacinta());
    }
}
