--liquibase formatted sql
--changeset davidzhu:931
UPDATE pin_fan_activity set set_top=0;
