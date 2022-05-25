package org.example.hibernate.category;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@EqualsAndHashCode(exclude = {
        "props",
        "rubric"
})
@ToString(exclude = {
        "props",
        "rubric"
})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rubric_props2")
public class RubricProps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Rubric rubric;

    @ManyToOne
    private Props props;

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
        rubric.getRubricPropsList().add(this);
    }

    public void setProps(Props props) {
        this.props = props;
        props.getRubricPropsList().add(this);
    }
}
