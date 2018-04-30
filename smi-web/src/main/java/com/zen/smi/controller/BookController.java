package com.zen.smi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zen.smi.bo.BookBO;
import com.zen.smi.bo.UserBO;
import com.zen.smi.bo.UsersBookBO;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.BookService;
import com.zen.smi.service.UserBookService;


@Controller
public class BookController extends BaseController {
	
	/**
	 * Logger for HomePageController class.
	 */
	private static final Logger LOGGER = Logger.getLogger(BookController.class);
	
	@Autowired 
	BookService bookService;
	
	@Autowired 
	UserBookService userBookService;
	
	
	
	@RequestMapping(value = "/create_book", method = RequestMethod.POST)
	public @ResponseBody String createBook(@RequestBody String bookJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		
		try {
			
			BookBO bookBO= gson.fromJson(bookJson, BookBO.class);
			bookJson=bookService.createbook(bookBO);
			if(bookJson.equals("success")){
				int id=bookService.getbookByName(bookBO.getBkName());
				bookBO.setId(id);
			}
			bookJson=gson.toJson(bookBO);
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
	@RequestMapping(value = "/edit_book", method = RequestMethod.POST)
	public @ResponseBody String editBook(@RequestBody String bookJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		
		try {
			
			BookBO bookBO= gson.fromJson(bookJson, BookBO.class);
			bookJson=bookService.createbook(bookBO);			
			bookJson=gson.toJson(bookBO);
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
	@RequestMapping(value = "/search_book", method = RequestMethod.POST)
	public @ResponseBody String searchBook(@RequestBody String bookJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		
		try {			
			BookBO bookBO= gson.fromJson(bookJson, BookBO.class);
			List<BookBO> booksBO=bookService.retrieveByValue(bookBO);			
			bookJson=gson.toJson(booksBO);
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
	@RequestMapping(value = "/reserve_book/{book_id}", method = RequestMethod.POST)
	public @ResponseBody String reserveBook(@PathVariable("book_id") int book_id,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String bookJson = null;
		try {
			String  user = SecurityContextHolder.getContext().getAuthentication().getName();
			BookBO bookBO= new BookBO();
			bookBO.setId(book_id);
			UserBO userBO=new UserBO();
			userBO.setUserName(user);
			UsersBookBO usersBookBO = new UsersBookBO();
			usersBookBO.setBook(bookBO);
			usersBookBO.setUser(userBO);
			bookJson=userBookService.createbook(usersBookBO);			
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}

	@RequestMapping(value = "/delete/{book_id}", method = RequestMethod.POST)
	public @ResponseBody String deleteBook(@PathVariable("book_id") int book_id,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String bookJson = null;
		try {
			
			BookBO bookBO= new BookBO();
			bookBO.setId(book_id);			
			bookJson=bookService.deletebook(bookBO);			
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
	@RequestMapping(value = "/category/{category_id}", method = RequestMethod.POST)
	public @ResponseBody String getBooksByCategory(@PathVariable("category_id") int category_id,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String bookJson = null;
		try {			
			List<BookBO> booksBO=bookService.retrieveByCategory(category_id);	
			bookJson=gson.toJson(booksBO);
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
	@RequestMapping(value = "/all_books", method = RequestMethod.GET)
	public @ResponseBody String getAllBooks(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String bookJson = null;
		try {			
			List<BookBO> booksBO=bookService.getAllBooks();	
			bookJson=gson.toJson(booksBO);
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
	
	@RequestMapping(value = "/user_books", method = RequestMethod.GET)
	public @ResponseBody String getUserBooks(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String bookJson = null;
		String  userName = SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			List<BookBO> booksBO=userBookService.getAllUserBooksById(userName);
			bookJson=gson.toJson(booksBO);
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
	@RequestMapping(value = "/expity_check", method = RequestMethod.GET)
	public @ResponseBody String getBooksByCategory(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String bookJson = null;
		try {			
			String  userName = SecurityContextHolder.getContext().getAuthentication().getName();
			userBookService.createBookTimeNotification(userName);			
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
}
