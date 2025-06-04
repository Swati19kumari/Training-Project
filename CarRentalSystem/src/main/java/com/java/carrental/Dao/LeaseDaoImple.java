package com.java.carrental.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.java.carrental.model.Lease;
import com.java.carrental.model.Type;
import com.java.carrental.util.ConnectionHelper;

public class LeaseDaoImple implements LeaseDao {
	static Connection con;
    static PreparedStatement psmt;
    

	@Override
	public Lease createLease(int customerId, int carId, LocalDate startDate, LocalDate endDate) throws ClassNotFoundException, SQLException {
		
		    Lease lease = new Lease();
		    lease.setCutomerId(customerId);
		    lease.setVehicleId(carId);
		    lease.setStartDate(startDate);
		    lease.setEndDate(endDate);

		    long startEpoch = startDate.toEpochDay();
		    long endEpoch = endDate.toEpochDay();
		    long days = endEpoch - startEpoch + 1;

		    lease.setType(days >= 30 ? Type.MONTHLYLEASE : Type.DAILYLEASE);

		    try (Connection con = ConnectionHelper.getConnection()) {
		        String sql = "INSERT INTO Lease(vehicleID, customerID, startDate, endDate, type) VALUES (?, ?, ?, ?, ?)";
		        try (PreparedStatement psmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		            psmt.setInt(1, lease.getVehicleId());
		            psmt.setInt(2, lease.getCutomerId());
		            psmt.setDate(3, Date.valueOf(lease.getStartDate()));
		            psmt.setDate(4, Date.valueOf(lease.getEndDate()));
		            psmt.setString(5, lease.getType().name());

		            int rows = psmt.executeUpdate();
		            if (rows > 0) {
		                try (ResultSet rs = psmt.getGeneratedKeys()) {
		                    if (rs.next()) {
		                        lease.setLeaseId(rs.getInt(1));
		                    }
		                }
		            }
		        }
		    }
		    return lease;
		}


	@Override
	public Lease returnLeaseByIdDaoImpl(int leaseId) throws ClassNotFoundException, SQLException {
		Lease lease=new Lease();
		 
		String cmd="SELECT * FROM lease WHERE leaseID=?;";
		con=ConnectionHelper.getConnection();
		psmt=con.prepareStatement(cmd);
		psmt.setInt(1, leaseId);
		
		ResultSet res=psmt.executeQuery();
		if(res.next()) {
			lease.setLeaseId(res.getInt("leaseID"));
			lease.setVehicleId(res.getInt("vehicleID"));
			lease.setCutomerId(res.getInt("customerID"));
			lease.setStartDate(res.getDate("startDate").toLocalDate());
			lease.setEndDate(res.getDate("endDate").toLocalDate());
			lease.setType(Type.valueOf(res.getString("type"))); 
		}
		return lease;
		
	}

	@Override
	public List<Lease> listActiveLeaseDaoImpl() throws SQLException, ClassNotFoundException {
	    Lease lease;
	    List<Lease> activeList = new ArrayList<Lease>();

	    String cmd = "SELECT a.leaseID, a.vehicleID, a.customerID, a.startDate, a.endDate, a.type " +
	                 "FROM lease a INNER JOIN Vehicle b ON a.vehicleID = b.vehicleID WHERE b.status = 'AVAILABLE';";

	    con = ConnectionHelper.getConnection();
	    psmt = con.prepareStatement(cmd);

	    ResultSet res = psmt.executeQuery();
	    while (res.next()) {
	        lease = new Lease();
	        lease.setLeaseId(res.getInt("leaseID"));
	        lease.setVehicleId(res.getInt("vehicleID"));
	        lease.setCutomerId(res.getInt("customerID"));
	        lease.setStartDate(res.getDate("startDate").toLocalDate());
	        lease.setEndDate(res.getDate("endDate").toLocalDate());

	        // Check if type is not null before setting it
	        String typeString = res.getString("type");
	        if (typeString != null) {
	            lease.setType(Type.valueOf(typeString));
	        } else {
	            // Handle the case where type is null, if necessary
	            System.out.println("Warning: Lease ID " + lease.getLeaseId() + " does not have a type assigned.");
	        }

	        activeList.add(lease);
	    }
	    return activeList;
	}


	@Override
	public List<Lease> listLeaseHistoryDaoImple() throws SQLException, ClassNotFoundException {
		 List<Lease> leaseHistory = new ArrayList<>();
		    String cmd = "SELECT * FROM lease ORDER BY leaseID DESC";
		     con= ConnectionHelper.getConnection();
		    psmt = con.prepareStatement(cmd);
		    ResultSet res = psmt.executeQuery();

		    while (res.next()) {
		        Lease lease = new Lease();
		        lease.setLeaseId(res.getInt("leaseID"));
		        lease.setVehicleId(res.getInt("vehicleID"));
		        lease.setCutomerId(res.getInt("customerID"));
		        lease.setStartDate(res.getDate("startDate").toLocalDate());
		        lease.setEndDate(res.getDate("endDate").toLocalDate());
		        lease.setType(Type.valueOf(res.getString("type")));
		        leaseHistory.add(lease);
		    }
		    return leaseHistory;
		}

}

        





