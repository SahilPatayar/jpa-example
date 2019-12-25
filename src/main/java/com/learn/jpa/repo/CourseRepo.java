package com.learn.jpa.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.jpa.entity.Course;

@Repository
public class CourseRepo {

	@Autowired
	private EntityManager em;
	
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
	
	
	
	@Transactional
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
}
