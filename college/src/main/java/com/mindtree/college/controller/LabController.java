package com.mindtree.college.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.college.dto.CollegeDto;
import com.mindtree.college.dto.LabDto;
import com.mindtree.college.dto.StudentDto;
import com.mindtree.college.exception.ControllerException;
import com.mindtree.college.service.LabService;

@RestController
public class LabController {
	@Autowired
	LabService labService;
	@GetMapping(value = "/labs")
	public ResponseEntity<Map<String, Object>> getAllLabsByStudentId(@RequestParam  int studentId) throws ControllerException{
		List<LabDto>labDtos= labService.getAllLabsByStudentId(studentId);
		Map<String, Object> success = new HashMap<String, Object>();
		success.put("Status", HttpStatus.OK);
		success.put("TimeStamp", new Date());
		success.put("Body", labDtos);
		return new ResponseEntity<Map<String, Object>>(success, HttpStatus.OK);
		
				
	}
	@GetMapping(value = "/students")
	public ResponseEntity<Map<String, Object>> getAllStudentsByLabId(@RequestParam int labId) throws ControllerException {
		LabDto labDto= labService.getAllStudentsByLabId(labId);
		Map<String, Object> success = new HashMap<String, Object>();
		success.put("Status", HttpStatus.OK);
		success.put("TimeStamp", new Date());
		success.put("Body", labDto);
		return new ResponseEntity<Map<String, Object>>(success, HttpStatus.OK);
	}
	@GetMapping(value = "/student")
	public ResponseEntity<Map<String, Object>> getStudentsByLabCount(@RequestParam int labCount) throws ControllerException{
		List<StudentDto> studentDtos= labService.getStudentByLabCount(labCount);
		Map<String, Object> success = new HashMap<String, Object>();
		success.put("Status", HttpStatus.OK);
		success.put("TimeStamp", new Date());
		success.put("Body", studentDtos);
		return new ResponseEntity<Map<String, Object>>(success, HttpStatus.OK);
	}
	@PostMapping(value = "/college")
	public CollegeDto addCollege(@RequestBody CollegeDto collegeDto) {
		CollegeDto collegeDto2= labService.addCollege(collegeDto);
		return collegeDto2;
	}
}
