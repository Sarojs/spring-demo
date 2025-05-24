package com.learners.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("Received GET request to /hello");
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}")
    public String sayHelloToUser(@PathVariable String name) {
        System.out.println("Received GET request to /hello/" + name);
        return "Hello, " + name + "!";
    }

    @GetMapping("/greet")
    public String greetWithQuery(@RequestParam(name = "name", defaultValue = "Guest") String name,
                                 @RequestParam(name = "age", required = false) Integer age) {
        System.out.println("Received GET request to /greet with name=" + name + ", age=" + age);
        if (age != null) {
            return "Hello, " + name + "! You are " + age + " years old.";
        }
        return "Hello, " + name + "!";
    }
}
