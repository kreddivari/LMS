package com.zen.smi.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zen.smi.bo.RoomBO;
import com.zen.smi.dao.entities.Notification;
import com.zen.smi.dao.entities.Room;
import com.zen.smi.dao.entities.UserNotification;
import com.zen.smi.dao.entities.UserRoom;
import com.zen.smi.dao.entities.Users;
import com.zen.smi.dao.exception.GenericDAOException;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.service.RoomService;

public class RoomServiceImpl extends BaseService implements RoomService {

	public void addRoom(RoomBO roomBO) throws BusinessException{
		
		Room room=new Room();
		room.setRoomName(roomBO.getRoomName());
		room.setRoomNum(roomBO.getRoomNum());
		room.setStatus(0);
		 try {
			getRoomDAO().addRoom(room);
		} catch (GenericDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<RoomBO> getAllRooms() throws BusinessException{
		List<RoomBO> roomsBO=new ArrayList<RoomBO>();
		try {
			List<Room> rooms=  getRoomDAO().retrieveAll();
			for(Room room:rooms){
				RoomBO roomBO=new RoomBO();
				roomBO.setId(room.getId());
				roomBO.setRoomName(room.getRoomName());
				roomBO.setStatus(room.getStatus());
				roomBO.setRoomNum(room.getRoomNum());
				if(roomBO.getStatus()==0){
				roomsBO.add(roomBO);
				}
			}
		} catch (GenericDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return roomsBO;
	}
	public List<RoomBO> getRoomsByUserId(String username) throws BusinessException{
		Users users;
		List<RoomBO> roomsBO=new ArrayList<RoomBO>();
		List<Room> rooms=null;
		try {
			users = getUserDAO().getUserByUserName(username);
			rooms=getUserRoomDAO().getAllUserRoomsByUserId(users.getUserId());
		} catch (GenericDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Room room:rooms){
			RoomBO roomBO=new RoomBO();
			roomBO.setId(room.getId());
			roomBO.setRoomName(room.getRoomName());
			roomBO.setStatus(room.getStatus());
			roomBO.setRoomNum(room.getRoomNum());			
			roomsBO.add(roomBO);			
		}				
		 return roomsBO;
	}
	public void updateRoom(RoomBO roomBO) throws BusinessException{
		try {			
			Room room=getRoomDAO().findById(roomBO.getId());
			room.setStatus(roomBO.getStatus());
			getRoomDAO().addRoom(room);
			UserRoom userRoom=getUserRoomDAO().getAllUserRoomsByRoomId(roomBO.getId());
			Notification notification=new Notification();
			//notification.setId(usersBook.getBookStatus());	
			notification.setNtDesc("Notification on Room:#"+room.getId());
			notification.setNtName("Status update notification");
			notification.setNtText("Reservation of Room:"+room.getRoomNum()+" is Approved");
			int notification_id=getNotificationDAO().createNotification(notification);
			notification.setId(notification_id);
			UserNotification userNotification = new UserNotification();
			userNotification.setUsers(userRoom.getUsers());
			userNotification.setNotification(notification);		
			userNotification.setStatus("UNREAD");				
			getUserNotificationDAO().createUserNotification(userNotification);
		
		} catch (GenericDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
   public void reserveRoom(String user_name,RoomBO roomBO) throws BusinessException{
	   try {
		Users users = getUserDAO().getUserByUserName(user_name);
		UserRoom userRoom=new UserRoom();
		userRoom.setUsers(users);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:MM");
		try {
			Date reserve_date = sdf.parse(roomBO.getReserveTime());
			Date leave_date=sdf.parse(roomBO.getLeaveTime());
			userRoom.setReserveTime(reserve_date);
			userRoom.setLeaveTime(leave_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 				
		Room room =getRoomDAO().findById(roomBO.getId());
		room.setStatus(1);
		getRoomDAO().addRoom(room);
		userRoom.setRoom(room);
		String result=getUserRoomDAO().addUserRoom(userRoom);
		if(result.equals("SUCCESS")){
			Notification notification=new Notification();
			//notification.setId(usersBook.getBookStatus());	
			notification.setNtDesc("Notification on Room:#"+room.getId());
			notification.setNtName("Status update notification");
			notification.setNtText("Reservation of Room:"+room.getRoomNum()+" "+"on Date"+new Date()+" "+"is submitted for Admin Approval");
			int notification_id=getNotificationDAO().createNotification(notification);
			notification.setId(notification_id);
			UserNotification userNotification = new UserNotification();
			userNotification.setUsers(users);
			userNotification.setNotification(notification);		
			userNotification.setStatus("UNREAD");				
			getUserNotificationDAO().createUserNotification(userNotification);
		}
	} catch (GenericDAOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
public List<RoomBO> getAllAdminRooms() throws BusinessException {
	List<RoomBO> roomsBO=new ArrayList<RoomBO>();
	try {
		List<Room> rooms=  getRoomDAO().retrieveAll();
		for(Room room:rooms){
			RoomBO roomBO=new RoomBO();
			roomBO.setId(room.getId());
			roomBO.setRoomName(room.getRoomName());
			roomBO.setStatus(room.getStatus());
			roomBO.setRoomNum(room.getRoomNum());			
			roomsBO.add(roomBO);			
		}
	} catch (GenericDAOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return roomsBO;
}
public String deletebook(int id) throws BusinessException {
	Room room=new Room();
	room.setId(id);
	try {
		getRoomDAO().delete(room);
	} catch (GenericDAOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "SUCCESS";
}
	
}
