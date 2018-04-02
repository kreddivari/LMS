package com.zen.smi.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class NotificationBO implements Serializable {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getNtDesc() {
		return ntDesc;
	}

	public void setNtDesc(String ntDesc) {
		this.ntDesc = ntDesc;
	}

	public String getNtName() {
		return ntName;
	}

	public void setNtName(String ntName) {
		this.ntName = ntName;
	}

	public String getNtText() {
		return ntText;
	}

	public void setNtText(String ntText) {
		this.ntText = ntText;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<UserNotificationBO> getUserNotifications() {
		return userNotifications;
	}

	public void setUserNotifications(List<UserNotificationBO> userNotifications) {
		this.userNotifications = userNotifications;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	
	private int id;	
	private Date createdDate;
	private String ntDesc;
	private String ntName;
	private String ntText;
	private Date updatedDate;
	private List<UserNotificationBO> userNotifications;

	public NotificationBO() {
	}
	
}