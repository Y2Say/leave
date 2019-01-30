CREATE TABLE `role` (
`id`  varchar(64) NOT NULL COMMENT '主键ID' ,
`name`  varchar(128) NULL COMMENT '角色(职位)' ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
comment '角色表';

CREATE TABLE `user_role` (
`id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID' ,
`account_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号ID' ,
`role_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID' ,
`created_by`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人' ,
`updated_by`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改人' ,
`create_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`update_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
comment '账号角色表';

CREATE TABLE `menu` (
`id`  varchar(64) NOT NULL COMMENT '主键ID' ,
`parent_id`  varchar(64) NULL COMMENT '父级ID' ,
`name`  varchar(128) NULL COMMENT '菜单名' ,
`url`  varchar(512) NULL COMMENT '路径' ,
`image`  varchar(500) NULL COMMENT '图片' ,
`sque`  int(4) NULL COMMENT '排序' ,
`created_by`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人' ,
`updated_by`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '修改人' ,
`create_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
`update_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间' ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
comment '菜单表';