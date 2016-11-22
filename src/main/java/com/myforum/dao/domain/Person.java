package com.myforum.dao.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_person")
public class Person extends BaseBean {

	private String account;

	private String password;

	private String sex;

	private String name;

	private String birthday;

	private String email;

	@Column(name = "ip_created")
	private String ipCreated;

    @Column(name = "date_last_actived")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateLastActived;

    @Column(name = "ip_last_actived")
	private String ipLastActived;

	@ManyToMany(mappedBy = "administrators")
	private Set<Board> boardsAdministrated = new HashSet<Board>();

	public String getAccount() {
		return account;
	}

	public Date getDateLastActived() {
		return dateLastActived;
	}

	public void setDateLastActived(Date dateLastActive) {
		this.dateLastActived = dateLastActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIpCreated() {
		return ipCreated;
	}

	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}

	public String getIpLastActived() {
		return ipLastActived;
	}

	public void setIpLastActived(String ipLastActived) {
		this.ipLastActived = ipLastActived;
	}

	public Set<Board> getBoardsAdministrated() {
		return boardsAdministrated;
	}

	public void setBoardsAdministrated(Set<Board> boardsAdministrated) {
		this.boardsAdministrated = boardsAdministrated;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setAccount(String account) {
		this.account = account;
	}
}