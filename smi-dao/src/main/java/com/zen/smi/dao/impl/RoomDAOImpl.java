package com.zen.smi.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.zen.smi.dao.RoomDAO;
import com.zen.smi.dao.entities.Room;
import com.zen.smi.dao.exception.GenericDAOException;

public class RoomDAOImpl extends BaseDAOImpl<Room, Serializable> implements RoomDAO {

	public RoomDAOImpl() {
		super(Room.class);
	}
	
	
	public void addRoom(Room room) throws GenericDAOException {
		saveOrUpdate(room);
	}
	public void updateRoom(Room room) throws GenericDAOException {
		saveOrUpdate(room);
	}
	
	public List<Room> getAllRooms() throws GenericDAOException {
		List<Room> rooms=retrieveAll();
		return rooms;
	}
}
