package com.zen.smi.dao;

import java.io.Serializable;
import java.util.List;
import com.zen.smi.dao.entities.Room;
import com.zen.smi.dao.entities.UserRoom;
import com.zen.smi.dao.exception.GenericDAOException;

public interface UserRoomDAO extends BaseDAO<UserRoom, Serializable> {

	public String addUserRoom(UserRoom userRoom) throws GenericDAOException;
	public void updateUserRoom(UserRoom userRoom) throws GenericDAOException;	
	public List<UserRoom> getAllUserRooms() throws GenericDAOException;
	public List<Room> getAllUserRoomsByUserId(int id) throws GenericDAOException;

}
