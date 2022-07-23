package com.chainsys.springmvc.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.chainsys.springmvc.dao.DoctorRepository;
import com.chainsys.springmvc.dao.EmployeeDao;
import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;
import com.chainsys.springmvc.pojo.DoctorAppointmentDTO;
import com.chainsys.springmvc.pojo.Employee;
import com.chainsys.springmvc.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	DoctorService doctorservice;
	@GetMapping("/doclist")
	public String getAllDoctor(Model model) {
		List<Doctor> doclist = doctorservice.getAllDoctor();
		model.addAttribute("alldoctor",doclist); 
		return "list-doctors";
	}
	  @GetMapping("/finddoctorid")
		public String findDoctorById(@RequestParam("docId") int id,Model model) {
		  Doctor thedoc=doctorservice.findDoctorById(id);
	    	model.addAttribute("finddoctorbyid", thedoc);
			return "find-doctor-id-form";
		}
	  @GetMapping("/adddocform")
		public String showAddForm(Model model)
		{
		  Doctor thedoc=new Doctor();
			model.addAttribute("adddoctor", thedoc);
			return "add-doctor-form";
		}
	    @PostMapping("/adddoc")
		public String addNewEmployees(@ModelAttribute("adddoctor") Doctor thedoc) {
	    	doctorservice.save(thedoc);
			return "redirect:/doctor/doclist";
		}
	    @GetMapping("/updatedocform")
		public String showUpdateForm(@RequestParam("docId") int id,Model model)
		{
			Doctor thedoc=doctorservice.findDoctorById(id);
			model.addAttribute("updatedoctor", thedoc);
			return "update-doctor-form";
		}
	    @PostMapping("/updatedoc")
		public String updateEmployees(@ModelAttribute("updatedoctor") Doctor thedoc) {
	    	doctorservice.save(thedoc);
			return "redirect:/doctor/doclist";
		}
	    @GetMapping("/deletedoctor")
		public String deleteDoctors(@RequestParam("docId") int id) {
	    	doctorservice.deleteDoctors(id);
			return "redirect:/doctor/doclist";
		}
	    @GetMapping("/getdocapp")
	    public String getAppointments(@RequestParam("id") int id,Model model)
	    {
	    DoctorAppointmentDTO dto=doctorservice.getDoctorAppointments(id); 
	    model.addAttribute("getdoctor", dto.getDoctor());
	    model.addAttribute("applist", dto.getAppointments());
	    return "list-doctor-appointments";	    
	    }
	    @GetMapping("/trans")
	    public void testTransaction(@RequestParam("id") int id)
	    {
	    	DoctorAppointmentDTO dto=new DoctorAppointmentDTO();
	    	Doctor dr=new Doctor();
	    	dr.setid(id);
	    	dr.setCity("chennai");
	    	Date dt = new Date(92, 07, 14);
			dr.setDob(dt);
			dr.setDoc_name("Praveena");
			dr.setFees(2000);
			dr.setPhone_no(8764568767L);
			dr.setSpeciality("heart");
			dto.setDoctor(dr);
			List<Appointment> applist=new ArrayList<Appointment>();
			for (int i = 0; i <= 2; i++) {
				Appointment app = new Appointment();
				app.setId(i);
				Date appdt = new Date(22, 07, 25);
				app.setAppointDate(appdt);
				app.setDocid(id);
				app.setPatientname("babu");
				app.setFees(20000);
				dto.addAppointment(app);
			}
			doctorservice.addDoctorAndAppointments(dto);
			System.out.println("Successfully completed");
	    }
}