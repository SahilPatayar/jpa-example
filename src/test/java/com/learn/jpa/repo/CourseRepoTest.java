package com.learn.jpa.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.learn.jpa.entity.Course;
import com.learn.jpa.entity.Review;

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
		courseRepo.deleteById(1001L);
		Course course = courseRepo.findById(1001L);
		assertNull(course);
	}
	
	@Test
	public void testFindAllCoursesByNativeQuery() {
		List courses = courseRepo.findAllCoursesByNativeQuery();
		assertNotNull(courses);
		assertEquals(4, courses.size());
		logger.info("All Courses from Basic Native Query -> {}", courses);
	}
	
	@Test
	public void testFindCourseWithNativeQueryWithParameter() {
		List courses = courseRepo.findCourseWithNativeQueryWithParameter(1000L);
		assertNotNull(courses);
		assertEquals(1, courses.size());
		logger.info("Course from Paramterized Native Query -> {}", courses);
	}
	
	@Test
	@Transactional
	public void testFindCourseWithReviews() {
		Course course = courseRepo.findById(1000L);
		assertNotNull(course);
		assertEquals(1000L, course.getId());
		
		List<Review> reviews = course.getReviews();
		assertNotNull(reviews);		
		assertEquals(3, reviews.size());
	}
	
	@Test
	@DirtiesContext
	public void testSaveReviews() {
		Review review1 = new Review();
		review1.setDescription("Excellent Course");
		review1.setRating(5);
		
		Review review2 = new Review();
		review2.setDescription("Didn't like the course");
		review2.setRating(1);
		
		courseRepo.saveReviews(1002L, Arrays.asList(review1, review2));
		
		List<Review> reviews = courseRepo.findAllReviews(1002L);
		
		assertNotNull(reviews);
		assertEquals(2, reviews.size());		
	}

}
