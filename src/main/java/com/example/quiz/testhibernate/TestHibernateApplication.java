package com.example.quiz.testhibernate;

import com.example.quiz.testhibernate.domain.Test;
import com.example.quiz.testhibernate.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestHibernateApplication implements CommandLineRunner {

	private final TestRepository testRepository;

	@Autowired
	public TestHibernateApplication(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App started");
	}
}
