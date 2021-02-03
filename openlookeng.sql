-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: openlookeng
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attend_records`
--

DROP TABLE IF EXISTS `attend_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attend_records` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'parimary key',
  `user_no` varchar(13) NOT NULL COMMENT 'user_no reference user_info.user_no',
  `real_name` varchar(30) NOT NULL COMMENT 'user''s real name reference user_info.user_real_name',
  `nick_name` varchar(30) NOT NULL COMMENT 'user'' nick name reference user_info.user_nick_name',
  `depart_id` int NOT NULL COMMENT 'user''depart id reference user_info.user_depart_id',
  `signin_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `face_img_path` varchar(200) NOT NULL DEFAULT '-',
  PRIMARY KEY (`id`),
  KEY `user_no` (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attend_records`
--

LOCK TABLES `attend_records` WRITE;
/*!40000 ALTER TABLE `attend_records` DISABLE KEYS */;
INSERT INTO `attend_records` VALUES (4,'38509876','宋运辉','小辉',3,'2021-02-02 23:56:32','/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/2/2/宋运辉_gaitubao_256x300.jpg');
/*!40000 ALTER TABLE `attend_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `face_imgs`
--

DROP TABLE IF EXISTS `face_imgs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `face_imgs` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'auto increment primary key id',
  `face_img_path` varchar(200) NOT NULL COMMENT 'face img saved path',
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `time` (`time`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `face_imgs`
--

LOCK TABLES `face_imgs` WRITE;
/*!40000 ALTER TABLE `face_imgs` DISABLE KEYS */;
INSERT INTO `face_imgs` VALUES (3,'/home/fisheep/Desktop','2021-01-17 17:08:09'),(4,'fadaf','2021-01-17 17:12:52'),(5,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/17/测试saveFile.png','2021-01-17 17:39:48'),(6,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 18:23:00'),(7,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 18:36:43'),(8,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 19:53:40'),(9,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 20:07:03'),(10,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 20:23:34'),(11,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 20:29:24'),(12,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 20:32:39'),(13,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 20:55:02'),(14,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 21:01:01'),(15,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 21:02:46'),(16,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 21:07:38'),(17,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 21:13:22'),(18,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 21:14:55'),(19,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 21:15:37'),(20,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 21:19:17'),(21,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 21:26:08'),(22,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 22:21:45'),(23,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 22:23:35'),(24,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 22:24:56'),(25,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 22:25:47'),(26,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 22:33:10'),(27,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 22:37:03'),(28,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 22:38:10'),(29,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 22:39:28'),(30,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/18/测试saveFile.png','2021-01-18 22:59:07'),(31,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 14:40:04'),(32,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 14:43:08'),(33,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 14:43:32'),(34,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 14:50:25'),(35,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 15:00:05'),(36,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 15:00:36'),(37,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 15:01:17'),(38,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 15:02:16'),(39,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 15:03:14'),(40,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 15:03:43'),(41,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 15:20:48'),(42,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/19/测试saveFile.png','2021-01-19 15:21:40'),(43,'test_path','2021-01-19 16:10:31'),(44,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 21:58:19'),(45,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 22:06:28'),(46,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 22:13:54'),(47,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 22:21:02'),(48,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 22:22:00'),(49,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 22:22:57'),(50,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 22:44:54'),(51,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 22:46:26'),(52,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 22:50:13'),(53,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 23:03:40'),(54,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/26/宋运辉_gaitubao_256x300.jpg','2021-01-26 23:04:36'),(55,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/27/宋运辉_gaitubao_256x300.jpg','2021-01-27 20:44:36'),(56,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/27/宋运辉_gaitubao_256x300.jpg','2021-01-27 20:46:28'),(57,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/27/宋运辉_gaitubao_256x300.jpg','2021-01-27 20:55:44'),(58,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/27/宋运辉_gaitubao_256x300.jpg','2021-01-27 21:10:01'),(59,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/27/宋运辉_gaitubao_256x300.jpg','2021-01-27 21:56:31'),(60,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/29/宋运辉_gaitubao_256x300.jpg','2021-01-29 15:33:13'),(61,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/1/29/宋运辉_gaitubao_256x300.jpg','2021-01-29 17:08:30'),(62,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/2/2/雷东宝_gaitubao_159x182.jpg','2021-02-02 23:15:35'),(63,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/2/2/梁思申_gaitubao_212x268.jpg','2021-02-02 23:17:06'),(64,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/2/2/梁思申_gaitubao_212x268.jpg','2021-02-02 23:20:48'),(65,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/2/2/寻建祥_gaitubao_222x254.jpg','2021-02-02 23:21:40'),(66,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/2/2/宋运辉_gaitubao_256x300.jpg','2021-02-02 23:22:12'),(67,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/2/2/宋运辉_gaitubao_256x300.jpg','2021-02-02 23:49:35'),(68,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/2/2/宋运辉_gaitubao_256x300.jpg','2021-02-02 23:51:51'),(69,'/home/fisheep/code/java/face-signin-backen-test/src/main/resources/upload/2021/2/2/宋运辉_gaitubao_256x300.jpg','2021-02-02 23:56:31');
/*!40000 ALTER TABLE `face_imgs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `id` int NOT NULL,
  `name` longtext NOT NULL,
  `age` int NOT NULL,
  `sex` int NOT NULL,
  `date` date DEFAULT NULL,
  `datevarchar` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (3,'fisheep',22,1,'2020-12-02','2020-12-02'),(4,'yuyang',11,1,'2019-05-22','2019-05-22'),(4,'xiaohong',13,0,'2019-09-18','2019-09-18'),(7,'xiaowang',17,1,'2020-10-01','2019-10-01');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT 'auto increment primary key id',
  `user_no` varchar(13) NOT NULL COMMENT 'users'' unique identity number',
  `user_phone` varchar(20) NOT NULL COMMENT 'users'' phone number',
  `user_real_name` varchar(30) NOT NULL COMMENT 'users'' real name',
  `user_nick_name` varchar(30) DEFAULT NULL COMMENT 'user''s nick name, allow null',
  `user_email` varchar(50) DEFAULT NULL COMMENT 'user''s email number, allow null',
  `user_depart_id` int NOT NULL COMMENT 'user''s department id',
  PRIMARY KEY (`user_id`),
  KEY `user_number` (`user_no`),
  KEY `user_phone` (`user_phone`),
  KEY `user_email` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (3,'1223965229','15922513997','余扬','fisheep','noahyu@126.com',4),(4,'3396648765','15002345829','杨巡','','yangxun@126.com',5),(5,'784487653','15803298764','寻建祥','大寻','xunjianxiang@163.com',4),(6,'38509876','13803287794','宋运辉','小辉','songyunhui@163.com',3),(7,'90578646572','13877498512','程开颜','','chengkaiyan@126.com',5),(8,'177828332','15573820087','雷东宝','东宝','leidongbao@126.com',6);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-03 10:09:19
