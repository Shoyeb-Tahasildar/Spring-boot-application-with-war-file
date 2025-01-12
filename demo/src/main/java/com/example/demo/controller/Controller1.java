package com.example.demo.controller;

import com.example.demo.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;

@RestController
public class Controller1 {

    ArrayList<User> l1 = new ArrayList<>();

   @GetMapping
    public String getData(){
       ObjectMapper objectMapper = new ObjectMapper();
       String l2 = null;
       try {
           l2 = objectMapper.writeValueAsString(l1);
       } catch (JsonProcessingException e) {
           throw new RuntimeException(e);
       }
       return l2;
   }

   @PostMapping
    public String addData(@RequestBody User user){
        try {
            l1.add(user);
            return "User added";
        }catch (Exception e){
            System.out.println(e);
        }
        return "Unable to add user";
   }

}
