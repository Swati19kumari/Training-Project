package com.java.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class LogindaoImpl implements Logindao {

	SessionFactory sessionFactory;

	Session session;

	@Override
	public String SignUp(Login login) {

		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();

		// 1. Hash the password before storing
		String hashed = PasswordUtil.hashPassword(login.getPasscode());
		login.setPasscode(hashed); // overwrite raw password with hashed one

		session.save(login);
		trans.commit();
		session.close();

		return null; 


	}

	@Override
	public String SignIn(Login login) {

	    FacesContext context = FacesContext.getCurrentInstance();

	    // 1. Check for empty username or password
	    if (login.getUsername() == null || login.getUsername().trim().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                "Username cannot be empty", ""));
	        return null;
	    }

	    if (login.getPasscode() == null || login.getPasscode().trim().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                "Password cannot be empty", ""));
	        return null;
	    }

	    // 2. Proceed with login
	    sessionFactory = HibernateUtil.getSessionFactory();
	    session = sessionFactory.openSession();

	    String enteredHashed = PasswordUtil.hashPassword(login.getPasscode());

	    String hql = "FROM Login WHERE username = :uname AND passcode = :pcode";
	    Query query = session.createQuery(hql);
	    query.setParameter("uname", login.getUsername());
	    query.setParameter("pcode", enteredHashed);

	    Login dbLogin = (Login) query.uniqueResult();

	    session.close();

	    if (dbLogin != null) {
	        return "menu"; // assuming you're using JSF 1.2 with faces-config navigation
	    } else {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
	                "Invalid username or password", ""));
	        return null; // stay on the same page
	    }
	}



}
