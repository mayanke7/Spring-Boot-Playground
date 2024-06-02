package com.mayanke7.configurationFiles;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {


    @GetMapping(path= "/hello")
    public String printHelloWorld(){
        return "Hello Mayank !";
    }
}
