package com.example.aula001springboot.controllers;

import com.example.aula001springboot.models.Events;
import com.example.aula001springboot.repositories.EventsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        Optional<Events> opt = er.findById(id);

        if (opt.isEmpty()) {
            mv.setViewName("redirect:/events");
            return mv;
        }

        Events event = opt.get();

        mv.setViewName("/events/detalhes");
        mv.addObject("event", event);

        return mv;
    }
}
