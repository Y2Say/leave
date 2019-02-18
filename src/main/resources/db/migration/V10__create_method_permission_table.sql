CREATE TABLE `method_access_permission` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL,
  `class_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '类名',
  `method_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '方法名',
  `role_ids` text CHARACTER SET utf8 COMMENT '角色ID列表，以逗号隔开',
  `user_ids` text COLLATE utf8_bin COMMENT '用户ID列表，以逗号隔开',
  `created_time` datetime NOT NULL COMMENT '记录该条记录的创建时间',
  `update_time` datetime NOT NULL COMMENT '记录该条记录的更新时间',
  `created_by` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '记录该条记录的创建者',
  `update_by` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '记录该条记录由何人更新',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='确定哪个方法仅限于哪些角色调用';
