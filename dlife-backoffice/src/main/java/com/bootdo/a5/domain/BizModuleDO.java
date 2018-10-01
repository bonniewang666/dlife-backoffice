package com.bootdo.a5.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 业务板块表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-01 15:24:35
 */
public class BizModuleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Long id;
	//业务板块，关联到字典表中类型为某一个业务主体，如type=dlife
	private String bizCategory;
	//关联的业务对象类型，关联到字典表的object_type
	private String objectType;
	//关联的对象ID
	private Long objectId;
	//创建人ID
	private Long createUserId;
	//创建时间
	private Date createDate;
	//修改人ID
	private Long updateUserId;
	//修改日期
	private Date updateDate;

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：业务板块，关联到字典表中类型为某一个业务主体，如type=dlife
	 */
	public void setBizCategory(String bizCategory) {
		this.bizCategory = bizCategory;
	}
	/**
	 * 获取：业务板块，关联到字典表中类型为某一个业务主体，如type=dlife
	 */
	public String getBizCategory() {
		return bizCategory;
	}
	/**
	 * 设置：关联的业务对象类型，关联到字典表的object_type
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	/**
	 * 获取：关联的业务对象类型，关联到字典表的object_type
	 */
	public String getObjectType() {
		return objectType;
	}
	/**
	 * 设置：关联的对象ID
	 */
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	/**
	 * 获取：关联的对象ID
	 */
	public Long getObjectId() {
		return objectId;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建人ID
	 */
	public Long getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改人ID
	 */
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	/**
	 * 获取：修改人ID
	 */
	public Long getUpdateUserId() {
		return updateUserId;
	}
	/**
	 * 设置：修改日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改日期
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
}
