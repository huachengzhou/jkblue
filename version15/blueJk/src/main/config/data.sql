/*
Navicat MySQL Data Transfer

Source Server         : jk
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : jk

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-03-04 18:06:17
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
-- Records of contract_c
-- ----------------------------
INSERT INTO `contract_c` VALUES ('0e2ef0e2-de8e-43a5-85d9-b859e5763a35', '杰信商贸有限公司', 'OOO-DDG-NN', '2018-03-12 16:00:00', 'Lonely', '冷温柔', '伤痕', null, '没有', 'JIXIN', '2018-03-12 16:00:00', '2', '2018-03-04 16:00:00', '没有', '1', null, null, null, null, null, 'ppv', null);
INSERT INTO `contract_c` VALUES ('257509c4-b0f3-47ae-afc5-f78dd6a31fa2', '杰信商贸有限公司', 'GDSDGD-FHSD-HSS', '2015-03-09 16:00:00', '尉缭', '文种', '樊於期', null, '那些在感情中只求付出不求回报的，往往都能如愿以偿，得不到任何回报。', '北京文英文纺织品有限公司', '2018-03-13 16:00:00', '3', '2020-03-18 16:00:00', '希望你想吃什么马上去吃，想做什么马上去做。毕竟你岁数大了，记性不好！', '2', null, null, null, null, null, 'DGFSDHFD', null);
INSERT INTO `contract_c` VALUES ('7d8e1bc8-ea3c-42f7-a490-8f7b6ca842a8', '杰信商贸有限公司', 'PB/9420UI', '2015-03-17 16:00:00', '鲁仲连', '公孙龙', '毛遂', null, '怎样优雅地表达着凉拉肚子了？”\r\n“你是无意穿堂风，偏偏孤倨引山洪。”', '德州群峰机械制造有限公司', '2018-03-06 16:00:00', '3', '2020-03-11 16:00:00', '人生中遇见的每一样东西，出场顺序真的很重要。比如抹完护手霜之后短时间内是打不开润唇膏的。', '2', null, null, null, null, null, 'DGFSDHFD', null);

-- ----------------------------
-- Table structure for contract_his_c
-- ----------------------------
DROP TABLE IF EXISTS `contract_his_c`;
CREATE TABLE `contract_his_c` (
  `CONTRACT_HIS_ID` varchar(90) NOT NULL,
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
  PRIMARY KEY (`CONTRACT_HIS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract_his_c
-- ----------------------------
INSERT INTO `contract_his_c` VALUES ('2e82aff6-9a05-4521-8676-ee12dcf873d6', '杰信商贸有限公司', 'TB/9420QH', '2015-02-09 16:00:00', 'alice', 'Lee', 'bob', '40408.50', '没有', 'SGU SDS', '2017-02-14 16:00:00', '3', '2018-02-07 16:00:00', '没有', '2', null, '1', null, null, null, 'FJFSSGDS', null);
INSERT INTO `contract_his_c` VALUES ('63394ae2-ba0a-4a8c-87dd-5677832c3402', '杰信商贸有限公司', 'PB/9420UI', '2017-12-03 16:00:00', 'Autism', 'Tearl', 'Superfici', '7684.80', '没有', 'COACH HOUSE', '2018-02-05 16:00:00', '3', '2018-02-12 16:00:00', '没有', '2', null, '1', null, null, null, 'DGFSDHFD', null);
INSERT INTO `contract_his_c` VALUES ('d3f8788e-054b-43fd-8f8b-84617a8e6fe2', '杰信商贸有限公司', 'TB/9420QH', '2018-02-04 16:00:00', 'alice', 'Lee', 'bob', '1525443.30', '没有', 'JK', '2018-02-04 16:00:00', '3', '2021-02-17 16:00:00', '没有', '2', null, '1', null, null, null, 'DGFSDHFD', null);

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
-- Records of contract_product_c
-- ----------------------------
INSERT INTO `contract_product_c` VALUES ('15256999-1f47-42f6-89a1-299236ded7f5', '0e2ef0e2-de8e-43a5-85d9-b859e5763a35', null, null, null, 'GDG-HDHD-DHD', '/ufiles/jfreeC.png', '公司产品的设计、开发及研制、生产管理等均网络化，拥有先进的cad、cam技术，同时拥有大型折弯机、龙门铣床、全自动焊接机及喷沙设备。公司严格按照iso9001国际质量认证标准，精心打造优良的品牌，jdy-100型生物秸秆打包机,fdy-200型全自动废纸打包机，mdy-400型全自动液压棉花打包机销售覆盖全国各地，主要销往全国二十多个省、市自治区、直辖市。部分产品还远销新加坡、马来西亚、印度尼西亚等国家。优质的产品，优良的服务，公道的价格赢得了广大消费者的厚爱。', null, null, null, '1/3', null, '40abff42-b1e7-43b3-89df-54b35526aca5', '成都川瑞达纸制品有限公司', '3', null, null, '33.30', '1132.20', null, '34', null, null, null, null, null, null, null, null, null, null, null, '44', 'ＨＺＭＨ', null);
INSERT INTO `contract_product_c` VALUES ('5a240e93-6f1b-45c1-8f8d-9b46a49441a4', '0e2ef0e2-de8e-43a5-85d9-b859e5763a35', null, null, null, 'RRR-HH-UUU', '/ufiles/', '没有', null, null, null, '55', null, '843b87d4-8bc9-423d-a3ca-c9521f54f976', '河滨厂', '190', null, null, '22.50', '495.00', null, '22', null, null, null, null, null, null, null, null, null, null, null, '335', 'A', null);
INSERT INTO `contract_product_c` VALUES ('b0a47a00-c31c-4e46-9778-d8972000ec8f', '0e2ef0e2-de8e-43a5-85d9-b859e5763a35', null, null, null, 'GDG-HDHD-DHD', '/ufiles/jfreeC.png', '老公那天跟我说：认识你之前老想着赚到钱了，再娶老婆，所以有几个女孩主动追我，我都不要。后来发现赚钱太难了，还是先娶老婆吧！\r\n。。。说的我TM跟多幸运似的！\r\n\r\n', null, null, null, '1/3', null, '40abff42-b1e7-43b3-89df-54b35526aca5', '成都川瑞达纸制品有限公司', '3', null, null, '33.60', '1142.40', null, '34', null, null, null, null, null, null, null, null, null, null, null, '55', 'ＨＺＭＨ', null);

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
-- Records of export_c
-- ----------------------------
INSERT INTO `export_c` VALUES ('241dd448-3c07-4da7-a07c-6c30817b2fd2', null, null, '2018-02-28 00:00:00', '2e82aff6-9a05-4521-8676-ee12dcf873d6,63394ae2-ba0a-4a8c-87dd-5677832c3402', 'TB/9420QH PB/9420UI', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null);
INSERT INTO `export_c` VALUES ('700075b6-8a3b-4909-80c7-bfb43915d79e', null, null, '2018-02-28 00:00:00', '63394ae2-ba0a-4a8c-87dd-5677832c3402', 'PB/9420UI', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null);

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
  `PACKING_UNIT` varchar(300) DEFAULT NULL COMMENT 'PCS/SETS',
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
-- Records of export_product_c
-- ----------------------------
INSERT INTO `export_product_c` VALUES ('144f43fd-22ef-4d87-ab22-72e4603dd216', null, '241dd448-3c07-4da7-a07c-6c30817b2fd2', 'a24ad5ae-1fbb-4c8b-aebb-b2a8f7b0b581', null, null, null, 'dsgdhdhd', null, null, null, 'DGGG-GHDG-HD', '33', null, null, null, null, null, null, null, null, 'ChengduTumufactory', '1224.50', null, null, '890', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('197642f7-b8d3-44eb-bd8e-be48146128fa', null, 'f534182e-2edd-4156-b494-2e2b927b8355', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('51c27bdc-b8fa-490b-9106-60329c61234a', null, '778c943d-0dd1-4179-afbb-8be2876e72a3', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('620ebfa6-d7fc-43ef-ac08-431d9d59b9d1', null, '6474da6b-9186-4d3e-b118-f5968a3104a8', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('74d5c1d4-2116-4618-a3d1-0d7c3f4da040', null, '3716292f-c7d4-4c22-8fb2-6ff25df4aa22', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('76aad9b9-07fd-4d22-989c-66c23be29bb4', null, '4a060c4f-f62b-4489-b354-f8e1d4965080', 'a24ad5ae-1fbb-4c8b-aebb-b2a8f7b0b581', null, null, null, 'SDF-HFG-SD--G', null, null, null, 'DD-YY-KK', '23', null, null, null, null, null, null, null, null, 'ChengduTumufactory', '224.60', null, null, '3', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('8467a9b2-57ed-4ada-b8b7-327a27c91720', null, '241dd448-3c07-4da7-a07c-6c30817b2fd2', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('87ffc141-22a7-4077-a366-a78f843bfabe', null, '25e6b8eb-0749-4f8c-ae6c-f798918f922d', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('98b0eddf-5265-48eb-b8bd-becfa8b504ef', null, '0e0e6390-b76c-4adf-9dda-8999fb239d31', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('99a54978-e353-443d-9828-3e27a1839054', null, '781ec66d-221f-43a2-96c8-0468b4dcb826', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('a1a49d91-a224-4732-8c3f-0b7c11f0dae8', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('ad6359a8-f825-4c95-adb6-0d59b285521b', null, '9b8162b3-ad48-4914-ab10-876bd1bc0f1b', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('b5f70508-c44c-4c61-b9d7-14f8c1d4d969', null, 'e3a84230-8ca5-4697-ac8b-c0ba4e87ffa0', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('bb292a7b-d0b7-4eb9-8421-2b2d5cb04adc', null, 'ea132951-423d-4832-8977-6ac850f21ac5', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('cc14dd5b-a9f1-425e-81ab-2906762f5440', null, '4a060c4f-f62b-4489-b354-f8e1d4965080', 'da770a18-322d-46d0-92eb-781212a5132b', null, null, null, 'GDG-HDHD-DHD', null, null, null, '北京aa工厂', '12', null, null, null, null, null, null, null, null, 'bb', '4343.65', null, null, '232', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('d83260ad-e7a9-4eed-a1da-0a5b3445da30', null, '241dd448-3c07-4da7-a07c-6c30817b2fd2', null, null, null, null, 'DFD-HFGSD', null, null, null, 'SDGSKD', '34', null, null, null, null, null, null, null, null, null, '224.70', null, null, '22', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('dc41f590-4b17-4b06-82ff-9281984047c0', null, '700075b6-8a3b-4909-80c7-bfb43915d79e', null, null, null, null, 'DFD-HFGSD', null, null, null, 'SDGSKD', '34', null, null, null, null, null, null, null, null, null, '224.70', null, null, '22', null, null, null, null, null, null, null, null);
INSERT INTO `export_product_c` VALUES ('e33e358e-9f00-4051-840a-491832558a14', null, '700075b6-8a3b-4909-80c7-bfb43915d79e', '25', null, null, null, 'SS-EER-SSF', null, null, null, 'FDG-DGHD-KHG', '2', null, null, null, null, null, null, null, null, 'b', '22.50', null, null, '344', null, null, null, null, null, null, null, null);

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
  `PACKING_UNIT` varchar(40) DEFAULT NULL,
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
-- Records of ext_cproduct_c
-- ----------------------------
INSERT INTO `ext_cproduct_c` VALUES ('284fd1d4-9263-41bb-9346-71184997953e', '40abff42-b1e7-43b3-89df-54b35526aca5', '5a240e93-6f1b-45c1-8f8d-9b46a49441a4', '1', null, 'GDG-HDHD-DHD', 'null', '没有', null, '成都川瑞达纸制品有限公司', '2', null, null, null, null, null, null, null, '没有', 'ＨＺＭＨ', '334.66', null, null, null, null, null, null, null, null, null, null, '2');
INSERT INTO `ext_cproduct_c` VALUES ('b7951165-1800-44eb-8acb-70b166c7f7bf', '40abff42-b1e7-43b3-89df-54b35526aca5', '15256999-1f47-42f6-89a1-299236ded7f5', '1', null, 'GDG-HDHD-DHD', 'null', 'Data too long for column \'PACKING_UNIT\' at row 1', null, '成都川瑞达纸制品有限公司', '2', null, null, null, null, null, null, null, 'Data too long for column \'PACKING_UNIT\' at row 1', 'ＨＺＭＨ', '334.66', null, null, null, null, null, null, null, null, null, null, '3');

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
-- Records of ext_eproduct_c
-- ----------------------------
INSERT INTO `ext_eproduct_c` VALUES ('123', null, null, null, null, '4', null, null, '2', null, null, '234.30', null, null);
INSERT INTO `ext_eproduct_c` VALUES ('1afc3adc-07b4-4001-b27d-dda2ee3de7fe', '8467a9b2-57ed-4ada-b8b7-327a27c91720', null, null, '2', 'GDG-HDHD-DHD-GGG', 'dgsd', '无', null, 'HHJ', '22.50', '45.00', '%E6%97%A0', '22');
INSERT INTO `ext_eproduct_c` VALUES ('8093831a-3eab-412d-8de2-9985edf8ab45', 'e33e358e-9f00-4051-840a-491832558a14', null, null, '2', 'GDG-HDHD-DHD-GGG', 'dgsd', '无', null, 'HHJ', '22.50', '45.00', '%E6%97%A0', '22');
INSERT INTO `ext_eproduct_c` VALUES ('981dfabe-8f61-4708-b78e-d1ee6ea7d723', '144f43fd-22ef-4d87-ab22-72e4603dd216', null, null, '1', 'RRET', 'GGG', 'NO', null, 'GGGGGGG', '34.70', '832.80', 'NO', '3');

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
  `CONTACTS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FACTORY_PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory_c
-- ----------------------------
INSERT INTO `factory_c` VALUES ('25', '牛仔裤', 'b', null, '8769679', '5687696', '77', '白领们中午四处乱窜找午饭吃，一家家小饭馆都贴着初九以后才开张。所以白领确实是社会底层，就连路边卖早点的都没开始上班。', 'bob', null, '1', '3', null, null, null, 'blake');
INSERT INTO `factory_c` VALUES ('40abff42-b1e7-43b3-89df-54b35526aca5', '杭州江南胶辊制线有限公司', 'ＨＺＭＨ', null, '5436754', '65786766', '4356754', '不得不说，中国真的越来越成熟和自信了。和2008年又是限行又是封道相比，这次办奥运一点都不扰民。\r\n我家住朝阳区，这次昌平冬奥会离得这么近，不到10公里，交通出行丝毫不受影响，真的是大国气量和高超治理。', '高渐离', null, '1', '44', null, null, '2018-03-04 04:21:11', '孙膑');
INSERT INTO `factory_c` VALUES ('843b87d4-8bc9-423d-a3ca-c9521f54f976', '玻璃A', 'A', null, '183806756865', '35754764', '343', '希望你想吃什么马上去吃，想做什么马上去做。毕竟你岁数大了，记性不好！', 'bob', null, '1', '5456', null, null, '2018-02-22 10:26:43', '阖闾');
INSERT INTO `factory_c` VALUES ('a24ad5ae-1fbb-4c8b-aebb-b2a8f7b0b581', '成都本土食品厂家', 'ChengduTumufactory', null, '95075440', '34343', '3346', '大连野生海参价格+多少钱+哪里买,大连野生海参(左右/功效)', 'Tep', null, '1', '3', null, null, '2018-02-26 08:08:09', 'blake');
INSERT INTO `factory_c` VALUES ('da770a18-322d-46d0-92eb-781212a5132b', '棉花BB', 'bb', null, '95075440', '48484', '5474', '“怎样优雅地表达着凉拉肚子了？”\r\n“你是无意穿堂风，偏偏孤倨引山洪。”', 'Ellis', null, '1', '5', null, null, '2018-02-22 10:28:07', '齐桓公');
INSERT INTO `factory_c` VALUES ('f2af67ff-cd45-430b-8a58-0beeab351df0', '鸡毛单子', 'Feather', null, '567879', '54545846', '13456', '也许鸟儿背地里都是小机器人，它们坐在电线上是为了充电。', 'Hayden', null, '1', '86', null, null, '2018-02-22 10:29:44', '郑庄公');

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
-- Records of fast_menu_b
-- ----------------------------
INSERT INTO `fast_menu_b` VALUES ('5343', 'fgdgd', 'sgdsd', '3', '3', '3', '3');

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
-- Records of jk_privilege
-- ----------------------------
INSERT INTO `jk_privilege` VALUES ('3070827e-8cc8-4cd7-a43a-0a5ac3b431d2', 'user:update', '普通用户:修改');
INSERT INTO `jk_privilege` VALUES ('517beba2-4ffe-4013-901a-ce50a9e74192', 'user:remove', '普通用户:删除');
INSERT INTO `jk_privilege` VALUES ('612d7f7e-62b7-4364-854d-ac115473275e', 'user:insert', '普通用户:添加');
INSERT INTO `jk_privilege` VALUES ('7fcb122d-a77d-4fc5-bef9-80152f4a9c5f', 'user:select', '普通用户:查看');

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
-- Records of jk_role
-- ----------------------------
INSERT INTO `jk_role` VALUES ('14a02476-9213-435f-8517-bb64837e0e32', 'admin', '管理员', '0');
INSERT INTO `jk_role` VALUES ('1b5b6967-08d8-43b9-8fff-4610aa71fbd6', 'teacher', '教师', '0');
INSERT INTO `jk_role` VALUES ('20c6705d-455f-4ecf-bc48-cb80bd3561eb', 'student', '学生', '0');
INSERT INTO `jk_role` VALUES ('83666b51-a91c-49c8-bffc-cf7450562466', 'user', '普通用户', '0');

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
-- Records of jk_user
-- ----------------------------
INSERT INTO `jk_user` VALUES ('489e41d2-4505-4922-b784-b2c93a952aca', 'd', 'sg', 'NDg5ZTQxZDItNDUwNS00OTIyLWI3ODQtYjJjOTNhOTUyYWNh', 'sdgsd', '1519375883658', '1', '2018-02-23 08:51:24');
INSERT INTO `jk_user` VALUES ('7ee8d486-571a-4d13-a6b6-e6dc23a5b333', '管理员A', 'admin', 'N2VlOGQ0ODYtNTcxYS00ZDEzLWE2YjYtZTZkYzIzYTViMzMzMTIzNDU2', '中央人事', '1518677679652', '1', '2018-02-15 06:54:40');
INSERT INTO `jk_user` VALUES ('d7314519-cbc2-4ae2-84ca-6df5adf984d0', '爱丽丝', 'alice', 'ZDczMTQ1MTktY2JjMi00YWUyLTg0Y2EtNmRmNWFkZjk4NGQwMTIzNDU2', '中国人民银行', '1518691596237', '1', '2018-02-15 10:46:36');

-- ----------------------------
-- Table structure for login_log_p
-- ----------------------------
DROP TABLE IF EXISTS `login_log_p`;
CREATE TABLE `login_log_p` (
  `LOGIN_LOG_ID` varchar(40) NOT NULL,
  `LOGIN_NAME` varchar(30) DEFAULT NULL,
  `IP_ADDRESS` varchar(20) DEFAULT NULL,
  `LOGIN_TIME` datetime DEFAULT NULL,
  `LOGIN_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LOGIN_LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_log_p
-- ----------------------------
INSERT INTO `login_log_p` VALUES ('1bd7b657-d80f-4f30-8f9b-30d91a6e575f', 'alice', '127.0.0.1', '2018-03-03 23:00:52', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('1ea4435a-8f61-4ae3-9868-b001284c0d33', 'admin', '0:0:0:0:0:0:0:1', '2018-03-03 18:54:51', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('24a4a2f3-d588-4418-898e-1caef61985f3', 'admin', '0:0:0:0:0:0:0:1', '2018-03-03 22:19:59', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('38ddeafd-6fda-4dc4-8962-9db84b5804b1', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 17:43:26', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('435352-sdsdgs-shsdgsgs', 'alice', '192.168.88.240', '2018-03-03 17:19:16', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('43e69cf3-b489-4636-a8b7-c133d8f909cd', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 17:16:59', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('4a0622ce-b64e-4142-b99c-8f11bf44c257', 'alice', '127.0.0.1', '2018-03-03 22:26:40', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('4b887644-7bf7-4053-a79a-6754079887be', 'alice', '127.0.0.1', '2018-03-03 22:45:47', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('5673c840-8cf2-48f3-a571-16605dc767d7', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 17:55:13', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('5dd672a6-4a09-46fb-9998-d11e837e5fd1', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 13:55:27', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('66b108cc-04c7-486b-a703-187a84c5963f', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 13:25:39', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('7dd0fff2-25f3-4ee7-945d-143112744884', 'admin', '0:0:0:0:0:0:0:1', '2018-03-03 20:33:43', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('7fca2d8e-a288-4ba3-ace5-753cc9f7ceb2', 'admin', '0:0:0:0:0:0:0:1', '2018-03-03 16:00:37', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('8aaafc8e-4b2e-44f4-9cef-0dfc595285ee', 'alice', '127.0.0.1', '2018-03-03 23:59:43', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('8b46e3df-3b01-41f6-b03e-046c5f14b2d5', 'admin', '0:0:0:0:0:0:0:1', '2018-03-03 19:08:16', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('8f8f8ff6-2a13-438e-b2e8-c1d41f3e5c3e', 'admin', '0:0:0:0:0:0:0:1', '2018-03-03 17:58:45', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('90e30ef3-a65d-4288-b97a-fe8663dc68fd', 'admin', '0:0:0:0:0:0:0:1', '2018-03-03 16:27:49', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('95c87f71-0e03-4bba-a341-6c90ada6907a', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 11:55:45', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('a5914c92-7c5d-4320-be8b-b76eaf25aee9', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 17:04:48', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('bbb859b2-f2ee-43d4-9879-f80983e682d3', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 17:08:49', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('c3141b10-07bd-4c1c-b037-e7421435544c', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 17:46:43', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('c31b6dfe-aa00-4d42-bd30-fdbd600a6060', 'alice', '127.0.0.1', '2018-03-03 23:05:19', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('c80438f3-efd8-4b60-87dd-e35a3028e151', 'admin', '0:0:0:0:0:0:0:1', '2018-03-03 16:24:48', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('d3c48e29-b507-4628-b64d-0bf00366c532', 'alice', '192.168.88.240', '2018-03-03 12:55:02', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('df454343jsdds-9sa8gsdgsg-shs', 'alice', '192.168.88.240', '2018-03-01 14:01:30', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('dfsd-hsg-4534-gd', 'alice', '122.4.67.8', '2018-03-03 15:59:46', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('dsgfshdfh564574-dfsd-dgsd-322', 'alice', '192.168.88.240', '2018-03-03 15:37:48', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('e46d1017-3b12-4c71-8261-948be77ecadf', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 12:13:44', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('e691f1b0-7282-420a-8495-891f4138dfb9', 'admin', '0:0:0:0:0:0:0:1', '2018-03-03 16:01:28', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('ec974bba-bd86-4302-9e9d-f9124a170e6f', 'admin', '0:0:0:0:0:0:0:1', '2018-03-04 17:50:44', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `login_log_p` VALUES ('f31e2131-37eb-4a7f-a847-062475b76b12', 'alice', '192.168.88.240', '2018-03-03 12:58:13', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('f914343f-536f-42ec-85e1-7fef158aca12', 'alice', '127.0.0.1', '2018-03-03 23:42:03', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('gaafss-hadfsf-ASDSA', 'ALICE', '192.168.88.240', '2018-03-03 00:00:01', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('kgfd65vsdggshssd', 'alice', '192.168.88.240', '2018-03-03 15:35:49', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `login_log_p` VALUES ('yyustetet-fdgfg-4-346', 'alice', '192.168.88.240', '2018-03-03 00:00:00', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');

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
  `STATE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PACKING_LIST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of packing_list_c
-- ----------------------------
INSERT INTO `packing_list_c` VALUES ('1df40cb8-93b4-4526-a27a-2ecab618adcd', 'a', 'b', 'GDSSDGSD-SSD-HS', '2018-03-12 00:00:00', 'A', 'B', '241dd448-3c07-4da7-a07c-6c30817b2fd2,700075b6-8a3b-4909-80c7-bfb43915d79e', 'TB/9420QH PB/9420UI|PB/9420UI', null, null, '2018-03-01 00:00:00', '1');

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
-- Records of privilege_role
-- ----------------------------
INSERT INTO `privilege_role` VALUES ('1b5b6967-08d8-43b9-8fff-4610aa71fbd6', '612d7f7e-62b7-4364-854d-ac115473275e', '1');
INSERT INTO `privilege_role` VALUES ('20c6705d-455f-4ecf-bc48-cb80bd3561eb', '612d7f7e-62b7-4364-854d-ac115473275e', '2');
INSERT INTO `privilege_role` VALUES ('5f1a508c-e7a6-413c-bc1b-ed01b6352846', '3070827e-8cc8-4cd7-a43a-0a5ac3b431d2', '26');
INSERT INTO `privilege_role` VALUES ('5f1a508c-e7a6-413c-bc1b-ed01b6352846', '517beba2-4ffe-4013-901a-ce50a9e74192', '27');
INSERT INTO `privilege_role` VALUES ('5f1a508c-e7a6-413c-bc1b-ed01b6352846', '612d7f7e-62b7-4364-854d-ac115473275e', '28');
INSERT INTO `privilege_role` VALUES ('5f1a508c-e7a6-413c-bc1b-ed01b6352846', '7fcb122d-a77d-4fc5-bef9-80152f4a9c5f', '29');
INSERT INTO `privilege_role` VALUES ('14a02476-9213-435f-8517-bb64837e0e32', '3070827e-8cc8-4cd7-a43a-0a5ac3b431d2', '38');
INSERT INTO `privilege_role` VALUES ('14a02476-9213-435f-8517-bb64837e0e32', '517beba2-4ffe-4013-901a-ce50a9e74192', '39');
INSERT INTO `privilege_role` VALUES ('14a02476-9213-435f-8517-bb64837e0e32', '612d7f7e-62b7-4364-854d-ac115473275e', '40');
INSERT INTO `privilege_role` VALUES ('14a02476-9213-435f-8517-bb64837e0e32', '7fcb122d-a77d-4fc5-bef9-80152f4a9c5f', '41');
INSERT INTO `privilege_role` VALUES ('83666b51-a91c-49c8-bffc-cf7450562466', '7fcb122d-a77d-4fc5-bef9-80152f4a9c5f', '46');

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
-- Records of sys_code_b
-- ----------------------------
INSERT INTO `sys_code_b` VALUES ('01', '系统代码', '-1', 'root', '0', '0', null, '1', null, '1', '0', null, '2010-03-11 09:34:38', null, '2010-03-11 09:34:38');
INSERT INTO `sys_code_b` VALUES ('0101', '人员级别', '01', '系统代码', '1', '0', '', '', '', '0', '1', '001', '2011-07-16 07:43:41', null, null);
INSERT INTO `sys_code_b` VALUES ('010102', '管理员', '0101', '人员级别', '2', '1', '', '', '', '0', '1', '001', '2011-07-16 07:44:43', null, null);
INSERT INTO `sys_code_b` VALUES ('010103', '总经理', '0101', '人员级别', '2', '1', '', '', '', '0', '2', '001', '2011-07-16 07:44:43', null, null);
INSERT INTO `sys_code_b` VALUES ('010104', '部门经理', '0101', '人员级别', '2', '1', '', '', '', '0', '3', '001', '2011-07-16 07:44:43', '001', '2011-07-16 07:44:59');
INSERT INTO `sys_code_b` VALUES ('010105', '组长', '0101', '人员级别', '2', '1', '', '', '', '0', '4', '001', '2011-07-16 07:44:43', null, null);
INSERT INTO `sys_code_b` VALUES ('010106', '员工', '0101', '人员级别', '2', '1', '', '', '', '0', '5', '001', '2011-07-16 07:44:43', null, null);
INSERT INTO `sys_code_b` VALUES ('0102', '栏目', '01', '系统代码', '1', '0', '', '', '', '0', '2', '001', '2011-08-05 15:21:43', null, null);
INSERT INTO `sys_code_b` VALUES ('010202', '新闻报道', '0102', '栏目', '2', '1', '', '', '', '0', '1', '001', '2011-08-05 15:24:17', null, null);
INSERT INTO `sys_code_b` VALUES ('010203', '通知公告', '0102', '栏目', '2', '1', '', '', '', '0', '2', '001', '2011-08-05 15:24:17', null, null);
INSERT INTO `sys_code_b` VALUES ('010204', '公司制度', '0102', '栏目', '2', '1', '', '', '', '0', '3', '001', '2011-08-05 15:24:17', null, null);
INSERT INTO `sys_code_b` VALUES ('010205', '行业报道', '0102', '栏目', '2', '1', '', '', '', '0', '4', '001', '2011-08-05 15:24:17', null, null);
INSERT INTO `sys_code_b` VALUES ('010206', '大事记', '0102', '栏目', '2', '1', '', '', '', '0', '5', '001', '2011-08-05 15:24:17', null, null);
INSERT INTO `sys_code_b` VALUES ('0103', '厂家类型', '01', '系统代码', '1', '0', '', '', '', '1', '3', '001', '2011-08-05 15:21:43', '001', '2011-10-04 08:13:04');
INSERT INTO `sys_code_b` VALUES ('010302', '玻璃', '0103', '厂家类型', '2', '1', '', '', '', '1', '1', '001', '2011-08-18 16:10:22', '001', '2011-10-04 08:14:20');
INSERT INTO `sys_code_b` VALUES ('010303', '彩盒', '0103', '厂家类型', '2', '1', '', '', '', '1', '2', '001', '2011-08-18 16:10:22', '001', '2011-10-04 08:14:20');
INSERT INTO `sys_code_b` VALUES ('010304', 'PVC', '0103', '厂家类型', '2', '1', '', '', '', '1', '3', '001', '2012-01-20 15:16:07', null, null);
INSERT INTO `sys_code_b` VALUES ('010305', '花纸', '0103', '厂家类型', '2', '1', '', '', '', '1', '4', '001', '2012-01-20 15:16:07', null, null);
INSERT INTO `sys_code_b` VALUES ('010306', '保丽龙', '0103', '厂家类型', '2', '1', '', '', '', '1', '5', '001', '2012-01-20 15:16:07', null, null);
INSERT INTO `sys_code_b` VALUES ('010307', '电镀', '0103', '厂家类型', '2', '1', '', '', '', '1', '6', '001', '2012-01-20 15:16:07', null, null);
INSERT INTO `sys_code_b` VALUES ('010308', '水龙头', '0103', '厂家类型', '2', '1', '', '', '', '1', '7', '001', '2012-01-20 15:16:07', null, null);
INSERT INTO `sys_code_b` VALUES ('010309', '蜡', '0103', '厂家类型', '2', '1', '', '', '', '1', '8', '001', '2012-11-09 11:59:26', null, null);
INSERT INTO `sys_code_b` VALUES ('0104', '附件类型', '01', '系统代码', '1', '0', '', '', '', '1', '4', '001', '2011-10-04 08:13:04', null, null);
INSERT INTO `sys_code_b` VALUES ('010402', '彩盒', '0104', '附件类型', '2', '1', '', '1', '', '1', '1', '001', '2011-10-04 08:14:10', null, null);
INSERT INTO `sys_code_b` VALUES ('010403', '花纸', '0104', '附件类型', '2', '1', '', '1', '', '1', '2', '001', '2011-10-04 08:14:10', null, null);
INSERT INTO `sys_code_b` VALUES ('010404', '保丽龙', '0104', '附件类型', '2', '1', '', '1', '', '1', '3', '001', '2011-10-04 08:14:10', null, null);
INSERT INTO `sys_code_b` VALUES ('010405', '电镀', '0104', '附件类型', '2', '1', null, '1', null, '1', '4', '001', '2011-10-04 08:14:11', null, '2011-11-26 13:08:59');
INSERT INTO `sys_code_b` VALUES ('010407', 'PVC', '0104', '附件类型', '2', '1', '', '1', '', '0', '6', '001', '2011-12-06 12:54:52', null, null);
INSERT INTO `sys_code_b` VALUES ('010408', '喷头', '0104', '附件类型', '2', '1', '', '1', '', '0', '7', '001', '2011-12-06 12:54:52', null, null);
INSERT INTO `sys_code_b` VALUES ('010409', '不锈钢勺子', '0104', '附件类型', '2', '1', null, '1', null, '0', '8', '001', '2012-04-01 14:24:24', null, '2012-04-01 14:24:24');
INSERT INTO `sys_code_b` VALUES ('a', '系统代码', '-1', 'root', '0', '0', null, '1', null, '1', '0', null, '2010-03-11 09:34:38', null, '2010-03-11 09:34:38');
INSERT INTO `sys_code_b` VALUES ('b', '人员级别', '01', '系统代码', '1', '0', '', '', '', '0', '1', '001', '2011-07-16 07:43:41', null, null);

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

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('14', '14a02476-9213-435f-8517-bb64837e0e32', '7ee8d486-571a-4d13-a6b6-e6dc23a5b333');
INSERT INTO `user_role` VALUES ('15', '83666b51-a91c-49c8-bffc-cf7450562466', 'd7314519-cbc2-4ae2-84ca-6df5adf984d0');
INSERT INTO `user_role` VALUES ('18', '83666b51-a91c-49c8-bffc-cf7450562466', '489e41d2-4505-4922-b784-b2c93a952aca');
SET FOREIGN_KEY_CHECKS=1;
