CREATE TABLE `role` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `name` varchar(128) DEFAULT NULL COMMENT '角色(职位)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

INSERT INTO `role` VALUES ('r1', '学科教师');
INSERT INTO `role` VALUES ('r2', '学科组长');
INSERT INTO `role` VALUES ('r3', '教学副校长');
INSERT INTO `role` VALUES ('r4', '校区校长');
INSERT INTO `role` VALUES ('r5', '校区人事');
INSERT INTO `role` VALUES ('r6', '系统管理员');