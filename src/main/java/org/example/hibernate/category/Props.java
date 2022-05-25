package org.example.hibernate.category;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(exclude = {
        "rubricPropsList",
        "propValueList"
})
@ToString(exclude = {
        "rubricPropsList",
        "propValueList"
})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "props2")
public class Props {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tittle;

    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "props")
    private List<RubricProps> rubricPropsList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "prop")
    private List<PropValue> propValueList  = new ArrayList<>();
}
