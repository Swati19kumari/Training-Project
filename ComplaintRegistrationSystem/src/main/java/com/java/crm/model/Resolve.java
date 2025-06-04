package com.java.crm.model;

import java.sql.Date;

public class Resolve {

	private int ResolveId;
	private String ComplaintID;
	private Date ComplaintDate;
	private Date ResolveDate;
	private String ResolvedBy;
	private String Comments;
	private transient long tat;

	@Override
	public String toString() {
		return "Resolve [ResolveId=" + ResolveId + ", ComplaintID=" + ComplaintID + ", ComplaintDate=" + ComplaintDate
				+ ", ResolveDate=" + ResolveDate + ", ResolvedBy=" + ResolvedBy + ", Comments=" + Comments + ", tat="
				+ tat + "]";
	}

	public int getResolveId() {
		return ResolveId;
	}

	public void setResolveId(int resolveId) {
		ResolveId = resolveId;
	}

	public String getComplaintID() {
		return ComplaintID;
	}

	public void setComplaintID(String complaintID) {
		ComplaintID = complaintID;
	}

	public Date getComplaintDate() {
		return ComplaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		ComplaintDate = complaintDate;
	}

	public Date getResolveDate() {
		return ResolveDate;
	}

	public void setResolveDate(Date resolveDate) {
		ResolveDate = resolveDate;
	}

	public String getResolvedBy() {
		return ResolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		ResolvedBy = resolvedBy;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public long getTat() {
		return tat;
	}

	public void setTat(long tat) {
		this.tat = tat;
	}

	public Resolve(int resolveId, String complaintID, Date complaintDate, Date resolveDate, String resolvedBy,
			String comments, long tat) {
		ResolveId = resolveId;
		ComplaintID = complaintID;
		ComplaintDate = complaintDate;
		ResolveDate = resolveDate;
		ResolvedBy = resolvedBy;
		Comments = comments;
		this.tat = tat;
	}

	public Resolve() {
	}

}
