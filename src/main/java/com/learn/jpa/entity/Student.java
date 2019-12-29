package com.learn.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name = "STUDENT")
@NamedQuery(name = "get_student_by_name", query = "select s from Student s where name like :studentName")
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "NAME", nullable = true)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private Passport passport;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Passport getPassport() {
		return passport;
	}


	public void setPassport(Passport passport) {
		this.passport = passport;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}	

}
