package com.learn.jpa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="COURSE")
@NamedQuery(name = "get_all_courses", query = "select c from Course c")
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
	
	// Mapped by should be on the non-owning side of relationship
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private List<Review> reviews = new ArrayList<Review>();	
	
	@ManyToMany()
	@JoinTable(name = "COURSE_STUDENT_LINK", joinColumns = @JoinColumn(name = "COURSE_ID"), inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
	private Set<Student> students = new HashSet();

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

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
	}
	
}
