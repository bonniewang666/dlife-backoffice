package com.bootdo.a5.domain;

import com.bootdo.common.utils.Base64Utils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;



/**
 * 
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 00:44:28
 */
public class WechatUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String openId;
	//
	private String wechatCode;
	//
	private String eid;
	//
	private String userName;
	//
	private String nickName;
	//
	private String avatar;
	//
	private String mobileNum;
	//
	private String project;
	//
	private String seat;
	//
	private String introduce;
	//
	private Boolean sex;
	//
	private String companyRole;
	//
	private Boolean cookFlag;
	//
	private String intesting;
	//
	private String skill;
	//
	private Date createTime;
	//
	private Date modifyTime;
	//
	private Integer totalPoint;

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
	 * 设置：
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：
	 */
	public void setWechatCode(String wechatCode) {
		this.wechatCode = wechatCode;
	}
	/**
	 * 获取：
	 */
	public String getWechatCode() {
		return wechatCode;
	}
	/**
	 * 设置：
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}
	/**
	 * 获取：
	 */
	public String getEid() {
		return eid;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：
	 */
	public String getNickName() throws UnsupportedEncodingException {
		return Base64Utils.decode(nickName);
	}
	/**
	 * 设置：
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：
	 */
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	/**
	 * 获取：
	 */
	public String getMobileNum() {
		return mobileNum;
	}
	/**
	 * 设置：
	 */
	public void setProject(String project) {
		this.project = project;
	}
	/**
	 * 获取：
	 */
	public String getProject() {
		return project;
	}
	/**
	 * 设置：
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}
	/**
	 * 获取：
	 */
	public String getSeat() {
		return seat;
	}
	/**
	 * 设置：
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	/**
	 * 获取：
	 */
	public String getIntroduce() {
		return introduce;
	}
	/**
	 * 设置：
	 */
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public Boolean getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setCompanyRole(String companyRole) {
		this.companyRole = companyRole;
	}
	/**
	 * 获取：
	 */
	public String getCompanyRole() {
		return companyRole;
	}
	/**
	 * 设置：
	 */
	public void setCookFlag(Boolean cookFlag) {
		this.cookFlag = cookFlag;
	}
	/**
	 * 获取：
	 */
	public Boolean getCookFlag() {
		return cookFlag;
	}
	/**
	 * 设置：
	 */
	public void setIntesting(String intesting) {
		this.intesting = intesting;
	}
	/**
	 * 获取：
	 */
	public String getIntesting() {
		return intesting;
	}
	/**
	 * 设置：
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}
	/**
	 * 获取：
	 */
	public String getSkill() {
		return skill;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
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
	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}
	/**
	 * 获取：
	 */
	public Integer getTotalPoint() {
		return totalPoint;
	}
}
