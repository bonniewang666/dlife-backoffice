--liquibase formatted sql
--changeset davidzhu:932

DROP TABLE IF EXISTS `tags`;

CREATE TABLE `tags` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签主键',
  `name` varchar(20) NOT NULL COMMENT '标签名称',
  `object_id` bigint(20) NOT NULL COMMENT '关联对象主键',
  `object_type` varchar(10) DEFAULT NULL COMMENT '关联对象类型,从字典表获取object_type类型获得',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签表'

delete from sys_dict where id in (123,124,125,126,127,128,129);

INSERT INTO `sys_dict` VALUES
('123', '小邀约', 'PIN', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('124', '小目标', 'FIT', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('125', '小问答', 'FAQS', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('126', '用户', 'USER', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('127', '文章', 'BLOG', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('128', '评论和回复', 'COMMENT', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('129', '图片', 'PIC', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null);





