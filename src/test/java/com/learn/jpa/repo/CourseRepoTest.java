package com.learn.jpa.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.jpa.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepoTest {
	
	private static Logger logger = LoggerFactory.getLogger(CourseRepoTest.class);

	@Autowired
	private CourseRepo courseRepo;
	
	@Test
	@DirtiesContext
	public void testSave() {
		Course course = new Course();
		course.setName("Train small breed dogs");
		courseRepo.save(course);
	}
	
	@Test
	@DirtiesContext
	public void testUpdate() {
		Course course = courseRepo.findById(1001L);
		course.setName("Training Cats Updated");
		courseRepo.save(course);
		
		Course updatedCourse = courseRepo.findById(1001L);
		assertEquals("Training Cats Updated", updatedCourse.getName());
	}

	@Test
	public void testFindById() {
		Course course = courseRepo.findById(1003L);
		assertNotNull(course);
		assertEquals(1003L, course.getId());
	}
	
	@Test
	public void testFindAllCoursesByQuery() {
		List courses = courseRepo.findAllCoursesByQuery();
		assertNotNull(courses);
		assertEquals(4, courses.size());
		logger.info("All Courses from Query -> {}",courses);
	}
	
	@Test
	public void testFindAllCoursesByTypedQuery() {
		List<Course> courses = courseRepo.findAllCoursesByTypedQuery();
		assertNotNull(courses);
		assertEquals(4, courses.size());
		logger.info("All Courses from Typed Query -> {}", courses);
	}

	@Test
	@DirtiesContext
	public void testDeleteById() {
		courseRepo.deleteById(1000L);
		Course course = courseRepo.findById(1000L);
		assertNull(course);
	}
	
	

}
