package com.mindtree.college.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.college.dto.CollegeDto;
import com.mindtree.college.dto.LabDto;
import com.mindtree.college.dto.StudentDto;
import com.mindtree.college.entity.College;
import com.mindtree.college.entity.Lab;
import com.mindtree.college.entity.Student;
import com.mindtree.college.exception.ControllerException;
import com.mindtree.college.exception.ErrorConstants;
import com.mindtree.college.repository.CollegeRepository;
import com.mindtree.college.repository.LabRepository;
import com.mindtree.college.repository.StudentRepository;
import com.mindtree.college.service.LabService;

@Service
public class LabServiceImpl implements LabService {
	@Autowired
	CollegeRepository collegeRepository;
	@Autowired
	LabRepository labRepository;
	@Autowired
	StudentRepository studentRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<LabDto> getAllLabsByStudentId(int studentId) throws ControllerException {
		List<Lab> labs = labRepository.findAll();
		List<LabDto> labDtos = new ArrayList<LabDto>();
		for (Lab lab : labs) {
			List<StudentDto> studentDtos = new ArrayList<StudentDto>();
			for (Student student : lab.getStudents()) {
				if (student.getStudentId() == studentId) {
					StudentDto studentDto = modelMapper.map(student, StudentDto.class);
					studentDtos.add(studentDto);
					LabDto labDto = modelMapper.map(lab, LabDto.class);
					// labDto.setStudentDtos(studentDtos);
					labDtos.add(labDto);
				}

			}

		}
		if (labDtos.isEmpty()) {
			throw new ControllerException("no lab found");
		}
		return labDtos;
	}

	@Override
	public LabDto getAllStudentsByLabId(int labId) throws ControllerException {
		Lab lab = labRepository.findById(labId).get();
		String labName = lab.getLabName();
		LabDto labDto = new LabDto();
		List<LabDto> labDtos = new ArrayList<LabDto>();
		List<StudentDto> studentDtos = new ArrayList<StudentDto>();
		for (Student student : lab.getStudents()) {
			StudentDto studentDto = modelMapper.map(student, StudentDto.class);
			studentDtos.add(studentDto);
		}
		labDto.setStudentDtos(studentDtos);
		labDto.setLabId(labId);
		labDto.setLabName(labName);
		labDtos.add(labDto);
		if (labDtos.isEmpty()) {
			throw new ControllerException("no lab found");
		}
		return labDto;
	}

	@Override
	public List<StudentDto> getStudentByLabCount(int labCount) throws ControllerException {
		List<Student> students = studentRepository.findAll();
		List<StudentDto> studentDtos = new ArrayList<StudentDto>();
		for (Student student : students) {
			if (student.getLabs().size() > labCount) {
				StudentDto studentDto = modelMapper.map(student, StudentDto.class);
				studentDtos.add(studentDto);
			}
		}
		if (studentDtos.isEmpty()) {
			throw new ControllerException("student isn't found");
		}
		return studentDtos;
	}

	@Override
	public CollegeDto addCollege(CollegeDto collegeDto) {
		College college = modelMapper.map(collegeDto, College.class);
		List<LabDto> labDtos = new ArrayList<LabDto>();
		List<Lab> labs = new ArrayList<Lab>();
		for (LabDto labDto : collegeDto.getLabDtos()) {
			List<Student> students = new ArrayList<Student>();
			for (StudentDto studentDto : labDto.getStudentDtos()) {
				Student student = modelMapper.map(studentDto, Student.class);
				studentRepository.save(student);
				students.add(student);
			}
			Lab lab = modelMapper.map(labDto, Lab.class);
			lab.setStudents(students);
			lab.setCollege(college);
			labRepository.save(lab);
			labs.add(lab);
			college.setLabs(labs);
			collegeRepository.save(college);
		}
		CollegeDto newCollegeDto = modelMapper.map(college, CollegeDto.class);
		List<LabDto> newLabDtos = new ArrayList<LabDto>();
		for (Lab lab2 : college.getLabs()) {
			List<StudentDto> studentDtos = new ArrayList<StudentDto>();
			for (Student student : lab2.getStudents()) {
				StudentDto newStudentDto = modelMapper.map(student, StudentDto.class);
				studentDtos.add(newStudentDto);
			}
			LabDto newLabDto = modelMapper.map(lab2, LabDto.class);
			newLabDto.setStudentDtos(studentDtos);
			newLabDtos.add(newLabDto);

		}
		newCollegeDto.setLabDtos(newLabDtos);
		return newCollegeDto;
	}
}
