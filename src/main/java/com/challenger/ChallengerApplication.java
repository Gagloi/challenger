package com.challenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ChallengerApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ChallengerApplication.class, args);
		TableJpaRepository tableJpaRepository = (TableJpaRepository) context.getBean("tableJpaRepository");
		Table table = tableJpaRepository.findById(1L).get();
		table.setPassword("3");
		tableJpaRepository.save(table);
	}

}
