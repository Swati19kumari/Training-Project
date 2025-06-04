package com.java.crm.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.java.crm.model.Resolve;
import com.java.enums.Status;

public class ResolveDaoImpl implements ResolveDao{
	
	    SessionFactory sf;
	    Session session;

	    @Override
	    public String addResolve(Resolve resolve) {
	        sf = new AnnotationConfiguration().configure().buildSessionFactory();
	        session = sf.openSession();
	        Transaction tx = session.beginTransaction();

	        // Save the Resolve object
	        session.save(resolve);

	        // Update the status of the complaint to "RESOLVED"
	        String hql = "UPDATE Complaint SET status = :status WHERE complaintId = :complaintId";
	        Query query = session.createQuery(hql);
	        query.setParameter("status", Status.RESOLVED);  // Assuming Status.RESOLVED is an enum value
	        query.setParameter("complaintId", resolve.getComplaintID());

	        // Execute the update
	        query.executeUpdate();

	        // Commit the transaction
	        tx.commit();

	        // Close session
	        session.close();

	        return "Resolve added and status updated successfully!";
	    }


	    @Override
	    public List<Resolve> getAllResolves() {
	        sf = new AnnotationConfiguration().configure().buildSessionFactory();
	        session = sf.openSession();

	        List<Resolve> resolveList = session.createQuery("from Resolve").list();

	        // Calculate TAT for each Resolve object
	        for (Resolve r : resolveList) {
	            if (r.getComplaintDate() != null && r.getResolveDate() != null) {
	                long tat = (r.getResolveDate().getTime() - r.getComplaintDate().getTime()) / (1000 * 60 * 60 * 24);
	                r.setTat(tat);
	            }
	        }

	        return resolveList;
	    }

	    @Override
	    public Resolve getResolveByComplaintId(String complaintId) {
	        sf = new AnnotationConfiguration().configure().buildSessionFactory();
	        session = sf.openSession();

	        // Modify this line to avoid parsing the complaintId as an integer
	        Query q = session.createQuery("from Resolve where complaintID = :cid");
	        q.setParameter("cid", complaintId); // pass complaintId directly as string

	        Resolve r = (Resolve) q.uniqueResult();

	        if (r != null && r.getComplaintDate() != null && r.getResolveDate() != null) {
	            long tat = (r.getResolveDate().getTime() - r.getComplaintDate().getTime()) / (1000 * 60 * 60 * 24);
	            r.setTat(tat);
	        }

	        return r;
	    }

	}

