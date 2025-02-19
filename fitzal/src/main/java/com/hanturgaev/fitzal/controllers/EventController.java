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
@RequestMapping("/events")
public class EventController {

    @Autowired
    private UserService userService;

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/")
    public String index(Model model, Authentication authentication){

        return "events";
    }

}
