/*
 Navicat Premium Data Transfer

 Source Server         : daetz
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : secondhand

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 11/06/2023 19:49:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `goods_id` int NULL DEFAULT NULL COMMENT '商品ID',
  `goods_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片',
  `count` int NULL DEFAULT NULL COMMENT '数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类名',
  `parent_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父级ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_id`(`parent_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '电脑', '数码');
INSERT INTO `category` VALUES (2, '手机', '数码');
INSERT INTO `category` VALUES (3, '平板', '数码');
INSERT INTO `category` VALUES (4, '面包', '美食');
INSERT INTO `category` VALUES (5, '牛奶', '美食');
INSERT INTO `category` VALUES (6, '饮料', '美食');
INSERT INTO `category` VALUES (7, '教材', '图书');
INSERT INTO `category` VALUES (8, '人文', '图书');
INSERT INTO `category` VALUES (9, '艺术', '图书');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单价',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '介绍',
  `category_id` int NULL DEFAULT NULL COMMENT '类别ID',
  `sale` int NULL DEFAULT NULL COMMENT '销量',
  `store` int NULL DEFAULT NULL COMMENT '库存',
  `used_year` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '使用年限',
  `state` tinyint(1) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 'Apple MacBook Air 13.3 ', 7999.00, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306080833118.png', 'Apple MacBook Air 13.3 八核M1芯片(7核图形处理器) 8G 256G SSD 深空灰 笔记本电脑 MGN63CH/A', 1, 22, 333, '3', 0);
INSERT INTO `goods` VALUES (2, 'Redmi K60', 2499.00, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081158271.png', 'Redmi K60 骁龙8+处理器 2K高光屏 6400万超清相机 5500mAh长续航 16GB+256GB 墨羽 小米红米5G', 2, 2000, 4000, '4', 1);
INSERT INTO `goods` VALUES (3, 'Apple iPad（第 9 代）', 2599.00, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081200175.png', 'Apple iPad（第 9 代）10.2英寸平板电脑 2021年款（64GB WLAN版/A13芯片/iPadOS MK2K3CH/A）深空灰色 ', 3, 2000, 4858, '3', 1);
INSERT INTO `goods` VALUES (4, '三只松鼠手撕面包', 21.90, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081201737.png', '三只松鼠手撕面包 早餐面包代餐休闲零食酵母小面包量贩装1000g/箱 ', 4, 322, 1223, '4', 1);
INSERT INTO `goods` VALUES (5, ' 蒙牛 纯牛奶', 37.90, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081203893.png', '蒙牛 纯牛奶 PURE MILK 250ml*16 每100ml含3.2g蛋白质 ', 5, 3243, 2123, '4', 1);
INSERT INTO `goods` VALUES (6, '元气森林苏打气泡水', 89.90, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081204201.png', '元气森林苏打气泡水饮料可乐无糖整箱0糖0脂0卡 【新品】柠檬味480mL*15瓶', 6, 4848, 48125, '4', 1);
INSERT INTO `goods` VALUES (7, '2023年正版初中3教材', 9.80, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081206029.png', '【人教版】2023年新版正版初中3三9九年级上册人教版语文课本教材教科书人民教育出版社初三九年级上册人教版语文课本 ', 7, 2654, 2524, '6', 1);
INSERT INTO `goods` VALUES (8, '漫画版人文历史类书籍 ', 39.00, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081208177.png', '【官方正版】带着孩子游中国全8册 漫画版人文历史类书籍 一二三四五六年级儿童趣味课外阅读书 中国儿童地理百科全书 带着孩子游中国·8册 ', 8, 1000, 5000, '1', 1);
INSERT INTO `goods` VALUES (9, '艺术的故事', 184.80, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081209148.png', '【官方正版 赠专享笔记本+飞机盒】艺术的故事 精装典藏 贡布里希爵士经典大众艺术阅读精品图书 西方艺术史 西方美术史 外国美术简史 广西美术出版社 ', 9, 2451, 5899, '2', 1);
INSERT INTO `goods` VALUES (11, '二手手机iphone 13pro max', 5999.99, 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306111514819.png', 'Apple 苹果 iPhone 14ProMax A2896 苹果14promax 手机 暗紫色 256G 套装一：搭配90天碎屏保障 ', 2, 0, 1, '2', 0);

-- ----------------------------
-- Table structure for infomation
-- ----------------------------
DROP TABLE IF EXISTS `infomation`;
CREATE TABLE `infomation`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` int NULL DEFAULT NULL COMMENT '主订单ID',
  `goods_id` int NULL DEFAULT NULL COMMENT '商品ID',
  `count` tinyint NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `handfirst`(`product_id`) USING BTREE,
  INDEX `handsecond`(`goods_id`) USING BTREE,
  CONSTRAINT `handfirst` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `handsecond` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '联系人表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of infomation
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单表',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `goods_id` int NULL DEFAULT NULL COMMENT '商品id',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `count` int NULL DEFAULT NULL COMMENT '商品数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `subtotal` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品小计',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (7, 'daetz', 4, 'Apple iPad（第 9 代）', 3, 2599.00, 7797.00);
INSERT INTO `orders` VALUES (8, 'daetz', 3, 'Redmi K60', 3, 2499.00, 7497.00);
INSERT INTO `orders` VALUES (9, 'daetz', 3, 'Redmi K60', 3, 2499.00, 7497.00);
INSERT INTO `orders` VALUES (10, 'daetz', 4, 'Apple iPad（第 9 代）', 3, 2599.00, 7797.00);
INSERT INTO `orders` VALUES (11, 'daetz', 5, 'Apple MacBook Air 13.3 ', 4, 7999.00, 31996.00);
INSERT INTO `orders` VALUES (14, 'daetz', 4, 'Apple iPad（第 9 代）', 3, 2599.00, 7797.00);
INSERT INTO `orders` VALUES (15, 'daetz', 5, 'Apple MacBook Air 13.3 ', 4, 7999.00, 31996.00);
INSERT INTO `orders` VALUES (17, 'daetz', 4, 'Apple iPad（第 9 代）', 3, 2599.00, 7797.00);
INSERT INTO `orders` VALUES (18, 'daetz', 3, 'Redmi K60', 3, 2499.00, 7497.00);
INSERT INTO `orders` VALUES (19, 'daetz', 4, 'Apple iPad（第 9 代）', 3, 2599.00, 7797.00);
INSERT INTO `orders` VALUES (20, 'daetz', 5, 'Apple MacBook Air 13.3 ', 4, 7999.00, 31996.00);
INSERT INTO `orders` VALUES (21, 'daetz', 7, 'Apple iPad（第 9 代）', 1, 2599.00, 2599.00);
INSERT INTO `orders` VALUES (22, 'daetz', 6, 'Apple MacBook Air 13.3 ', 1, 7999.00, 7999.00);
INSERT INTO `orders` VALUES (23, 'admin', 8, 'Apple MacBook Air 13.3 ', 3, 7999.00, 23997.00);
INSERT INTO `orders` VALUES (24, 'admin', 9, 'Redmi K60', 1, 2499.00, 2499.00);
INSERT INTO `orders` VALUES (25, 'admin', 10, 'Apple iPad（第 9 代）', 1, 2599.00, 2599.00);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` int NULL DEFAULT NULL COMMENT '用户ID',
  `total` decimal(10, 2) NULL DEFAULT NULL COMMENT '总金额',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '下单时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `trade_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易单号',
  `order_status` tinyint NULL DEFAULT NULL COMMENT '订单状态',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人地址',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '001', 1, 2000.00, '2023-04-27 22:23:50', '2023-04-28 22:25:16', '001', 0, 'daetz', '1234', '安徽池州', '加急');
INSERT INTO `product` VALUES (2, '002', 2, 56.00, '2023-04-27 22:25:54', '2023-04-28 22:25:57', '002', 1, 'xetz', '4321', '浙江嘉兴', '我不急');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_as_cs NULL DEFAULT NULL COMMENT '位置',
  `role` tinyint NULL DEFAULT NULL COMMENT '权限(1表示管理员，0表示普通用户)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_as_cs COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'daetz', '123456', '大鹅同志', 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081926351.png', '男', '2002-09-24', '3446914219@qq.com', '浙江嘉兴', 0);
INSERT INTO `user` VALUES (24, 'admin', '123456', 'zhanyong', 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306081926351.png', '男', '2002-06-10', '3446914219@qq.com', '嘉兴市南湖区118号', 1);
INSERT INTO `user` VALUES (27, '张五', '123456', '小A', 'https://daetz-image.oss-cn-hangzhou.aliyuncs.com/img/202306111903445.png', '男', '2018-06-12', '123456789@qq.com', '浙江嘉兴', 1);

SET FOREIGN_KEY_CHECKS = 1;
