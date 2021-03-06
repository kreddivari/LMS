package com.zen.smi.dao.entities;
// Generated Mar 25, 2018 2:48:28 AM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name = "book")
public class Book implements java.io.Serializable {

	private Integer id;
	private String bkName;
	private String bkDesc;
	private Integer bkYear;
	private String bkAuthor;
	private Date createdDate;
	private Date updatedDate;
	private Integer statusFlag;
	private Set<BookCategory> bookCategories = new HashSet<BookCategory>(0);
	private Set<UsersBooks> usersBookses = new HashSet<UsersBooks>(0);
	private Set<UserFines> userFineses = new HashSet<UserFines>(0);

	public Book() {
	}

	public Book(String bkName, String bkDesc, Integer bkYear, String bkAuthor, Date createdDate, Date updatedDate,
			Integer statusFlag, Set<BookCategory> bookCategories, Set<UsersBooks> usersBookses,
			Set<UserFines> userFineses) {
		this.bkName = bkName;
		this.bkDesc = bkDesc;
		this.bkYear = bkYear;
		this.bkAuthor = bkAuthor;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.statusFlag = statusFlag;
		this.bookCategories = bookCategories;
		this.usersBookses = usersBookses;
		this.userFineses = userFineses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "bk_name", length = 55)
	public String getBkName() {
		return this.bkName;
	}

	public void setBkName(String bkName) {
		this.bkName = bkName;
	}

	@Column(name = "bk_desc", length = 55)
	public String getBkDesc() {
		return this.bkDesc;
	}

	public void setBkDesc(String bkDesc) {
		this.bkDesc = bkDesc;
	}

	@Column(name = "bk_year")
	public Integer getBkYear() {
		return this.bkYear;
	}

	public void setBkYear(Integer bkYear) {
		this.bkYear = bkYear;
	}

	@Column(name = "bk_author", length = 45)
	public String getBkAuthor() {
		return this.bkAuthor;
	}

	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "status_flag")
	public Integer getStatusFlag() {
		return this.statusFlag;
	}

	public void setStatusFlag(Integer statusFlag) {
		this.statusFlag = statusFlag;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<BookCategory> getBookCategories() {
		return this.bookCategories;
	}

	public void setBookCategories(Set<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<UsersBooks> getUsersBookses() {
		return this.usersBookses;
	}

	public void setUsersBookses(Set<UsersBooks> usersBookses) {
		this.usersBookses = usersBookses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<UserFines> getUserFineses() {
		return this.userFineses;
	}

	public void setUserFineses(Set<UserFines> userFineses) {
		this.userFineses = userFineses;
	}

}
