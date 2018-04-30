package com.zen.smi.service;

import java.util.List;
import com.zen.smi.bo.RoomBO;
import com.zen.smi.exception.BusinessException;

public interface RoomService {

	public void addRoom(RoomBO room) throws BusinessException;
	public void updateRoom(RoomBO room) throws BusinessException;	
	public List<RoomBO> getAllRooms() throws BusinessException;
	public void reserveRoom(String user, RoomBO roomBO)throws BusinessException;
	public List<RoomBO> getRoomsByUserId(String user)throws BusinessException;
	public List<RoomBO> getAllAdminRooms()throws BusinessException;
	public String deletebook(int id)throws BusinessException;

}
