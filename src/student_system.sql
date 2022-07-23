/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : student_system

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 23/07/2022 22:14:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin`  (
  `a_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `a_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `a_level` int(1) NOT NULL,
  PRIMARY KEY (`a_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('admin', 'admin', 1);
INSERT INTO `tb_admin` VALUES ('student', 'student', 3);
INSERT INTO `tb_admin` VALUES ('teacher', 'teacher', 2);

-- ----------------------------
-- Table structure for tb_choose_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_choose_course`;
CREATE TABLE `tb_choose_course`  (
  `cc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `t_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `s_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_choose_course
-- ----------------------------
INSERT INTO `tb_choose_course` VALUES (1, 'NJUPT-G1-ma-01', 'teacher_04', 'student_01');
INSERT INTO `tb_choose_course` VALUES (2, 'NJUPT-G1-pt-01', 'teacher_01', 'student_01');
INSERT INTO `tb_choose_course` VALUES (3, 'NJUPT-G1-cm-01', 'teacher_03', 'student_03');
INSERT INTO `tb_choose_course` VALUES (4, 'NJUPT-G1-cs-01', 'teacher_02', 'student_03');
INSERT INTO `tb_choose_course` VALUES (5, 'NJUPT-G1-cs-01', 'teacher_02', 'student_03');
INSERT INTO `tb_choose_course` VALUES (6, 'NJUPT-G1-ma-02', 'teacher_04', 'student_06');
INSERT INTO `tb_choose_course` VALUES (7, 'NJUPT-G1-ma-02', 'teacher_04', 'student_06');
INSERT INTO `tb_choose_course` VALUES (8, 'NJUPT-G1-ma-03', 'teacher_04', 'student_04');
INSERT INTO `tb_choose_course` VALUES (9, 'NJUPT-G1-ca-05', 'teacher_07', 'student_04');
INSERT INTO `tb_choose_course` VALUES (10, 'NJUPT-G1-cs-02', 'teacher_02', 'student_01');

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `c_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `c_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `c_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `c_branch` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `c_address` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `c_amount` int(20) NOT NULL,
  `c_allowance` int(20) NOT NULL,
  `t_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES (1, 'NJUPT-G1-ma-01', '高等数学A', '理学院', '教二-201', 40, 4, 'teacher_04');
INSERT INTO `tb_course` VALUES (2, 'NJUPT-G1-en-02', '大学英语Ⅱ', '外国语学院', '教二-107', 36, 3, 'teacher_06');
INSERT INTO `tb_course` VALUES (3, 'NJUPT-G1-cs-01', 'C语言', '计算机学院', '教三-207', 40, 0, 'teacher_02');
INSERT INTO `tb_course` VALUES (4, 'NJUPT-G1-cm-01', '通信原理', '通信信息工程学院', '教二-203', 39, 0, 'teacher_03');
INSERT INTO `tb_course` VALUES (5, 'NJUPT-G1-pt-01', '物流学导论', '现代邮政学院', '教4-404', 30, 0, 'teacher_01');
INSERT INTO `tb_course` VALUES (6, 'NJUPT-G1-cm-02', '数字电路', '通信信息工程学院', '三牌楼教西-302', 40, 2, 'teacher_03');
INSERT INTO `tb_course` VALUES (7, 'NJUPT-G1-ca-01 ', '职业规划和就业指导', '校长办公室', '三牌楼教东101', 20, 2, 'teacher_05');
INSERT INTO `tb_course` VALUES (8, 'NJUPT-G1-ca-02', '心理学', '校长办公室', '教三-309', 20, 2, 'teacher_05');
INSERT INTO `tb_course` VALUES (9, 'NJUPT-G1-ma-02', '线性代数', '理学院', '教二-301', 40, 0, 'teacher_04');
INSERT INTO `tb_course` VALUES (10, 'NJUPT-G1-ma-03', '概率与统计', '理学院', '教二-302', 40, 1, 'teacher_04');
INSERT INTO `tb_course` VALUES (11, 'NJUPT-G1-ca-03', '就业指导规划', '现代邮政学院', '教三-215', 10, 1, 'teacher_07');
INSERT INTO `tb_course` VALUES (12, 'NJUPT-G1-ca-05', '新生心里辅导', '现代邮政学院', '教三-201', 10, 0, 'teacher_07');
INSERT INTO `tb_course` VALUES (13, 'NJUPT-G1-cs-02', '操作系统', '计算机学院', '教三-309', 40, 1, 'teacher_02');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `s_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `s_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `s_sex` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `s_data` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `s_tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `s_address` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `s_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (1, 'student_01', '施浩', '男性', '2018-09-02', '17684055986', '贵州毕节', 'NJUPT');
INSERT INTO `tb_student` VALUES (2, 'studeng_02', '袁畅', '男性', '2018-09-01', '15522665544', '安徽六安', 'student_01');
INSERT INTO `tb_student` VALUES (3, 'student_03', '赵新宇', '未知', '2018-09-02', '17766990022', '江苏无锡', 'student_03');
INSERT INTO `tb_student` VALUES (4, 'student_04', '陶流铭', '男性', '2018-09-02', '15487902867', '广西百色', 'NJUPT');
INSERT INTO `tb_student` VALUES (5, 'student_05', '蔡水', '男性', '2018-09-02', '15866340719', '海南文昌', 'student_05');
INSERT INTO `tb_student` VALUES (6, 'student_06', '杨博宇', '男性', '2019-09-02', '15095527533', '江苏苏州', 'NJUPT');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`  (
  `t_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `t_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `t_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `t_sex` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `t_tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `t_office` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `t_branch` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `t_password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES (1, 'teacher_01', '李老师', '男性', '19805185622', '教三-101', '现代邮政学院', 'shihao');
INSERT INTO `tb_teacher` VALUES (2, 'teacher_02', '张老师', '男性', '17888885200', '教一-501', '计算机学院', 'teacher_02');
INSERT INTO `tb_teacher` VALUES (3, 'teacher_03', '牛老师', '女性', '13876543310', '行政北楼-221', '通信信息工程学院', 'teacher_03');
INSERT INTO `tb_teacher` VALUES (4, 'teacher_04', '王老师', '女性', '15207109932', '教四-527', '理学院', 'teacher_04');
INSERT INTO `tb_teacher` VALUES (5, 'teacher_05', '章老师', '女性', '17765670021', '行政南楼-101', '校长办公室', 'teacher');
INSERT INTO `tb_teacher` VALUES (6, 'teacher_06', '方老师', '女性', '15655200982', '教五-311', '外国语学院', 'NJUPT');
INSERT INTO `tb_teacher` VALUES (9, 'teacher_07', '盛秋旭', '女', '19805542190', '行政南楼-108', '现代邮政学院', 'shengqiuxu');

SET FOREIGN_KEY_CHECKS = 1;
