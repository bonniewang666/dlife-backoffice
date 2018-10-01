package com.bootdo.a5.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 标签表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-01 14:22:13
 */
public class TagsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//标签主键
	private Long id;
	//标签名称
	private String name;
	//关联对象主键
	private Long objectId;
	//关联对象类型,从字典表获取object_type类型获得
	private String objectType;
	//创建人
	private Long createUserId;
	//
	private Date createDate;
	//修改人
	private Long updateUserId;
	//修改时间
	private Date updateDate;

	/**
	 * 设置：标签主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：标签主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：标签名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：标签名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：关联对象主键
	 */
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	/**
	 * 获取：关联对象主键
	 */
	public Long getObjectId() {
		return objectId;
	}
	/**
	 * 设置：关联对象类型,从字典表获取object_type类型获得
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	/**
	 * 获取：关联对象类型,从字典表获取object_type类型获得
	 */
	public String getObjectType() {
		return objectType;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建人
	 */
	public Long getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUserId(Long updateUserId) {
		this.updateUserId = updateUserId;
	}
	/**
	 * 获取：修改人
	 */
	public Long getUpdateUserId() {
		return updateUserId;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
}
