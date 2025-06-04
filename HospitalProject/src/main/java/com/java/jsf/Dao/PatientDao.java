package com.java.jsf.Dao;

import java.util.List;

import com.java.jsf.model.MedicationHistory;
import com.java.jsf.model.Patient;

public interface PatientDao {

	//-- ShowPatientById, ShowPatientByDoctorId
	
	public Patient searchPatientById(String patientId);
	
	public List<Patient> searchPatientByDoctorId(String doctorId);
	public String AddPatient(Patient patient);
}
