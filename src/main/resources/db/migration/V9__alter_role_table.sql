ALTER TABLE `role`
ADD COLUMN `status`  int(4) NOT NULL DEFAULT 0 COMMENT '角色状态（0-正常，1-弃用）' AFTER `level`;