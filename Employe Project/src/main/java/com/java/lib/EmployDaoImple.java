package com.java.lib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.java.lib.Employ;

public class EmployDaoImple implements EmployDao{

	@Override
	public List<Employ> showEmployDao() {
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Connected");
		Session session=sf.openSession();
		Query query=session.createQuery("from Employ");
		List<Employ> employList=query.list();
		return employList;
		}
	

	@Override
	public Employ searchEmployDao(int empno) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Query query=session.createQuery("from Employ where empno="+empno);
		Employ employ=(Employ)query.uniqueResult();
		return employ;
	}

	@Override
	public String addEmployDao(Employ employ) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction trans=session.beginTransaction();
		session.save(employ);
		trans.commit();
		return "Employ Record Inserted...";
		
	}

	@Override
	public String updateEmployDao(Employ employ) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session =sf.openSession();
		Transaction trans=session.beginTransaction();
		session.update(employ);
		trans.commit();
		return "Employ Record Updated..";
	}

	@Override
	public String deleteEmployDao(int empno) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Employ employ=searchEmployDao(empno);
		Transaction trans=session.beginTransaction();
		session.delete(employ);
		trans.commit();
		return "Employ Record Deleted...";
		
	}

	
}
