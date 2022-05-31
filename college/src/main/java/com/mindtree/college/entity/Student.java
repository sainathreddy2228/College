package com.mindtree.college.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	private int studentId;
	private String studentName;
	private String studentDepartment;
	@ManyToMany
	List<Lab>labs;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int studentId, String studentName, String studentDepartment, List<Lab> labs) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDepartment = studentDepartment;
		this.labs = labs;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentDepartment() {
		return studentDepartment;
	}
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	public List<Lab> getLabs() {
		return labs;
	}
	public void setLabs(List<Lab> labs) {
		this.labs = labs;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentDepartment="
				+ studentDepartment + ", labs=" + labs + "]";
	}
	
}
