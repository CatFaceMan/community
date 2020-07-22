/*
Navicat MySQL Data Transfer

Source Server         : con
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-07-21 23:28:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `title` varchar(50) NOT NULL DEFAULT '',
  `content` varchar(1000) DEFAULT NULL,
  `tip` varchar(50) DEFAULT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModified` datetime DEFAULT NULL,
  `accountId` varchar(50) DEFAULT NULL,
  `commentCount` varchar(1000) CHARACTER SET latin1 DEFAULT NULL,
  `viewCount` int(11) DEFAULT NULL,
  `likeCount` int(11) DEFAULT NULL,
  `avatarUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`title`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', 'CatFaceMan', '传奇世界', '无限可能', '传世', '2020-07-21 10:54:25', '2020-07-21 10:54:25', '48912201', '1', '2', '3', 'https://avatars3.githubusercontent.com/u/48912201?v=4');
