package com.mindtree.college.service;

import java.util.List;

import com.mindtree.college.dto.CollegeDto;
import com.mindtree.college.dto.LabDto;
import com.mindtree.college.dto.StudentDto;
import com.mindtree.college.exception.ControllerException;

public interface LabService {

	public List<LabDto> getAllLabsByStudentId(int studentId) throws ControllerException;

	public LabDto getAllStudentsByLabId(int labId) throws ControllerException;

	public List<StudentDto> getStudentByLabCount(int labCount) throws ControllerException;

	public CollegeDto addCollege(CollegeDto collegeDto);


}
