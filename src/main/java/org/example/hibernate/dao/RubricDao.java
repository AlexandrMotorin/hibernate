package org.example.hibernate.dao;

import org.example.hibernate.category.Props;
import org.example.hibernate.category.Rubric;

import java.util.List;

public interface RubricDao {
    Rubric findRubricByName(String name);
}
