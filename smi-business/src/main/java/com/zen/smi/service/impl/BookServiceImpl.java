package com.zen.smi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.zen.smi.bo.BookBO;
import com.zen.smi.dao.entities.Book;
import com.zen.smi.dao.entities.BookCategory;
import com.zen.smi.dao.entities.Category;
import com.zen.smi.dao.entities.Notification;
import com.zen.smi.dao.entities.UserNotification;
import com.zen.smi.dao.entities.UsersBooks;
import com.zen.smi.dao.exception.GenericDAOException;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.BookService;

public class BookServiceImpl extends BaseService implements BookService {
	
	
	private static final Logger LOGGER = Logger.getLogger(BookServiceImpl.class);

   

	public int getbookByName(String name) throws BusinessException {
		int id=getBooksDAO().getBookByName("select * from book where bk_name='"+name+"'");
		return id;
	}

	public String createbook(BookBO bookBO) throws BusinessException {
		String result=null;
		try {
			Book book=new Book();
			Category category=new Category();
			
				book.setBkAuthor(bookBO.getBkAuthor());
				book.setBkName(bookBO.getBkName());
				book.setBkYear(bookBO.getBkYear());
				book.setStatusFlag(0);
				book.setCreatedDate(new Date());
								
			getBooksDAO().createUser(book);
			BookCategory bookCategory=new BookCategory();
			category.setId(bookBO.getCt_id());
			bookCategory.setBook(book);
			bookCategory.setCategory(category);
			result= "success";
		} catch (GenericDAOException e) {
			result= "failed";
            throw new BusinessException(e);			
		}		
		return result;
	}
	public String updatebook(BookBO bookBO) throws BusinessException {
		String result=null;
		try {
			    Book book=new Book();
				book.setId(bookBO.getId());	
				book.setUpdatedDate(bookBO.getUpdatedDate());			
				book.setBkAuthor(bookBO.getBkAuthor());
				book.setBkName(bookBO.getBkName());
				book.setBkYear(bookBO.getBkYear());
				book.setStatusFlag(bookBO.getStatusFlag());
				book.setCreatedDate(bookBO.getCreatedDate());								
		    	getBooksDAO().createUser(book);
		        UsersBooks userBook=getUserBooksDAO().getAllUsersBooksbyBookId(bookBO.getId());
		        Notification notification=new Notification();
				notification.setNtDesc("Notification on Book:#"+book.getId());
				notification.setNtName("Status update notification");
				notification.setNtText("Book reservation of Book:"+book.getBkName()+" "+"on Date"+book.getCreatedDate()+" "+"is Approved!");
				int notification_id=getNotificationDAO().createNotification(notification);
				notification.setId(notification_id);
				UserNotification userNotification = new UserNotification();
				userNotification.setUsers(userBook.getUsers());
				userNotification.setNotification(notification);		
				userNotification.setStatus("UNREAD");				
				getUserNotificationDAO().createUserNotification(userNotification);
			    result= "success";
		} catch (GenericDAOException e) {
			result= "failed";
            throw new BusinessException(e);			
		}		
		return result;
	}

	public List<BookBO> getAllBooks() throws BusinessException {
		List<BookBO> booksBO=new ArrayList<BookBO>();
		try {
			List<Book> books=getBooksDAO().getAllBooks();
			for(Book book:books){
				BookBO bookBO=new BookBO();
				bookBO.setBkAuthor(book.getBkAuthor());
				bookBO.setBkName(book.getBkName());
				bookBO.setBkYear(book.getBkYear());
				bookBO.setId(book.getId());
				bookBO.setStatusFlag(book.getStatusFlag());
				if(bookBO.getStatusFlag()==0){
					booksBO.add(bookBO);
				}
								
			}
		} catch (GenericDAOException e) {
			throw new BusinessException(e);			
		}
		return booksBO;
	}
	public List<BookBO> getAllBooksForAdmin() throws BusinessException {
		List<BookBO> booksBO=new ArrayList<BookBO>();
		try {
			List<Book> books=getBooksDAO().getAllBooks();
			for(Book book:books){
				BookBO bookBO=new BookBO();
				bookBO.setBkAuthor(book.getBkAuthor());
				bookBO.setBkName(book.getBkName());
				bookBO.setBkYear(book.getBkYear());
				bookBO.setId(book.getId());
				bookBO.setStatusFlag(book.getStatusFlag());
				booksBO.add(bookBO);								
			}
		} catch (GenericDAOException e) {
			throw new BusinessException(e);			
		}
		return booksBO;
	}
	
	public String deletebook(BookBO bookBO) throws BusinessException {
		String result=null;
		try {
			Book book=new Book();
			if(bookBO.getId()>0){				
				book.setId(bookBO.getId());	
				getBooksDAO().deleteBook(book);
			}					
			
			result= "success";
		} catch (GenericDAOException e) {
			result= "failed";
            throw new BusinessException(e);			
		}		
		return result;
	}

	public List<BookBO> retrieveByValue(BookBO bookbo) throws BusinessException {
		    Book bookEntity=new Book();	
		    List<BookBO> booksBO=new ArrayList<BookBO>();
		    bookEntity.setBkAuthor(bookbo.getBkAuthor());
		    bookEntity.setBkName(bookbo.getBkName());
		    bookEntity.setBkYear(bookbo.getBkYear());
		    bookEntity.setStatusFlag(bookbo.getStatusFlag());
		    try {
		    	List<Book> books=getBooksDAO().retrieveByValue(bookEntity);
		    	for(Book book:books){
					BookBO bookBO=new BookBO();
					bookBO.setBkAuthor(book.getBkAuthor());
					bookBO.setBkName(book.getBkName());
					bookBO.setBkYear(book.getBkYear());
					bookBO.setId(book.getId());
					bookBO.setStatusFlag(book.getStatusFlag());
					booksBO.add(bookBO);				
				}
			} catch (GenericDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return booksBO;
	}
	
	public List<BookBO> retrieveByCategory(int id) throws BusinessException {
		List<Book> books=new ArrayList<Book>();		
		List<BookBO> booksBO=new ArrayList<BookBO>();
		try {			
			List<BookCategory> book_categories=getBookcategoryDAO().getAllBookCategories(id);
			for(BookCategory book_category:book_categories){
				books.add(book_category.getBook());				
			}
			if(!books.isEmpty()){
				for(Book book:books){
					BookBO bookBO=new BookBO();
					bookBO.setBkAuthor(book.getBkAuthor());
					bookBO.setBkName(book.getBkName());
					bookBO.setBkYear(book.getBkYear());
					bookBO.setId(book.getId());
					bookBO.setStatusFlag(book.getStatusFlag());
					booksBO.add(bookBO);				
				}
			}
		} catch (GenericDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booksBO;
	}
	
}
