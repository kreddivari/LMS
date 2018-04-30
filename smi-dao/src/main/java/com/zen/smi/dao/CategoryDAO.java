package com.zen.smi.dao;

import java.io.Serializable;
import java.util.List;

import com.zen.smi.dao.entities.Category;
import com.zen.smi.dao.exception.GenericDAOException;

public interface CategoryDAO extends BaseDAO<Category, Serializable> {
	public void createCategory(Category category) throws GenericDAOException;
	public void updateCategory(Category category) throws GenericDAOException;	
	public List<Category> getAllCategories() throws GenericDAOException ;
	public Category getCategoryById(int id) throws GenericDAOException ;
}
