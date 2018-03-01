/*
Navicat MySQL Data Transfer

Source Server         : jk
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : jk

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-03-01 10:03:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for contract_c
-- ----------------------------
DROP TABLE IF EXISTS `contract_c`;
CREATE TABLE `contract_c` (
  `CONTRACT_ID` varchar(90) NOT NULL,
  `OFFEROR` varchar(200) DEFAULT NULL,
  `CONTRACT_NO` varchar(20) DEFAULT NULL COMMENT '合同号',
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
-- Table structure for contract_his_c
-- ----------------------------
DROP TABLE IF EXISTS `contract_his_c`;
CREATE TABLE `contract_his_c` (
  `CONTRACT_ID` varchar(40) CHARACTER SET latin1 NOT NULL,
  `OFFEROR` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `CONTRACT_NO` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `SIGNING_DATE` datetime DEFAULT NULL,
  `INPUT_BY` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `CHECK_BY` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `INSPECTOR` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `TOTAL_AMOUNT` decimal(10,2) DEFAULT NULL,
  `CREQUEST` varchar(2000) CHARACTER SET latin1 DEFAULT NULL,
  `CUSTOM_NAME` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `SHIP_TIME` datetime DEFAULT NULL,
  `IMPORT_NUM` int(11) DEFAULT NULL COMMENT '打印时标识几个星,对应说明中的内容',
  `DELIVERY_PERIOD` datetime DEFAULT NULL,
  `REMARK` varchar(600) CHARACTER SET latin1 DEFAULT NULL,
  `PRINT_STYLE` char(1) CHARACTER SET latin1 DEFAULT NULL COMMENT '宽2:一页两个货物  窄1:一页一个货物',
  `OLD_STATE` int(11) DEFAULT NULL COMMENT '归档前状态, 方便回退',
  `STATE` int(11) DEFAULT NULL COMMENT '0草稿 1已上报待报运\r\n            \r\n            归档后, 其他选择合同的地方均去除.\r\n            表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况',
  `OUT_STATE` int(11) DEFAULT NULL COMMENT '0未走货 1部分 2全部\r\n            \r\n            归档后, 其他选择合同的地方均去除.\r\n            表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况',
  `TRADE_TERMS` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `CREATE_BY` varchar(40) CHARACTER SET latin1 DEFAULT NULL,
  `CREATE_DEPT` varchar(40) CHARACTER SET latin1 DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
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
-- Table structure for export_c
-- ----------------------------
DROP TABLE IF EXISTS `export_c`;
CREATE TABLE `export_c` (
  `EXPORT_ID` varchar(40) NOT NULL COMMENT '主键',
  `PACKING_LIST_ID` varchar(40) DEFAULT NULL,
  `CONTRACT_ID` varchar(40) DEFAULT NULL COMMENT '因为分次报运，废除此字段',
  `INPUT_DATE` datetime DEFAULT NULL COMMENT 'xx时间',
  `CONTRACT_IDS` varchar(200) DEFAULT NULL COMMENT 'ID集合串\r\n            \r\n            x,y,z',
  `CUSTOMER_CONTRACT` varchar(200) DEFAULT NULL COMMENT '客户的合同号,可选择多个合同',
  `LCNO` varchar(10) DEFAULT NULL COMMENT 'L/C T/T 信用证号',
  `CONSIGNEE` varchar(100) DEFAULT NULL COMMENT '收货人及地址',
  `MARKS` varchar(1000) DEFAULT NULL COMMENT '唛头',
  `SHIPMENT_PORT` varchar(100) DEFAULT NULL COMMENT '装运港',
  `DESTINATION_PORT` varchar(100) DEFAULT NULL,
  `TRANSPORT_MODE` varchar(10) DEFAULT NULL COMMENT 'SEA/AIR 运输方式',
  `PRICE_CONDITION` varchar(10) DEFAULT NULL COMMENT 'FBO/CIF 价格条件',
  `REMARK` varchar(100) DEFAULT NULL,
  `BOX_NUM` int(11) DEFAULT NULL,
  `CNUMBER` int(11) DEFAULT NULL,
  `PACKING_UNIT` varchar(10) DEFAULT NULL COMMENT 'PCS/SETS',
  `GROSS_WEIGHT` decimal(10,2) DEFAULT NULL COMMENT '毛重',
  `NET_WEIGHT` decimal(10,2) DEFAULT NULL COMMENT '净重',
  `SIZE_LENGTH` decimal(10,2) DEFAULT NULL COMMENT '长度',
  `SIZE_WIDTH` decimal(10,2) DEFAULT NULL COMMENT '宽度',
  `SIZE_HEIGHT` decimal(10,2) DEFAULT NULL COMMENT '高度/厚度',
  `CSIZE` decimal(10,2) DEFAULT NULL COMMENT '数量',
  `AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '自动计算: 数量x单价',
  `NO_TAX` decimal(10,3) DEFAULT NULL COMMENT '收购单价',
  `TAX` decimal(10,3) DEFAULT NULL COMMENT '收购单价',
  `COST_PRICE` decimal(10,2) DEFAULT NULL COMMENT '自动计算=数量x含税/1.17标准值',
  `COST_TAX` decimal(10,3) DEFAULT NULL COMMENT '自动计算=数量x含税-收购成本金额',
  `STATE` int(255) DEFAULT NULL COMMENT '0-草稿 1-已上报 2-装箱 3-委托 4-发票 5-财务',
  `CREATE_BY` varchar(255) DEFAULT NULL COMMENT '报运人',
  `CREATE_DEPT` varchar(255) DEFAULT NULL COMMENT '报运部门',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '报运时间',
  `MEASUREMENT` decimal(10,5) DEFAULT NULL COMMENT '体积',
  PRIMARY KEY (`EXPORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for export_product_c
-- ----------------------------
DROP TABLE IF EXISTS `export_product_c`;
CREATE TABLE `export_product_c` (
  `EXPORT_PRODUCT_ID` varchar(40) NOT NULL,
  `CONTRACT_PRODUCT_ID` varchar(40) DEFAULT NULL COMMENT '标识从哪个合同货物而来',
  `EXPORT_ID` varchar(40) DEFAULT NULL,
  `FACTORY_ID` varchar(40) DEFAULT NULL,
  `CONTRACT_ID` varchar(40) DEFAULT NULL,
  `CONTRACT_NO` varchar(30) DEFAULT NULL,
  `PRODUCT_NAME` varchar(200) DEFAULT NULL,
  `PRODUCT_NO` varchar(50) DEFAULT NULL,
  `PRODUCT_IMAGE` varchar(200) DEFAULT NULL,
  `PRODUCT_DESC` varchar(600) DEFAULT NULL,
  `LOADING_RATE` varchar(30) DEFAULT NULL COMMENT 'x/y',
  `PACKING_UNIT` varchar(50) DEFAULT NULL COMMENT 'PCS/SETS',
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
  `AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '自动计算: 数量x单价',
  `CUNIT` varchar(10) DEFAULT NULL,
  `BOX_NUM` int(11) DEFAULT NULL,
  `EX_PRICE` decimal(10,2) DEFAULT NULL COMMENT 'sales confirmation 中的价格（手填）',
  `EX_UNIT` varchar(10) DEFAULT NULL COMMENT '$/￥',
  `NO_TAX` decimal(10,2) DEFAULT NULL COMMENT '空着,EXCEL手工填',
  `TAX` decimal(10,2) DEFAULT NULL COMMENT '收购单价=合同单价',
  `COST_PRICE` decimal(10,2) DEFAULT NULL COMMENT '自动计算=数量x含税/1.17标准值',
  `COST_TAX` decimal(10,2) DEFAULT NULL COMMENT '自动计算=数量x含税-收购成本金额',
  `ACCESSORIES` bit(1) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  PRIMARY KEY (`EXPORT_PRODUCT_ID`)
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
-- Table structure for ext_eproduct_c
-- ----------------------------
DROP TABLE IF EXISTS `ext_eproduct_c`;
CREATE TABLE `ext_eproduct_c` (
  `EXT_EPRODUCT_ID` varchar(40) NOT NULL,
  `EXPORT_PRODUCT_ID` varchar(40) CHARACTER SET latin1 DEFAULT NULL,
  `FACTORY_ID` varchar(40) DEFAULT NULL,
  `FACTORY_NAME` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `CTYPE` int(11) DEFAULT NULL COMMENT 'SYS_CODE=0104',
  `PRODUCT_NO` varchar(50) DEFAULT NULL,
  `PRODUCT_IMAGE` varchar(200) DEFAULT NULL,
  `PRODUCT_DESC` varchar(600) DEFAULT NULL,
  `CNUMBER` int(11) DEFAULT NULL,
  `PACKING_UNIT` varchar(10) DEFAULT NULL COMMENT 'PCS/SETS',
  `PRICE` decimal(10,2) DEFAULT NULL,
  `AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '自动计算: 数量x单价',
  `PRODUCT_REQUEST` varchar(2000) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  PRIMARY KEY (`EXT_EPRODUCT_ID`)
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
-- Table structure for packing_list_c
-- ----------------------------
DROP TABLE IF EXISTS `packing_list_c`;
CREATE TABLE `packing_list_c` (
  `PACKING_LIST_ID` varchar(40) CHARACTER SET latin1 NOT NULL,
  `SELLER` varchar(200) DEFAULT NULL,
  `BUYER` varchar(200) DEFAULT NULL,
  `INVOICE_NO` varchar(30) DEFAULT NULL COMMENT '选择',
  `INVOICE_DATE` datetime DEFAULT NULL,
  `MARKS` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `DESCRIPTIONS` varchar(200) DEFAULT NULL,
  `EXPORT_IDS` varchar(200) DEFAULT NULL COMMENT '报运ID集合',
  `EXPORT_NOS` varchar(200) DEFAULT NULL COMMENT '报运NO集合x,y|z,h',
  `CREATE_BY` varchar(40) DEFAULT NULL,
  `CREATE_DEPT` varchar(40) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`PACKING_LIST_ID`)
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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_code_b
-- ----------------------------
DROP TABLE IF EXISTS `sys_code_b`;
CREATE TABLE `sys_code_b` (
  `SYS_CODE_ID` varchar(40) NOT NULL COMMENT '数据字典ID',
  `NAME` varchar(100) DEFAULT NULL COMMENT '数据字典名称',
  `PARENT_ID` varchar(40) DEFAULT NULL,
  `PARENT_NAME` varchar(100) DEFAULT NULL,
  `LAYER_NUM` int(11) DEFAULT NULL,
  `IS_LEAF` char(1) DEFAULT NULL,
  `ICO` varchar(20) DEFAULT NULL,
  `STATE` char(1) DEFAULT NULL,
  `CNOTE` varchar(100) DEFAULT NULL,
  `QUOTE_NUM` int(11) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  `CREATED_BY` varchar(40) DEFAULT NULL,
  `CREATED_TIME` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(40) DEFAULT NULL,
  `UPDATED_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`SYS_CODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rid` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '关联 jk_role表',
  `uid` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '关联 jk_user表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS=1;
