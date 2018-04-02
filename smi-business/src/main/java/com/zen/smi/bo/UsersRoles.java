package com.zen.smi.bo;

public class UsersRoles implements java.io.Serializable {

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserBO getUsers() {
		return users;
	}

	public void setUsers(UserBO users) {
		this.users = users;
	}

	public RoleBO getRoles() {
		return roles;
	}

	public void setRoles(RoleBO roles) {
		this.roles = roles;
	}

	private Integer userRoleId;
	private UserBO users;
	private RoleBO roles;

	public UsersRoles() {
	}

	public UsersRoles(UserBO users, RoleBO roles) {
		this.users = users;
		this.roles = roles;
	}

	

}
