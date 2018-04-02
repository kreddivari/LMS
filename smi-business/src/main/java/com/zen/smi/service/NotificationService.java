package com.zen.smi.service;

import java.util.List;
import com.zen.smi.bo.NotificationBO;
import com.zen.smi.exception.BusinessException;

public interface NotificationService {

	public void createNotification(NotificationBO notification) throws BusinessException ;
	public void updateNotification(NotificationBO notification) throws BusinessException;	
	public List<NotificationBO> getAllNotifications() throws BusinessException ;
}
