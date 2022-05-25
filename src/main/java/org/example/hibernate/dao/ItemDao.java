package org.example.hibernate.dao;

import org.example.hibernate.category.Item;
import org.example.hibernate.category.Rubric;
import org.example.hibernate.dto.CreateItemDto;

import java.util.List;

public interface ItemDao {
    Item addItem(CreateItemDto dto);
    List<Item> findItemsByRubric(Rubric rubric);
}
