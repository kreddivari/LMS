package com.zen.smi.service;

import java.util.List;

import com.zen.smi.bo.BookBO;
import com.zen.smi.dao.entities.Book;
import com.zen.smi.dao.exception.GenericDAOException;
import com.zen.smi.exception.BusinessException;

public interface BookService {

	int getbookByName(String name) throws BusinessException;	
	String createbook(BookBO bookBO) throws BusinessException;
	List<BookBO> getAllBooks() throws BusinessException;
	List<BookBO> getAllBooksForAdmin() throws BusinessException;
	public String deletebook(BookBO bookBO) throws BusinessException;
	public List<BookBO> retrieveByValue(BookBO bookBO) throws BusinessException;
	public List<BookBO> retrieveByCategory(int id) throws BusinessException;
	String updatebook(BookBO bookBO)throws BusinessException;
}
