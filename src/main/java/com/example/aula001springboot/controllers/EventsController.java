package com.example.aula001springboot.controllers;

import com.example.aula001springboot.models.Events;
import com.example.aula001springboot.repositories.EventsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventsController {
    @Autowired
    private EventsRepositories er;

    @RequestMapping("/events/form")
    public String form() {
        return "formEvents";
    }
   // @RequestMapping(path = "/events", method = RequestMethod.POST)
    @PostMapping("/events")
    public String adicionar(Events events){

        System.out.println(events);
        er.save(events);
        return "events-add";
    }
}
