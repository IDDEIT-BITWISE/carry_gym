package com.hanturgaev.fitzal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "feedbacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User client; // Клиент, который оставил отзыв

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = true)
    private Event event;
}