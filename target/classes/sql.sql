CREATE DATABASE youtu;

USE youtu;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_uuid` char(32) NOT NULL DEFAULT '0' COMMENT '用户Uuid',
  `user_name` varchar(20) NOT NULL DEFAULT '0' COMMENT '登录名',
  `password` varchar(32) NOT NULL DEFAULT '0' COMMENT '登录密码',
  `telephone` varchar(13) NOT NULL DEFAULT '0' COMMENT '手机号',
  `code` varchar(6) NOT NULL DEFAULT '0' COMMENT '验证码',
  `code_create_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '验证码生成时间，13位毫秒值',
  `head_img` varchar(100) NOT NULL DEFAULT '0' COMMENT '头像地址',
  `nick_name` varchar(20) NOT NULL DEFAULT '0' COMMENT '昵称',
  `real_name` varchar(20) NOT NULL DEFAULT '0' COMMENT '真实姓名',
  `sex` enum('1','0') NOT NULL DEFAULT '0' COMMENT '0男，1女',
  `birthday` varchar(20) NOT NULL DEFAULT '0' COMMENT '生日',
  `examine_state` enum('1','0') NOT NULL DEFAULT '0' COMMENT '0正常，1禁止',
  `forbidden_time` varchar(20) NOT NULL DEFAULT '0' COMMENT '禁止时间',
  `city` varchar(50) NOT NULL DEFAULT '0' COMMENT '所在城市，**省**市',
  `last_login_time` varchar(20) NOT NULL DEFAULT '0' COMMENT '最后登录时间',
  `jpush_id` varchar(20) NOT NULL DEFAULT '0' COMMENT '推送设备号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`name`, `degree`) VALUES ('xjx', '0');

