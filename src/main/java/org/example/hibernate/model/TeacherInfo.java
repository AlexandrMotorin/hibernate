package org.example.hibernate.model;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class TeacherInfo {

    private String name;
    private String surname;
    private LocalDate birthday;

}
