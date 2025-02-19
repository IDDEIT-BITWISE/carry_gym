package com.hanturgaev.fitzal.services;

import com.hanturgaev.fitzal.models.Event;
import com.hanturgaev.fitzal.models.User;
import com.hanturgaev.fitzal.repositories.EventRepository;
import com.hanturgaev.fitzal.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void joinEvent(Long eventId, Long userId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Событие не найдено"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        if (event.getParticipants().contains(user)) {
            throw new RuntimeException("Пользователь уже присоединился к событию");
        }

        event.getParticipants().add(user);

        eventRepository.save(event);
    }

}
