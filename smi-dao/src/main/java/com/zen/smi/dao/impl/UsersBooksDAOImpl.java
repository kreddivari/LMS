package com.zen.smi.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.SimpleExpression;

import com.zen.smi.dao.BooksDAO;
import com.zen.smi.dao.UserBooksDAO;
import com.zen.smi.dao.entities.Book;
import com.zen.smi.dao.entities.UsersBooks;
import com.zen.smi.dao.exception.GenericDAOException;

public class UsersBooksDAOImpl extends BaseDAOImpl<UsersBooks, Serializable> implements UserBooksDAO {

	public UsersBooksDAOImpl() {
		super(UsersBooks.class);
	}
	
	public static void main(String[] args) throws Exception {
		UsersBooksDAOImpl impl=new UsersBooksDAOImpl();
		List<UsersBooks> user_books=impl.getAllUsersBooksbyId(2);
		System.out.println(user_books);
	}

	public String createUserBook(UsersBooks usersBooks) throws GenericDAOException {
		saveOrUpdate(usersBooks);	
		return "SUCCESS";
	}

	public List<UsersBooks> getAllUsersBooksbyId(int id) throws GenericDAOException {
		List<UsersBooks> userBooks=load("from UsersBooks where users.userId="+id+"");
		return userBooks;
	}
	public UsersBooks getAllUsersBooksbyBookId(int id) throws GenericDAOException {
		List<UsersBooks> userBooks=load("from UsersBooks where book.id="+id+"");
		return userBooks.get(0);
	}
	
}
