/*
Navicat MySQL Data Transfer

Source Server         : jk
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : jk

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-02-14 16:44:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contract_c
-- ----------------------------
DROP TABLE IF EXISTS `contract_c`;
CREATE TABLE `contract_c` (
  `CONTRACT_ID` varchar(90) NOT NULL,
  `OFFEROR` varchar(200) DEFAULT NULL,
  `CONTRACT_NO` varchar(20) DEFAULT NULL,
  `SIGNING_DATE` datetime DEFAULT NULL,
  `INPUT_BY` varchar(30) DEFAULT NULL,
  `CHECK_BY` varchar(30) DEFAULT NULL,
  `INSPECTOR` varchar(30) DEFAULT NULL,
  `TOTAL_AMOUNT` decimal(10,2) DEFAULT NULL,
  `CREQUEST` varchar(2000) DEFAULT NULL,
  `CUSTOM_NAME` varchar(2000) DEFAULT NULL,
  `SHIP_TIME` datetime DEFAULT NULL,
  `IMPORT_NUM` char(1) DEFAULT NULL,
  `DELIVERY_PERIOD` datetime DEFAULT NULL,
  `REMARK` varchar(2000) DEFAULT NULL,
  `PRINT_STYLE` char(1) DEFAULT NULL,
  `OLD_STATE` int(11) DEFAULT NULL,
  `STATE` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(40) DEFAULT NULL,
  `CREATE_DEPT` varchar(40) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `TRADE_TERMS` varchar(30) DEFAULT NULL,
  `OUT_STATE` int(11) DEFAULT NULL,
  PRIMARY KEY (`CONTRACT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for contract_product_c
-- ----------------------------
DROP TABLE IF EXISTS `contract_product_c`;
CREATE TABLE `contract_product_c` (
  `CONTRACT_PRODUCT_ID` varchar(90) NOT NULL COMMENT '唯一',
  `contractId` varchar(40) DEFAULT NULL,
  `EXPORT_LIST_ID` varchar(40) DEFAULT NULL,
  `INVOICE_ID` varchar(40) DEFAULT NULL,
  `PRODUCT_NAME` varchar(200) DEFAULT NULL,
  `productNo` varchar(50) DEFAULT NULL,
  `productImage` varchar(200) DEFAULT NULL,
  `productDesc` varchar(600) DEFAULT NULL,
  `SIZE_LENGTH` decimal(10,2) DEFAULT NULL,
  `SIZE_WIDTH` decimal(10,2) DEFAULT NULL,
  `SIZE_HEIGHT` decimal(10,2) DEFAULT NULL,
  `loadingRate` varchar(30) DEFAULT NULL,
  `PRODUCT_REQUEST` varchar(2000) DEFAULT NULL,
  `factoryId` varchar(40) DEFAULT NULL,
  `packingUnit` varchar(20) DEFAULT NULL,
  `cnumber` int(11) DEFAULT NULL,
  `outNumber` int(11) DEFAULT NULL,
  `finished` bit(1) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `CUNIT` varchar(10) DEFAULT NULL,
  `boxNum` int(11) DEFAULT NULL,
  `GROSS_WEIGHT` decimal(10,2) DEFAULT NULL,
  `NET_WEIGHT` decimal(10,2) DEFAULT NULL,
  `CSIZE` varchar(20) DEFAULT NULL,
  `EX_PRICE` decimal(10,2) DEFAULT NULL,
  `EX_AMOUNT` decimal(10,2) DEFAULT NULL,
  `EX_UNIT` varchar(10) DEFAULT NULL,
  `NO_TAX` decimal(10,2) DEFAULT NULL,
  `TAX` decimal(10,2) DEFAULT NULL,
  `COST_PRICE` decimal(10,2) DEFAULT NULL,
  `COST_TAX` decimal(10,2) DEFAULT NULL,
  `ACCESSORIES` bit(1) DEFAULT NULL,
  `orderNo` int(11) DEFAULT NULL,
  `factoryName` varchar(1255) DEFAULT NULL,
  `exts` varchar(555) DEFAULT NULL,
  PRIMARY KEY (`CONTRACT_PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ext_cproduct_c
-- ----------------------------
DROP TABLE IF EXISTS `ext_cproduct_c`;
CREATE TABLE `ext_cproduct_c` (
  `EXT_CPRODUCT_ID` varchar(90) NOT NULL,
  `FACTORY_ID` varchar(40) DEFAULT NULL,
  `CONTRACT_PRODUCT_ID` varchar(40) DEFAULT NULL,
  `CTYPE` int(11) DEFAULT NULL,
  `PRODUCT_NAME` varchar(200) DEFAULT NULL,
  `PRODUCT_NO` varchar(50) DEFAULT NULL,
  `PRODUCT_IMAGE` varchar(200) DEFAULT NULL,
  `PRODUCT_DESC` varchar(600) DEFAULT NULL,
  `LOADING_RATE` varchar(30) DEFAULT NULL,
  `PACKING_UNIT` varchar(10) DEFAULT NULL,
  `CNUMBER` int(11) DEFAULT NULL,
  `OUT_NUMBER` int(11) DEFAULT NULL,
  `FINISHED` bit(1) DEFAULT NULL,
  `GROSS_WEIGHT` decimal(10,2) DEFAULT NULL,
  `NET_WEIGHT` decimal(10,2) DEFAULT NULL,
  `SIZE_LENGTH` decimal(10,2) DEFAULT NULL,
  `SIZE_WIDTH` decimal(10,2) DEFAULT NULL,
  `SIZE_HEIGHT` decimal(10,2) DEFAULT NULL,
  `PRODUCT_REQUEST` varchar(2000) DEFAULT NULL,
  `FACTORY_NAME` varchar(200) DEFAULT NULL,
  `PRICE` decimal(10,2) DEFAULT NULL,
  `AMOUNT` decimal(10,2) DEFAULT NULL,
  `CUNIT` varchar(10) DEFAULT NULL,
  `BOX_NUM` int(11) DEFAULT NULL,
  `EX_PRICE` decimal(10,2) DEFAULT NULL,
  `EX_UNIT` varchar(10) DEFAULT NULL,
  `NO_TAX` decimal(10,2) DEFAULT NULL,
  `TAX` decimal(10,2) DEFAULT NULL,
  `COST_PRICE` decimal(10,2) DEFAULT NULL,
  `COST_TAX` decimal(10,2) DEFAULT NULL,
  `ACCESSORIES` bit(1) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  PRIMARY KEY (`EXT_CPRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for factory_c
-- ----------------------------
DROP TABLE IF EXISTS `factory_c`;
CREATE TABLE `factory_c` (
  `FACTORY_PRODUCT_ID` varchar(90) NOT NULL,
  `FULL_NAME` varchar(200) DEFAULT NULL COMMENT '全称',
  `FACTORY_NAME` varchar(50) DEFAULT NULL,
  `CONTRACTOR` varchar(30) DEFAULT NULL,
  `PHONE` varchar(20) DEFAULT NULL,
  `MOBILE` varchar(20) DEFAULT NULL,
  `FAX` varchar(20) DEFAULT NULL,
  `CNOTE` text,
  `INSPECTOR` varchar(30) DEFAULT NULL,
  `CTYPE` varchar(40) DEFAULT NULL,
  `STATE` char(1) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(40) DEFAULT NULL,
  `CREATE_DEPT` varchar(40) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`FACTORY_PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fast_menu_b
-- ----------------------------
DROP TABLE IF EXISTS `fast_menu_b`;
CREATE TABLE `fast_menu_b` (
  `ID` varchar(120) NOT NULL,
  `NAME` varchar(90) DEFAULT NULL,
  `CNNAME` varchar(90) DEFAULT NULL,
  `CURL` varchar(450) DEFAULT NULL,
  `CLICK_NUM` double DEFAULT NULL,
  `BELONG_USER` varchar(120) DEFAULT NULL,
  `CTYPE` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for jk_privilege
-- ----------------------------
DROP TABLE IF EXISTS `jk_privilege`;
CREATE TABLE `jk_privilege` (
  `pid` varchar(100) NOT NULL,
  `privilege_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jk_role
-- ----------------------------
DROP TABLE IF EXISTS `jk_role`;
CREATE TABLE `jk_role` (
  `rid` varchar(100) CHARACTER SET latin1 NOT NULL,
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色描述 example:teacher',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述 example:教师',
  `available` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for jk_user
-- ----------------------------
DROP TABLE IF EXISTS `jk_user`;
CREATE TABLE `jk_user` (
  `uid` varchar(100) CHARACTER SET latin1 NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `username` varchar(50) NOT NULL COMMENT '用户登录名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `organizationid` varchar(1000) DEFAULT NULL COMMENT '公司',
  `salt` varchar(255) DEFAULT NULL COMMENT '盐',
  `lock_User` tinyint(4) DEFAULT NULL COMMENT '是否锁定',
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for privilege_role
-- ----------------------------
DROP TABLE IF EXISTS `privilege_role`;
CREATE TABLE `privilege_role` (
  `rid` varchar(100) DEFAULT NULL COMMENT '关联 jk_role table',
  `pid` varchar(100) DEFAULT NULL COMMENT '关联 jk_privilege',
  `id` int(25) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '关联 jk_role表',
  `uid` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '关联 jk_user表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS=1;