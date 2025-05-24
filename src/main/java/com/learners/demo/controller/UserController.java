package com.learners.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learners.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/patterns/builder")
public class UserController {
    @GetMapping(value = "/createUser")
    public String builder(@RequestParam(name = "name", defaultValue = "Guest") String name,
                          @RequestParam(name = "age", defaultValue = "0") int age,
                          @RequestParam(name = "email", defaultValue = "") String email) {
        // Example logic to create a user using the builder pattern
        User user = new User.UserBuilder()
                .setName(name)
                .setAge(age)
                .setEmail(email)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String userJson = objectMapper.writeValueAsString(user);
            System.out.println("User created: " + userJson);
            return "User created: " + userJson;
        } catch (JsonProcessingException e) {
            System.out.println("Error converting user to JSON: " + e.getMessage());
        }
        return "Unable to create user!";
    }
}
