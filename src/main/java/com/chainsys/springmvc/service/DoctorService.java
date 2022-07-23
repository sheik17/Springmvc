package com.chainsys.springmvc.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.springmvc.dao.AppointmentRepository;
import com.chainsys.springmvc.dao.DoctorRepository;
import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;
import com.chainsys.springmvc.pojo.DoctorAppointmentDTO;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository repo;
	@Autowired
	private AppointmentRepository apprepo;

 	public List<Doctor> getAllDoctor() {
		List<Doctor> doclist = repo.findAll();
		return doclist;
	}

	@Transactional
	public Doctor save(Doctor dr) {
		return repo.save(dr);
	}

	public Doctor findDoctorById(int id) {
		return repo.findById(id);
	}

	public Doctor addNewEmployees(Doctor dr) {
		return repo.save(dr);
	}

	public Doctor updateEmployees(Doctor dr) {
		return repo.save(dr);
	}

	@Transactional
	public void deleteDoctors(int id) {
		repo.deleteById(id);
	}

	public DoctorAppointmentDTO getDoctorAppointments(int id) {

		Doctor dr = findDoctorById(id);
		DoctorAppointmentDTO dto = new DoctorAppointmentDTO();
		dto.setDoctor(dr);
		for (int i = 0; i < 5; i++) {
			Appointment app = new Appointment();
			app.setId(id);
			Date dt = new Date(22, 07, 25);
			app.setAppointDate(dt);
			app.setDocid(id);
			app.setPatientname("gokul");
			app.setFees(20000);
			dto.addAppointment(app);
		}
		return dto;
	}

	public void addDoctorAndAppointments(DoctorAppointmentDTO dto)
	{
		Doctor dr=dto.getDoctor();
		save(dr);
		List<Appointment> appointmentList=dto.getAppointments();
		int count=appointmentList.size();
		for(int i=0;i<count;i++)
		{
			apprepo.save(appointmentList.get(i));
		}
	}

}

