package com.zen.smi.service;

import com.zen.smi.bo.BookBO;
import com.zen.smi.bo.UserBO;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.exception.UserException;

public interface BookService {

	UserBO getbookByName(String name) throws BusinessException;	
	String createbook(BookBO bookBOO) throws BusinessException;	
}
