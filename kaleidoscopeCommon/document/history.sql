--用户表
CREATE TABLE `yiny_user` (
`id`  int(11) NOT NULL ,
`name`  varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL ,
`age`  int(11) NULL DEFAULT NULL ,
`o_id`  bigint(20) NULL DEFAULT NULL ,
`login_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL ,
`password`  varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL ,
`mobile`  varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL ,
`email`  varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL ,
`gen_time`  datetime NOT NULL ,
`last_login_time`  datetime NULL DEFAULT NULL ,
`count`  bigint(20) NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_unicode_ci


