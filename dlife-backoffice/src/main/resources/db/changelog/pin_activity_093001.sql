--liquibase formatted sql
--changeset davidzhu:930

ALTER TABLE pin_fan_activity ADD set_top int comment '置顶标示,0-不置顶 1-置顶';
ALTER TABLE pin_fan_activity ADD num_order int comment '置顶的顺序,如1，2，3';

UPDATE pin_fan_activity set set_top=1;
