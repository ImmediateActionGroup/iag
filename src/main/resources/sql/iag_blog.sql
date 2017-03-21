/*
Navicat MySQL Data Transfer

Source Server         : localmysql
Source Server Version : 50716
Source Host           : 127.0.0.1:3306
Source Database       : iag_blog

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-03-21 18:31:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for iag_board
-- ----------------------------
DROP TABLE IF EXISTS `iag_board`;
CREATE TABLE `iag_board` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `board_name` varchar(20) NOT NULL COMMENT '板块名字',
  `icon` varchar(30) NOT NULL COMMENT '版块图标',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `is_delete` tinyint(4) NOT NULL COMMENT '软删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_board
-- ----------------------------

-- ----------------------------
-- Table structure for iag_comments
-- ----------------------------
DROP TABLE IF EXISTS `iag_comments`;
CREATE TABLE `iag_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) NOT NULL COMMENT '回复内容',
  `publish_time` datetime NOT NULL COMMENT '回复时间',
  `praise_num` int(10) NOT NULL COMMENT '点赞数',
  `bad_num` int(10) NOT NULL COMMENT '坏数',
  `parent_id` int(11) NOT NULL COMMENT '父回复节点',
  `posts_id` int(11) NOT NULL COMMENT '帖子id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `posts_id` (`posts_id`),
  KEY `user_id` (`user_id`),
  KEY `iag_comments_ibfk_3` (`parent_id`),
  CONSTRAINT `iag_comments_ibfk_1` FOREIGN KEY (`posts_id`) REFERENCES `iag_posts` (`id`),
  CONSTRAINT `iag_comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `iag_user` (`id`),
  CONSTRAINT `iag_comments_ibfk_3` FOREIGN KEY (`parent_id`) REFERENCES `iag_comments` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_comments
-- ----------------------------

-- ----------------------------
-- Table structure for iag_label
-- ----------------------------
DROP TABLE IF EXISTS `iag_label`;
CREATE TABLE `iag_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `label_name` varchar(20) NOT NULL COMMENT '标签名',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `iag_label_ibfk1` (`user_id`),
  CONSTRAINT `iag_label_ibfk1` FOREIGN KEY (`user_id`) REFERENCES `iag_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_label
-- ----------------------------

-- ----------------------------
-- Table structure for iag_log
-- ----------------------------
DROP TABLE IF EXISTS `iag_log`;
CREATE TABLE `iag_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `operator` varchar(20) NOT NULL COMMENT '操作人',
  `operation` varchar(20) NOT NULL COMMENT '操作',
  `operate_time` datetime NOT NULL COMMENT '操作时间',
  `url` varchar(100) NOT NULL COMMENT '操作URL',
  `ip` varchar(20) NOT NULL COMMENT '操作ip',
  `param` varchar(255) DEFAULT NULL COMMENT '参数',
  `detail` varchar(255) DEFAULT NULL COMMENT '详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_log
-- ----------------------------

-- ----------------------------
-- Table structure for iag_message
-- ----------------------------
DROP TABLE IF EXISTS `iag_message`;
CREATE TABLE `iag_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) NOT NULL COMMENT '信息内容',
  `sender_id` int(11) NOT NULL COMMENT '发送人id',
  `resiver_id` int(11) NOT NULL COMMENT '接收人id',
  `send_time` datetime NOT NULL COMMENT '发送时间',
  `is_read` tinyint(4) NOT NULL COMMENT '是否已读',
  `is_reply` tinyint(4) NOT NULL COMMENT '是否已回复',
  PRIMARY KEY (`id`),
  KEY `iag_message_ibfk1` (`sender_id`),
  KEY `iag_messge_ibfk2` (`resiver_id`),
  CONSTRAINT `iag_message_ibfk1` FOREIGN KEY (`sender_id`) REFERENCES `iag_user` (`id`),
  CONSTRAINT `iag_messge_ibfk2` FOREIGN KEY (`resiver_id`) REFERENCES `iag_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_message
-- ----------------------------

-- ----------------------------
-- Table structure for iag_notice
-- ----------------------------
DROP TABLE IF EXISTS `iag_notice`;
CREATE TABLE `iag_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `send_time` datetime NOT NULL COMMENT '发送时间',
  `is_read` tinyint(4) NOT NULL COMMENT '是否已读',
  `is_delete` tinyint(4) NOT NULL COMMENT '是否已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_notice
-- ----------------------------

-- ----------------------------
-- Table structure for iag_permission
-- ----------------------------
DROP TABLE IF EXISTS `iag_permission`;
CREATE TABLE `iag_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `permission_name` varchar(20) NOT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_permission
-- ----------------------------
INSERT INTO `iag_permission` VALUES ('1', 'add');
INSERT INTO `iag_permission` VALUES ('2', 'delete');
INSERT INTO `iag_permission` VALUES ('3', 'query');
INSERT INTO `iag_permission` VALUES ('4', 'update');

-- ----------------------------
-- Table structure for iag_posts
-- ----------------------------
DROP TABLE IF EXISTS `iag_posts`;
CREATE TABLE `iag_posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL COMMENT '帖子标题',
  `content` mediumtext NOT NULL COMMENT '帖子内容',
  `publish_time` datetime NOT NULL COMMENT '发布时间',
  `view_num` int(10) NOT NULL COMMENT '浏览量',
  `praise_num` int(10) NOT NULL COMMENT '点赞量',
  `edit_type` tinyint(4) NOT NULL COMMENT '编辑格式、Markerdown 或者 富文本',
  `is_delete` tinyint(4) NOT NULL COMMENT '软删除',
  `is_hidden` tinyint(4) NOT NULL COMMENT '是否隐藏',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后编辑时间',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `board_id` int(11) NOT NULL COMMENT '版块id',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `board_id` (`board_id`),
  CONSTRAINT `iag_posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `iag_user` (`id`),
  CONSTRAINT `iag_posts_ibfk_2` FOREIGN KEY (`board_id`) REFERENCES `iag_board` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_posts
-- ----------------------------

-- ----------------------------
-- Table structure for iag_posts_label
-- ----------------------------
DROP TABLE IF EXISTS `iag_posts_label`;
CREATE TABLE `iag_posts_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `posts_id` int(11) NOT NULL COMMENT '帖子id',
  `label_id` int(11) NOT NULL COMMENT '标签id',
  PRIMARY KEY (`id`),
  KEY `posts_id` (`posts_id`),
  KEY `label_id` (`label_id`),
  CONSTRAINT `iag_posts_label_ibfk_1` FOREIGN KEY (`posts_id`) REFERENCES `iag_posts` (`id`),
  CONSTRAINT `iag_posts_label_ibfk_2` FOREIGN KEY (`label_id`) REFERENCES `iag_label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_posts_label
-- ----------------------------

-- ----------------------------
-- Table structure for iag_posts_praise
-- ----------------------------
DROP TABLE IF EXISTS `iag_posts_praise`;
CREATE TABLE `iag_posts_praise` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `posts_id` int(11) NOT NULL COMMENT '帖子id',
  `praise_time` datetime NOT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `posts_id` (`posts_id`),
  CONSTRAINT `iag_posts_praise_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `iag_user` (`id`),
  CONSTRAINT `iag_posts_praise_ibfk_2` FOREIGN KEY (`posts_id`) REFERENCES `iag_posts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_posts_praise
-- ----------------------------

-- ----------------------------
-- Table structure for iag_resource
-- ----------------------------
DROP TABLE IF EXISTS `iag_resource`;
CREATE TABLE `iag_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `resource_name` varchar(20) NOT NULL COMMENT '资源名',
  `resource_value` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_resource
-- ----------------------------
INSERT INTO `iag_resource` VALUES ('1', '用户', 'user');
INSERT INTO `iag_resource` VALUES ('2', '帖子', 'posts');
INSERT INTO `iag_resource` VALUES ('3', '回复', 'comments');
INSERT INTO `iag_resource` VALUES ('4', '板块', 'board');
INSERT INTO `iag_resource` VALUES ('5', '私信', 'message');
INSERT INTO `iag_resource` VALUES ('6', '角色', 'role');
INSERT INTO `iag_resource` VALUES ('7', '系统配置', 'sysconfig');

-- ----------------------------
-- Table structure for iag_resource_permission
-- ----------------------------
DROP TABLE IF EXISTS `iag_resource_permission`;
CREATE TABLE `iag_resource_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `resource_id` int(11) NOT NULL COMMENT '资源id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  `res_per_value` varchar(255) NOT NULL COMMENT '资源权限字符',
  PRIMARY KEY (`id`),
  KEY `resource_id` (`resource_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `iag_resource_permission_ibfk_1` FOREIGN KEY (`resource_id`) REFERENCES `iag_resource` (`id`),
  CONSTRAINT `iag_resource_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `iag_permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_resource_permission
-- ----------------------------
INSERT INTO `iag_resource_permission` VALUES ('1', '1', '1', 'user:add');
INSERT INTO `iag_resource_permission` VALUES ('2', '1', '2', 'user:delete');
INSERT INTO `iag_resource_permission` VALUES ('3', '1', '3', 'user:query');
INSERT INTO `iag_resource_permission` VALUES ('4', '1', '4', 'user:update');
INSERT INTO `iag_resource_permission` VALUES ('5', '2', '1', 'posts:add');
INSERT INTO `iag_resource_permission` VALUES ('6', '2', '2', 'posts:delete');
INSERT INTO `iag_resource_permission` VALUES ('7', '2', '3', 'posts:query');
INSERT INTO `iag_resource_permission` VALUES ('8', '2', '4', 'posts:update');
INSERT INTO `iag_resource_permission` VALUES ('9', '3', '1', 'comments:add');
INSERT INTO `iag_resource_permission` VALUES ('10', '3', '2', 'comments:delete');
INSERT INTO `iag_resource_permission` VALUES ('11', '3', '3', 'comments:query');
INSERT INTO `iag_resource_permission` VALUES ('12', '3', '4', 'comments:update');
INSERT INTO `iag_resource_permission` VALUES ('13', '4', '1', 'board:add');
INSERT INTO `iag_resource_permission` VALUES ('14', '4', '2', 'board:delete');
INSERT INTO `iag_resource_permission` VALUES ('15', '4', '3', 'board:query');
INSERT INTO `iag_resource_permission` VALUES ('16', '4', '4', 'board:update');
INSERT INTO `iag_resource_permission` VALUES ('17', '5', '1', 'message:add');
INSERT INTO `iag_resource_permission` VALUES ('18', '5', '2', 'message:delete');
INSERT INTO `iag_resource_permission` VALUES ('19', '5', '3', 'message:query');
INSERT INTO `iag_resource_permission` VALUES ('20', '5', '4', 'message:update');
INSERT INTO `iag_resource_permission` VALUES ('21', '6', '1', 'role:add');
INSERT INTO `iag_resource_permission` VALUES ('22', '6', '2', 'role:delete');
INSERT INTO `iag_resource_permission` VALUES ('23', '6', '3', 'role:query');
INSERT INTO `iag_resource_permission` VALUES ('24', '6', '4', 'role:update');
INSERT INTO `iag_resource_permission` VALUES ('25', '7', '1', 'sysconfig:add');
INSERT INTO `iag_resource_permission` VALUES ('26', '7', '2', 'sysconfig:delete');
INSERT INTO `iag_resource_permission` VALUES ('27', '7', '3', 'sysconfig:query');
INSERT INTO `iag_resource_permission` VALUES ('28', '7', '4', 'sysconfig:update');

-- ----------------------------
-- Table structure for iag_role
-- ----------------------------
DROP TABLE IF EXISTS `iag_role`;
CREATE TABLE `iag_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(20) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_role
-- ----------------------------
INSERT INTO `iag_role` VALUES ('1', '超级管理员');
INSERT INTO `iag_role` VALUES ('2', '管理员');
INSERT INTO `iag_role` VALUES ('3', '普通会员');

-- ----------------------------
-- Table structure for iag_role_resper
-- ----------------------------
DROP TABLE IF EXISTS `iag_role_resper`;
CREATE TABLE `iag_role_resper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `res_per_id` int(11) NOT NULL COMMENT '资源权限id',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `res_per_id` (`res_per_id`),
  CONSTRAINT `iag_role_resper_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `iag_role` (`id`),
  CONSTRAINT `iag_role_resper_ibfk_2` FOREIGN KEY (`res_per_id`) REFERENCES `iag_resource_permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_role_resper
-- ----------------------------
INSERT INTO `iag_role_resper` VALUES ('1', '1', '4');
INSERT INTO `iag_role_resper` VALUES ('2', '1', '14');
INSERT INTO `iag_role_resper` VALUES ('3', '1', '12');
INSERT INTO `iag_role_resper` VALUES ('4', '1', '2');
INSERT INTO `iag_role_resper` VALUES ('5', '1', '10');
INSERT INTO `iag_role_resper` VALUES ('6', '1', '22');
INSERT INTO `iag_role_resper` VALUES ('7', '1', '19');
INSERT INTO `iag_role_resper` VALUES ('8', '1', '6');
INSERT INTO `iag_role_resper` VALUES ('9', '1', '28');
INSERT INTO `iag_role_resper` VALUES ('10', '1', '21');
INSERT INTO `iag_role_resper` VALUES ('11', '1', '13');
INSERT INTO `iag_role_resper` VALUES ('12', '1', '18');
INSERT INTO `iag_role_resper` VALUES ('13', '1', '8');
INSERT INTO `iag_role_resper` VALUES ('14', '1', '17');
INSERT INTO `iag_role_resper` VALUES ('15', '1', '24');
INSERT INTO `iag_role_resper` VALUES ('16', '1', '11');
INSERT INTO `iag_role_resper` VALUES ('17', '1', '16');
INSERT INTO `iag_role_resper` VALUES ('18', '1', '23');
INSERT INTO `iag_role_resper` VALUES ('19', '1', '20');
INSERT INTO `iag_role_resper` VALUES ('20', '1', '26');
INSERT INTO `iag_role_resper` VALUES ('21', '1', '15');
INSERT INTO `iag_role_resper` VALUES ('22', '1', '27');
INSERT INTO `iag_role_resper` VALUES ('23', '1', '1');
INSERT INTO `iag_role_resper` VALUES ('24', '1', '5');
INSERT INTO `iag_role_resper` VALUES ('25', '1', '3');
INSERT INTO `iag_role_resper` VALUES ('26', '1', '9');
INSERT INTO `iag_role_resper` VALUES ('27', '1', '7');
INSERT INTO `iag_role_resper` VALUES ('28', '1', '25');
INSERT INTO `iag_role_resper` VALUES ('29', '2', '5');
INSERT INTO `iag_role_resper` VALUES ('30', '2', '6');
INSERT INTO `iag_role_resper` VALUES ('31', '2', '7');
INSERT INTO `iag_role_resper` VALUES ('32', '2', '8');
INSERT INTO `iag_role_resper` VALUES ('33', '2', '9');
INSERT INTO `iag_role_resper` VALUES ('34', '2', '10');
INSERT INTO `iag_role_resper` VALUES ('35', '2', '11');
INSERT INTO `iag_role_resper` VALUES ('36', '2', '12');
INSERT INTO `iag_role_resper` VALUES ('37', '2', '13');
INSERT INTO `iag_role_resper` VALUES ('38', '2', '14');
INSERT INTO `iag_role_resper` VALUES ('39', '2', '15');
INSERT INTO `iag_role_resper` VALUES ('40', '2', '16');
INSERT INTO `iag_role_resper` VALUES ('41', '2', '17');
INSERT INTO `iag_role_resper` VALUES ('42', '2', '18');
INSERT INTO `iag_role_resper` VALUES ('43', '2', '19');
INSERT INTO `iag_role_resper` VALUES ('44', '2', '20');
INSERT INTO `iag_role_resper` VALUES ('45', '2', '25');
INSERT INTO `iag_role_resper` VALUES ('46', '2', '26');
INSERT INTO `iag_role_resper` VALUES ('47', '2', '27');
INSERT INTO `iag_role_resper` VALUES ('48', '2', '28');

-- ----------------------------
-- Table structure for iag_user
-- ----------------------------
DROP TABLE IF EXISTS `iag_user`;
CREATE TABLE `iag_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) NOT NULL COMMENT '邮箱',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `phone_num` varchar(14) DEFAULT NULL COMMENT '手机号',
  `is_delete` tinyint(4) NOT NULL COMMENT '软删除',
  `register_time` datetime NOT NULL COMMENT '注册时间',
  `last_modify_time` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `config_id` int(11) DEFAULT NULL COMMENT '用户配置外键',
  PRIMARY KEY (`id`),
  KEY `config_id` (`config_id`),
  CONSTRAINT `iag_user_ibfk_1` FOREIGN KEY (`config_id`) REFERENCES `iag_userconfig` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_user
-- ----------------------------

-- ----------------------------
-- Table structure for iag_userconfig
-- ----------------------------
DROP TABLE IF EXISTS `iag_userconfig`;
CREATE TABLE `iag_userconfig` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_userconfig
-- ----------------------------

-- ----------------------------
-- Table structure for iag_user_attention
-- ----------------------------
DROP TABLE IF EXISTS `iag_user_attention`;
CREATE TABLE `iag_user_attention` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `attention_id` int(11) NOT NULL COMMENT '关注人id',
  `attentioned_id` int(11) NOT NULL COMMENT '被关注人id',
  PRIMARY KEY (`id`),
  KEY `attention_id` (`attention_id`),
  KEY `attentioned_id` (`attentioned_id`),
  CONSTRAINT `iag_user_attention_ibfk_1` FOREIGN KEY (`attention_id`) REFERENCES `iag_user` (`id`),
  CONSTRAINT `iag_user_attention_ibfk_2` FOREIGN KEY (`attentioned_id`) REFERENCES `iag_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_user_attention
-- ----------------------------

-- ----------------------------
-- Table structure for iag_user_board
-- ----------------------------
DROP TABLE IF EXISTS `iag_user_board`;
CREATE TABLE `iag_user_board` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户外键',
  `board_id` int(11) NOT NULL COMMENT '版块id',
  `role_value` tinyint(4) NOT NULL COMMENT '版块角色、1，版主 2、副版主',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `board_id` (`board_id`),
  CONSTRAINT `iag_user_board_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `iag_user` (`id`),
  CONSTRAINT `iag_user_board_ibfk_2` FOREIGN KEY (`board_id`) REFERENCES `iag_board` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iag_user_board
-- ----------------------------

-- ----------------------------
-- Table structure for iag_user_role
-- ----------------------------
DROP TABLE IF EXISTS `iag_user_role`;
CREATE TABLE `iag_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `iag_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `iag_user` (`id`),
  CONSTRAINT `iag_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `iag_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of iag_user_role
-- ----------------------------
