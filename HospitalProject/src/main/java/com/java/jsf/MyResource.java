package com.java.jsf;

import java.util.List;

import com.java.jsf.Dao.DoctorDao;
import com.java.jsf.Dao.DoctorDaoImpl;
import com.java.jsf.controller.DoctorController;
import com.java.jsf.model.Doctor;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

public static void main(String[] args) {
	DoctorDao doc = new DoctorDaoImpl();
	List<Doctor> doctor =  doc.getSpecialization("SKIN");
	List<Doctor> doctor3 =  doc.showDoctorDao();
	for (Doctor doctor2 : doctor3) {
		System.out.println(doctor2);
	}
	System.out.println("hello");
}
}
