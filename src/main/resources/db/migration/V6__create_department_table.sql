
CREATE TABLE `department` (
  `id` varchar(64) NOT NULL COMMENT '部门ID',
  `name` varchar(64) NOT NULL COMMENT '部门名称',
  `description` varchar(128) DEFAULT NULL COMMENT '部门描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('d0', '系统', '管理员');
INSERT INTO `department` VALUES ('d1', '人事部', null);
INSERT INTO `department` VALUES ('d2', '教研部', null);
INSERT INTO `department` VALUES ('d3', '市场部', null);
INSERT INTO `department` VALUES ('d4', 'IT部', null);
INSERT INTO `department` VALUES ('d5', '校区领导', null);
INSERT INTO `department` VALUES ('d6', '其他', null);