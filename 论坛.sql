/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : project

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 05/09/2019 14:01:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `areaID` int(11) NOT NULL AUTO_INCREMENT COMMENT '版区ID',
  `areaName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '版区名',
  PRIMARY KEY (`areaID`) USING BTREE,
  UNIQUE INDEX `areaName`(`areaName`) USING BTREE,
  INDEX `areaID`(`areaID`) USING BTREE,
  INDEX `areaID_2`(`areaID`) USING BTREE,
  INDEX `areaID_3`(`areaID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `articleID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主题对应的ID',
  `title` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主题名',
  `areaID` int(11) NOT NULL COMMENT '所属版区',
  `account` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `floors` int(11) NOT NULL DEFAULT 0 COMMENT '总层数',
  PRIMARY KEY (`articleID`) USING BTREE,
  INDEX `account`(`account`) USING BTREE,
  INDEX `area`(`areaID`) USING BTREE,
  INDEX `articleID`(`articleID`) USING BTREE,
  INDEX `articleID_2`(`articleID`) USING BTREE,
  INDEX `articleID_3`(`articleID`) USING BTREE,
  CONSTRAINT `account` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `area` FOREIGN KEY (`areaID`) REFERENCES `area` (`areaid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for floor
-- ----------------------------
DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor`  (
  `articleID` int(11) NOT NULL COMMENT '主题ID',
  `floorNumber` int(11) NOT NULL COMMENT '楼层数',
  `account` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼层发言人',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼层内容',
  PRIMARY KEY (`articleID`, `floorNumber`) USING BTREE,
  INDEX `accountname`(`account`) USING BTREE,
  CONSTRAINT `accountname` FOREIGN KEY (`account`) REFERENCES `user` (`account`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `article` FOREIGN KEY (`articleID`) REFERENCES `article` (`articleid`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `account` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号ID',
  `userType` tinyint(4) NOT NULL COMMENT '账户类型，0为管理员，1买家，2商家',
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
