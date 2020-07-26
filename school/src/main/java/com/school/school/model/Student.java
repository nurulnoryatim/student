package com.school.school.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int age;

	@Column(name = "name")
	private String name;

	@Column(name = "courseid")
	private String courseid;

	@Column(name = "registered")
	private boolean registered;

	public Student() {

	}

	public Student(String name, String courseid, int age, boolean registered) {
		this.name = name;
		this.courseid = courseid;
		this.registered = registered;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean isRegistered) {
		this.registered = registered;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", courseid=" + courseid + ", registered=" + registered + "]";
	}
}
