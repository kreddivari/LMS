package com.zen.smi.service.impl;

import org.apache.log4j.Logger;

import com.zen.smi.bo.BookBO;
import com.zen.smi.bo.UserBO;
import com.zen.smi.dao.entities.Book;
import com.zen.smi.dao.exception.GenericDAOException;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.BookService;

public class BookServiceImpl extends BaseService implements BookService {
	
	
	private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);

   

	public UserBO getbookByName(String name) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	public String createbook(BookBO bookBO) throws BusinessException {
		String result=null;
		try {
			Book book=getModelMapper().map(bookBO, Book.class);
			if(bookBO.getId()<=0){				
				book.setId(bookBO.getId());	
				book.setUpdatedDate(bookBO.getUpdatedDate());
			}	else{
				book.setCreatedDate(bookBO.getCreatedDate());
			}					
			getBooksDAO().createUser(book);
			result= "success";
		} catch (GenericDAOException e) {
			result= "failed";
            throw new BusinessException(e);			
		}		
		return result;
	}	
}
