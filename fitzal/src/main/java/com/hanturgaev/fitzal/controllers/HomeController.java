package com.hanturgaev.fitzal.controllers;
import com.hanturgaev.fitzal.models.Trainer;
import com.hanturgaev.fitzal.models.User;
import com.hanturgaev.fitzal.services.TrainerService;
import com.hanturgaev.fitzal.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/")
    public String index(){
        return "home";
    }


    @GetMapping(value = "/login")
    public String goAuth() {
        return "login";
    }

    @GetMapping(value = "/badPage")
    public String goBad() {
        return "badPage";
    }

    @GetMapping(value = "/news")
    public String goNews() {
        return "news";
    }

    @GetMapping(value = "/contacts")
    public String goContacts() {
        return "contacts";
    }


    @PostMapping(value = "/register")
    public String register(@ModelAttribute User user, HttpServletRequest request,
                           @CurrentSecurityContext SecurityContext securityContext) {
        userService.save(user);

        //Program authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user, user.getPassword(), user.getAuthorities());

        securityContext.setAuthentication(authentication);

        // Create a new session and add the security context.
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
        return "redirect:/";
    }

    @GetMapping(value = "/register")
    public String goRegister() {
        return "register";
    }
    @GetMapping(value = "/about")
    public String goAbout() {
        return "about";
    }
    @GetMapping(value = "/events")
    public String goEvents() {
        return "events";
    }

    @GetMapping(value = "/trainers")
    public String goTrainers(Model model) {
        model.addAttribute("trainers", trainerService.getAllTrainers());
        model.addAttribute("trainer", new Trainer());
        return "trainers";
    }





//    @PostMapping(value = "/register")
//    public String register(@ModelAttribute User user, HttpServletRequest request,
//                           @CurrentSecurityContext SecurityContext securityContext) {
//        userService.save(user);
//
//        //Program authentication
//        Authentication authentication = new UsernamePasswordAuthenticationToken(
//                user, user.getPassword(), user.getAuthorities());
//
//        securityContext.setAuthentication(authentication);
//
//        // Create a new session and add the security context.
//        HttpSession session = request.getSession(true);
//        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
//        return "redirect:/";
//    }



}
