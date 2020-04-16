/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : ssm_yb_test

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2020-03-25 15:56:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for businessaudit_test
-- ----------------------------
DROP TABLE IF EXISTS `businessaudit_test`;
CREATE TABLE `businessaudit_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hospital_level` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `disease` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `illegalclass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `startdate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enddate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sicode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `accept` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enable` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of businessaudit_test
-- ----------------------------
INSERT INTO `businessaudit_test` VALUES ('1', '铜川市妇幼保健院', '', '', '', '2018-01-01', '2020-03-15', '000000012091293', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `businessaudit_test` VALUES ('2', null, '三级', null, null, '2018-01-01', '2020-03-15', '000000012091293', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `businessaudit_test` VALUES ('3', null, null, '高血压3级', null, '2018-01-01', '2020-03-15', '000000012091293', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `businessaudit_test` VALUES ('4', null, null, null, '疑似违规', '2018-01-01', '2020-03-15', '000000012091293', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `businessaudit_test` VALUES ('5', null, null, null, null, '2018-01-01', '2020-03-15', '000000012091293', 'y', '基于UI的自动化处理', 'n');
INSERT INTO `businessaudit_test` VALUES ('6', null, null, null, null, '2018-01-01', '2020-03-15', '000000012091293', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `businessaudit_test` VALUES ('7', null, null, null, null, '2018-01-01', '2020-03-15', '', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `businessaudit_test` VALUES ('8', null, null, null, null, '2018-01-01', '2020-03-15', '', 'n', '基于UI的自动化处理', 'y');
INSERT INTO `businessaudit_test` VALUES ('9', null, null, null, null, '2018-01-01', '2020-03-15', '000000012143444', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `businessaudit_test` VALUES ('10', null, null, null, null, '2018-01-01', '2020-03-15', '000000012065775', 'y', '基于UI的自动化处理', 'y');

-- ----------------------------
-- Table structure for conclusionaudit_test
-- ----------------------------
DROP TABLE IF EXISTS `conclusionaudit_test`;
CREATE TABLE `conclusionaudit_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hospital_level` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `disease` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `illegalclass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `startdate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enddate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `illegalresult` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sicode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enable` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of conclusionaudit_test
-- ----------------------------
INSERT INTO `conclusionaudit_test` VALUES ('1', '铜川市人民医院', '', '', '', '2018-01-01', '2020-03-15', '', '', 'y');
INSERT INTO `conclusionaudit_test` VALUES ('2', null, '三级', null, null, null, '2020-03-15', '', '', 'y');
INSERT INTO `conclusionaudit_test` VALUES ('3', null, null, '慢性胃炎', null, null, '2020-03-15', '', '', 'y');
INSERT INTO `conclusionaudit_test` VALUES ('4', null, null, null, '违规', null, '2020-03-15', '', '', 'y');
INSERT INTO `conclusionaudit_test` VALUES ('5', null, null, null, '疑似违规', null, '2020-03-15', '', '', 'y');
INSERT INTO `conclusionaudit_test` VALUES ('6', null, null, null, null, null, '2020-03-15', '违规', '', 'y');
INSERT INTO `conclusionaudit_test` VALUES ('7', null, null, null, null, null, '2020-03-15', '不违规', '', 'y');
INSERT INTO `conclusionaudit_test` VALUES ('8', null, null, null, null, null, '2020-03-15', '', '', 'y');
INSERT INTO `conclusionaudit_test` VALUES ('9', null, null, null, null, null, '2020-03-15', '', '000000012143444', 'y');
INSERT INTO `conclusionaudit_test` VALUES ('10', null, null, null, null, null, '2020-03-15', '', '000000012065775', 'y');

-- ----------------------------
-- Table structure for expertreview_test
-- ----------------------------
DROP TABLE IF EXISTS `expertreview_test`;
CREATE TABLE `expertreview_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hospital_level` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `disease` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `illegalclass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `startdate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enddate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sicode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `accept` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enable` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of expertreview_test
-- ----------------------------
INSERT INTO `expertreview_test` VALUES ('1', '铜川市妇幼保健院', '', '', '', '2018-01-01', '2020-03-15', '000000012171213', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `expertreview_test` VALUES ('2', null, '三级', null, null, '2018-01-01', '2020-03-15', '000000012207889', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `expertreview_test` VALUES ('3', null, null, '高血压3级', null, '2018-01-01', '2020-03-15', '', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `expertreview_test` VALUES ('4', null, null, null, '疑似违规', '2018-01-01', '2020-03-15', '000000012157594', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `expertreview_test` VALUES ('5', null, null, null, null, '2018-01-01', '2020-03-15', '', 'n', '基于UI的自动化处理', 'n');
INSERT INTO `expertreview_test` VALUES ('6', null, null, null, null, '2018-01-01', '2020-03-15', '000000012207889', 'n', '基于UI的自动化处理', 'y');
INSERT INTO `expertreview_test` VALUES ('7', null, null, null, null, '2018-01-01', '2020-03-15', '', 'n', '基于UI的自动化处理', 'y');
INSERT INTO `expertreview_test` VALUES ('8', null, null, null, null, '2018-01-01', '2020-03-15', '', 'y', '基于UI的自动化处理', 'y');
INSERT INTO `expertreview_test` VALUES ('9', null, null, null, null, '2018-01-01', '2020-03-15', '', 'n', '基于UI的自动化处理', 'n');
INSERT INTO `expertreview_test` VALUES ('10', null, null, null, null, '2018-01-01', '2020-03-15', '000000012065775', 'y', '基于UI的自动化处理', 'n');

-- ----------------------------
-- Table structure for hospitaldoubtfeedback_test
-- ----------------------------
DROP TABLE IF EXISTS `hospitaldoubtfeedback_test`;
CREATE TABLE `hospitaldoubtfeedback_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `disease` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `startdate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enddate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sicode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `accpet` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `filepath` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enable` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of hospitaldoubtfeedback_test
-- ----------------------------
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('1', '', '2018-01-01', '2019-03-15', '000000012171213', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('2', null, '2018-01-01', '2019-03-15', '000000012207889', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('3', '冠状动脉粥样硬化性心脏病', '2018-01-01', '2019-03-15', '', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('4', '冠状动脉粥样硬化性心脏病', '2018-01-01', '2019-03-15', '', 'y', '我是基于UI自动化自动处理的', null, 'y');
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('5', '冠状动脉粥样硬化性心脏病', '2018-01-01', '2019-03-15', '000000012171142', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('6', '冠状动脉粥样硬化性心脏病', '2018-01-01', '2019-03-15', '000000012091293', 'y', '我是基于UI自动化自动处理的', null, 'y');
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('7', '冠状动脉粥样硬化性心脏病', '2018-01-01', '2019-03-15', '', 'y', '我是基于UI自动化自动处理的', null, 'y');
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('8', '冠状动脉粥样硬化性心脏病', '2018-01-01', '2019-03-15', '000000012097945', 'y', '我是基于UI自动化自动处理的', null, 'y');
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('9', '冠状动脉粥样硬化性心脏病', '2018-01-01', '2019-03-15', '000000012143444', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitaldoubtfeedback_test` VALUES ('10', '冠状动脉粥样硬化性心脏病', '2018-01-01', '2019-03-15', '000000012065775', 'y', '我是基于UI自动化自动处理的', null, 'y');

-- ----------------------------
-- Table structure for hospitalfeedback_test
-- ----------------------------
DROP TABLE IF EXISTS `hospitalfeedback_test`;
CREATE TABLE `hospitalfeedback_test` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `disease` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `startdate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enddate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sicode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `accept` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `filepath` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enable` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of hospitalfeedback_test
-- ----------------------------
INSERT INTO `hospitalfeedback_test` VALUES ('1', '', '2019-01-01', '2019-05-30', '', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitalfeedback_test` VALUES ('2', '', '2019-01-01', '2019-05-30', '', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitalfeedback_test` VALUES ('3', '原发性高血压', '2019-01-01', '2019-05-30', '', 'n', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitalfeedback_test` VALUES ('4', '', '2019-01-01', '2019-05-30', '', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitalfeedback_test` VALUES ('5', '', '2019-01-01', '2019-05-30', '', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitalfeedback_test` VALUES ('6', '', '2019-01-01', '2019-05-30', '201905071530110009-100003', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitalfeedback_test` VALUES ('7', '', '2019-01-01', '2019-05-30', '', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitalfeedback_test` VALUES ('8', '', '2019-01-01', '2019-05-30', '', 'n', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitalfeedback_test` VALUES ('9', '', '2019-01-01', '2019-05-30', '', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');
INSERT INTO `hospitalfeedback_test` VALUES ('10', '', '2019-01-01', '2019-05-30', '', 'y', '我是基于UI自动化自动处理的', 'C:\\hsnet.log', 'y');

-- ----------------------------
-- Table structure for login_test
-- ----------------------------
DROP TABLE IF EXISTS `login_test`;
CREATE TABLE `login_test` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `loginId` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of login_test
-- ----------------------------
INSERT INTO `login_test` VALUES ('1', 'ssm', '83881021');
INSERT INTO `login_test` VALUES ('2', '1001', '666666');

-- ----------------------------
-- Table structure for querydoubtful_test
-- ----------------------------
DROP TABLE IF EXISTS `querydoubtful_test`;
CREATE TABLE `querydoubtful_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hospital_level` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `disease` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `handleState` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `startdate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enddate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ruleNum` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sicode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `illegalclass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `insuredname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enable` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of querydoubtful_test
-- ----------------------------
INSERT INTO `querydoubtful_test` VALUES ('1', null, null, null, null, '2018-01-01', '2021-01-01', null, '000000012171213', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('2', null, null, null, null, null, null, null, '000000012207889', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('3', null, null, null, null, null, null, null, '000000012246716', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('4', null, null, null, null, null, null, null, '000000012157594', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('5', null, null, null, null, null, null, null, '000000012171142', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('6', null, null, null, null, null, null, null, '000000012091293', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('7', null, null, null, null, null, null, null, '000000012183672', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('8', null, null, null, null, null, null, null, '000000012097945', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('9', null, null, null, null, null, null, null, '000000012143444', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('10', null, null, null, null, null, null, null, '000000012065775', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('11', null, null, null, null, null, null, null, '000000012132469', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('12', null, null, null, null, null, null, null, '000000012087360', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('13', null, null, null, null, null, null, null, '000000012101501', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('14', null, null, null, null, null, null, null, '000000012073227', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('15', null, null, null, null, null, null, null, '000000012116311', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('16', null, null, null, null, null, null, null, '000000012074062', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('17', null, null, null, null, null, null, null, '000000012073548', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('18', null, null, null, null, null, null, null, '000000012044125', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('19', null, null, null, null, null, null, null, '000000012041341', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('20', null, null, null, null, null, null, null, '000000011992928', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('21', null, null, null, null, null, null, null, '000000011972853', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('22', null, null, null, null, null, null, null, '000000011950042', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('23', null, null, null, null, null, null, null, '000000012031381', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('24', null, null, null, null, null, null, null, '000000011975154', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('25', null, null, null, null, null, null, null, '000000012020140', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('26', null, null, null, null, null, null, null, '000000011978698', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('27', null, null, null, null, null, null, null, '000000011911856', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('28', null, null, null, null, null, null, null, '000000012217524', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('29', null, null, null, null, null, null, null, '000000012150928', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('30', null, null, null, null, null, null, null, '000000012152394', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('31', null, null, null, null, null, null, null, '000000012085362', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('32', null, null, null, null, null, null, null, '000000012123998', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('33', null, null, null, null, null, null, null, '000000012043869', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('34', null, null, null, null, null, null, null, '000000012097360', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('35', null, null, null, null, null, null, null, '000000011976194', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('36', null, null, null, null, null, null, null, '000000011987883', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('37', null, null, null, null, null, null, null, '000000012077145', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('38', null, null, null, null, null, null, null, '000000011966477', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('39', null, null, null, null, null, null, null, '000000011928771', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('40', null, null, null, null, null, null, null, '000000011917010', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('41', null, null, null, null, null, null, null, '000000011965125', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('42', null, null, null, null, null, null, null, '000000011979629', null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('43', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `querydoubtful_test` VALUES ('44', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for reviewfirst_test
-- ----------------------------
DROP TABLE IF EXISTS `reviewfirst_test`;
CREATE TABLE `reviewfirst_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hospital_level` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `disease` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `startdate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enddate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `illegalClass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `siCode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nextstate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enable` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of reviewfirst_test
-- ----------------------------
INSERT INTO `reviewfirst_test` VALUES ('1', '铜川市妇幼保健院', '', '', '2019-01-01', '2019-05-30', '', '', '医院疑似违规病例反馈', '基于UI的自动处理', 'y');
INSERT INTO `reviewfirst_test` VALUES ('2', '', '三级', '', '2019-01-01', '2019-05-30', '', '', '结案', '基于UI的自动处理', 'y');
INSERT INTO `reviewfirst_test` VALUES ('3', '', '', '原发性高血压', '2019-01-01', '2019-05-30', '', '', '结案', '基于UI的自动处理', 'y');
INSERT INTO `reviewfirst_test` VALUES ('4', '', '', '', '2019-01-01', '2019-05-30', '', '', '医院疑似违规病例反馈', '基于UI的自动处理', 'y');
INSERT INTO `reviewfirst_test` VALUES ('5', '', '', '', '2019-01-01', '2019-05-30', '违规', '', '结案', '基于UI的自动处理', 'y');
INSERT INTO `reviewfirst_test` VALUES ('6', '', '', '', '2019-01-01', '2019-05-30', '', '201905071530110009-100003', '结案', '基于UI的自动处理', 'y');
INSERT INTO `reviewfirst_test` VALUES ('7', '', '', '', '2019-01-01', '2019-05-30', '', '', '结案', '基于UI的自动处理', 'y');
INSERT INTO `reviewfirst_test` VALUES ('8', '', '', '', '2019-01-01', '2019-05-30', '', '', '医院疑似违规病例反馈', '基于UI的自动处理', 'y');
INSERT INTO `reviewfirst_test` VALUES ('9', '', '', '', '2019-01-01', '2019-05-30', '疑似违规', '', '结案', '基于UI的自动处理', 'y');
INSERT INTO `reviewfirst_test` VALUES ('10', '', '', '', '2019-01-01', '2019-05-30', '', '', '医院疑似违规病例反馈', '基于UI的自动处理', 'y');

-- ----------------------------
-- Table structure for reviewsecond_test
-- ----------------------------
DROP TABLE IF EXISTS `reviewsecond_test`;
CREATE TABLE `reviewsecond_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `hospital_level` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `disease` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `startdate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enddate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `illegalClass` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `siCode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nextstate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `enable` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of reviewsecond_test
-- ----------------------------
INSERT INTO `reviewsecond_test` VALUES ('1', '铜川市妇幼保健院', '', '', '2018-01-01', '2020-03-15', '', '000000012171142', '结案', '基于UI的自动化处理', 'y');
INSERT INTO `reviewsecond_test` VALUES ('2', '铜川市妇幼保健院', '', null, '2018-01-01', '2020-03-15', null, '000000012091293', '结案', '基于UI的自动化处理', 'y');
INSERT INTO `reviewsecond_test` VALUES ('3', '', '三级', '', '2018-01-01', '2020-03-15', null, '', '结案', '基于UI的自动化处理', 'y');
INSERT INTO `reviewsecond_test` VALUES ('4', null, null, '脊椎病', '2018-01-01', '2020-03-15', null, '', '结案', '基于UI的自动化处理', 'y');
INSERT INTO `reviewsecond_test` VALUES ('5', null, null, null, '2018-01-01', '2020-03-15', '违规', '', '医院疑似违规病例反馈', '基于UI的自动化处理', 'y');
INSERT INTO `reviewsecond_test` VALUES ('6', null, null, null, '2018-01-01', '2020-03-15', '疑似违规', '', '医院疑似违规病例反馈', '基于UI的自动化处理', 'y');
INSERT INTO `reviewsecond_test` VALUES ('7', null, null, null, '2018-01-01', '2020-03-15', null, '', '结案', '基于UI的自动化处理', 'y');
INSERT INTO `reviewsecond_test` VALUES ('8', null, null, null, '2018-01-01', '2020-03-15', null, '', '医院疑似违规病例反馈', '基于UI的自动化处理', 'y');
INSERT INTO `reviewsecond_test` VALUES ('9', null, null, null, '2018-01-01', '2020-03-15', null, '', '医院疑似违规病例反馈', '基于UI的自动化处理', 'n');
INSERT INTO `reviewsecond_test` VALUES ('10', null, null, null, '2018-01-01', '2020-03-15', null, '000000012065775', '医院疑似违规病例反馈', '基于UI的自动化处理', 'y');
