CREATE TABLE `menu` (
  `id` varchar(64) NOT NULL COMMENT '主键ID',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父节点ID',
  `name` varchar(128) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(128) DEFAULT NULL COMMENT 'URL',
  `image` varchar(128) DEFAULT NULL COMMENT '图片',
  `sequ` int(4) DEFAULT NULL COMMENT '排序',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';