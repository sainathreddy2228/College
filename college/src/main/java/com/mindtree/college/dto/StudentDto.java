package com.mindtree.college.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class StudentDto {
	private int studentId;
	private String studentName;
	private String studentDepartment;
	private List<LabDto>labDtos;
	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDto(int studentId, String studentName, String studentDepartment, List<LabDto> labDtos) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDepartment = studentDepartment;
		this.labDtos = labDtos;
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
	public List<LabDto> getLabDtos() {
		return labDtos;
	}
	public void setLabDtos(List<LabDto> labDtos) {
		this.labDtos = labDtos;
	}
	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentDepartment="
				+ studentDepartment + ", labDtos=" + labDtos + "]";
	}
	
}
