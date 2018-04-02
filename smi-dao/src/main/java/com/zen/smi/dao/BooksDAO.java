package com.zen.smi.dao;

import java.io.Serializable;
import java.util.List;

import com.zen.smi.dao.entities.Book;
import com.zen.smi.dao.exception.GenericDAOException;

public interface BooksDAO extends BaseDAO<Book, Serializable> {

	public void createUser(Book book) throws GenericDAOException;
	public void updateBook(Book book) throws GenericDAOException ;	
	public List<Book> getAllBooks() throws GenericDAOException ;

}
