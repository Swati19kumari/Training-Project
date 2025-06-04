package com.java.lms.model;

import java.time.LocalDate;

import lombok.Data;


public class LeaveDetails {
		
		private int leaveId;
	    private int empId;
	    private LocalDate leaveStartDate;
	    private LocalDate leaveEndDate;
	    private LeaveType leaveType =getLeaveType().EL;
	    private String leaveReason;
	    private LeaveStatus leaveStatus = getLeaveStatus().PENDING;
	    private int NoOfDays;
		public int getLeaveId() {
			return leaveId;
		}
		public void setLeaveId(int leaveId) {
			this.leaveId = leaveId;
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public LocalDate getLeaveStartDate() {
			return leaveStartDate;
		}
		public void setLeaveStartDate(LocalDate leaveStartDate) {
			this.leaveStartDate = leaveStartDate;
		}
		public LocalDate getLeaveEndDate() {
			return leaveEndDate;
		}
		public void setLeaveEndDate(LocalDate leaveEndDate) {
			this.leaveEndDate = leaveEndDate;
		}
		public LeaveType getLeaveType() {
			return leaveType;
		}
		public void setLeaveType(LeaveType leaveType) {
			this.leaveType = leaveType;
		}
		public String getLeaveReason() {
			return leaveReason;
		}
		public void setLeaveReason(String leaveReason) {
			this.leaveReason = leaveReason;
		}
		public LeaveStatus getLeaveStatus() {
			return leaveStatus;
		}
		public void setLeaveStatus(LeaveStatus leaveStatus) {
			this.leaveStatus = leaveStatus;
		}
		public int getNoOfDays() {
			return NoOfDays;
		}
		public void setNoOfDays(int noOfDays) {
			NoOfDays = noOfDays;
		}
		public LeaveDetails(int leaveId, int empId, LocalDate leaveStartDate, LocalDate leaveEndDate,
				LeaveType leaveType, String leaveReason, LeaveStatus leaveStatus, int noOfDays) {
			super();
			this.leaveId = leaveId;
			this.empId = empId;
			this.leaveStartDate = leaveStartDate;
			this.leaveEndDate = leaveEndDate;
			this.leaveType = leaveType;
			this.leaveReason = leaveReason;
			this.leaveStatus = leaveStatus;
			NoOfDays = noOfDays;
		}
		public LeaveDetails() {
			super();
		}
		@Override
		public String toString() {
			return "LeaveDetails [leaveId=" + leaveId + ", empId=" + empId + ", leaveStartDate=" + leaveStartDate
					+ ", leaveEndDate=" + leaveEndDate + ", leaveType=" + leaveType + ", leaveReason=" + leaveReason
					+ ", leaveStatus=" + leaveStatus + ", NoOfDays=" + NoOfDays + "]";
		}
	    
	    
}