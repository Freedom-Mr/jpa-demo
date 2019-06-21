/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50552
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50552
 File Encoding         : 65001

 Date: 02/11/2018 18:30:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_grade
-- ----------------------------
DROP TABLE IF EXISTS `sys_grade`;
CREATE TABLE `sys_grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '级别名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id+grade+inst_id+dep_id`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户级别关联表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_grade
-- ----------------------------
INSERT INTO `sys_grade` VALUES (1, '系统', '2018-09-26 15:47:27');
INSERT INTO `sys_grade` VALUES (2, '单位', '2018-09-26 15:49:19');
INSERT INTO `sys_grade` VALUES (3, '部门', '2018-09-26 15:51:12');

-- ----------------------------
-- Table structure for sys_name
-- ----------------------------
DROP TABLE IF EXISTS `sys_name`;
CREATE TABLE `sys_name`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_name
-- ----------------------------
INSERT INTO `sys_name` VALUES (6, '4');
INSERT INTO `sys_name` VALUES (7, '5');
INSERT INTO `sys_name` VALUES (8, '6');

-- ----------------------------
-- Table structure for sys_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm`  (
  `val` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限值，shiro的权限控制表达式',
  `parent` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父权限ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `type` int(3) NULL DEFAULT NULL COMMENT '权限类型：1.菜单 2.按钮 3.接口 4.特殊',
  `leaf` int(1) NULL DEFAULT NULL COMMENT '是否叶子节点',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`val`) USING BTREE,
  UNIQUE INDEX `val`(`val`) USING BTREE,
  INDEX `parent`(`parent`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_perm
-- ----------------------------
INSERT INTO `sys_perm` VALUES ('*', NULL, '所有权限', 0, 0, '2018-04-19 18:14:12', '2018-09-28 11:08:26');
INSERT INTO `sys_perm` VALUES ('m:analysis', NULL, '分析工具', 1, 0, '2018-10-18 11:50:31', '2018-10-18 11:50:31');
INSERT INTO `sys_perm` VALUES ('m:analysis:menu_1', 'm:analysis', '菜单-1', 1, 0, '2018-10-18 11:50:31', '2018-11-01 17:22:23');
INSERT INTO `sys_perm` VALUES ('m:analysis:menu_1:a', 'm:analysis:menu_1', '菜单-1-a', 1, 1, '2018-11-01 17:22:23', '2018-11-01 17:22:23');
INSERT INTO `sys_perm` VALUES ('m:analysis:menu_1:b', 'm:analysis:menu_1', '菜单-1-b', 1, 1, '2018-11-01 17:22:23', '2018-11-01 17:22:23');
INSERT INTO `sys_perm` VALUES ('m:analysis:menu_1:c', 'm:analysis:menu_1', '菜单-1-c', 1, 1, '2018-11-01 17:22:23', '2018-11-01 17:22:23');
INSERT INTO `sys_perm` VALUES ('m:analysis:menu_2', 'm:analysis', '菜单-2', 1, 1, '2018-10-18 11:50:31', '2018-10-18 11:50:31');
INSERT INTO `sys_perm` VALUES ('m:dispose', NULL, '我的工作台', 1, 1, '2018-10-18 11:53:13', '2018-10-18 11:53:13');
INSERT INTO `sys_perm` VALUES ('m:event:menu_1', NULL, '专题分析', 1, 1, '2018-10-18 11:50:31', '2018-10-18 11:50:31');
INSERT INTO `sys_perm` VALUES ('m:focuspeople:menu_1', NULL, '重点人', 1, 1, '2018-10-18 11:50:31', '2018-10-18 11:53:13');
INSERT INTO `sys_perm` VALUES ('m:monitor', NULL, '监控预警', 1, 0, '2018-10-18 11:50:31', '2018-10-18 11:50:31');
INSERT INTO `sys_perm` VALUES ('m:monitor:menu_1', 'm:monitor', '菜单-1', 1, 1, '2018-10-18 11:50:31', '2018-10-18 11:50:31');
INSERT INTO `sys_perm` VALUES ('m:monitor:menu_2', 'm:monitor', '菜单-2', 1, 1, '2018-10-18 11:50:31', '2018-10-18 11:50:31');
INSERT INTO `sys_perm` VALUES ('m:monitor:menu_3', 'm:monitor', '菜单-3', 1, 1, '2018-10-18 11:50:31', '2018-10-18 11:50:31');
INSERT INTO `sys_perm` VALUES ('m:sys', NULL, '系统管理', 1, 0, '2018-10-17 10:02:08', '2018-10-17 15:14:35');
INSERT INTO `sys_perm` VALUES ('m:sys:department', 'm:sys', '部门管理', 1, 1, '2018-10-18 09:14:27', '2018-10-18 09:14:27');
INSERT INTO `sys_perm` VALUES ('m:sys:institution', 'm:sys', '单位管理', 1, 1, '2018-10-18 09:22:02', '2018-10-18 09:22:02');
INSERT INTO `sys_perm` VALUES ('m:sys:perm', 'm:sys', '权限管理', 1, 1, '2018-10-17 10:02:08', '2018-10-17 10:09:31');
INSERT INTO `sys_perm` VALUES ('m:sys:role', 'm:sys', '角色管理', 1, 1, '2018-10-17 10:02:08', '2018-10-17 10:09:31');
INSERT INTO `sys_perm` VALUES ('m:sys:user', 'm:sys', '用户管理', 1, 1, '2018-10-18 10:33:42', '2018-10-18 10:33:42');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名，用于显示',
  `grade` int(2) NOT NULL COMMENT '级别：1-系统，2-单位，3-部门；',
  `rdesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `rval` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色值，用于权限判断',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `grade_id`(`grade`) USING BTREE,
  INDEX `rval`(`rval`) USING BTREE,
  CONSTRAINT `sys_role_ibfk_1` FOREIGN KEY (`grade`) REFERENCES `sys_grade` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (-1, '超级管理员', 1, '具有系统理员权限', 'root', '2018-04-19 17:34:33', '2018-10-26 20:02:34');
INSERT INTO `sys_role` VALUES (1, '游客', 3, '游客', 'visito', '2018-10-26 19:55:56', '2018-11-02 17:04:54');
INSERT INTO `sys_role` VALUES (2, '单位管理员', 2, '具有单位管理员权限', 'inst_1', '2018-06-02 14:56:49', '2018-10-26 19:52:12');
INSERT INTO `sys_role` VALUES (3, '单位审计员', 2, '具有单位审计员权限', 'inst_2', '2018-06-02 14:56:39', '2018-10-26 19:52:05');
INSERT INTO `sys_role` VALUES (4, '单位业务员', 2, '具有单位业务员权限', 'inst_3', '2018-10-26 19:51:26', '2018-10-26 19:52:03');
INSERT INTO `sys_role` VALUES (5, '部门管理员', 3, '具有部门管理员权限', 'dep_1', '2018-10-26 19:52:44', '2018-10-26 19:53:06');
INSERT INTO `sys_role` VALUES (6, '部门审计员', 3, '具有部门审计员权限', 'dep_2', '2018-10-26 19:53:29', '2018-10-26 19:53:32');
INSERT INTO `sys_role` VALUES (7, '部门业务员', 3, '具有部门业务员权限12', 'dep_3', '2018-10-26 19:54:00', '2018-11-01 10:18:12');

-- ----------------------------
-- Table structure for sys_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `perm_val` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限值',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_id+perm_val`(`role_id`, `perm_val`) USING BTREE,
  INDEX `val_perm_val`(`perm_val`) USING BTREE,
  CONSTRAINT `sys_role_perm_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `sys_role_perm_ibfk_2` FOREIGN KEY (`perm_val`) REFERENCES `sys_perm` (`val`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_perm
-- ----------------------------
INSERT INTO `sys_role_perm` VALUES (1, -1, '*', '2018-10-26 20:03:11');
INSERT INTO `sys_role_perm` VALUES (2, 1, 'm:analysis', '2018-11-02 16:36:23');
INSERT INTO `sys_role_perm` VALUES (3, 2, 'm:sys', '2018-10-29 18:43:55');
INSERT INTO `sys_role_perm` VALUES (4, 2, 'm:sys:department', '2018-10-29 18:43:04');
INSERT INTO `sys_role_perm` VALUES (5, 2, 'm:sys:user', '2018-10-29 18:44:10');
INSERT INTO `sys_role_perm` VALUES (6, 7, 'm:monitor', '2018-11-01 20:07:42');

-- ----------------------------
-- Procedure structure for a
-- ----------------------------
DROP PROCEDURE IF EXISTS `a`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `a`()
BEGIN 

DECLARE i INT DEFAULT 1;

WHILE i<10
DO 
insert into aaa(zid) values (i); 
SET i=i+1; 
END WHILE ; 
commit; 

END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
