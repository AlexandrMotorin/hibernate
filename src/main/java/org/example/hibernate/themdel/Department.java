package org.example.hibernate.themdel;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "personList")
@EqualsAndHashCode(exclude = "personList")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Person> personList = new ArrayList<>();
}
