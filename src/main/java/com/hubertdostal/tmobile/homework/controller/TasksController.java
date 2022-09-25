package com.hubertdostal.tmobile.homework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TasksController {

    @GetMapping("/")
    public String getHello() {
        return "Hello world!";
    }
}
