package org.example.hibernate.themdel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    private Instant createdAt;

    private String createdBy;

    public void setPerson(Person person){
        this.person = person;
        person.getPersonSections().add(this);
    }

    public void setSection(Section section){
        this.section = section;
        section.getPersonSections().add(this);
    }

}
