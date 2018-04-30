package com.zen.smi.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.zen.smi.dao.BookCategoryDAO;
import com.zen.smi.dao.entities.Book;
import com.zen.smi.dao.entities.BookCategory;
import com.zen.smi.dao.exception.GenericDAOException;

public class BookCategoryDAOImpl extends BaseDAOImpl<BookCategory, Serializable> implements BookCategoryDAO {

	public BookCategoryDAOImpl() {
		super(BookCategory.class);
	}
	
	public List<BookCategory> getAllBookCategories(int id) throws GenericDAOException {
		String query="from BookCategory where category.id = "+id+"";
		List<BookCategory> book_categories=load(query);		
		return book_categories;
	}
	public static void main(String[] args) throws Exception {
		BookCategoryDAOImpl impl=new BookCategoryDAOImpl();
		int id=1;
		List<BookCategory> book_categories=impl.getAllBookCategories(id);
		System.out.println(book_categories);
	}
	public void createBookCategory(BookCategory bookCategory) throws GenericDAOException {
		saveOrUpdate(bookCategory);
	}
}
