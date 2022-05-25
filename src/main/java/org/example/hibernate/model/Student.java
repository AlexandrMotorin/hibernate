package org.example.hibernate.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(exclude = "faculty")
@EqualsAndHashCode(exclude = "faculty")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private StudentInfo studentInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Profile profile;


}
