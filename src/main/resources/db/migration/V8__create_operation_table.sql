CREATE TABLE operation (
`id`  varchar(64) NOT NULL COMMENT '操作权限ID' ,
`name`  varchar(64) NOT NULL COMMENT '操作权限名称' ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
comment '操作权限表';

INSERT INTO `operation` VALUES ('1', '新增');
INSERT INTO `operation` VALUES ('2', '删除');
INSERT INTO `operation` VALUES ('3', '修改');
INSERT INTO `operation` VALUES ('4', '查询');