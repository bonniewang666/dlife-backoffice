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
 * @date 2018-09-28 01:58:34
 */
public class QuestionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Integer answerCount;
	//
	private String avatar;
	//
	private Date createTime;
	//
	private String description;
	//
	private String nickName;
	//
	private Integer readingCount;
	//
	private String title;
	//
	private String wechatUserId;
	//
	private Integer replyCount;
	//
	private Integer thumbsupCount;
	//
	private Date modifyTime;

	//所属业务板块
	private BizModuleDO bizModuleDO =new BizModuleDO();

	public BizModuleDO getBizModuleDO() {
		return bizModuleDO;
	}

	public void setBizModuleDO(BizModuleDO bizModuleDO) {
		this.bizModuleDO = bizModuleDO;
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
	 * 设置：
	 */
	public void setAnswerCount(Integer answerCount) {
		this.answerCount = answerCount;
	}
	/**
	 * 获取：
	 */
	public Integer getAnswerCount() {
		return answerCount;
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
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：
	 */
	public String getDescription() {
		return description;
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
	public void setReadingCount(Integer readingCount) {
		this.readingCount = readingCount;
	}
	/**
	 * 获取：
	 */
	public Integer getReadingCount() {
		return readingCount;
	}
	/**
	 * 设置：
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
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
	public void setThumbsupCount(Integer thumbsupCount) {
		this.thumbsupCount = thumbsupCount;
	}
	/**
	 * 获取：
	 */
	public Integer getThumbsupCount() {
		return thumbsupCount;
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
}
