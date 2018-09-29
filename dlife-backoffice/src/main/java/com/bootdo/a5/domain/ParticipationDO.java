package com.bootdo.a5.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-09-29 10:51:39
 */
public class ParticipationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String wechatUserId;
	//
	private String nickName;
	//
	private String avatar;
	//
	private String project;
	//
	private Date participationTime;
	//
	private Integer currentContinueDays;
	//
	private Long fitnessActivityId;
	//
	private Date latestClockinTime;
	//
	private Integer longestContinueDays;
	//
	private Integer totalClockinDays;
	//
	private Integer totalParticipateDays;

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
	public void setWechatUserId(String wechatUserId) {
		this.wechatUserId = wechatUserId;
	}
	/**
	 * 获取：
	 */
	public String getWechatUserId() {
		return wechatUserId;
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
	public String getNickName() {
		return nickName;
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
	public void setParticipationTime(Date participationTime) {
		this.participationTime = participationTime;
	}
	/**
	 * 获取：
	 */
	public Date getParticipationTime() {
		return participationTime;
	}
	/**
	 * 设置：
	 */
	public void setCurrentContinueDays(Integer currentContinueDays) {
		this.currentContinueDays = currentContinueDays;
	}
	/**
	 * 获取：
	 */
	public Integer getCurrentContinueDays() {
		return currentContinueDays;
	}
	/**
	 * 设置：
	 */
	public void setFitnessActivityId(Long fitnessActivityId) {
		this.fitnessActivityId = fitnessActivityId;
	}
	/**
	 * 获取：
	 */
	public Long getFitnessActivityId() {
		return fitnessActivityId;
	}
	/**
	 * 设置：
	 */
	public void setLatestClockinTime(Date latestClockinTime) {
		this.latestClockinTime = latestClockinTime;
	}
	/**
	 * 获取：
	 */
	public Date getLatestClockinTime() {
		return latestClockinTime;
	}
	/**
	 * 设置：
	 */
	public void setLongestContinueDays(Integer longestContinueDays) {
		this.longestContinueDays = longestContinueDays;
	}
	/**
	 * 获取：
	 */
	public Integer getLongestContinueDays() {
		return longestContinueDays;
	}
	/**
	 * 设置：
	 */
	public void setTotalClockinDays(Integer totalClockinDays) {
		this.totalClockinDays = totalClockinDays;
	}
	/**
	 * 获取：
	 */
	public Integer getTotalClockinDays() {
		return totalClockinDays;
	}
	/**
	 * 设置：
	 */
	public void setTotalParticipateDays(Integer totalParticipateDays) {
		this.totalParticipateDays = totalParticipateDays;
	}
	/**
	 * 获取：
	 */
	public Integer getTotalParticipateDays() {
		return totalParticipateDays;
	}
}
