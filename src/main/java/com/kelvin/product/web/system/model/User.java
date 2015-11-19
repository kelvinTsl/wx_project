package com.kelvin.product.web.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;


import com.kelvin.product.core.generic.entity.IDEntity;

/**
 * Created by tangshulei on 2015/10/22.
 */
@Entity(name="User")
public class User extends IDEntity{
	
	@Column(name="user_name",nullable = false, length=128)
	private String userName;
	
	@Column(name="password",nullable = false, length=20)
	private String password;
	
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
