package com.bootdo.a5.domain;

import org.springframework.web.util.HtmlUtils;

import java.io.Serializable;
import java.util.Date;



/**
 * 抓取的文章表
 * 
 * @author aitp
 * @email aitp@accenture.com
 * @date 2018-10-03 18:38:44
 */
public class ArticleReferralDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//关联网页抓取器
	private Long crawlerId;
	//标题
	private String originTitle;
	//概述
	private String originSummary;
	//文章地址
	private String originUrl;
	//Md5 URL，用于排重
	private String originUrlCode;
	//图片URL的标识
	private String originImgUrl;
	//创建时间
	private String originCreateDate;
	//作者
	private String author;
	//创建人
	private Long createUserId;
	//创建时间
	private Date createDate;
	//修改人
	private Long updateUserId;
	//修改时间
	private Date updateDate;

	private String orginContent;

	public String getOrginContent() {

		String html = HtmlUtils.htmlUnescape(orginContent);

		return html;
	}

	public void setOrginContent(String orginContent) {
//		String html = HtmlUtils.htmlEscape(orginContent);
		this.orginContent = orginContent;
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
	 * 设置：关联网页抓取器
	 */
	public void setCrawlerId(Long crawlerId) {
		this.crawlerId = crawlerId;
	}
	/**
	 * 获取：关联网页抓取器
	 */
	public Long getCrawlerId() {
		return crawlerId;
	}
	/**
	 * 设置：标题
	 */
	public void setOriginTitle(String originTitle) {
		this.originTitle = originTitle;
	}
	/**
	 * 获取：标题
	 */
	public String getOriginTitle() {
		return originTitle;
	}
	/**
	 * 设置：概述
	 */
	public void setOriginSummary(String originSummary) {
		this.originSummary = originSummary;
	}
	/**
	 * 获取：概述
	 */
	public String getOriginSummary() {
		return originSummary;
	}
	/**
	 * 设置：文章地址
	 */
	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}
	/**
	 * 获取：文章地址
	 */
	public String getOriginUrl() {
		return originUrl;
	}
	/**
	 * 设置：Md5 URL，用于排重
	 */
	public void setOriginUrlCode(String originUrlCode) {
		this.originUrlCode = originUrlCode;
	}
	/**
	 * 获取：Md5 URL，用于排重
	 */
	public String getOriginUrlCode() {
		return originUrlCode;
	}
	/**
	 * 设置：图片URL的标识
	 */
	public void setOriginImgUrl(String originImgUrl) {
		this.originImgUrl = originImgUrl;
	}
	/**
	 * 获取：图片URL的标识
	 */
	public String getOriginImgUrl() {
		return originImgUrl;
	}
	/**
	 * 设置：创建时间
	 */
	public void setOriginCreateDate(String originCreateDate) {
		this.originCreateDate = originCreateDate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getOriginCreateDate() {
		return originCreateDate;
	}
	/**
	 * 设置：作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者
	 */
	public String getAuthor() {
		return author;
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
