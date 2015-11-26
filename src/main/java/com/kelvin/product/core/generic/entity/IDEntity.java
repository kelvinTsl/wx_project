package com.kelvin.product.core.generic.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

/**
 * Created by tangshulei on 2015/10/21.
 */
@MappedSuperclass
public abstract class IDEntity{

	@Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "native")
    @Column(name = "ID")
	public Integer id;

	@Column(name="create_name", length=64)
	public String createName;

	@Column(name="create_by")
	public Integer createBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	public Date createTime;
	@Column(name="update_name", length=64)
	public String updateName;
	@Column(name="update_by")
	public Integer updateBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_time")
	public Date updataTime;

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public int getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(int updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdataTime() {
		return updataTime;
	}

	public void setUpdataTime(Date updataTime) {
		this.updataTime = updataTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
