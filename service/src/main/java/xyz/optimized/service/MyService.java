package xyz.optimized.service;


import xyz.optyimized.model.Placinta;

public class MyService {

    public String getMessage() {
        return "Hello, World! from Service";
    }

    public Placinta getPlacinta() {
        return new Placinta().name("Placinta cu branza")
                .description("Placinta cu branza si marar de la mama");
    }
}
