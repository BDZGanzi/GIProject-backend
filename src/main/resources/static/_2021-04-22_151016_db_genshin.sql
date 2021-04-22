/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ db_genshin /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE db_genshin;

DROP TABLE IF EXISTS tb_avatar;
CREATE TABLE `tb_avatar` (
  `avatar_id` bigint NOT NULL,
  `name` varchar(10) DEFAULT NULL COMMENT '角色名',
  `element` varchar(10) DEFAULT NULL COMMENT '元素',
  `rarity` int DEFAULT NULL COMMENT '星级',
  `image` varchar(100) DEFAULT NULL COMMENT '头像图片链接',
  PRIMARY KEY (`avatar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_owned_avatar;
CREATE TABLE `tb_owned_avatar` (
  `player_id` bigint NOT NULL,
  `avatar_id` bigint NOT NULL,
  `fetter` int DEFAULT NULL COMMENT '好感度',
  `level` int DEFAULT NULL COMMENT '等级',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名字',
  `element` varchar(5) DEFAULT NULL COMMENT '角色元素所使用的类型',
  `image` varchar(100) DEFAULT NULL COMMENT '角色头像链接',
  `rarity` int DEFAULT NULL COMMENT '角色星级',
  PRIMARY KEY (`player_id`,`avatar_id`),
  KEY `player_id` (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_player;
CREATE TABLE `tb_player` (
  `player_id` bigint NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_stat;
CREATE TABLE `tb_stat` (
  `player_id` bigint NOT NULL,
  `active_day` int DEFAULT NULL COMMENT '活跃天数',
  `achievement` int DEFAULT NULL COMMENT '已完成成就数',
  `win_rate` int DEFAULT NULL COMMENT '？？？',
  `anemoculus` int DEFAULT NULL COMMENT '已获得风神瞳',
  `geoculus` int DEFAULT NULL COMMENT '已获得岩神曈数量',
  `avatar` int DEFAULT NULL COMMENT '已解锁角色数量',
  `way_point` int DEFAULT NULL COMMENT '已解锁传送点数量',
  `domain` int DEFAULT NULL COMMENT '已解锁秘境',
  `spiral_abyss` varchar(10) DEFAULT NULL COMMENT '深渊通关层数',
  `precious_chest` int DEFAULT NULL COMMENT '宝贵的宝箱',
  `luxurious_chest` int DEFAULT NULL COMMENT '豪华的宝箱',
  `exquisite_chest` int DEFAULT NULL COMMENT '精致的宝箱',
  `common_chest` int DEFAULT NULL COMMENT '普通的宝箱',
  PRIMARY KEY (`player_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;









/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
