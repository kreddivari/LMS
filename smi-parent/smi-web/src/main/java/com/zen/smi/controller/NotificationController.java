package com.zen.smi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@RequestMapping(value = "/notification_all", method = RequestMethod.GET)
	public @ResponseBody String getAll(@RequestBody String userJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String Json = null;
		try {
			List<NotificationBO> notificationBO=notificationService.getAllNotifications();
			Json= gson.toJson(notificationBO);					
		} catch (Throwable th) {
			th.printStackTrace();
			Json = handleOtherError(th);
		}
		return Json;
	}
	
}
