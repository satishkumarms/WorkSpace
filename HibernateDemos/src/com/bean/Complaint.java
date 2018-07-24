package com.bean;

import java.sql.Date;

public class Complaint {

	private Long complaintId;
	private String complaintDetails;
	private Date dateofComplaint;
	private String status;
	private Customer customer;
	public Date getDateofComplaint() {
		return dateofComplaint;
	}
	public void setDateofComplaint(Date dateofComplaint) {
		this.dateofComplaint = dateofComplaint;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Complaint() {
		super();
	}
	public Complaint(String complaintDetails, Date date, String status, Customer customer) {
		super();
		this.complaintDetails = complaintDetails;
		this. dateofComplaint = date;
		this.status = status;
        this.customer = customer;
	}
	public Long getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}
	public String getComplaintDetails() {
		return complaintDetails;
	}
	public void setComplaintDetails(String complaintDetails) {
		this.complaintDetails = complaintDetails;
	}
	public Date getDate() {
		return  dateofComplaint;
	}
	public void setDate(Date date) {
		this. dateofComplaint = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
