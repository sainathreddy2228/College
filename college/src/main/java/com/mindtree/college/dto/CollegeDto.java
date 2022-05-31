package com.mindtree.college.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class CollegeDto {
	private int collegeId;
	private String collegeName;
	private String collegeLocation;
	private double collegeCapacity;
	private List<LabDto>labDtos;
	public CollegeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CollegeDto(int collegeId, String collegeName, String collegeLocation, double collegeCapacity,
			List<LabDto> labDtos) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeLocation = collegeLocation;
		this.collegeCapacity = collegeCapacity;
		this.labDtos = labDtos;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeLocation() {
		return collegeLocation;
	}
	public void setCollegeLocation(String collegeLocation) {
		this.collegeLocation = collegeLocation;
	}
	public double getCollegeCapacity() {
		return collegeCapacity;
	}
	public void setCollegeCapacity(double collegeCapacity) {
		this.collegeCapacity = collegeCapacity;
	}
	public List<LabDto> getLabDtos() {
		return labDtos;
	}
	public void setLabDtos(List<LabDto> labDtos) {
		this.labDtos = labDtos;
	}
	@Override
	public String toString() {
		return "CollegeDto [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeLocation="
				+ collegeLocation + ", collegeCapacity=" + collegeCapacity + ", labDtos=" + labDtos + "]";
	}
	
}
