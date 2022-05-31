package com.mindtree.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.college.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
