package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    private static  HashMap<String,String> events = new HashMap<String,String>();
    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", events);
        System.out.println(events.keySet());
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEvent(){
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String description){
        events.put("name", eventName);
        events.put("description", description);
        return "redirect:/events";
    }
}
