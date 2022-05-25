package org.example.hibernate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String phone;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
        student.setProfile(this);
    }
}
