package com.example.aula001springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventsController {

    @RequestMapping("/events/form")
    public String form() {
        return "formEvents";
    }
}
