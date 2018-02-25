package com.example.quiz.testhibernate.repositories;

import com.example.quiz.testhibernate.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

    @Query("select t.type from Test t where t.type = :type group by type")
    List<String> customQueryGetTestTypeDistinctByType(@Param("type") String type);

    @Query("select t.type from Test t group by type")
    List<String> customQueryGetTestTypeDistinct();
}
