package org.example.hibernate.dao;

import org.example.hibernate.category.Props;
import org.example.hibernate.category.Rubric;

import java.util.List;

public interface PropsDao {
    List<Props> findPropsByRubric(Rubric rubric);
    List<Props> findPropsByTitle(String title);
}
