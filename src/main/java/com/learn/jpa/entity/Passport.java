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
@Table(name = "PASSPORT")
@NamedQuery(name = "get_passport_by_name", query = "select p from Passport p where passportNumber like :passNum")
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "PASSPORT_NUMBER", nullable = false)
	private String passportNumber;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + "]";
	}	

}
