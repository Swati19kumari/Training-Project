package com.java.lib.model;

import java.sql.Date;

import lombok.Data;

public class TranBook {
	
	private String userName;
	private int bookId;
	private Date fromDate;
	private int fine;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public TranBook(String userName, int bookId, Date fromDate, int fine) {
		super();
		this.userName = userName;
		this.bookId = bookId;
		this.fromDate = fromDate;
		this.fine = fine;
	}
	public TranBook() {
		super();
	}
	@Override
	public String toString() {
		return "TranBook [userName=" + userName + ", bookId=" + bookId + ", fromDate=" + fromDate + ", fine=" + fine
				+ "]";
	}
	
	
	
	
	
}
