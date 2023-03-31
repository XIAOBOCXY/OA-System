/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2022-06-20 21:33:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_baoxiao`
-- ----------------------------
DROP TABLE IF EXISTS `t_baoxiao`;
CREATE TABLE `t_baoxiao` (
  `baoxiao_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报销序号',
  `baoxiao_no` varchar(255) DEFAULT NULL COMMENT '报销编号',
  `baoxiao_user_id` varchar(255) DEFAULT NULL COMMENT '报销申请人',
  `baoxiao_type` int(11) DEFAULT NULL COMMENT '报销类型',
  `baoxiao_test` varchar(255) DEFAULT NULL COMMENT '报销摘要',
  `baoxiao_money` int(11) DEFAULT NULL COMMENT '报销金额',
  `baoxiao_create_time` date DEFAULT NULL COMMENT '报销申请时间',
  `baoxiao_status` int(11) DEFAULT NULL COMMENT '报销申请状态',
  PRIMARY KEY (`baoxiao_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='报销信息表';

-- ----------------------------
-- Records of t_baoxiao
-- ----------------------------
INSERT INTO `t_baoxiao` VALUES ('1', 'bno5', '2', '2', 'aa', '40', '2022-06-18', '2');
INSERT INTO `t_baoxiao` VALUES ('2', 'bno2', '3', '3', '11', '40', '2022-06-19', '1');

-- ----------------------------
-- Table structure for `t_dept`
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门序号，主键，自增',
  `dept_no` varchar(50) NOT NULL COMMENT '部门编号，唯一',
  `dept_name` varchar(50) NOT NULL COMMENT '部门名称',
  `dept_pid` int(11) DEFAULT NULL COMMENT '部门父编号',
  `dept_user` varchar(50) DEFAULT NULL COMMENT '负责人名称',
  `dept_address` varchar(100) DEFAULT NULL COMMENT '部门地址',
  PRIMARY KEY (`dept_id`) USING BTREE,
  UNIQUE KEY `dept_no` (`dept_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='部门信息表';

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', 'dept001', '总公司', '0', '李总', '辽宁大连');
INSERT INTO `t_dept` VALUES ('2', 'dept002', '财务部', '1', '李磊', '102室');
INSERT INTO `t_dept` VALUES ('3', 'dept003', '教学部', '1', '韩飞', '103室');
INSERT INTO `t_dept` VALUES ('4', 'dept004', '后勤部', '1', '关羽', '104室');
INSERT INTO `t_dept` VALUES ('5', 'dept005', '教质部', '1', '张飞', '105室');

-- ----------------------------
-- Table structure for `t_holiday`
-- ----------------------------
DROP TABLE IF EXISTS `t_holiday`;
CREATE TABLE `t_holiday` (
  `holiday_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `holiday_no` varchar(10) DEFAULT NULL COMMENT '请假条编号',
  `holiday_user_id` int(11) DEFAULT NULL COMMENT '申请人Id',
  `holiday_type_id` int(11) DEFAULT NULL COMMENT '请假的类型',
  `holiday_bz` varchar(500) DEFAULT NULL COMMENT '请假理由',
  `holiday_start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `holiday_end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `holiday_holiday_status` int(20) DEFAULT NULL COMMENT '请假条的状态，1：草稿2：提交',
  `holiday_shenpi_user_id` varchar(11) DEFAULT NULL COMMENT '审批人Id',
  `holiday_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `holiday_update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`holiday_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='请假信息表';

-- ----------------------------
-- Records of t_holiday
-- ----------------------------
INSERT INTO `t_holiday` VALUES ('1', 'no1', '3', '6', '33', '2022-06-09 16:00:00', '2022-06-19 16:00:00', '2', '2', '2022-06-20 16:00:00', '2022-06-24 16:00:00');
INSERT INTO `t_holiday` VALUES ('2', 'no2', '4', '3', '44', '2022-06-18 16:00:00', '2022-06-24 16:00:00', '1', '2', '2022-06-18 16:00:00', '2022-06-18 16:00:00');
INSERT INTO `t_holiday` VALUES ('3', 'no3', '2', '7', '11', '2022-05-19 16:00:00', '2022-05-24 16:00:00', '1', '2', '2022-05-24 16:00:00', '2022-05-24 16:00:00');
INSERT INTO `t_holiday` VALUES ('4', 'no4', '3', '1', '455', '2022-05-19 16:00:00', '2022-05-25 16:00:00', '1', null, '2022-06-18 23:24:20', '2022-06-18 23:24:20');
INSERT INTO `t_holiday` VALUES ('5', 'no5', '3', '4', '55', '2022-05-19 16:00:00', '2022-05-25 16:00:00', '1', null, '2022-06-18 23:28:01', '2022-06-18 23:28:01');
INSERT INTO `t_holiday` VALUES ('6', 'NO6', '4', '4', '66', '2022-05-19 16:00:00', '2022-05-25 16:00:00', '1', '0', '2022-06-18 16:00:00', '2022-06-18 16:00:00');

-- ----------------------------
-- Table structure for `t_login`
-- ----------------------------
DROP TABLE IF EXISTS `t_login`;
CREATE TABLE `t_login` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `login_account` varchar(20) DEFAULT NULL COMMENT '登录名唯一',
  `login_pwd` char(32) DEFAULT NULL COMMENT '密码',
  `login_salt` char(10) DEFAULT NULL COMMENT '盐',
  `login_index` int(11) DEFAULT NULL COMMENT '加密索引',
  `login_status` int(11) DEFAULT NULL COMMENT '状态，0：正常，1：禁用',
  `login_error` int(11) DEFAULT NULL COMMENT '错误次数',
  `login_user_id` int(11) DEFAULT NULL COMMENT '用户详细信息的Id',
  `login_role_id` int(11) DEFAULT NULL COMMENT '角色Id，默认1，普通用户',
  `login_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户登录信息表';

-- ----------------------------
-- Records of t_login
-- ----------------------------
INSERT INTO `t_login` VALUES ('1', 'hello', '9D73DF8ED7D0991497593E362C5F4A7C', 'DcaRpkXGLp', '8', '1', '1', '2', '1', '2022-05-15 16:00:00');
INSERT INTO `t_login` VALUES ('2', 'zhangsan', '5F781C20347E78C98A1EA1F15DB471F1', 'DcaRpkXGLp', '8', '0', '0', '2', '1', '2022-05-14 15:35:55');
INSERT INTO `t_login` VALUES ('3', 'lisi', '9D73DF8ED7D0991497593E362C5F4A7C', 'DcaRpkXGLp', '8', '0', '0', '3', '2', '2022-05-21 10:16:36');
INSERT INTO `t_login` VALUES ('4', 'zhangwu', '5F781C20347E78C98A1EA1F15DB471F1', 'DcaRpkXGLp', '8', '0', '0', '4', '3', '2022-05-21 10:17:10');
INSERT INTO `t_login` VALUES ('5', 'liwu', '5F781C20347E78C98A1EA1F15DB471F1', 'DcaRpkXGLp', '8', '0', '0', '5', '4', '2022-05-21 10:17:47');
INSERT INTO `t_login` VALUES ('6', 'admin', 'E801B5CA9D07015213B73B8BE64D0B8B', 'OqGNgvUaCq', '5', '0', '0', '6', '1', '2022-06-14 14:46:52');
INSERT INTO `t_login` VALUES ('7', 'stu', '593C9B4A9390551D53E5CACF28EBD638', 'nEIHpgXTax', '0', '0', '0', '7', '2', '2022-06-15 09:01:54');
INSERT INTO `t_login` VALUES ('8', 'No111112', '593C9B4A9390551D53E5CACF28EBD638', 'VjmPdhNTcG', '0', '0', '0', '8', '3', '2022-06-15 10:43:33');
INSERT INTO `t_login` VALUES ('9', 'No111113', '593C9B4A9390551D53E5CACF28EBD638', 'UTvEtpSCGD', '0', '0', '0', '9', '3', '2022-06-15 11:29:49');

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `menu_name` varchar(20) DEFAULT NULL COMMENT '菜单名称，唯一',
  `menu_href_url` varchar(100) DEFAULT NULL COMMENT '对应url',
  `menu_parent_id` int(11) DEFAULT NULL COMMENT '上一级菜单',
  `menu_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单信息表';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '人事管理', '#', '0', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('2', '财务管理', '#', '0', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('3', '系统管理', '#', '0', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('4', '部门管理', '/dept/getall', '1', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('5', '员工管理', '/login/getall', '1', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('6', '请假管理', '/holiday/getall', '1', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('7', '报销管理', '/baoxiao/getall', '2', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('8', '账户管理', '/login/getInfo', '3', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('9', '角色管理', '/role/getall', '3', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('10', '权限管理', '/permissions/getall', '3', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('11', '密码重置', '/login/passwordModify', '3', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('12', '系统退出', '/login/exit', '3', '2022-05-14 17:19:21');
INSERT INTO `t_menu` VALUES ('13', '添加部门', '/dept/add', '4', '2022-06-13 10:42:00');
INSERT INTO `t_menu` VALUES ('14', '获得部门', '/dept/getDept', '4', '2022-06-13 10:43:07');
INSERT INTO `t_menu` VALUES ('15', '修改部门', '/dept/modifyDept', '4', '2022-06-13 10:43:40');
INSERT INTO `t_menu` VALUES ('16', '删除部门', '/dept/delDept', '4', '2022-06-13 10:44:11');
INSERT INTO `t_menu` VALUES ('17', '添加请假', '/holiday/add', '4', '2022-06-18 22:31:21');
INSERT INTO `t_menu` VALUES ('18', '获得请假', '/holiday/getHoliday', '4', '2022-06-18 22:32:11');
INSERT INTO `t_menu` VALUES ('19', '修改请假', '/holiday/modifyHoliday', '4', '2022-06-18 22:32:49');
INSERT INTO `t_menu` VALUES ('20', '删除请假', '/holiday/delHoliday', '4', '2022-06-18 22:33:26');

-- ----------------------------
-- Table structure for `t_permissions`
-- ----------------------------
DROP TABLE IF EXISTS `t_permissions`;
CREATE TABLE `t_permissions` (
  `permissions_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `permissions_role_id` int(11) DEFAULT NULL COMMENT '角色Id',
  `permissions_menu_id` int(11) DEFAULT NULL COMMENT '菜单Id',
  `permissions_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`permissions_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='权限信息表';

-- ----------------------------
-- Records of t_permissions
-- ----------------------------
INSERT INTO `t_permissions` VALUES ('1', '1', '1', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('2', '1', '2', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('3', '1', '3', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('4', '1', '4', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('5', '1', '5', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('6', '1', '6', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('7', '1', '7', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('8', '1', '8', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('9', '1', '9', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('10', '1', '10', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('11', '1', '11', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('12', '1', '12', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('13', '2', '1', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('14', '2', '2', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('15', '2', '3', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('16', '2', '5', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('17', '2', '6', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('18', '2', '8', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('19', '2', '11', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('20', '2', '12', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('21', '3', '1', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('22', '3', '2', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('23', '3', '3', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('24', '3', '4', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('25', '3', '5', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('26', '3', '6', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('27', '3', '7', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('28', '3', '8', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('29', '3', '11', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('30', '3', '12', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('31', '4', '1', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('32', '4', '2', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('33', '4', '3', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('34', '4', '4', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('35', '4', '5', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('36', '4', '6', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('37', '4', '7', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('38', '4', '8', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('39', '4', '9', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('40', '4', '10', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('41', '4', '11', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('42', '4', '12', '2022-05-14 17:20:35');
INSERT INTO `t_permissions` VALUES ('43', '1', '13', '2022-06-13 10:45:40');
INSERT INTO `t_permissions` VALUES ('44', '1', '14', '2022-06-13 10:45:50');
INSERT INTO `t_permissions` VALUES ('45', '1', '15', '2022-06-13 10:46:07');
INSERT INTO `t_permissions` VALUES ('46', '1', '16', '2022-06-13 10:46:17');
INSERT INTO `t_permissions` VALUES ('47', '2', '4', '2022-06-15 09:37:05');
INSERT INTO `t_permissions` VALUES ('48', '2', '7', '2022-06-15 09:37:20');
INSERT INTO `t_permissions` VALUES ('49', '2', '9', '2022-06-15 09:38:15');
INSERT INTO `t_permissions` VALUES ('50', '2', '10', '2022-06-15 09:38:18');
INSERT INTO `t_permissions` VALUES ('51', '2', '13', '2022-06-15 09:38:20');
INSERT INTO `t_permissions` VALUES ('52', '2', '14', '2022-06-15 09:38:21');
INSERT INTO `t_permissions` VALUES ('53', '2', '15', '2022-06-15 09:38:24');
INSERT INTO `t_permissions` VALUES ('54', '2', '16', '2022-06-15 09:38:27');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名，唯一',
  `role_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色信息表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', '2022-05-14 17:16:52');
INSERT INTO `t_role` VALUES ('2', '学生', '2022-05-14 17:17:04');
INSERT INTO `t_role` VALUES ('3', '员工', '2022-05-14 17:17:18');
INSERT INTO `t_role` VALUES ('4', '人事专员', '2022-05-14 17:17:35');

-- ----------------------------
-- Table structure for `t_sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_config`;
CREATE TABLE `t_sys_config` (
  `config_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `config_type` varchar(20) DEFAULT NULL COMMENT '配置类型（请假，报销关键字）',
  `config_key` varchar(20) DEFAULT NULL COMMENT '该配置项的key值(用于请假，还是报销)',
  `config_page_value` varchar(20) DEFAULT NULL COMMENT '页面显示值（例如，丧假是带薪的，如果是直系亲属5天，旁系亲属2天，）',
  `config_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='配置信息表';

-- ----------------------------
-- Records of t_sys_config
-- ----------------------------
INSERT INTO `t_sys_config` VALUES ('1', '事假', '假期', '1', '2022-05-21 14:04:25');
INSERT INTO `t_sys_config` VALUES ('2', '婚假', '假期', '14', '2022-05-21 14:04:52');
INSERT INTO `t_sys_config` VALUES ('3', '病假', '假期', '1', '2022-05-21 14:05:16');
INSERT INTO `t_sys_config` VALUES ('4', '产假', '假期', '120', '2022-05-21 14:05:42');
INSERT INTO `t_sys_config` VALUES ('5', '丧假', '假期', '3', '2022-05-21 14:06:12');
INSERT INTO `t_sys_config` VALUES ('6', '出差', '报销', '80', '2022-05-21 14:06:56');
INSERT INTO `t_sys_config` VALUES ('7', '住宿', '报销', '200', '2022-05-21 14:07:27');

-- ----------------------------
-- Table structure for `t_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `user_info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_info_no` varchar(10) DEFAULT NULL COMMENT '用户编号，员工号',
  `user_name` varchar(80) DEFAULT NULL COMMENT '姓名',
  `user_dept_id` int(11) DEFAULT NULL COMMENT '所在部门',
  `user_info_sex` char(1) DEFAULT NULL COMMENT '性别',
  `user_info_education` varchar(10) DEFAULT NULL COMMENT '学历',
  `user_info_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `user_info_phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `user_info_entry_time` datetime DEFAULT NULL COMMENT '入职时间',
  `user_info_create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_info_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='员工信息表';

-- ----------------------------
-- Records of t_user_info
-- ----------------------------
INSERT INTO `t_user_info` VALUES ('1', 'No111111', '张一', '3', '女', '本科', '2600011111@qq.com', '11111111111', '2022-06-24 16:00:00', '2022-06-15 10:43:33');
INSERT INTO `t_user_info` VALUES ('2', 'No222222', '陈哈哈', '2', '男', '本科', 'lisi@qq.com', '13733333333', '2022-05-21 10:20:30', '2022-05-21 10:20:33');
INSERT INTO `t_user_info` VALUES ('3', 'No333333', '张三丰', '3', '男', '本科', 'zhagnsanfeng@163.com', '13711111111', '2022-05-14 15:35:55', '2022-05-14 15:35:55');
INSERT INTO `t_user_info` VALUES ('4', 'No444444', '张四', '3', '男', '研究生', 'zhangwu#163,com', '13722222222', '2022-05-21 10:18:59', '2022-05-21 10:19:03');
INSERT INTO `t_user_info` VALUES ('5', 'No555555', '李武', '3', '男', '博士生', 'liwu@yahoo.com', '13744444444', '2022-05-21 10:21:24', '2022-05-21 10:21:27');
INSERT INTO `t_user_info` VALUES ('6', 'No666666', '张四丰', '4', '女', '本科', '2600011112@qq.com', '11111111112', '2022-06-14 16:00:00', '2022-06-15 11:29:49');
