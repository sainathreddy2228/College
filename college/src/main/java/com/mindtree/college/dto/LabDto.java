package com.mindtree.college.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class LabDto {
	private int labId;
	private String labName;
	private List<StudentDto>studentDtos;
	private CollegeDto collegeDto;
	public LabDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LabDto(int labId, String labName, List<StudentDto> studentDtos, CollegeDto collegeDto) {
		super();
		this.labId = labId;
		this.labName = labName;
		this.studentDtos = studentDtos;
		this.collegeDto = collegeDto;
	}
	@Override
	public String toString() {
		return "LabDto [labId=" + labId + ", labName=" + labName + ", studentDtos=" + studentDtos + ", collegeDto="
				+ collegeDto + "]";
	}
	public int getLabId() {
		return labId;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public List<StudentDto> getStudentDtos() {
		return studentDtos;
	}
	public void setStudentDtos(List<StudentDto> studentDtos) {
		this.studentDtos = studentDtos;
	}
	public CollegeDto getCollegeDto() {
		return collegeDto;
	}
	public void setCollegeDto(CollegeDto collegeDto) {
		this.collegeDto = collegeDto;
	}
	
}
