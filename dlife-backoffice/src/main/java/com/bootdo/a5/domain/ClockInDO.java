package com.bootdo.a5.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 打卡信息
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-01 10:31:17
 */
public class ClockInDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//活动标题
	private String title;
	//签到日记
	private String signNote;
	//打卡时间
	private Date punchDateTime;
	//
	private Integer activityId;
	//
	private Long activityParticipationId;
	//
	private Integer replyCount;
	//
	private Integer thumbsUpCount;

	//关联的wechat用户
	private WechatUserDO wechatUserDO;

	public WechatUserDO getWechatUserDO() {
		return wechatUserDO;
	}

	public void setWechatUserDO(WechatUserDO wechatUserDO) {
		this.wechatUserDO = wechatUserDO;
	}

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
	 * 设置：签到日记
	 */
	public void setSignNote(String signNote) {
		this.signNote = signNote;
	}
	/**
	 * 获取：签到日记
	 */
	public String getSignNote() {
		return signNote;
	}
	/**
	 * 设置：打卡时间
	 */
	public void setPunchDateTime(Date punchDateTime) {
		this.punchDateTime = punchDateTime;
	}
	/**
	 * 获取：打卡时间
	 */
	public Date getPunchDateTime() {
		return punchDateTime;
	}
	/**
	 * 设置：
	 */
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	/**
	 * 获取：
	 */
	public Integer getActivityId() {
		return activityId;
	}
	/**
	 * 设置：
	 */
	public void setActivityParticipationId(Long activityParticipationId) {
		this.activityParticipationId = activityParticipationId;
	}
	/**
	 * 获取：
	 */
	public Long getActivityParticipationId() {
		return activityParticipationId;
	}
	/**
	 * 设置：
	 */
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	/**
	 * 获取：
	 */
	public Integer getReplyCount() {
		return replyCount;
	}
	/**
	 * 设置：
	 */
	public void setThumbsUpCount(Integer thumbsUpCount) {
		this.thumbsUpCount = thumbsUpCount;
	}
	/**
	 * 获取：
	 */
	public Integer getThumbsUpCount() {
		return thumbsUpCount;
	}
}
