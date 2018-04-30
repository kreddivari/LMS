package com.zen.smi.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.zen.smi.bo.BookBO;
import com.zen.smi.bo.UsersBookBO;
import com.zen.smi.dao.entities.Book;
import com.zen.smi.dao.entities.Notification;
import com.zen.smi.dao.entities.UserNotification;
import com.zen.smi.dao.entities.Users;
import com.zen.smi.dao.entities.UsersBooks;
import com.zen.smi.dao.exception.GenericDAOException;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.UserBookService;

public class UserBookServiceImpl extends BaseService implements UserBookService{

	public String createbook(UsersBookBO usersBookBO) throws BusinessException {
		String result=null;
		try {
			Date dt = new Date();
			Users users = getUserDAO().getUserByUserName(usersBookBO.getUser().getUserName());
			Book db_book=getBooksDAO().findById(usersBookBO.getBook().getId());			
			db_book.setStatusFlag(1);
			db_book.setUpdatedDate(dt);			
			getBooksDAO().createUser(db_book);
			UsersBooks usersBook =new UsersBooks();
			usersBook.setUsers(users);
			usersBook.setBook(db_book);
			usersBook.setBookedDate(dt);	
			usersBook.setBookStatus(1);
			Calendar c = Calendar.getInstance(); 
			c.setTime(dt); 
			c.add(Calendar.DATE, 3);
			Date dtx = c.getTime();
			usersBook.setExpiryDate(dtx);			
			result=getUserBooksDAO().createUserBook(usersBook);
			if(result.equals("SUCCESS")){
				Notification notification=new Notification();
				//notification.setId(usersBook.getBookStatus());	
				notification.setNtDesc("Notification on Book:#"+db_book.getId());
				notification.setNtName("Status update notification");
				notification.setNtText("Book reservation of Book:"+db_book.getBkName()+" "+"on Date"+db_book.getCreatedDate()+" "+"is submitted for Admin Approval");
				int notification_id=getNotificationDAO().createNotification(notification);
				notification.setId(notification_id);
				UserNotification userNotification = new UserNotification();
				userNotification.setUsers(users);
				userNotification.setNotification(notification);		
				userNotification.setStatus("UNREAD");				
				getUserNotificationDAO().createUserNotification(userNotification);
			}
		} catch (GenericDAOException e) {			
			e.printStackTrace();
			result="FAILURE";
		}
		return result;
	}
	
	public List<BookBO> getAllUserBooksById(String name) throws BusinessException {
		List<BookBO> booksBO = new ArrayList<BookBO>();
		List<Book> books= new ArrayList<Book>();
		try {			
			Users users = getUserDAO().getUserByUserName(name);
			List<UsersBooks> userBooks=getUserBooksDAO().getAllUsersBooksbyId(users.getUserId());
			for(UsersBooks userBook:userBooks){
				books.add(userBook.getBook());
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
			e.printStackTrace();
		}
		return booksBO;
	}
	
	public void createBookTimeNotification(String name) throws BusinessException {
		List<BookBO> booksBO = new ArrayList<BookBO>();
		List<Book> books= new ArrayList<Book>();
		try {			
			Users users = getUserDAO().getUserByUserName(name);
			List<UsersBooks> userBooks=getUserBooksDAO().getAllUsersBooksbyId(users.getUserId());
			for(UsersBooks userBook:userBooks){
				books.add(userBook.getBook());
			}
			if(!books.isEmpty()){
				for(Book book:books){
					int days = daysBetween(book.getCreatedDate(), book.getUpdatedDate());
					if(days<=1)	{
						Notification notification=new Notification();						
						notification.setNtDesc("Notification on Book:#"+book.getId());
						notification.setNtName("Book Return notification");						
						notification.setNtText("Book reservation of Book:"+book.getBkName()+" "+"on Date"+book.getCreatedDate()+" "+"is about to expire in days:"+days+"");
						int notification_id=getNotificationDAO().createNotification(notification);
						notification.setId(notification_id);
						UserNotification userNotification = new UserNotification();
						userNotification.setUsers(users);
						userNotification.setNotification(notification);		
						userNotification.setStatus("UNREAD");				
						getUserNotificationDAO().createUserNotification(userNotification);								
					}		
				}
			}
		} catch (GenericDAOException e) {			
			e.printStackTrace();
		}
		
	}
	public static int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
}
}
