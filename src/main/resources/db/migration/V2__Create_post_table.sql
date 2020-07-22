/*
Navicat MySQL Data Transfer

Source Server         : con
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-07-21 23:28:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `accountId` varchar(50) DEFAULT NULL,
  `login` varchar(50) DEFAULT NULL,
  `token` varchar(50) DEFAULT NULL,
  `gmtCreate` datetime DEFAULT NULL,
  `gmtModified` datetime DEFAULT NULL,
  `bio` varchar(50) DEFAULT NULL,
  `avatarUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (''7'', ''48912201'', ''CatFaceMan'', ''f0af19a9-af2c-41bc-9706-a0e0716b951a'', ''2020-07-21 11:00:21'', ''2020-07-21 11:00:21'', ''https://blog.csdn.net/qaqpbp'', ''https://avatars3.githubusercontent.com/u/48912201?v=4'');
