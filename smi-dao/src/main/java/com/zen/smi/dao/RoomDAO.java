package com.zen.smi.dao;

import java.io.Serializable;
import java.util.List;
import com.zen.smi.dao.entities.Room;
import com.zen.smi.dao.exception.GenericDAOException;

public interface RoomDAO extends BaseDAO<Room, Serializable> {

	public void addRoom(Room room) throws GenericDAOException;
	public void updateRoom(Room room) throws GenericDAOException;	
	public List<Room> getAllRooms() throws GenericDAOException;

}
