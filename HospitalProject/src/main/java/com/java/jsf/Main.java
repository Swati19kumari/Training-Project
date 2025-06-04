package com.java.jsf;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.java.jsf.Dao.DoctorDaoImpl;
import com.java.jsf.model.Doctor;
import com.java.jsf.model.Patient;

public class Main {

public static void main(String[] args) {
		
		DoctorDaoImpl dao=new DoctorDaoImpl();
		System.out.println("Hello ");
		
		SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		
		Transaction trans = session.beginTransaction();
		
//		dao.SearchByDoctorID("HSkDS01");
		
//		System.out.println(	dao.SearchByDoctorsID("HSkDS02").getLocation());
		
		
//		createData(session, trans);
		
//       createPatitentData();		
	}

		public static void createPatitentData() {

			SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sf.openSession();
			
			
			Transaction trans = session.beginTransaction();
	        Doctor doctor = (Doctor) session.get(Doctor.class, "HSkDS01");

			 Patient patient = new Patient();
	         patient.setPatientId("PTH629");
	         patient.setPatientName("Ravikant Sharma");
	         patient.setDateOfBirth(Date.valueOf("1990-04-15"));
	         patient.setDoctor(doctor);  // Set reference

	         // 4. Save Patient
	         session.save(patient);
	         trans.commit();

	         System.out.println("Patient inserted successfully!");
			
		}
		
		
		
		

		
	

//		public static void main(String[] args) {
//
//			SessionFactory sf = SessionHelper.getConnection();
//			Session session = sf.openSession();
//
//			// Create sample doctor
//			Doctor doctor = new Doctor();
//			doctor.setDoctorId("D001");  // You can also generate ID if needed
//			doctor.setDoctorName("Dr. Arun Nair");
//			doctor.setSpecialization(Specialization.HEART);  // Assuming enum
//			doctor.setLocation("Chennai");
//			doctor.setMobileNo("9876543210");
//			doctor.setIsStatus(Status.ACTIVE);
//
//			Transaction tx = session.beginTransaction();
//			session.save(doctor);
//			tx.commit();
//
//			System.out.println("Doctor record inserted successfully.");
//			session.close();
//			sf.close();
//		}

// 
//	public static void createPatient(Session session, Transaction trans) {
//		// Assuming doctor D002 already exists
//		Doctor doctor = (Doctor) session.get(Doctor.class, "HSkDS03");
//
//		Doctor doctor = new Doctor();
//		Patient patient = new Patient();
//		patient.setPatientId("PTH600");
//		doctor.setDoctorId("HSkDS03");
//		patient.setPatientName("Alice Johnson");
////		patient.setDateOfBirth(Date.valueOf(LocalDate.of(1995, 5, 20))); // Convert LocalDate to SQL Date
//		patient.setDoctor(doctor);
//		session.save(patient);
//		trans.commit();
//
//		System.out.println("Patient created successfully.");
//	}
//	
//	public static void createMedicationHistory(Session session, Transaction trans) {
//	    // Assuming patient PTH600 already exists
//	    Patient patient = new Patient();
////	    patient.setPatientId("PTH608");  // Just set the ID, no need to fetch entire object if using assigned IDs
//	    
//	    MedicationHistory medHistory = new MedicationHistory();
//	    medHistory.setMedId("MHD6000");
//	    patient.setPatientId("PTH608");
//	    medHistory.setMedicines("Paracetamol");
//	    medHistory.setTests("Blood Test");
//	    medHistory.setPatient(patient);
// 
//	    session.save(medHistory);
//	    trans.commit();
// 
//	    System.out.println("MedicationHistory created successfully.");
//	}
}
