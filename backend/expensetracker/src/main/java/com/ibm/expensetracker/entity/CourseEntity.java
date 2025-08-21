package com.ibm.expensetracker.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="course")
public class CourseEntity {


	@Id     //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)   //auto increment
	private Long id;

	@Column(length = 100)
	private String courseName;
	
	@ManyToMany(mappedBy ="courses" )
	private Set<StudentEntity> students;
	
	public CourseEntity() {
		
	
	}

	public CourseEntity(Long id, String courseName, Set<StudentEntity> students) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentEntity> students) {
		this.students = students;
	}

	
	
}
