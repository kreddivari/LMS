package com.zen.smi.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zen.smi.dao.UserRoomDAO;
import com.zen.smi.dao.entities.Room;
import com.zen.smi.dao.entities.UserRoom;
import com.zen.smi.dao.exception.GenericDAOException;

public class UserRoomDAOImpl extends BaseDAOImpl<UserRoom, Serializable> implements UserRoomDAO {

	public UserRoomDAOImpl() {
		super(UserRoom.class);
	}

	public String addUserRoom(UserRoom userRoom) throws GenericDAOException {
		saveOrUpdate(userRoom);
		return "SUCCESS";
		
	}

	public void updateUserRoom(UserRoom userRoom) throws GenericDAOException {
		// TODO Auto-generated method stub
		saveOrUpdate(userRoom);
	}

	public List<UserRoom> getAllUserRooms() throws GenericDAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Room> getAllUserRoomsByUserId(int id) throws GenericDAOException {
		List<Room> rooms=new ArrayList<Room>();
		List<UserRoom> userRooms=load("from UserRoom where users.userId="+id+"");
		for(UserRoom userRoom:userRooms){
			rooms.add(userRoom.getRoom());
		}
		return rooms;
	}
	
	public UserRoom getAllUserRoomsByRoomId(int id) throws GenericDAOException {
		List<UserRoom> UserRooms=load("from UserRoom where room.id="+id+"");
		return UserRooms.get(0);
	}
	
}
