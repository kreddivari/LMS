package com.zen.smi.service;

import java.util.List;
import com.zen.smi.bo.CategoryBO;
import com.zen.smi.exception.BusinessException;

public interface CategoryService {	
	public void createCategory(CategoryBO category) throws BusinessException;
	public void updateCategory(CategoryBO category) throws BusinessException;	
	public List<CategoryBO> getAllCategories() throws BusinessException ;	
}
