package com.java.crm.Dao;

import java.util.List;

import com.java.crm.model.Complaint;

public interface ComplaintDao {

	void addComplaint(Complaint complaint);

	Complaint searchComplaintById(String complaintID);

	List<Complaint> getAllComplaints();
}
