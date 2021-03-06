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

import com.zen.smi.bo.BookBO;
import com.zen.smi.bo.RoomBO;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.RoomService;


@Controller
public class RoomController extends BaseController {
	
	/**
	 * Logger for HomePageController class.
	 */
	private static final Logger LOGGER = Logger.getLogger(RoomController.class);
	
	@Autowired 
	RoomService roomService;
	
	
	
	@RequestMapping(value = "/reserve_room", method = RequestMethod.POST)
	public @ResponseBody String reserveRoom(@RequestBody String roomJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String result = null;
		try {
			RoomBO roomBO=gson.fromJson(roomJson, RoomBO.class);
			String  user = SecurityContextHolder.getContext().getAuthentication().getName();			
			roomService.reserveRoom(user,roomBO);
		} catch (Throwable th) {
			th.printStackTrace();
			roomJson = handleOtherError(th);
		}
		return result;
	}
	@RequestMapping(value = "/edit_room", method = RequestMethod.POST)
	public @ResponseBody String editRoom(@RequestBody String roomJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String result = null;
		try {
			RoomBO roomBO=gson.fromJson(roomJson, RoomBO.class);
			roomService.updateRoom(roomBO);
		} catch (Throwable th) {
			th.printStackTrace();
			roomJson = handleOtherError(th);
		}
		return result;
	}
	@RequestMapping(value = "/add_room", method = RequestMethod.POST)
	public @ResponseBody String addRoom(@RequestBody String roomJson,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String result = null;
		try {
			RoomBO roomBO=gson.fromJson(roomJson, RoomBO.class);
			roomService.addRoom(roomBO);
		} catch (Throwable th) {
			th.printStackTrace();
			roomJson = handleOtherError(th);
		}
		return result;
	}
	
	@RequestMapping(value = "/all_rooms", method = RequestMethod.GET)
	public @ResponseBody String getRooms(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String json = "SUCCESS";
		try {					
			List<RoomBO> rooms=roomService.getAllRooms();	
			json=gson.toJson(rooms);
		} catch (Throwable th) {
			th.printStackTrace();
			json = handleOtherError(th);
		}
		return json;
	}
	
	@RequestMapping(value = "/delete/{room_id}", method = RequestMethod.POST)
	public @ResponseBody String deleteBook(@PathVariable("room_id") int room_id,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String bookJson = null;
		try {					
			bookJson=roomService.deletebook(room_id);			
		} catch (Throwable th) {
			th.printStackTrace();
			bookJson = handleOtherError(th);
		}
		return bookJson;
	}
	@RequestMapping(value = "/admin_all_rooms", method = RequestMethod.GET)
	public @ResponseBody String getAdminRooms(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String json = "SUCCESS";
		try {					
			List<RoomBO> rooms=roomService.getAllAdminRooms();	
			json=gson.toJson(rooms);
		} catch (Throwable th) {
			th.printStackTrace();
			json = handleOtherError(th);
		}
		return json;
	}
	@RequestMapping(value = "/user_rooms", method = RequestMethod.GET)
	public @ResponseBody String getUserRooms(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		String json = "SUCCESS";
		try {	
			String  user = SecurityContextHolder.getContext().getAuthentication().getName();
			List<RoomBO> rooms=roomService.getRoomsByUserId(user);	
			json=gson.toJson(rooms);
		} catch (Throwable th) {
			th.printStackTrace();
			json = handleOtherError(th);
		}
		return json;
	}
}
