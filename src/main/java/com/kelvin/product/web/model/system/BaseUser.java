package com.kelvin.product.web.model.system;

import javax.persistence.*;


import com.kelvin.product.core.generic.entity.IDEntity;

import java.util.Date;

/**
 * Created by tangshulei on 2015/10/22.
 */
@Entity
@Table(name="t_base_user")
public class BaseUser extends IDEntity{

	@Column(name="user_name",nullable = false, length=128)
	private String userName;
	
	@Column(name="password",nullable = false, length=20)
	private String password;

	@Column(name="sex",nullable = false, length=1)
	private int sex;

	@Column(name="telephone",nullable = false, length=20)
	private String telephone;

	@Column(name="cellphone",nullable = true, length=20)
	private String cellphone;

	@Column(name="email",nullable = true, length=20)
	private String email;

	@Column(name="status",nullable = false, length=1)
	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login_time")
	private Date lastLoginTime;

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
