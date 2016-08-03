CREATE DATABASE youtu;

USE youtu;

CREATE TABLE `user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `password`  varchar(32) NOT NULL COMMENT '密码',
  `name` varchar(120) NOT NULL COMMENT '用户名称',
  `degree` SMALLINT NOT NULL COMMENT '用户等级',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '账号创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_degree` (`degree`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `user` (`name`, `degree`) VALUES ('xjx', '0');

