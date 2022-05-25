package org.example.hibernate.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class StudentInfo {

    private String name;
    private String surname;
    private LocalDate birthday;

}
