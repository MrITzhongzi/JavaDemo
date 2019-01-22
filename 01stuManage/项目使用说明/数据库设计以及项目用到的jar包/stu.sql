/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : stus

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 22/01/2019 15:26:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `hobby` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `info` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 302 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES (1, 'admin', '男', '10086', '1989-10-07', '篮球，足球', '我是个中国人');
INSERT INTO `stu` VALUES (215, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (216, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (217, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (218, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (219, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (220, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (221, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (222, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (223, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (224, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (225, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (226, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (227, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (228, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (229, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (230, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (231, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (232, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (233, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (234, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (235, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (236, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (237, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (238, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (239, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (240, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (241, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (242, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (243, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (244, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (245, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (246, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (247, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (248, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (249, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (250, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (251, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (252, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (253, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (254, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (255, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (256, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (257, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (258, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (259, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (260, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (261, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (262, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (263, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (264, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (265, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (266, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (267, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (268, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (269, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (270, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (271, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (272, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (273, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (274, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (275, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (276, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (277, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (278, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (279, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (280, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (281, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (282, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (283, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (284, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (285, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (286, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (287, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (288, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (289, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (290, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (291, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (292, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (293, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (294, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (295, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (296, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (297, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (298, '李洪伟1', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (299, '李洪伟a', '女', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (300, '李洪伟b', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');
INSERT INTO `stu` VALUES (301, '李洪伟ab', '男', '10010', '1992-10-01', '游泳, 篮球', '12121');

SET FOREIGN_KEY_CHECKS = 1;
