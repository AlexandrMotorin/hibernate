package org.example.hibernate.themdel;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ToString(exclude = {"department", "chats", "sections"})
@EqualsAndHashCode(exclude = {"department", "chats", "sections"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Department department;

    @OneToOne
    @JoinColumn
    private Cat cat;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id")
    )
    private List<Chat> chats = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "person")
    private List<PersonSection> personSections = new ArrayList<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "Addresses",
            joinColumns = @JoinColumn(name = "person_id")
    )
    @Column(name = "address")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<AddressType, String> addresses = new HashMap<>();


    public void addChat(Chat chat){
        chats.add(chat);
        chat.getPersons().add(this);
    }



}
