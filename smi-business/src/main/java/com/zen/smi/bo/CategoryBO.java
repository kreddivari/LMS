package com.zen.smi.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CategoryBO implements Serializable {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCtDesc() {
		return ctDesc;
	}

	public void setCtDesc(String ctDesc) {
		this.ctDesc = ctDesc;
	}

	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public List<BookCategoryBO> getBookCategories() {
		return bookCategories;
	}

	public void setBookCategories(List<BookCategoryBO> bookCategories) {
		this.bookCategories = bookCategories;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	
	private int id;
	private Date createdDate;
	private String ctDesc;
	private String ctName;
	private Date updatedTime;
	private List<BookCategoryBO> bookCategories;

	public CategoryBO() {
	}
	
}