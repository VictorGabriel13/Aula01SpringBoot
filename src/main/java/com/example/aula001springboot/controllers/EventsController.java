package com.example.aula001springboot.controllers;

import com.example.aula001springboot.models.Events;
import com.example.aula001springboot.repositories.EventsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventsController {
    @Autowired
    private EventsRepositories er;

    @RequestMapping("/form")
    public String form() {
        return "events/formEvents";
    }
   // @RequestMapping(path = "/events", method = RequestMethod.POST)
    @PostMapping
    public String adicionar(Events events){

        System.out.println(events);
        er.save(events);
        return "events/events-add";
    }

    @GetMapping
    public ModelAndView listar() {

        List<Events> eventos = er.findAll();
        ModelAndView mv = new ModelAndView("events/lista");
        mv.addObject("events", eventos);
        return mv;
    }
}
