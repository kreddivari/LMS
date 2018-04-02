package com.zen.smi.bo;

import java.io.Serializable;


public class BookCategoryBO implements Serializable {
	
	private int bookCategoryId;
	private BookBO book;	
	private CategoryBO category;
	
	public int getBookCategoryId() {
		return bookCategoryId;
	}

	public void setBookCategoryId(int bookCategoryId) {
		this.bookCategoryId = bookCategoryId;
	}

	public BookBO getBook() {
		return book;
	}

	public void setBook(BookBO book) {
		this.book = book;
	}

	public CategoryBO getCategory() {
		return category;
	}

	public void setCategory(CategoryBO category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	
	

	public BookCategoryBO() {
	}
	
	
}