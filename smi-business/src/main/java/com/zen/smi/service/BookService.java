package com.zen.smi.service;

import java.util.List;

import com.zen.smi.bo.BookBO;
import com.zen.smi.exception.BusinessException;

public interface BookService {

	BookBO getbookByName(String name) throws BusinessException;	
	String createbook(BookBO bookBO) throws BusinessException;
	List<BookBO> getAllBooks() throws BusinessException;	
}
