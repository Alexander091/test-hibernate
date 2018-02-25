package com.example.quiz.testhibernate.repositories;

import com.example.quiz.testhibernate.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestCustomRepository extends JpaRepository<Test, Long> {

    List<String> findTypesUsingCriteria();
}
