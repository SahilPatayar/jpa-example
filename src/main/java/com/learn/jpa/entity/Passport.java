package com.learn.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PASSPORT")
@NamedQuery(name = "get_passport_by_name", query = "select p from Passport p where passportNumber like :passNum")
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "PASSPORT_NUMBER", nullable = false)
	private String passportNumber;

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

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + "]";
	}	

}
