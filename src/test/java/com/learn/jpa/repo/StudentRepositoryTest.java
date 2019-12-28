package com.learn.jpa.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.jpa.entity.Passport;
import com.learn.jpa.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
	
	private static Logger logger = LoggerFactory.getLogger(StudentRepositoryTest.class);

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	@DirtiesContext
	public void testSaveStudent() {
		Student student = new Student();
		student.setName("Joey");
		studentRepository.saveStudent(student);
		
		Student savedStudent = studentRepository.findStudentByName("Joey");
		logger.info("Saved Student -> {}", savedStudent);
		assertNotNull(savedStudent);
		assertEquals("Joey", savedStudent.getName());
	}
	
	@Test
	@DirtiesContext
	public void testSavePassport() {
		Passport passport = new Passport();
		passport.setPassportNumber("JOE98745");
		studentRepository.savePassport(passport);
		
		Passport savedPassport = studentRepository.findPassportByNumber("JOE98745");
		logger.info("Saved Passport -> {}", savedPassport);
		assertNotNull(savedPassport);
		assertEquals("JOE98745", savedPassport.getPassportNumber());
	}

	@Test
	public void testFindStudentById() {
	}
	
	@Test
	@DirtiesContext
	public void testSaveStudentAndPassport() {
		Student student = new Student();
		student.setName("Joey");
		
		Passport passport = new Passport();
		passport.setPassportNumber("JOE98745");
		
		studentRepository.saveStudentAndPassport(student, passport);
		Student savedStudent = studentRepository.findStudentByName("Joey");
		logger.info("Saved Student -> {}", savedStudent);
		
		assertNotNull(savedStudent);
		assertEquals("Joey", savedStudent.getName());
		
		Passport savedPassport = savedStudent.getPassport();
		logger.info("Saved Passport -> {}", savedPassport);
		
		assertNotNull(savedPassport);
		assertEquals("JOE98745", savedPassport.getPassportNumber());
	}
	
	
}
