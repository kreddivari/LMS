package com.zen.smi.bo;

import java.io.Serializable;
import java.util.Date;

public class UsersBookBO implements Serializable {
	public int getUsersBooksId() {
		return usersBooksId;
	}

	public void setUsersBooksId(int usersBooksId) {
		this.usersBooksId = usersBooksId;
	}

	public int getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(int bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public BookBO getBook() {
		return book;
	}

	public void setBook(BookBO book) {
		this.book = book;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	
	private int usersBooksId;
	private int bookStatus;
	private Date bookedDate;
	private Date expiryDate;
	private BookBO book;
	private UserBO user;

	public UsersBookBO() {
	}
	
}