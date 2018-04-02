package com.zen.smi.bo;

import java.io.Serializable;
import java.util.Date;

public class UserRoomBO implements Serializable {
	public int getUserRoomId() {
		return userRoomId;
	}

	public void setUserRoomId(int userRoomId) {
		this.userRoomId = userRoomId;
	}

	public Date getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Date getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(Date reserveTime) {
		this.reserveTime = reserveTime;
	}

	public RoomBO getRoom() {
		return room;
	}

	public void setRoom(RoomBO room) {
		this.room = room;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	
	private int userRoomId;
	private Date leaveTime;
	private Date reserveTime;
	private RoomBO room;
	private UserBO user;

	public UserRoomBO() {
	}
	

}