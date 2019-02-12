CREATE TABLE `menu` (
`id`  varchar(64) NOT NULL COMMENT '主键ID' ,
`parent_id`  varchar(64) NULL COMMENT '父节点ID' ,
`name`  varchar(128) NULL COMMENT '菜单名称' ,
`url`  varchar(128) NULL COMMENT 'URL' ,
`image`  varchar(128) NULL COMMENT '图片' ,
`sequ`  int(4) NULL COMMENT '排序' ,
`created_by`  varchar(64) NULL COMMENT '创建人' ,
`updated_by`  varchar(64) NULL COMMENT '修改人' ,
`create_time` timestamp NULL default current_timestamp comment '创建时间',
`update_time` timestamp NULL default current_timestamp on update current_timestamp comment '修改时间',
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
comment '菜单表';