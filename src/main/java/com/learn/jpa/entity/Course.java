package com.learn.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="COURSE")
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name="NAME", nullable = false, length = 100)
	private String name;
	
	@UpdateTimestamp
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	@CreationTimestamp
	@Column(name="CREATE_DATE")
	private Date createDate;
	

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

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", lastUpdateDate=" + lastUpdateDate + ", createDate="
				+ createDate + "]";
	}
	
}
