package com.zen.smi.bo;

import java.io.Serializable;
import java.util.Date;

public class UserNotificationBO implements Serializable {
	public int getUserNotificationId() {
		return userNotificationId;
	}

	public void setUserNotificationId(int userNotificationId) {
		this.userNotificationId = userNotificationId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public NotificationBO getNotification() {
		return notification;
	}

	public void setNotification(NotificationBO notification) {
		this.notification = notification;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	
	private int userNotificationId;
	private Date createdDate;
	private Date updatedDate;
	private NotificationBO notification;
	private UserBO user;

	public UserNotificationBO() {
	}
	

}