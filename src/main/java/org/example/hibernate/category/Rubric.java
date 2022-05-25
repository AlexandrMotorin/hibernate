package org.example.hibernate.category;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode(exclude = {
        "parent",
        "childRubrics",
        "rubricItemList",
        "rubricPropsList"
})
@ToString(exclude = {
        "parent",
        "childRubrics",
        "rubricItemList",
        "rubricPropsList"
})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rubric2")
public class Rubric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tittle;

    private String description;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Rubric parent;

    @Builder.Default
    @OneToMany(mappedBy = "parent")
    private List<Rubric> childRubrics = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "rubric")
    private List<RubricItem> rubricItemList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "rubric")
    private List<RubricProps> rubricPropsList = new ArrayList<>();
}
