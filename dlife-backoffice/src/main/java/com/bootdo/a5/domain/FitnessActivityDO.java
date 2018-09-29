package com.bootdo.a5.domain;

import com.bootdo.common.utils.Base64Utils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;



/**
 * 健身活动信息
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 01:32:25
 */
public class FitnessActivityDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//活动标题
	private String title;
	//活动描述
	private String descrption;
	//用户id 创建人
	private String wechatUserId;
	//昵称
	private String nickName;
	//头像
	private String avatar;
	//项目名称
	private String project;
	//角色
	private String companyRole;
	//报名开始时间
	private Date signStartTime;
	//报名截至时间
	private Date signEndTime;
	//开始时间
	private Date activityStartTime;
	//结束时间
	private Date activityEndTime;
	//评论数量
	private Integer commentCount;
	//
	private Date modifyTime;
	//
	private Integer readingCount;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：活动标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：活动标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：活动描述
	 */
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	/**
	 * 获取：活动描述
	 */
	public String getDescrption() {
		return descrption;
	}
	/**
	 * 设置：用户id 创建人
	 */
	public void setWechatUserId(String wechatUserId) {
		this.wechatUserId = wechatUserId;
	}
	/**
	 * 获取：用户id 创建人
	 */
	public String getWechatUserId() {
		return wechatUserId;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickName() throws UnsupportedEncodingException {
		return Base64Utils.decode(nickName);
	}
	/**
	 * 设置：头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProject(String project) {
		this.project = project;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProject() {
		return project;
	}
	/**
	 * 设置：角色
	 */
	public void setCompanyRole(String companyRole) {
		this.companyRole = companyRole;
	}
	/**
	 * 获取：角色
	 */
	public String getCompanyRole() {
		return companyRole;
	}
	/**
	 * 设置：报名开始时间
	 */
	public void setSignStartTime(Date signStartTime) {
		this.signStartTime = signStartTime;
	}
	/**
	 * 获取：报名开始时间
	 */
	public Date getSignStartTime() {
		return signStartTime;
	}
	/**
	 * 设置：报名截至时间
	 */
	public void setSignEndTime(Date signEndTime) {
		this.signEndTime = signEndTime;
	}
	/**
	 * 获取：报名截至时间
	 */
	public Date getSignEndTime() {
		return signEndTime;
	}
	/**
	 * 设置：开始时间
	 */
	public void setActivityStartTime(Date activityStartTime) {
		this.activityStartTime = activityStartTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getActivityStartTime() {
		return activityStartTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setActivityEndTime(Date activityEndTime) {
		this.activityEndTime = activityEndTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getActivityEndTime() {
		return activityEndTime;
	}
	/**
	 * 设置：评论数量
	 */
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	/**
	 * 获取：评论数量
	 */
	public Integer getCommentCount() {
		return commentCount;
	}
	/**
	 * 设置：
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：
	 */
	public void setReadingCount(Integer readingCount) {
		this.readingCount = readingCount;
	}
	/**
	 * 获取：
	 */
	public Integer getReadingCount() {
		return readingCount;
	}
}
