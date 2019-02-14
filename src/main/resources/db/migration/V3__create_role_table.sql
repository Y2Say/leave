CREATE TABLE `role` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `name` varchar(128) DEFAULT NULL COMMENT '角色(职位)',
  `description` varchar(128) DEFAULT NULL COMMENT '描述',
  `level`  int(4) NULL DEFAULT NULL COMMENT '角色等级' ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

INSERT INTO `role` VALUES ('r1', '学科教师', '', null);
INSERT INTO `role` VALUES ('r2', '学科组长', '', null);
INSERT INTO `role` VALUES ('r3', '教学副校长', '', null);
INSERT INTO `role` VALUES ('r4', '校区校长', '', null);
INSERT INTO `role` VALUES ('r5', '校区人事', '', null);
INSERT INTO `role` VALUES ('r6', '系统管理员', '', null);