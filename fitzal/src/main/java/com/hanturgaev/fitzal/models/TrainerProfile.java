package com.hanturgaev.fitzal.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable // Указываем, что это встраиваемый класс
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerProfile {
    private String specialization;
    private String bio;
    private String photoPath;
}