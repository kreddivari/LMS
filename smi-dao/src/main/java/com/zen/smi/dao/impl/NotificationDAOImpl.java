package com.zen.smi.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.zen.smi.dao.NotificationDAO;
import com.zen.smi.dao.entities.Notification;
import com.zen.smi.dao.exception.GenericDAOException;

public class NotificationDAOImpl extends BaseDAOImpl<Notification, Serializable> implements NotificationDAO {

	public NotificationDAOImpl() {
		super(Notification.class);
	}
	
	public void createNotification(Notification notification) throws GenericDAOException {
		saveOrUpdate(notification);
	}
	public void updateNotification(Notification notification) throws GenericDAOException {
		saveOrUpdate(notification);
	}
	
	public List<Notification> getAllNotifications() throws GenericDAOException {
		List<Notification> notifications=retrieveAll();
		return notifications;
	}
}
