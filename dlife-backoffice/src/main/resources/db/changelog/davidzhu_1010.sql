--liquibase formatted sql
--changeset davidzhu:934

ALTER TABLE question MODIFY COLUMN description text comment '问题描述';

ALTER TABLE sys_user ADD wechat_user_id bigint comment '系统用户关联的微信ID，用于在后台发布信息关联前台显示';
