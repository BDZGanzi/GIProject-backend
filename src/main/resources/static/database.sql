DROP DATABASE IF EXISTS db_genshin;
CREATE DATABASE db_genshin;
USE db_genshin;

DROP TABLE IF EXISTS `tb_avatar`;
CREATE TABLE `tb_avatar` (
    `avatar_id` BIGINT NOT NULL,
    `name` VARCHAR (10) COMMENT '角色名',
    `element` VARCHAR (10) COMMENT '元素',
    `rarity` INT COMMENT '星级',
    `image` VARCHAR (100) COMMENT '头像图片链接',
    PRIMARY KEY (`avatar_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
DROP TABLE IF EXISTS `tb_player`;
CREATE TABLE `tb_player` (
    `player_id` BIGINT NOT NULL,
    `username` VARCHAR (20) DEFAULT NULL,
    PRIMARY KEY (`player_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `tb_stats`;
CREATE TABLE `tb_stats` (
    `player_id` BIGINT NOT NULL,
    `active_day` INT COMMENT '活跃天数',
    `achievement` INT COMMENT '已完成成就数',
    `win_rate` INT COMMENT '？？？',
    `anemoculus` INT COMMENT '已获得风神瞳',
    `geoculus` INT COMMENT '已获得岩神曈数量',
    `avatar` INT COMMENT '已解锁角色数量',
    `way_point` INT COMMENT '已解锁传送点数量',
    `domain` INT COMMENT '已解锁秘境',
    `spiral_abyss` VARCHAR (10) COMMENT '深渊通关层数',
    `precious_chest` INT COMMENT '宝贵的宝箱',
    `luxurious_chest` INT COMMENT '豪华的宝箱',
    `exquisite_chest` INT COMMENT '精致的宝箱',
    `common_chest` INT COMMENT '普通的宝箱',
    PRIMARY KEY (`player_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `tb_owned_avatar`;
CREATE TABLE `tb_owned_avatar` (
    `player_id` BIGINT NOT NULL,
    `avatar_id` BIGINT NOT NULL ,
    `fetter` INT COMMENT '好感度',
    `level` INT COMMENT '等级',
    PRIMARY KEY (`player_id`, `avatar_id`),
    INDEX(`player_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;