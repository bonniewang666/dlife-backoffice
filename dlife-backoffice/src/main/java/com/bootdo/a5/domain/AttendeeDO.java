package com.bootdo.a5.domain;

import com.bootdo.common.utils.Base64Utils;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 小邀约参加人
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-09-29 12:36:56
 */
public class AttendeeDO implements Serializable {
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
	private Date participationTime;
	//
	private String activitiyTile;
	//
	private Long pinFanActivityId;

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
		return Base64Utils.decode( nickName );
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
	public void setActivitiyTile(String activitiyTile) {
		this.activitiyTile = activitiyTile;
	}
	/**
	 * 获取：
	 */
	public String getActivitiyTile() {
		return activitiyTile;
	}
	/**
	 * 设置：
	 */
	public void setPinFanActivityId(Long pinFanActivityId) {
		this.pinFanActivityId = pinFanActivityId;
	}
	/**
	 * 获取：
	 */
	public Long getPinFanActivityId() {
		return pinFanActivityId;
	}
}
