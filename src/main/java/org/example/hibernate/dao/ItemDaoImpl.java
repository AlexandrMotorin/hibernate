package org.example.hibernate.dao;

import lombok.Cleanup;
import org.example.hibernate.category.Item;
import org.example.hibernate.category.Rubric;
import org.example.hibernate.category.RubricItem;
import org.example.hibernate.dto.CreateItemDto;
import org.example.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;

public class ItemDaoImpl implements ItemDao {

    RubricDao rubricDao;

    @Override
    public Item addItem(CreateItemDto dto) {


        Rubric rubric = rubricDao.findRubricByName(dto.getRubricName());

        Item.builder()
                .tittle(dto.getName())
                .description(dto.getDescription());
//                .rubricItemList(List.of(rubric));


        //засунуть property значения

        @Cleanup var session = HibernateUtil.openSession();
        session.beginTransaction();

        session.getTransaction().commit();
        return null;
    }

    @Override
    public List<Item> findItemsByRubric(Rubric rubric) {

        @Cleanup var session = HibernateUtil.openSession();
        session.beginTransaction();


        return null;
    }


}
