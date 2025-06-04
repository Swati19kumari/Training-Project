
package com.java.jsf.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.java.jsf.Dao.DoctorDao;
import com.java.jsf.Dao.MedicationHistoryDao;
import com.java.jsf.Dao.PatientDao;
import com.java.jsf.model.Doctor;
import com.java.jsf.model.MedicationHistory;
import com.java.jsf.model.Patient;

public class DoctorController {

	
	MedicationHistoryDao medDao;
	MedicationHistory med;
	private List<MedicationHistory> medList;
	
	public List<MedicationHistory> getMedList() {
		return medList;
	}

	public void setMedList(List<MedicationHistory> medList) {
		this.medList = medList;
	}

	public MedicationHistoryDao getMedDao() {
		return medDao;
	}

	public void setMedDao(MedicationHistoryDao medDao) {
		this.medDao = medDao;
	}

	public MedicationHistory getMed() {
		return med;
	}

	public void setMed(MedicationHistory med) {
		this.med = med;
	}

	
	
	DoctorDao doctordao;
	Doctor doctor;

	// for doctor model
	private String doctorId;
	private List<Doctor> doctorList;
	private String specializations;

	PatientDao patientdao;
	Patient patient;
	
	//for patient model
	private String patientId;
	
	
	private List<Patient> patientList;

	public List<Patient> getPatientList() {
	    return patientList;
	}

	public void setPatientList(List<Patient> patientList) {
	    this.patientList = patientList;
	}

	public String ShowPatientByDocId() {
	    patientList = patientdao.searchPatientByDoctorId(doctorId);
	    if (patientList == null || patientList.isEmpty()) {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_WARN, "No patients found for doctor ID: " + doctorId, null));
	    }
	    return null; // stay on same page
	}

	

	//getter setter for patient
	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public PatientDao getPatientdao() {
		return patientdao;
	}

	public void setPatientdao(PatientDao patientdao) {
		this.patientdao = patientdao;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	//getter setter of doctor
	
	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

	public String getSpecializations() {
		return specializations;
	}

	public void setSpecializations(String specializations) {
		this.specializations = specializations;
	}

	public DoctorDao getDoctordao() {
		return doctordao;
	}

	public void setDoctordao(DoctorDao doctordao) {
		this.doctordao = doctordao;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String addDoctors(Doctor doctor) {
		System.out.println("Doctor Added");
		return doctordao.addDoctor(doctor);

	}

	public List<Doctor> showDoctor() {
		return doctordao.showDoctorDao();
	}

	public void doctorSpecializationChanged(ValueChangeEvent e) {
		this.specializations = e.getNewValue().toString();
		doctorList = doctordao.getSpecialization(this.specializations);
	}

	public String searchDoctor() {
		doctor = doctordao.searchDoctorById(doctorId);
		if (doctor == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No Doctor Found with id:" + doctorId, null));
		}
		return "SearchDoctor";
	}

	public String ShowPatientById() {
		patient = patientdao.searchPatientById(patientId);
		if (patient == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "No Patient found with id:" + patientId, null));
		}
		return "PatientById";
	}
	
	public List<Patient> ShowPatientByDocId(String docId) {
		
		return patientdao.searchPatientByDoctorId(docId);
		
	}
	
	public String addPatientController() {
		return patientdao.AddPatient(patient);
	}
	
	public String showMedicationHistoryByPatienceId() {
		medList=medDao.ShowPatientMedicalHistory(patientId);
		if(medList == null) {
			FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"this patient dont have medication history"+patientId,null));
		}
		
		return "ShowMedHistByPatientId";
	}
	
	public String addMedicalHistoryController() {
		 
		return medDao.AddMedicalHistory(med);
	}
}
