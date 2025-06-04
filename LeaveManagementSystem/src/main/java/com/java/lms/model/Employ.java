package com.java.lms.model;

import java.sql.Date;

import lombok.Data;


public class Employ {

	int EmpId;
	String Emp_Name;
	String Emp_Mail;
	String Emp_Mob_No;
	Date EmpDtJoin;
	String Emp_Dept;
	int Emp_Manager_Id;
	int Emp_Avail_Leave_Bal;
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmp_Name() {
		return Emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}
	public String getEmp_Mail() {
		return Emp_Mail;
	}
	public void setEmp_Mail(String emp_Mail) {
		Emp_Mail = emp_Mail;
	}
	public String getEmp_Mob_No() {
		return Emp_Mob_No;
	}
	public void setEmp_Mob_No(String emp_Mob_No) {
		Emp_Mob_No = emp_Mob_No;
	}
	public Date getEmpDtJoin() {
		return EmpDtJoin;
	}
	public void setEmpDtJoin(Date empDtJoin) {
		EmpDtJoin = empDtJoin;
	}
	public String getEmp_Dept() {
		return Emp_Dept;
	}
	public void setEmp_Dept(String emp_Dept) {
		Emp_Dept = emp_Dept;
	}
	public int getEmp_Manager_Id() {
		return Emp_Manager_Id;
	}
	public void setEmp_Manager_Id(int emp_Manager_Id) {
		Emp_Manager_Id = emp_Manager_Id;
	}
	public int getEmp_Avail_Leave_Bal() {
		return Emp_Avail_Leave_Bal;
	}
	public void setEmp_Avail_Leave_Bal(int emp_Avail_Leave_Bal) {
		Emp_Avail_Leave_Bal = emp_Avail_Leave_Bal;
	}
	public Employ(int empId, String emp_Name, String emp_Mail, String emp_Mob_No, Date empDtJoin, String emp_Dept,
			int emp_Manager_Id, int emp_Avail_Leave_Bal) {
		super();
		EmpId = empId;
		Emp_Name = emp_Name;
		Emp_Mail = emp_Mail;
		Emp_Mob_No = emp_Mob_No;
		EmpDtJoin = empDtJoin;
		Emp_Dept = emp_Dept;
		Emp_Manager_Id = emp_Manager_Id;
		Emp_Avail_Leave_Bal = emp_Avail_Leave_Bal;
	}
	public Employ() {
		super();
	}
	@Override
	public String toString() {
		return "Employ [EmpId=" + EmpId + ", Emp_Name=" + Emp_Name + ", Emp_Mail=" + Emp_Mail + ", Emp_Mob_No="
				+ Emp_Mob_No + ", EmpDtJoin=" + EmpDtJoin + ", Emp_Dept=" + Emp_Dept + ", Emp_Manager_Id="
				+ Emp_Manager_Id + ", Emp_Avail_Leave_Bal=" + Emp_Avail_Leave_Bal + "]";
	}
	
	
}
