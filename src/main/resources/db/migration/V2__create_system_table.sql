CREATE TABLE system_user(
`id`  varchar(64) NOT NULL COMMENT '主键ID' ,
`account`  varchar(64) NOT NULL COMMENT '账号' ,
`password`  varchar(225) NOT NULL COMMENT '密码' ,
`status`  int(4) NULL COMMENT '状态（1-正常，2-禁用）' ,
`salt`  varchar(225) default null COMMENT '盐',
`created_by`  varchar(64) NOT NULL COMMENT '创建人' ,
`updated_by`  varchar(64) NOT NULL COMMENT '修改人' ,
`create_time` timestamp NOT NULL default current_timestamp comment '创建时间',
`update_time` timestamp NOT NULL default current_timestamp on update current_timestamp comment '修改时间',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
comment '管理员账号信息表';
