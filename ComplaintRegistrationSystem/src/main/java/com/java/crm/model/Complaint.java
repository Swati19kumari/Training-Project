package com.java.crm.model;

import java.sql.Date;

import com.java.enums.Severity;
import com.java.enums.Status;

public class Complaint {

	private String ComplaintId;
	private String ComplaintType;
	private String cdescription;
	private Date ComplaintDate;
	private Severity severity;
	private Status status;
	@Override
	public String toString() {
		return "Complaint [ComplaintId=" + ComplaintId + ", ComplaintType=" + ComplaintType + ", cdescription="
				+ cdescription + ", ComplaintDate=" + ComplaintDate + ", severity=" + severity + ", status=" + status
				+ "]";
	}
	public String getComplaintId() {
		return ComplaintId;
	}
	public void setComplaintId(String complaintId) {
		ComplaintId = complaintId;
	}
	public String getComplaintType() {
		return ComplaintType;
	}
	public void setComplaintType(String complaintType) {
		ComplaintType = complaintType;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	public Date getComplaintDate() {
		return ComplaintDate;
	}
	public void setComplaintDate(Date complaintDate) {
		ComplaintDate = complaintDate;
	}
	public Severity getSeverity() {
		return severity;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Complaint(String complaintId, String complaintType, String cdescription, Date complaintDate,
			Severity severity, Status status) {
		ComplaintId = complaintId;
		ComplaintType = complaintType;
		this.cdescription = cdescription;
		ComplaintDate = complaintDate;
		this.severity = severity;
		this.status = status;
	}
	public Complaint() {
	}

	
	
	
	

}
