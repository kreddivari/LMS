package com.zen.smi.service;

import java.util.List;

import com.zen.smi.bo.BookBO;
import com.zen.smi.bo.UsersBookBO;
import com.zen.smi.exception.BusinessException;

public interface UserBookService {

		String createbook(UsersBookBO usersBookBO) throws BusinessException;
	    List<BookBO> getAllUserBooksById(String name) throws BusinessException;
	    void createBookTimeNotification(String userName) throws BusinessException;
		
}
