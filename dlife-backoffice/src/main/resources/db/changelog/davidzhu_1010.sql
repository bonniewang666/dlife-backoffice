--liquibase formatted sql
--changeset davidzhu:934

ALTER TABLE question MODIFY COLUMN description text comment '问题描述';