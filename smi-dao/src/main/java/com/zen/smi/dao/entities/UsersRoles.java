package com.zen.smi.dao.entities;
// Generated Mar 25, 2018 2:48:28 AM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * UsersRoles generated by hbm2java
 */
@Entity
@Table(name = "users_roles", catalog = "project", uniqueConstraints = @UniqueConstraint(columnNames = { "user_id",
		"role_id" }))
public class UsersRoles implements java.io.Serializable {

	private Integer userRoleId;
	private Roles roles;
	private Users users;

	public UsersRoles() {
	}

	public UsersRoles(Roles roles, Users users) {
		this.roles = roles;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_role_id", unique = true, nullable = false)
	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
