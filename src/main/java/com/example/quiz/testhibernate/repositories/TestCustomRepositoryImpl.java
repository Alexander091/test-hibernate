package com.example.quiz.testhibernate.repositories;

import com.example.quiz.testhibernate.domain.Test;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class TestCustomRepositoryImpl extends SimpleJpaRepository<Test, Long> implements TestCustomRepository {

    private EntityManager entityManager;

    public TestCustomRepositoryImpl(EntityManager entityManager) {
        super(Test.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<String> findTypesUsingCriteria() {

        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Test.class).setProjection(
                Projections.distinct(Projections.projectionList()
                        .add(Projections.property("type"), "type")));
        List list = crit.list();
        return list;
    }
}
