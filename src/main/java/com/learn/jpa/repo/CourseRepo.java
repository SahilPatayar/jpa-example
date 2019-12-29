package com.learn.jpa.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.jpa.entity.Course;
import com.learn.jpa.entity.Review;
import com.learn.jpa.entity.Student;

@Repository
public class CourseRepo {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public void save(Course course) {
		if(course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}		
	}
	
	public Course findById(Long id) {
		Course course = em.find(Course.class, id);
		return course;
	}
	
	public List findAllCoursesByQuery() {
		Query query = em.createNamedQuery("get_all_courses");
		return query.getResultList();
	}
	
	public List<Course> findAllCoursesByTypedQuery() {
		TypedQuery<Course> typedQuery = em.createNamedQuery("get_all_courses", Course.class);
		return typedQuery.getResultList();
	}
	
	public List findAllCoursesByNativeQuery() {
		Query query = em.createNativeQuery("select * from course");
		return query.getResultList();
	}
	
	public List findCourseWithNativeQueryWithParameter(Long courseId) {
		Query query = em.createNativeQuery("select * from course where id = :id", Course.class);
		query.setParameter("id", courseId);
		return query.getResultList();
	}
	
	@Transactional
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	@Transactional
	public void saveReviews(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		logger.info("Reviews -> {}", course.getReviews());
		
		for(Review review : reviews) {
			review.setCourse(course);
			em.persist(review);
		}		
	}
	
	@Transactional
	public List<Review> findAllReviews(Long courseId) {
		Course course = findById(courseId);
		List<Review> reviews = course.getReviews();
		logger.info("Reviews -> {}", reviews);
		return reviews;
	}
	
	@Transactional
	public void addStudentsToCourse(Long courseId, Long studentId) {
		Course course = findById(courseId);
		Student student = studentRepository.findStudentById(studentId);
		//logger.info("Course students -> {}", course.getStudents());
		
		// logger.info("Student courses -> {}", student.getCourses());
		
		course.addStudent(student);
		student.addCourse(course);
		em.merge(course);
		
	}
	
	
	
}
