package xyz.optimized.service;


//import xyz.optyimized.model.Placinta;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public String getMessage() {
        return "Hello, World! from Service";
    }

    //sample use
//    public Placinta getPlacinta() {
//        return new Placinta().name("Placinta cu branza")
//                .description("Placinta cu branza si marar de la mama");
//    }
}
