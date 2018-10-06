--liquibase formatted sql
--changeset davidzhu:932

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签主键',
  `name` varchar(20) NOT NULL COMMENT '标签名称',
  `wechat_user_id` bigint(20) DEFAULT NULL COMMENT 'wechat user编号',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL,
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签表';


DROP TABLE IF EXISTS `tag_biz`;
CREATE TABLE `tag_biz` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `object_type` varchar(255) NOT NULL COMMENT '关联的业务对象类型，关联到字典表的object_type',
  `object_id` bigint(20) NOT NULL COMMENT '关联的对象ID',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `update_date` datetime DEFAULT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签和业务对象关系表';


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='业务板块表';

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

delete from `sys_menu` where menu_id in (127,128,129,130);
INSERT INTO `sys_menu` VALUES
('127', '110', '板块内容', '/a5/bizModule', 'a5:bizModule:bizModule', '1', '', null, null, null),
('128', '127', '新增', '/a5/bizModule/add', 'a5:bizModule:add', '2', '', null, null, null),
('129', '127', '修改', '/a5/bizModule/update', 'a5:bizModule:edit', '2', '', null, null, null),
('130', '127', '删除', '/a5/bizModule/remove', 'a5:bizModule:remove', '2', '', null, null, null);
update  `sys_menu` set name='基础服务' where menu_id=110;
update  `sys_menu` set order_num=1 where menu_id=112;
update  `sys_menu` set order_num=2 where menu_id=105;
update  `sys_menu` set order_num=3 where menu_id=116;
update  `sys_menu` set order_num=4 where menu_id=120;
update  `sys_menu` set order_num=5 where menu_id=127;
update  `sys_menu` set order_num=6 where menu_id=111;

delete from `sys_menu` where menu_id in (131,132,133,134);
INSERT INTO `sys_menu` VALUES
('131', '110', '标签池', '/a5/tag', 'a5:tag:tag', '1', '', null, null, null),
('132', '131', '新增', '/a5/tag/add', 'a5:tag:add', '2', '', null, null, null),
('133', '131', '修改', '/a5/tag/update', 'a5:tag:edit', '2', '', null, null, null),
('134', '131', '删除', '/a5/tag/remove', 'a5:tag:remove', '2', '', null, null, null);
update  `sys_menu` set order_num=7 where menu_id=131;




