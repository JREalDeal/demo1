package xyz.optimized;

import xyz.optimized.service.MyService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(new MyService().getMessage());
    }
}
