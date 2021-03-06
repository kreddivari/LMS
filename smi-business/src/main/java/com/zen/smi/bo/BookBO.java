package com.zen.smi.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */

public class BookBO implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private int id;	
	private String bkAuthor;	
	private String bkDesc;	 
	private String bkName;
	private int bkYear;	
	private int ct_id;
	private Date createdDate;	
	private int statusFlag;	
	private Date updatedDate;	
	private List<BookCategoryBO> bookCategories;
	private List<UserFineBO> userFines;
	private List<UsersBookBO> usersBooks;
	
	public BookBO() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBkAuthor() {
		return bkAuthor;
	}
	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}
	public String getBkDesc() {
		return bkDesc;
	}
	public void setBkDesc(String bkDesc) {
		this.bkDesc = bkDesc;
	}
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public int getBkYear() {
		return bkYear;
	}
	public void setBkYear(int bkYear) {
		this.bkYear = bkYear;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public List<BookCategoryBO> getBookCategories() {
		return bookCategories;
	}
	public void setBookCategories(List<BookCategoryBO> bookCategories) {
		this.bookCategories = bookCategories;
	}
	public List<UserFineBO> getUserFines() {
		return userFines;
	}
	public void setUserFines(List<UserFineBO> userFines) {
		this.userFines = userFines;
	}
	public List<UsersBookBO> getUsersBooks() {
		return usersBooks;
	}
	public void setUsersBooks(List<UsersBookBO> usersBooks) {
		this.usersBooks = usersBooks;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getCt_id() {
		return ct_id;
	}
	public void setCt_id(int ct_id) {
		this.ct_id = ct_id;
	}
}