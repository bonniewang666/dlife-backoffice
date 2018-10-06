--liquibase formatted sql
--changeset davidzhu:933

DROP TABLE IF EXISTS `crawler`;
CREATE TABLE `crawler` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_name` varchar(255) DEFAULT NULL COMMENT '地址名称',
  `channel_description` varchar(1000) DEFAULT NULL COMMENT '地址描述',
  `symbol_page_number` varchar(255) DEFAULT NULL COMMENT 'URL中标识页码的参数',
  `channel_url` varchar(1000) DEFAULT NULL COMMENT 'url',
  `symbol_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `symbol_summary` varchar(255) DEFAULT NULL COMMENT '概述的标识',
  `symbol_create_date` varchar(255) DEFAULT NULL COMMENT '创建时间的标识',
  `symbol_img_url` varchar(255) DEFAULT NULL COMMENT '图片URL的标识',
  `symbol_author` varchar(255) DEFAULT NULL COMMENT '作者的标识',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `symbol_url` varchar(255) DEFAULT NULL COMMENT 'url地址的标识',
  `symbol_paragraph` varchar(255) DEFAULT NULL,
  `executed` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='网页抓取器表';

DROP TABLE IF EXISTS `article_referral`;
CREATE TABLE `article_referral` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `crawler_id` bigint(20) DEFAULT NULL COMMENT '关联网页抓取器',
  `origin_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `origin_summary` varchar(1000) DEFAULT NULL COMMENT '概述',
  `origin_url` varchar(1000) DEFAULT NULL COMMENT '文章地址',
  `origin_url_code` varchar(1000) DEFAULT NULL COMMENT 'Md5 URL，用于排重',
  `origin_img_url` varchar(1000) DEFAULT NULL COMMENT '图片URL的标识',
  `origin_create_date` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `orgin_content` text COMMENT '原内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COMMENT='抓取的文章表'


delete from `sys_menu` where menu_id in (139,140,141,142);
INSERT INTO `sys_menu` VALUES
('139', '110', '爬虫配置', '/a5/crawler', 'a5:crawler:crawler', '1', '', null, null, null),
('140', '139', '新增', '/a5/crawler/add', 'a5:crawler:add', '2', '', null, null, null),
('141', '139', '修改', '/a5/crawler/update', 'a5:crawler:edit', '2', '', null, null, null),
('142', '139', '删除', '/a5/crawler/remove', 'a5:crawler:remove', '2', '', null, null, null);
update  `sys_menu` set order_num=8 where menu_id=139;

delete from `sys_menu` where menu_id in (135,136,137,138);
INSERT INTO `sys_menu` VALUES
('135', '110', '文章抓取', '/a5/articleReferral', 'a5:articleReferral:articleReferral', '1', '', null, null, null),
('136', '135', '新增', '/a5/articleReferral/add', 'a5:articleReferral:add', '2', '', null, null, null),
('137', '135', '修改', '/a5/articleReferral/update', 'a5:articleReferral:edit', '2', '', null, null, null),
('138', '135', '删除', '/a5/articleReferral/remove', 'a5:articleReferral:remove', '2', '', null, null, null);
update  `sys_menu` set order_num=9 where menu_id=135;




