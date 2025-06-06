package com.java.lib.model;




public class Books {

	private int id;
	private String name;
	private String author;
	private String edition;
	private String dept;
	private int noOfBooks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getNoOfBooks() {
		return noOfBooks;
	}
	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}
	public Books(int id, String name, String author, String edition, String dept, int noOfBooks) {
		
		this.id = id;
		this.name = name;
		this.author = author;
		this.edition = edition;
		this.dept = dept;
		this.noOfBooks = noOfBooks;
	}
	public Books() {
		
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", edition=" + edition + ", dept=" + dept
				+ ", noOfBooks=" + noOfBooks + "]";
	}
	
	
	
}
