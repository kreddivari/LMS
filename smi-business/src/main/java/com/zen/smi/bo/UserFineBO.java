package com.zen.smi.bo;

import java.io.Serializable;
import java.util.Date;

public class UserFineBO implements Serializable {
	public int getUserFinesId() {
		return userFinesId;
	}

	public void setUserFinesId(int userFinesId) {
		this.userFinesId = userFinesId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BookBO getBook() {
		return book;
	}

	public void setBook(BookBO book) {
		this.book = book;
	}

	public FineBO getFine() {
		return fine;
	}

	public void setFine(FineBO fine) {
		this.fine = fine;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

	
	private int userFinesId;
	private String desc;
	private Date payDate;
	private int status;
	private BookBO book;
	private FineBO fine;
	private UserBO user;

	public UserFineBO() {
	}
	
	
}