package com.uk.main.rest.lessson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.uk.main.rest.course.Course;

@Entity
public class Lesson {

	@Id
	private int id;
	private String name;
	private String description;
	@ManyToOne
	private Course course;
	public Lesson() {
	}

	public Lesson(int id, String name, String description,int courseId,int topicId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.course= new Course(courseId,"","",topicId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Lesson [id=" + id + ", name=" + name + ", description=" + description + ", course=" + course + "]";
	}




}
