package com.bootdo.a5.domain;

import com.bootdo.common.utils.Base64Utils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 拼饭活动
 * 
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-27 20:23:32
 */
public class FanActivityDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//发布者id
	private String wechatUserId;
	//头像
	private String avatar;
	//昵称
	private String nickName;
	//活动类型
	private Integer activitiyType;
	//活动名称
	private String activitiyTile;
	//人均预算
	private BigDecimal budget;
	//活动地址
	private String activitiyAddre;
	//活动描述
	private String descrption;
	//组织者
	private String organizeUser;
	//封面图
	private String coverPicture;
	//约定时间
	private Date appointDatetime;
	//约定结束时间
	private Date appointEndDatetime;
	//商家URL
	private String salerUrl;
	//最少参与者
	private Integer lowerLimit;
	//最多参与者
	private Integer upperLimit;
	//支付类型
	private String payType;
	//截至日期
	private Date deadline;
	//备注
	private String jhiComment;
	//活动状态 0-新建 1-完成 2-取消
	private Integer status;
	//评论数量
	private Integer commentCount;
	//
	private Integer readingCount;
	//
	private Date modifyTime;
	//
	private Integer joinStatus;
	//
	private Boolean official;
	//
	private Boolean stick;
	//
	private String stickOrder;

	//是否置顶
	private Integer setTop;
	//置顶顺序
	private Integer numOrder;

	//所属业务板块
	private BizModuleDO bizModuleDO =new BizModuleDO();

	public BizModuleDO getBizModuleDO() {
		return bizModuleDO;
	}

	public void setBizModuleDO(BizModuleDO bizModuleDO) {
		this.bizModuleDO = bizModuleDO;
	}


	public Integer getSetTop() {
		return setTop;
	}

	public void setSetTop(Integer setTop) {
		this.setTop = setTop;
	}

	public Integer getNumOrder() {
		return numOrder;
	}

	public void setNumOrder(Integer numOrder) {
		this.numOrder = numOrder;
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
	 * 设置：发布者id
	 */
	public void setWechatUserId(String wechatUserId) {
		this.wechatUserId = wechatUserId;
	}
	/**
	 * 获取：发布者id
	 */
	public String getWechatUserId() {
		return wechatUserId;
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
	 * 设置：活动类型
	 */
	public void setActivitiyType(Integer activitiyType) {
		this.activitiyType = activitiyType;
	}
	/**
	 * 获取：活动类型
	 */
	public Integer getActivitiyType() {
		return activitiyType;
	}
	/**
	 * 设置：活动名称
	 */
	public void setActivitiyTile(String activitiyTile) {
		this.activitiyTile = activitiyTile;
	}
	/**
	 * 获取：活动名称
	 */
	public String getActivitiyTile() {
		return activitiyTile;
	}
	/**
	 * 设置：人均预算
	 */
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	/**
	 * 获取：人均预算
	 */
	public BigDecimal getBudget() {
		return budget;
	}
	/**
	 * 设置：活动地址
	 */
	public void setActivitiyAddre(String activitiyAddre) {
		this.activitiyAddre = activitiyAddre;
	}
	/**
	 * 获取：活动地址
	 */
	public String getActivitiyAddre() {
		return activitiyAddre;
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
	 * 设置：组织者
	 */
	public void setOrganizeUser(String organizeUser) {
		this.organizeUser = organizeUser;
	}
	/**
	 * 获取：组织者
	 */
	public String getOrganizeUser() {
		return organizeUser;
	}
	/**
	 * 设置：封面图
	 */
	public void setCoverPicture(String coverPicture) {
		this.coverPicture = coverPicture;
	}
	/**
	 * 获取：封面图
	 */
	public String getCoverPicture() {
		return coverPicture;
	}
	/**
	 * 设置：约定时间
	 */
	public void setAppointDatetime(Date appointDatetime) {
		this.appointDatetime = appointDatetime;
	}
	/**
	 * 获取：约定时间
	 */
	public Date getAppointDatetime() {
		return appointDatetime;
	}
	/**
	 * 设置：约定结束时间
	 */
	public void setAppointEndDatetime(Date appointEndDatetime) {
		this.appointEndDatetime = appointEndDatetime;
	}
	/**
	 * 获取：约定结束时间
	 */
	public Date getAppointEndDatetime() {
		return appointEndDatetime;
	}
	/**
	 * 设置：商家URL
	 */
	public void setSalerUrl(String salerUrl) {
		this.salerUrl = salerUrl;
	}
	/**
	 * 获取：商家URL
	 */
	public String getSalerUrl() {
		return salerUrl;
	}
	/**
	 * 设置：最少参与者
	 */
	public void setLowerLimit(Integer lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	/**
	 * 获取：最少参与者
	 */
	public Integer getLowerLimit() {
		return lowerLimit;
	}
	/**
	 * 设置：最多参与者
	 */
	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}
	/**
	 * 获取：最多参与者
	 */
	public Integer getUpperLimit() {
		return upperLimit;
	}
	/**
	 * 设置：支付类型
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 获取：支付类型
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 设置：截至日期
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	/**
	 * 获取：截至日期
	 */
	public Date getDeadline() {
		return deadline;
	}
	/**
	 * 设置：备注
	 */
	public void setJhiComment(String jhiComment) {
		this.jhiComment = jhiComment;
	}
	/**
	 * 获取：备注
	 */
	public String getJhiComment() {
		return jhiComment;
	}
	/**
	 * 设置：活动状态 0-新建 1-完成 2-取消
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：活动状态 0-新建 1-完成 2-取消
	 */
	public Integer getStatus() {
		return status;
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
	public void setJoinStatus(Integer joinStatus) {
		this.joinStatus = joinStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getJoinStatus() {
		return joinStatus;
	}
	/**
	 * 设置：
	 */
	public void setOfficial(Boolean official) {
		this.official = official;
	}
	/**
	 * 获取：
	 */
	public Boolean getOfficial() {
		return official;
	}
	/**
	 * 设置：
	 */
	public void setStick(Boolean stick) {
		this.stick = stick;
	}
	/**
	 * 获取：
	 */
	public Boolean getStick() {
		return stick;
	}
	/**
	 * 设置：
	 */
	public void setStickOrder(String stickOrder) {
		this.stickOrder = stickOrder;
	}
	/**
	 * 获取：
	 */
	public String getStickOrder() {
		return stickOrder;
	}
}
