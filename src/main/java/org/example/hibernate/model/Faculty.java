package org.example.hibernate.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@ToString(exclude = "students")
@EqualsAndHashCode(exclude = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "faculty")
    @OrderBy("studentInfo.name desc, studentInfo.surname desc")
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student){
        students.add(student);
        student.setFaculty(this);
    }

}
