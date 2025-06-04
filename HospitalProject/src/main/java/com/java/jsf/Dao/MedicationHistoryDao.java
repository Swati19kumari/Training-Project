package com.java.jsf.Dao;

import java.util.List;

import com.java.jsf.model.Doctor;
import com.java.jsf.model.MedicationHistory;

public interface MedicationHistoryDao {
	//-- ShowPatientMedicalHistory, ShowPatientTests, AddMedicalHistory
	
	public List<MedicationHistory> ShowPatientMedicalHistory(String patientId);
	public List<String> getTestsByPatientId(String patientId);
	public String AddMedicalHistory(MedicationHistory medicHis);
	
	
}
