package com.hanturgaev.fitzal.services;

import com.hanturgaev.fitzal.models.Event;
import com.hanturgaev.fitzal.models.User;
import com.hanturgaev.fitzal.models.UserRole;
import com.hanturgaev.fitzal.repositories.EventRepository;
import com.hanturgaev.fitzal.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.EventException;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Autowired
    public UserService(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Пользователь с таким email не найден"));
        return user;
    }

    @Transactional
    public void save(User user) {
        user.setRole(UserRole.CLIENT_ROLE);
        user.setPassword("{noop}"+user.getPassword());
        userRepository.save(user);

    }


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
