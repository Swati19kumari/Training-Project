package com.java.crm.Dao;

import java.util.List;

import com.java.crm.model.Resolve;

public interface ResolveDao {

	String addResolve(Resolve resolve);

	List<Resolve> getAllResolves();

	Resolve getResolveByComplaintId(String complaintId);
}
