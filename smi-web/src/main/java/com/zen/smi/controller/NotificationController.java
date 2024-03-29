package com.zen.smi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zen.smi.bo.NotificationBO;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.NotificationService;


@Controller
public class NotificationController extends BaseController {
	
	/**
	 * Logger for HomePageController class.
	 */
	private static final Logger LOGGER = Logger.getLogger(NotificationController.class);
	
	@Autowired 
	NotificationService notificationService;
	
	
	@RequestMapping(value = "/add_notification", method = RequestMethod.POST)
	public @ResponseBody String create(@RequestBody String userJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String Json = "SUCCESS";
		try {
			
			NotificationBO notificationBO= gson.fromJson(Json, NotificationBO.class);
			notificationService.createNotification(notificationBO);			
		} catch (Throwable th) {
			th.printStackTrace();
			Json = handleOtherError(th);
		}
		return Json;
	}
	@RequestMapping(value = "/update_notification/{id}", method = RequestMethod.POST)
	public @ResponseBody String create(@PathVariable("user_id") int user_id,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String Json = "SUCCESS";
		try {
			
			NotificationBO notificationBO= gson.fromJson(Json, NotificationBO.class);
			notificationService.createNotification(notificationBO);			
		} catch (Throwable th) {
			th.printStackTrace();
			Json = handleOtherError(th);
		}
		return Json;
	}
	
	@RequestMapping(value = "/notifications/{notification_id}", method = RequestMethod.POST)
	public @ResponseBody String getAll(@PathVariable("notification_id") int notification_id,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String Json = null;
		try {
			String result=notificationService.updateUserNotification(notification_id);
			Json= gson.toJson(result);					
		} catch (Throwable th) {
			th.printStackTrace();
			Json = handleOtherError(th);
		}
		return Json;
	}
	
	@RequestMapping(value = "/notifications", method = RequestMethod.GET)
	public @ResponseBody String getAllNotifications(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String Json = null;
		try {
			String  user = SecurityContextHolder.getContext().getAuthentication().getName();
			List<NotificationBO> notifications=notificationService.getAllNotifications(user);
			Json= gson.toJson(notifications);					
		} catch (Throwable th) {
			th.printStackTrace();
			Json = handleOtherError(th);
		}
		return Json;
	}
	
	
}
