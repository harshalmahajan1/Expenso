package com.ibm.expensetracker.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="student")
public class StudentEntity {

	@Id     //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)   //auto increment
	private Long id;

	@Column(length = 100)
	private String studentName;
	
	@Column(length = 100)
	private String email;
	
	@ManyToMany
	@JoinTable(name="student_courses",
	           joinColumns = {@JoinColumn(name = "student_id"),},
	           inverseJoinColumns = { @JoinColumn(name="course_id")})
	private Set<CourseEntity> courses;
	
	
	public StudentEntity() {
		
		
	}


	public StudentEntity(Long id, String studentName, String email, Set<CourseEntity> courses) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.email = email;
		this.courses = courses;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Set<CourseEntity> getCourses() {
		return courses;
	}


	public void setCourses(Set<CourseEntity> courses) {
		this.courses = courses;
	}
	
	
}
