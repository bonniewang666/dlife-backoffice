package com.bootdo.a5.domain;

import com.bootdo.common.utils.Base64Utils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;


/**
 * @author aitp
 * @email 1992lcg@163.com
 * @date 2018-09-28 02:25:07
 */
public class CommentDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long parentId;
    //
    private Long objectId;
    //
    private String channel;
    //
    private String wechatUserId;
    //
    private String avatar;
    //
    private String nickName;
    //
    private String content;
    //
    private Integer rating1;
    //
    private Integer rating2;
    //
    private Integer rating3;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer replyCount;
    //
    private String rpAvatar;
    //
    private String rpNickName;
    //
    private Long rpWechatUserId;
    //
    private String module;

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
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取：
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置：
     */
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    /**
     * 获取：
     */
    public Long getObjectId() {
        return objectId;
    }

    /**
     * 设置：
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * 获取：
     */
    public String getChannel() {
        return channel;
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
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取：
     */
    public String getNickName() {
        return Base64Utils.decode( nickName);
    }

    /**
     * 设置：
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置：
     */
    public void setRating1(Integer rating1) {
        this.rating1 = rating1;
    }

    /**
     * 获取：
     */
    public Integer getRating1() {
        return rating1;
    }

    /**
     * 设置：
     */
    public void setRating2(Integer rating2) {
        this.rating2 = rating2;
    }

    /**
     * 获取：
     */
    public Integer getRating2() {
        return rating2;
    }

    /**
     * 设置：
     */
    public void setRating3(Integer rating3) {
        this.rating3 = rating3;
    }

    /**
     * 获取：
     */
    public Integer getRating3() {
        return rating3;
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
    public void setRpAvatar(String rpAvatar) {
        this.rpAvatar = rpAvatar;
    }

    /**
     * 获取：
     */
    public String getRpAvatar() {
        return rpAvatar;
    }

    /**
     * 设置：
     */
    public void setRpNickName(String rpNickName) {
        this.rpNickName = rpNickName;
    }

    /**
     * 获取：
     */
    public String getRpNickName() {
        return rpNickName;
    }

    /**
     * 设置：
     */
    public void setRpWechatUserId(Long rpWechatUserId) {
        this.rpWechatUserId = rpWechatUserId;
    }

    /**
     * 获取：
     */
    public Long getRpWechatUserId() {
        return rpWechatUserId;
    }

    /**
     * 设置：
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * 获取：
     */
    public String getModule() {
        return module;
    }
}
