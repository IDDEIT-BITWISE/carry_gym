package com.hanturgaev.fitzal.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Embeddable // Указываем, что это встраиваемый класс
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientProfile {
    private List<Long> eventIds; // Список ID событий, в которых участвует клиент
    private List<Long> feedbackIds; // Список ID отзывов, оставленных клиентом
}