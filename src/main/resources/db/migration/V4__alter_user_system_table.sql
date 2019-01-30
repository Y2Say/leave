ALTER TABLE `user`
ADD COLUMN `name`  varchar(64) NULL COMMENT '用户名' AFTER `account`;

ALTER TABLE `system_user`
ADD COLUMN `name`  varchar(64) NULL COMMENT '用户名' AFTER `account`;

