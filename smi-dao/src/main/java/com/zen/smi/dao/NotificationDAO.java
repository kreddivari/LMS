package com.zen.smi.dao;

import java.io.Serializable;
import java.util.List;
import com.zen.smi.dao.entities.Notification;
import com.zen.smi.dao.exception.GenericDAOException;

public interface NotificationDAO extends BaseDAO<Notification, Serializable> {

	public void createNotification(Notification notification) throws GenericDAOException ;
	public void updateNotification(Notification notification) throws GenericDAOException;	
	public List<Notification> getAllNotifications() throws GenericDAOException ;
}
