/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : vrtrain

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 14/09/2022 15:38:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '123456', '管理员', '2022-08-17 16:07:25', '11111111111');
INSERT INTO `sys_user` VALUES (12, 'linghuchong', '123456', '令狐冲', '2022-08-18 10:31:29', '23412341');
INSERT INTO `sys_user` VALUES (14, 'guojing', '123456', '郭靖', '2022-08-18 12:32:43', '4329841');
INSERT INTO `sys_user` VALUES (15, 'sanfeng', '123456', '张三丰', '2022-08-18 12:33:08', '3241');
INSERT INTO `sys_user` VALUES (16, 'xiaobao', '123456', '韦小宝', '2022-08-18 13:45:22', '5413142');
INSERT INTO `sys_user` VALUES (17, 'zhebie', '123456', '哲别', '2022-08-18 14:37:17', '888');
INSERT INTO `sys_user` VALUES (18, 'yaoshi', '123456', '黄药师', '2022-08-18 14:37:33', '666');
INSERT INTO `sys_user` VALUES (37, 'reg', '123', NULL, '2022-09-07 16:43:09', NULL);
INSERT INTO `sys_user` VALUES (44, 'admi', '123', NULL, '2022-09-07 16:52:03', NULL);
INSERT INTO `sys_user` VALUES (54, '1234', '1234', NULL, '2022-09-07 16:57:07', NULL);
INSERT INTO `sys_user` VALUES (55, '123456', '123456', NULL, '2022-09-07 16:57:40', NULL);
INSERT INTO `sys_user` VALUES (59, 'admingg', '123', NULL, '2022-09-07 17:02:34', NULL);

SET FOREIGN_KEY_CHECKS = 1;
