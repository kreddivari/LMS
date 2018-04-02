package com.zen.smi.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FineBO implements Serializable {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public float getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(float fineAmount) {
		this.fineAmount = fineAmount;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public List<UserFineBO> getUserFines() {
		return userFines;
	}

	public void setUserFines(List<UserFineBO> userFines) {
		this.userFines = userFines;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	private int id;
	private String cause;	
	private float fineAmount;	
	private Date payDate;
	private List<UserFineBO> userFines;

	public FineBO() {
	}

	
}