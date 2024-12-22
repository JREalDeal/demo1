package xyz.optimized.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetinsController {
    @GetMapping("/greetings")
    public String getMessage() {
        return "Hello, World!";
    }
}
