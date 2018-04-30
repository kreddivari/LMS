package com.zen.smi.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zen.smi.dao.BookCategoryDAO;
import com.zen.smi.dao.BooksDAO;
import com.zen.smi.dao.CategoryDAO;
import com.zen.smi.dao.MessagesDAO;
import com.zen.smi.dao.NotificationDAO;
import com.zen.smi.dao.RolesDAO;
import com.zen.smi.dao.RoomDAO;
import com.zen.smi.dao.UserBooksDAO;
import com.zen.smi.dao.UserNotificationDAO;
import com.zen.smi.dao.UserRoomDAO;
import com.zen.smi.dao.UsersDAO;
import com.zen.smi.dao.UsersRolesDAO;


public class BaseService {	
	

	private ModelMapper modelMapper=new ModelMapper();
	@Autowired
	private UsersDAO userDAO;	
	@Autowired
	private UsersRolesDAO usersRolesDAO;
	@Autowired
	private RolesDAO rolesDAO;
	@Autowired
	private BooksDAO booksDAO;
	@Autowired
	private UserBooksDAO userBooksDAO;	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private BookCategoryDAO bookcategoryDAO;
	@Autowired
	NotificationDAO notificationDAO;
	@Autowired
	UserNotificationDAO userNotificationDAO;
	@Autowired
	RoomDAO roomDAO;
	@Autowired
	UserRoomDAO userRoomDAO;
	
	
	public UsersDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UsersRolesDAO getUsersRolesDAO() {
		return usersRolesDAO;
	}

	public void setUsersRolesDAO(UsersRolesDAO usersRolesDAO) {
		this.usersRolesDAO = usersRolesDAO;
	}

	public RolesDAO getRolesDAO() {
		return rolesDAO;
	}

	public void setRolesDAO(RolesDAO rolesDAO) {
		this.rolesDAO = rolesDAO;
	}

	private MessagesDAO messagesDAO; 
	
	
	public MessagesDAO getMessagesDAO() {
		return messagesDAO;
	}

	public void setMessagesDAO(MessagesDAO messagesDAO) {
		this.messagesDAO = messagesDAO;
	}
	public BooksDAO getBooksDAO() {
		return booksDAO;
	}

	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	public UserBooksDAO getUserBooksDAO() {
		return userBooksDAO;
	}

	public void setUserBooksDAO(UserBooksDAO userBooksDAO) {
		this.userBooksDAO = userBooksDAO;
	}
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}
	public BookCategoryDAO getBookcategoryDAO() {
		return bookcategoryDAO;
	}

	public void setBookcategoryDAO(BookCategoryDAO bookcategoryDAO) {
		this.bookcategoryDAO = bookcategoryDAO;
	}
	public NotificationDAO getNotificationDAO() {
		return notificationDAO;
	}
	public void setNotificationDAO(NotificationDAO notificationDAO) {
		this.notificationDAO = notificationDAO;
	}
	public UserNotificationDAO getUserNotificationDAO() {
		return userNotificationDAO;
	}
	public void setUserNotificationDAO(UserNotificationDAO userNotificationDAO) {
		this.userNotificationDAO = userNotificationDAO;
	}
	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	public UserRoomDAO getUserRoomDAO() {
		return userRoomDAO;
	}
	public void setUserRoomDAO(UserRoomDAO userRoomDAO) {
		this.userRoomDAO = userRoomDAO;
	}
}
