package com.hanturgaev.fitzal.services;

import com.hanturgaev.fitzal.models.Event;
import com.hanturgaev.fitzal.models.User;
import com.hanturgaev.fitzal.repositories.EventRepository;
import com.hanturgaev.fitzal.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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

    @Transactional
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Transactional
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Transactional
    public List<Event> getAllEventsByDay(String day) {
        return eventRepository.findByDay(day);
    }

    @Transactional
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<List<Event>> getAllEventsGroupByDay() {
        List<List<Event>> result = new ArrayList<>();
        for (int i=1; i <= 7; i++) {
            List<Event> eventsByDay = getAllEventsByDay(String.valueOf(i));
            eventsByDay.sort(Comparator.comparing(event -> LocalTime.parse(event.getTime())));
            result.add(eventsByDay);
        }

        return result;
    }

    @Transactional
    public void updateEvent(Event event) {

        eventRepository.save(event);
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }
    @Transactional
    public void leaveEvent(Long eventId, Long userId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Событие не найдено"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        if (!event.getParticipants().contains(user)) {
            throw new RuntimeException("Пользователь не записан на это событие");
        }

        event.getParticipants().remove(user);
        eventRepository.save(event);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<Long> getEventsByUserId(Long id) {
        List<Event> events = eventRepository.findByParticipantsId(id);
        List<Long> eventIds = events.stream()
                .map(Event::getId) // Преобразуем каждый Event в его id
                .collect(Collectors.toList());
        return eventIds;
    }

}
