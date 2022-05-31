package com.mindtree.college.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {
	@Id
	private int collegeId;
	private String collegeName;
	private double collegeCapacity;
	private String collegeLocation;
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="college")
	List<Lab>labs;
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(int collegeId, String collegeName, double collegeCapacity, String collegeLocation, List<Lab> labs) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeCapacity = collegeCapacity;
		this.collegeLocation = collegeLocation;
		this.labs = labs;
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
	public double getCollegeCapacity() {
		return collegeCapacity;
	}
	public void setCollegeCapacity(double collegeCapacity) {
		this.collegeCapacity = collegeCapacity;
	}
	public String getCollegeLocation() {
		return collegeLocation;
	}
	public void setCollegeLocation(String collegeLocation) {
		this.collegeLocation = collegeLocation;
	}
	public List<Lab> getLabs() {
		return labs;
	}
	public void setLabs(List<Lab> labs) {
		this.labs = labs;
	}
	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeCapacity="
				+ collegeCapacity + ", collegeLocation=" + collegeLocation + ", labs=" + labs + "]";
	}
	
}
