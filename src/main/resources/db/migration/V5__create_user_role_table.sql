CREATE TABLE user_role (
`user_id`  varchar(64) NOT NULL COMMENT '用户ID' ,
`role_id`  varchar(64) NOT NULL COMMENT '角色ID' ,
`create_time`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8
comment '用户角色表';