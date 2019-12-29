package com.learn.jpa.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.jpa.entity.Passport;
import com.learn.jpa.entity.Student;

@Repository
public class StudentRepository {

	@Autowired
	private EntityManager em;
	
	public Student findStudentById(Long id) {
		return em.find(Student.class, id);
	}
	
	public Passport findPassportById(Long id) {
		return em.find(Passport.class, id);
	}
	
	public Student findStudentByName(String name) {
		Query query = em.createNamedQuery("get_student_by_name", Student.class);
		query.setParameter("studentName", name);		
		List students = query.getResultList();		
		if(students != null && students.size() != 0) {
			return (Student) students.get(0);
		}
		return null;		
	}
	
	public Passport findPassportByNumber(String passportNum) {
		Query query = em.createNamedQuery("get_passport_by_name", Passport.class);
		query.setParameter("passNum", passportNum);
		List passports = query.getResultList();		
		if(passports != null && passports.size() != 0) {
			return (Passport) passports.get(0);
		}
		return null;		
	}
	
	@Transactional
	public void saveStudent(Student student) {
		if(student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}		
	}
	
	@Transactional
	public void savePassport(Passport passport) {
		if(passport.getId() == null) {
			em.persist(passport);
		} else {
			em.merge(passport);
		}
	}
	
	@Transactional
	public void saveStudentAndPassport(Student student, Passport passport) {
		em.persist(passport);
		student.setPassport(passport);
		em.persist(student);
	}
	
}
