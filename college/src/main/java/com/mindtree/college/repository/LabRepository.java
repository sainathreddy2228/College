package com.mindtree.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.college.entity.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, Integer>{

}
