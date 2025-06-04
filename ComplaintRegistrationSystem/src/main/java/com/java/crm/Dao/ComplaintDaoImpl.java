package com.java.crm.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.java.crm.model.Complaint;
import com.java.enums.Status;

public class ComplaintDaoImpl implements ComplaintDao{
	
	Session session;
	SessionFactory sf;
	
	@Override
    public void addComplaint(Complaint complaint) {
		
		    sf = new AnnotationConfiguration().configure().buildSessionFactory();
            session = sf.openSession();
            // Generate ID using private method
            String generatedID = generateComplaintID(session);
            complaint.setComplaintId(generatedID);
            complaint.setStatus(Status.PENDING);

            Transaction tx = session.beginTransaction();
            session.save(complaint);
            tx.commit();
        }

    private String generateComplaintID(Session session) {
        Query query = session.createQuery("select count(c) from Complaint c");
        long count = (long) query.uniqueResult();
        return String.format("C%03d", count + 1);
    }

	
	@Override
	public Complaint searchComplaintById(String complaintID) {
	    sf = new AnnotationConfiguration().configure().buildSessionFactory();
	    session = sf.openSession();
	    Query q = session.createQuery("from Complaint where complaintID = :complaintID");
	    q.setParameter("complaintID", complaintID);
	    Complaint com = (Complaint) q.uniqueResult();
	    return com;
	}

	@Override
	public List<Complaint> getAllComplaints() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		session = sf.openSession();
		List<Complaint> list = session.createQuery("from Complaint").list();
		return list;
	}

}
