package com.zen.smi.dao;

import java.io.Serializable;
import java.util.List;

import com.zen.smi.dao.entities.UserNotification;
import com.zen.smi.dao.exception.GenericDAOException;

public interface UserNotificationDAO extends BaseDAO<UserNotification, Serializable> {

	public void createUserNotification(UserNotification userNotification) throws GenericDAOException ;
	public void updateUserNotification(UserNotification userNotification) throws GenericDAOException ;
	public List<UserNotification> getNotificationsById(int id) throws GenericDAOException ;
	public UserNotification getUserNotificationsByNotificationId(int id) throws GenericDAOException;
}
