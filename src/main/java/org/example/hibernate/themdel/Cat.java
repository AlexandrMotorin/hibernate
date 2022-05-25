package org.example.hibernate.themdel;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(exclude = "person")
@EqualsAndHashCode(exclude = "person")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "cat",cascade = CascadeType.ALL)
    private Person person;
}
