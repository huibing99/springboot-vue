/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 80030
Source Host           : localhost:3306
Source Database       : vrtrain

Target Server Type    : MYSQL
Target Server Version : 80030
File Encoding         : 65001

Date: 2022-09-21 17:18:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for trainee
-- ----------------------------
DROP TABLE IF EXISTS `trainee`;
CREATE TABLE `trainee` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createtime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of trainee
-- ----------------------------
INSERT INTO `trainee` VALUES ('1', 'www', '111', 'no', '123', null);
INSERT INTO `trainee` VALUES ('2', '123', '123', '12312', '123', null);
INSERT INTO `trainee` VALUES ('3', '1', '1', '1', '1', null);
INSERT INTO `trainee` VALUES ('4', '0', '111', 'n', '123', null);
INSERT INTO `trainee` VALUES ('5', '6', '1', '1', '1', null);
INSERT INTO `trainee` VALUES ('6', 'test', '333', 'test', '111', null);
INSERT INTO `trainee` VALUES ('7', 'admin', 'test', '', '', '2022-09-17 15:28:52');
INSERT INTO `trainee` VALUES ('8', 'test2', 'test', 'test', 'test', '2022-09-17 15:36:56');
INSERT INTO `trainee` VALUES ('9', 'cc', 'cc', 'cc', 'cc', '2022-09-17 15:57:14');
INSERT INTO `trainee` VALUES ('10', 'vv', 'vv', 'v', 'v5', '2022-09-18 22:03:33');
INSERT INTO `trainee` VALUES ('11', 'xx', 'xx', 'x', 'x', '2022-09-18 22:09:09');
