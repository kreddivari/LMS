package com.zen.smi.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.zen.smi.dao.BooksDAO;
import com.zen.smi.dao.MessagesDAO;
import com.zen.smi.dao.RolesDAO;
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
	

}
