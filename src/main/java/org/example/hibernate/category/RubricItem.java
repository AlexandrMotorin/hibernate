package org.example.hibernate.category;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@EqualsAndHashCode(exclude = {
        "item",
        "rubric"
})
@ToString(exclude = {
        "item",
        "rubric"
})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rubric_item2")
public class RubricItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "rubric_id")
    private Rubric rubric;

    public void setItem(Item item) {
        this.item = item;
        item.getRubricItemList().add(this);
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
        rubric.getRubricItemList().add(this);
    }
}
