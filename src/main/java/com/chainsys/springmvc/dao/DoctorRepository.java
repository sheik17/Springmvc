package com.chainsys.springmvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.springmvc.pojo.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	Doctor findById(int id);

	Doctor save(Doctor thedoc);

	// use for adding a new doctor
	void deleteById(int dr_id);

	List<Doctor> findAll();

}