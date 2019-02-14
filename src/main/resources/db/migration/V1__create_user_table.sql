CREATE TABLE `user` (
`id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID' ,
`account`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号' ,
`name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名' ,
`password`  varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码' ,
`status`  int(4) NULL DEFAULT NULL COMMENT '状态（0-初始化，1-正常，2-禁用）' ,
`department_id`  varchar(64)  NULL COMMENT '部门ID' ,
`salt`  varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐' ,
`created_by`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '创建人' ,
`updated_by`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '修改人' ,
`create_time`  timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`update_time`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
comment '用户账号信息表';