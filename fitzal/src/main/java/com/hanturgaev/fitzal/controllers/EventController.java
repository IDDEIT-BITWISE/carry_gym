package com.hanturgaev.fitzal.controllers;
import com.hanturgaev.fitzal.models.Event;
import com.hanturgaev.fitzal.models.Trainer;
import com.hanturgaev.fitzal.models.User;
import com.hanturgaev.fitzal.services.EventService;
import com.hanturgaev.fitzal.services.TrainerService;
import com.hanturgaev.fitzal.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private UserService userService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public String index(Model model, Authentication authentication){
        User user = (User)authentication.getPrincipal();

        model.addAttribute("events", eventService.getAllEventsGroupByDay());
        model.addAttribute("event", new Event());
        model.addAttribute("userEventList", eventService.getEventsByUserId(user.getId()));
        System.out.println(eventService.getEventsByUserId(user.getId()));
        return "events";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Event event = eventService.getEventById(id)
                .orElseThrow(() -> new RuntimeException("Событие не найдено"));
        model.addAttribute("event", event);
        List<Trainer> trainers = trainerService.getAllTrainers();
        model.addAttribute("trainers", trainers);
        return "editEvent";
    }

    @PostMapping("/edit/{id}")
    public String updateEvent(@PathVariable("id") Long id, @ModelAttribute Event event) {
        event.setId(id);
        eventService.updateEvent(event);
        return "redirect:/events/";
    }


    @PostMapping("/join/{eventId}")
    public String joinEvent(@PathVariable("eventId") Long eventId,
                            Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        eventService.joinEvent(eventId, user.getId());

        return "redirect:/events/";
    }

    @PostMapping("/leave/{eventId}")
    public String leaveEvent(@PathVariable("eventId") Long eventId,
                             Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        eventService.leaveEvent(eventId, user.getId());
        return "redirect:/events/";


    }
}


