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

DROP TABLE IF EXISTS `biz_module`;
CREATE TABLE `biz_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `biz_category` varchar(255) NOT NULL COMMENT '业务板块，关联到字典表中类型为某一个业务主体，如type=dlife',
  `object_type` varchar(255) NOT NULL COMMENT '关联的业务对象类型，关联到字典表的object_type',
  `object_id` bigint(20) NOT NULL COMMENT '关联的对象ID',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  `company` varchar(255) DEFAULT NULL COMMENT '所属公司',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='业务板块表'

delete from sys_dict where id in (123,124,125,126,127,128,129);
INSERT INTO `sys_dict` VALUES
('123', '小邀约', 'PIN', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('124', '小目标', 'FIT', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('125', '小问答', 'FAQS', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('126', '用户', 'USER', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('127', '文章', 'BLOG', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('128', '评论和回复', 'COMMENT', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null),
('129', '图片', 'PIC', 'object_type', '业务对象类型', null, null, null, null, null, null, '', null);

delete from sys_dict where id in (130,131,132,133,134,135);
INSERT INTO `sys_dict` VALUES
('130', '技术板块', 'technology', 'dlife', 'dlife业务板块', null, null, null, null, null, null, '', null),
('131', '游戏人生', 'games', 'dlife', 'dlife业务板块', null, null, null, null, null, null, '', null),
('132', '健康生活', 'life', 'dlife', 'dlife业务板块', null, null, null, null, null, null, '', null),
('133', '美食天地', 'food', 'dlife', 'dlife业务板块', null, null, null, null, null, null, '', null),
('134', '数码世界', 'e-world', 'dlife', 'dlife业务板块', null, null, null, null, null, null, '', null),
('135', '影音娱乐', 'entertainment', 'dlife', 'dlife业务板块', null, null, null, null, null, null, '', null);

delete from sys_dict where id in (138,139);
INSERT INTO `sys_dict` VALUES
('138', 'dlife', 'dlife', 'company', '所属公司，业务主体', null, null, null, null, null, null, '', null),
('139', '屈臣氏', 'asw', 'company', '所属公司，业务主体', null, null, null, null, null, null, '', null);





