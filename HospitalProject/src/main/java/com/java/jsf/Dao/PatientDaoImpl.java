package com.java.jsf.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.jsf.model.Doctor;
import com.java.jsf.model.Patient;
import com.java.jsf.util.SessionHelper;

public class PatientDaoImpl implements PatientDao {

	SessionFactory sf;
	Session session;
	
//	public Doctor searchDoctorById(String doctorId) {
//
//		sf = SessionHelper.getConnection(); // only once
//		session = sf.openSession();
//		Query query = session.createQuery("From Doctor Where doctorId=:doctorId");
//		query.setString("doctorId", doctorId);
//		Doctor doctor = (Doctor) query.uniqueResult();
//		session.close(); // always close session
//
//		return doctor;
//	}
	
	
	@Override
	public Patient searchPatientById(String patientId) {
		sf=SessionHelper.getConnection();
		session=sf.openSession();
		Query query=session.createQuery("From Patient Where patientId=:patientId");
		query.setString("patientId", patientId);
		Patient patient=(Patient)query.uniqueResult();
		session.close();
		
		return patient;
	}

	@Override
	public List<Patient> searchPatientByDoctorId(String doctorId) {
		sf=SessionHelper.getConnection();
		session=sf.openSession();
		Query query=session.createQuery("From Patient Where doctorId=:doctorId");
		query.setString("doctorId",doctorId);
		List<Patient> patientList = query.list();
		return patientList;
		
	}
	
	public static String getNextPatientId(Session session) {
		String prefix = "PTH";
		String sql = "select max(patientId) from Patient";
		String maxId = (String) session.createQuery(sql).uniqueResult();
		
		if(maxId == null) {
			return prefix + "0001";
		}
		
		int id = Integer.parseInt(maxId.substring(prefix.length()));
		id++;
		
		return String.format("%s%03d", prefix,id);
	}
	

	@Override
	public String AddPatient(Patient patient) {
		sf=SessionHelper.getConnection();
		session=sf.openSession();
		String medId = getNextPatientId(session);
		patient.setPatientId(medId);
		Transaction tx = session.beginTransaction();
		session.save(patient);
		tx.commit();
		return "PatientDashBoard.jsf?faces-redirect=true";
		
	}

}
