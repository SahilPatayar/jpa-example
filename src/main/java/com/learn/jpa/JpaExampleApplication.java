package com.learn.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.jpa.entity.Course;
import com.learn.jpa.repo.CourseRepo;

@SpringBootApplication
public class JpaExampleApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepo courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}

	public void run(String... args) throws Exception {
//		Course c = new Course();
//		c.setName("New C1");		
//		courseRepository.save(c);
//		
//		Course c2 = new Course();
//		c2.setName("New C2");		
//		courseRepository.save(c2);
//		
//		Thread.sleep(5000);
//		
//		c2.setName("New C2 - Updated");	
//		courseRepository.save(c2);
//      logger.info("Finding all courses {} ", courseRepository.findAllCoursesByTypedQuery());		
	}

}
