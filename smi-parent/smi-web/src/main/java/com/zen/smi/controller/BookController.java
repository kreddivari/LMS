package com.zen.smi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zen.smi.bo.BookBO;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.BookService;


@Controller
public class BookController extends BaseController {
	
	/**
	 * Logger for HomePageController class.
	 */
	private static final Logger LOGGER = Logger.getLogger(BookController.class);
	
	@Autowired 
	BookService bookService;
	
	
	
	@RequestMapping(value = "/create_book", method = RequestMethod.POST)
	public @ResponseBody String createBook(@RequestBody String userJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String bookJson = null;
		try {
			
			BookBO bookBO= gson.fromJson(bookJson, BookBO.class);
			bookJson=bookService.createbook(bookBO);			
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
	
	
}
