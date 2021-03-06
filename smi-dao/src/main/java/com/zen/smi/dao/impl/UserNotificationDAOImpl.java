package com.zen.smi.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zen.smi.dao.UserNotificationDAO;
import com.zen.smi.dao.entities.UserNotification;
import com.zen.smi.dao.exception.GenericDAOException;

public class UserNotificationDAOImpl extends BaseDAOImpl<UserNotification, Serializable> implements UserNotificationDAO {

	public UserNotificationDAOImpl() {
		super(UserNotification.class);
	}

	public void createUserNotification(UserNotification userNotification) throws GenericDAOException {
		// TODO Auto-generated method stub
		saveOrUpdate(userNotification);
	}

	public void updateUserNotification(UserNotification userNotification) throws GenericDAOException {
		saveOrUpdate(userNotification);
		
	}

	public List<UserNotification> getNotificationsById(int id) throws GenericDAOException {
		List<UserNotification> userNotifications=load("from UserNotification where users.id="+id+"");
		return userNotifications;
	}
	
	public UserNotification getUserNotificationsByNotificationId(int id) throws GenericDAOException {
		List<UserNotification> userNotifications=loadntf("from UserNotification where notification.id="+id+"");
		return userNotifications.get(0);
	}
	 public List<UserNotification> loadntf(String queryName) {
			List<UserNotification> recordSet = null;
			Session session = null;
			Transaction transaction = null;
	 		try{
	 			session = getSessionFactory().openSession();
		        transaction = session.beginTransaction();
	            Query myQuery = session.createQuery(queryName);	
				recordSet = myQuery.list();
				transaction.commit();
	        }
			catch (HibernateException ex){
				transaction.rollback();
	           throw ex;
	       }
	       finally {
	    	   if (session.isOpen()){
	                session.close();
	            }
	        }

			return recordSet;
		}
	  
}
