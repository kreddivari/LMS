package com.zen.smi.dao;

import java.io.Serializable;
import java.util.List;

import com.zen.smi.dao.entities.BookCategory;
import com.zen.smi.dao.exception.GenericDAOException;

public interface BookCategoryDAO extends BaseDAO<BookCategory, Serializable> {
	
	public List<BookCategory> getAllBookCategories(int id) throws GenericDAOException;
	public void createBookCategory(BookCategory bookCategory)throws GenericDAOException;
	
}