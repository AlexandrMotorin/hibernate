package org.example.hibernate;

import lombok.Cleanup;
import org.example.hibernate.category.*;
import org.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class Runner {
    public static void main(String[] args) {


        @Cleanup Session session = HibernateUtil.openSession();
        session.beginTransaction();


        Rubric rubric = session.createQuery("from Rubric where tittle='Кнопочные телефоны'", Rubric.class)
                .getSingleResult();
        List<Props> props = session.createQuery("from Props", Props.class).getResultList();

        props.forEach(p -> {
            RubricProps rubricProps = RubricProps.builder()
                    .rubric(rubric)
                    .props(p)
                    .build();

            session.persist(rubricProps);
        });

        session.getTransaction().commit();
    }
}
