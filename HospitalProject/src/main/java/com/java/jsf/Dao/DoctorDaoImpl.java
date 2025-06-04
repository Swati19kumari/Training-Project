package com.java.jsf.Dao;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.java.jsf.model.Doctor;
import com.java.jsf.model.Specialization;
import com.java.jsf.model.Status;
import com.java.jsf.util.SessionHelper;

public class DoctorDaoImpl implements DoctorDao {

	SessionFactory sf;
	Session session;

	private String localCode;

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	@Override
	public String addDoctor(Doctor doctor) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();

		// Generate custom doctorId
		String generatedID = generateDoctorID(session);
		doctor.setDoctorId(generatedID);
		doctor.setIsStatus(Status.ACTIVE); // default status

		Transaction tx = session.beginTransaction();
		session.save(doctor);
		tx.commit();
		session.close();
		return "AddDoctor";
	}

	private String generateDoctorID(Session session) {
		// Ensure uniqueness by appending count
		Query query = session.createQuery("select count(d) from Doctor d");
		long count = (long) query.uniqueResult();

		// You can customize prefix and pattern as needed
		String prefix = "HSk";
		String uniquePart = String.format("DS%02d", count + 1); // DS01, DS02, etc.

		return prefix + uniquePart; // e.g., HSkDS01
	}

	@Override
	public List<Doctor> showDoctorDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.getNamedQuery("showDoctor");
		List<Doctor> doctorList = query.list();
		return doctorList;
	}

	// showByCategory

//		public List<String> getSpecialization() {
//			SessionFactory sf = SessionHelper.getConnection();
//			Session session = sf.openSession();
//			Criteria cr = session.createCriteria(Doctor.class);
//			Projection projection = Projections.distinct(Projections.property("specialisation"));
//			cr.setProjection(projection);
//			List<String> list = cr.list();
//			return list;
//		}

	@Override
	public List<Doctor> getSpecialization(String specialization) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Doctor.class);
		cr.add(Restrictions.eq("specialization", Specialization.valueOf(specialization)));
		List<Doctor> doctorList = cr.list();
		return doctorList;
	}

	@Override
	public Doctor searchDoctorById(String doctorId) {

		sf = SessionHelper.getConnection(); // only once
		session = sf.openSession();
		Query query = session.createQuery("From Doctor Where doctorId=:doctorId");
		query.setString("doctorId", doctorId);
		Doctor doctor = (Doctor) query.uniqueResult();
		session.close(); // always close session

		return doctor;
	}

}
