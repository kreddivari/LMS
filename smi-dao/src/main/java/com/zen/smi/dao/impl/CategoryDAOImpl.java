package com.zen.smi.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.zen.smi.dao.CategoryDAO;
import com.zen.smi.dao.entities.Category;
import com.zen.smi.dao.exception.GenericDAOException;

public class CategoryDAOImpl extends BaseDAOImpl<Category, Serializable> implements CategoryDAO {

	public CategoryDAOImpl() {
		super(Category.class);
	}
	
	public static void main(String[] args) throws Exception {
		CategoryDAOImpl impl=new CategoryDAOImpl();
		impl.getAllCategories();
	}
	
	public void createCategory(Category category) throws GenericDAOException {
		saveOrUpdate(category);
	}
	public void updateCategory(Category category) throws GenericDAOException {
		saveOrUpdate(category);
	}
	
	public List<Category> getAllCategories() throws GenericDAOException {
		List<Category> categories=retrieveAll();
		return categories;
	}

	public Category getCategoryById(int id) throws GenericDAOException {
		Category category=findById(id);
		return category;
	}
}
