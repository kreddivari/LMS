package com.zen.smi.dao.impl;

import java.io.Serializable;
import java.util.List;
import com.zen.smi.dao.BooksDAO;
import com.zen.smi.dao.entities.Book;
import com.zen.smi.dao.exception.GenericDAOException;

public class BooksDAOImpl extends BaseDAOImpl<Book, Serializable> implements BooksDAO {

	public BooksDAOImpl() {
		super(Book.class);
	}
	
	public static void main(String[] args) throws Exception {
		BooksDAOImpl impl=new BooksDAOImpl();
		impl.getAllBooks();
	}
	
	public void createUser(Book book) throws GenericDAOException {
		saveOrUpdate(book);
	}
	public void updateBook(Book book) throws GenericDAOException {
		saveOrUpdate(book);
	}
	
	public List<Book> getAllBooks() throws GenericDAOException {
		List<Book> books=retrieveAll();
		return books;
	}
}
