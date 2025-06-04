package com.java.lib.model;



import java.sql.Date;

import lombok.Data;

public class TransReturn {
    private String username;
    private int bookId;
    private Date fromDate;
    private Date ToDate;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return ToDate;
	}
	public void setToDate(Date toDate) {
		ToDate = toDate;
	}
	public TransReturn(String username, int bookId, Date fromDate, Date toDate) {
		super();
		this.username = username;
		this.bookId = bookId;
		this.fromDate = fromDate;
		ToDate = toDate;
	}
	public TransReturn() {
		super();
	}
	@Override
	public String toString() {
		return "TransReturn [username=" + username + ", bookId=" + bookId + ", fromDate=" + fromDate + ", ToDate="
				+ ToDate + "]";
	}
    
    
}