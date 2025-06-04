package com.java.carrental.Dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.java.carrental.model.Lease;

public interface LeaseDao {
	Lease createLease(int customerId,int carId,LocalDate startDate, LocalDate endDate) throws ClassNotFoundException, SQLException;
	
	Lease returnLeaseByIdDaoImpl(int leaseId) throws ClassNotFoundException, SQLException;
	List<Lease> listActiveLeaseDaoImpl() throws SQLException, ClassNotFoundException;
	List<Lease> listLeaseHistoryDaoImple() throws SQLException, ClassNotFoundException;
	
}
