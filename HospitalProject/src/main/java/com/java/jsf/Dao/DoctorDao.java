package com.java.jsf.Dao;

import java.util.List;

import com.java.jsf.model.Doctor;

public interface DoctorDao {

	public String addDoctor(Doctor doctor);

	 public List<Doctor> showDoctorDao();

	 List<Doctor>  getSpecialization(String specialization);
	 
	public Doctor searchDoctorById(String doctorId);

}
