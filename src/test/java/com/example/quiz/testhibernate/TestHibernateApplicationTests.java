package com.example.quiz.testhibernate;

import com.example.quiz.testhibernate.repositories.TestCustomRepository;
import com.example.quiz.testhibernate.repositories.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@SqlGroup({
		@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql")
})
public class TestHibernateApplicationTests {

	@Autowired
	private TestRepository testRepository;
	@Autowired
	private TestCustomRepository testCustomRepository;


	@Test
	public void test_showAllEntities() {
		List<com.example.quiz.testhibernate.domain.Test> tests = testRepository.findAll();
		System.out.println("All Entities");
		System.out.println(tests);

		assertEquals(tests.size(), 5);
	}

	@Test
	public void testDistinctSpringData_ShowOnlyType1(){
		List<String> tests = testRepository.customQueryGetTestTypeDistinctByType("Type 1");
		System.out.println("By Spring Data");
		System.out.println(tests);
		assertEquals(tests.size(), 1);
	}

	@Test
	public void testDistinctSpringData_ShowAllTypes(){
		List<String> tests = testRepository.customQueryGetTestTypeDistinct();
		System.out.println("By Spring Data");
		System.out.println(tests);
		assertEquals(tests.size(), 3);
	}

	@Test
	public void testDistinctCustomRepository_ShowOnlyType1(){
		List<String> tests = testCustomRepository.findTypesUsingCriteria();
		System.out.println("By Criteria");
		System.out.println(tests);
		assertEquals(tests.size(), 3);
	}
}
