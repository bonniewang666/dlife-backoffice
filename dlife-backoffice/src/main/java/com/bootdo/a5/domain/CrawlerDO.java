package com.bootdo.a5.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 网页抓取器表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-03 18:39:33
 */
public class CrawlerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//地址名称
	private String channelName;
	//地址描述
	private String channelDescription;
	//URL中标识页码的参数
	private String symbolPageNumber;
	//url
	private String channelUrl;
	//标题
	private String symbolTitle;
	//概述的标识
	private String symbolSummary;
	//创建时间的标识
	private String symbolCreateDate;
	//图片URL的标识
	private String symbolImgUrl;
	//作者的标识
	private String symbolAuthor;
	//创建人
	private Long createUserId;
	//创建时间
	private Date createDate;
	//修改人
	private Long updateUserId;
	//修改时间
	private Date updateDate;

	private String symbolUrl;

	private String symbolParagraph;

	private Long executed;

	public String getSymbolParagraph() {
		return symbolParagraph;
	}

	public void setSymbolParagraph(String symbolParagraph) {
		this.symbolParagraph = symbolParagraph;
	}

	public Long getExecuted() {
		return executed;
	}

	public void setExecuted(Long executed) {
		this.executed = executed;
	}

	public String getSymbolUrl() {
		return symbolUrl;
	}

	public void setSymbolUrl(String symbolUrl) {
		this.symbolUrl = symbolUrl;
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
	 * 设置：地址名称
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	/**
	 * 获取：地址名称
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * 设置：地址描述
	 */
	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}
	/**
	 * 获取：地址描述
	 */
	public String getChannelDescription() {
		return channelDescription;
	}
	/**
	 * 设置：URL中标识页码的参数
	 */
	public void setSymbolPageNumber(String symbolPageNumber) {
		this.symbolPageNumber = symbolPageNumber;
	}
	/**
	 * 获取：URL中标识页码的参数
	 */
	public String getSymbolPageNumber() {
		return symbolPageNumber;
	}
	/**
	 * 设置：url
	 */
	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
	}
	/**
	 * 获取：url
	 */
	public String getChannelUrl() {
		return channelUrl;
	}
	/**
	 * 设置：标题
	 */
	public void setSymbolTitle(String symbolTitle) {
		this.symbolTitle = symbolTitle;
	}
	/**
	 * 获取：标题
	 */
	public String getSymbolTitle() {
		return symbolTitle;
	}
	/**
	 * 设置：概述的标识
	 */
	public void setSymbolSummary(String symbolSummary) {
		this.symbolSummary = symbolSummary;
	}
	/**
	 * 获取：概述的标识
	 */
	public String getSymbolSummary() {
		return symbolSummary;
	}
	/**
	 * 设置：创建时间的标识
	 */
	public void setSymbolCreateDate(String symbolCreateDate) {
		this.symbolCreateDate = symbolCreateDate;
	}
	/**
	 * 获取：创建时间的标识
	 */
	public String getSymbolCreateDate() {
		return symbolCreateDate;
	}
	/**
	 * 设置：图片URL的标识
	 */
	public void setSymbolImgUrl(String symbolImgUrl) {
		this.symbolImgUrl = symbolImgUrl;
	}
	/**
	 * 获取：图片URL的标识
	 */
	public String getSymbolImgUrl() {
		return symbolImgUrl;
	}
	/**
	 * 设置：作者的标识
	 */
	public void setSymbolAuthor(String symbolAuthor) {
		this.symbolAuthor = symbolAuthor;
	}
	/**
	 * 获取：作者的标识
	 */
	public String getSymbolAuthor() {
		return symbolAuthor;
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
