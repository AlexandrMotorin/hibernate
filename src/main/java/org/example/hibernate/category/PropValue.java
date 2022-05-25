package org.example.hibernate.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prop_val")
public class PropValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Props prop;

    @ManyToOne
    private Value value;

    public void setProp(Props prop) {
        this.prop = prop;
        prop.getPropValueList().add(this);
    }

    public void setValue(Value value) {
        this.value = value;
        value.getPropValueList().add(this);
    }
}
