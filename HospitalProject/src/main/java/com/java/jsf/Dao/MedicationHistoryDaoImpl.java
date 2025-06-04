package com.java.jsf.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.jsf.model.Doctor;
import com.java.jsf.model.MedicationHistory;
import com.java.jsf.model.Patient;
import com.java.jsf.model.Status;
import com.java.jsf.util.SessionHelper;

public class MedicationHistoryDaoImpl  implements MedicationHistoryDao{
	
	
	SessionFactory sf;
	Session session;
	
	
	@Override
	public List<MedicationHistory> ShowPatientMedicalHistory(String patientId) {
		sf=SessionHelper.getConnection();
		session=sf.openSession();
		Query query=session.createQuery("from MedicationHistory where patient.patientId =:patientId");
		query.setParameter("patientId", patientId);
		List<MedicationHistory> MedicList=query.list();
		
		session.close();
		return MedicList;
	}

	@Override
	public List<String> getTestsByPatientId(String patientId) {
		sf=SessionHelper.getConnection();
		session=sf.openSession();
		Query query=session.createQuery(" Select tests from MedicationHistory where patient.patientId =:patientId");
		query.setParameter("patientId", patientId);
		List<String> testList=query.list();
		session.getTransaction().commit();
		session.close();
		return testList;
	}


	
	@Override
	public String AddMedicalHistory(MedicationHistory medHistory) {
		sf=SessionHelper.getConnection();
		session=sf.openSession();
		String medId = getNextMedId(session);
		medHistory.setMedId(medId);
		Transaction tx = session.beginTransaction();
		session.save(medHistory);
		tx.commit();
		return "MedHisDashBoard.jsf?faces-redirect=true";
	}
	
	public static String getNextMedId(Session session) {
		String prefix = "MHD";
		String sql = "select max(medId) from MedicationHistory";
		String maxId = (String) session.createQuery(sql).uniqueResult();
		
		if(maxId == null) {
			return prefix + "0001";
		}
		
		int id = Integer.parseInt(maxId.substring(prefix.length()));
		id++;
		
		return String.format("%s%03d", prefix,id);
	}
	
	
}