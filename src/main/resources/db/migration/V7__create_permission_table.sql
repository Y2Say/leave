CREATE TABLE permission (
`role_id`  varchar(64) NOT NULL COMMENT '角色ID' ,
`menu_id`  varchar(64) NOT NULL COMMENT '资源ID' ,
`create_time`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间' ,
PRIMARY KEY (`role_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
comment '权限表';