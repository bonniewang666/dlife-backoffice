--liquibase formatted sql
--changeset davidzhu:928


-- ----------------------------
--  Records of `sys_menu`
-- ----------------------------
INSERT INTO `sys_menu` VALUES
  ('105', '110', '小邀约', '/a5/fanActivity', 'a5:fanActivity:fanActivity', '1', '', '3', null, null),
  ('106', '105', '新增', '', 'a5:fanActivity:add', '2', '', null, null, null),
  ('107', '105', '修改', '', 'a5:fanActivity:edit', '2', '', null, null, null),
  ('108', '105', '删除', '', 'a5:fanActivity:remove', '2', '', null, null, null),
  ('109', '105', '批量删除', '', 'a5:fanActivity:batchRemove', '2', '', null, null, null),
  ('110', '0', 'A5', '', '', '0', 'fa fa-users', null, null, null),
  ('111', '110', '微信用户', '/a5/wechatUser', 'a5:wechatUser:wechatUser', '0', '', '1', null, null),
  ('112', '110', '小目标', '/a5/fitnessActivity', 'a5:fitnessActivity:fitnessActivity', '1', '', '2', null, null),
  ('113', '112', '新增', '/a5/fitnessActivity/add', 'a5:fitnessActivity:add', '2', '', null, null, null),
  ('114', '112', '删除', '/a5/fitnessActivity/remove', 'a5:fitnessActivity:remove', '2', '', null, null, null),
  ('115', '112', '修改', '/a5/fitnessActivity/update', 'a5:fitnessActivity:edit', '2', '', null, null, null),
  ('116', '110', '小问答', '/a5/question', 'a5:question:question', '1', '', '4', null, null),
  ('117', '116', '新增', '/a5/question/add', 'a5:question:add', '2', '', null, null, null),
  ('118', '116', '修改', '/a5/question/update', 'a5:question:edit', '2', '', null, null, null),
  ('119', '116', '删除', '/a5/question/remove', 'a5:question:remove', '2', '', null, null, null),
  ('120', '110', '评论及回复', '/a5/comment', 'a5:comment:comment', '1', '', '5', null, null),
  ('121', '120', '新增', '/a5/comment/add', 'a5:comment:add', '2', '', null, null, null),
  ('122', '120', '修改', '/a5/comment/update', 'a5:comment:edit', '2', '', null, null, null),
  ('123', '120', '删除', '/a5/comment/remove', 'a5:comment:remove', '2', '', null, null, null),
  ('124', '120', '批量删除', '/a5/comment/batchRemove', 'a5:comment:batchRemove', '2', '', null, null, null),
  ('125', '111', '修改', '/a5/wechatUser/update', 'a5:wechatUser:edit', '2', '', null, null, null),
  ('126', '111', '修改状态', '/a5/wechatUser/update', 'a5:wechatUser:edit', '2', '', null, null, null);

