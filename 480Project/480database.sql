-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: theater
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movie` varchar(50) NOT NULL,
  `theatername` varchar(50) DEFAULT NULL,
  `released` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`movie`),
  KEY `theatername` (`theatername`),
  CONSTRAINT `movie_ibfk_1` FOREIGN KEY (`theatername`) REFERENCES `theater` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('Frozen','Cineplex',0),('Inception','Cineplex',1),('Pulp Fiction','Cineplex',1),('The Godfather','Cineplex',1),('Titanic','Cineplex',1);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `seatNum` int DEFAULT NULL,
  `showtimeid` int DEFAULT NULL,
  `available` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `showtimeid` (`showtimeid`),
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`showtimeid`) REFERENCES `showtime` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,1,1,1),(2,2,1,1),(3,3,1,1),(4,4,1,1),(5,5,1,1),(6,6,1,1),(7,7,1,1),(8,8,1,1),(9,9,1,1),(10,10,1,1),(11,11,1,1),(12,12,1,1),(13,13,1,1),(14,14,1,1),(15,15,1,1),(16,16,1,1),(17,17,1,1),(18,18,1,1),(19,19,1,1),(20,20,1,1),(21,1,2,1),(22,2,2,1),(23,3,2,1),(24,4,2,1),(25,5,2,1),(26,6,2,1),(27,7,2,1),(28,8,2,1),(29,9,2,1),(30,10,2,1),(31,11,2,1),(32,12,2,1),(33,13,2,1),(34,14,2,1),(35,15,2,1),(36,16,2,1),(37,17,2,1),(38,18,2,1),(39,19,2,1),(40,20,2,1),(41,1,3,1),(42,2,3,1),(43,3,3,1),(44,4,3,1),(45,5,3,1),(46,6,3,1),(47,7,3,1),(48,8,3,1),(49,9,3,1),(50,10,3,1),(51,11,3,1),(52,12,3,1),(53,13,3,1),(54,14,3,1),(55,15,3,1),(56,16,3,1),(57,17,3,1),(58,18,3,1),(59,19,3,1),(60,20,3,1),(61,1,4,1),(62,2,4,1),(63,3,4,1),(64,4,4,1),(65,5,4,1),(66,6,4,1),(67,7,4,1),(68,8,4,1),(69,9,4,1),(70,10,4,1),(71,11,4,1),(72,12,4,1),(73,13,4,1),(74,14,4,1),(75,15,4,1),(76,16,4,1),(77,17,4,1),(78,18,4,1),(79,19,4,1),(80,20,4,1),(81,1,5,1),(82,2,5,1),(83,3,5,1),(84,4,5,1),(85,5,5,1),(86,6,5,1),(87,7,5,1),(88,8,5,1),(89,9,5,1),(90,10,5,1),(91,11,5,1),(92,12,5,1),(93,13,5,1),(94,14,5,1),(95,15,5,1),(96,16,5,1),(97,17,5,1),(98,18,5,1),(99,19,5,1),(100,20,5,1),(101,1,6,1),(102,2,6,1),(103,3,6,1),(104,4,6,1),(105,5,6,1),(106,6,6,1),(107,7,6,1),(108,8,6,1),(109,9,6,1),(110,10,6,1),(111,11,6,1),(112,12,6,1),(113,13,6,1),(114,14,6,1),(115,15,6,1),(116,16,6,1),(117,17,6,1),(118,18,6,1),(119,19,6,1),(120,20,6,1),(121,1,7,1),(122,2,7,1),(123,3,7,1),(124,4,7,1),(125,5,7,1),(126,6,7,1),(127,7,7,1),(128,8,7,1),(129,9,7,1),(130,10,7,1),(131,11,7,1),(132,12,7,1),(133,13,7,1),(134,14,7,1),(135,15,7,1),(136,16,7,1),(137,17,7,1),(138,18,7,1),(139,19,7,1),(140,20,7,1),(141,1,8,1),(142,2,8,1),(143,3,8,1),(144,4,8,1),(145,5,8,1),(146,6,8,1),(147,7,8,1),(148,8,8,1),(149,9,8,1),(150,10,8,1),(151,11,8,1),(152,12,8,1),(153,13,8,1),(154,14,8,1),(155,15,8,1),(156,16,8,1),(157,17,8,1),(158,18,8,1),(159,19,8,1),(160,20,8,1),(161,1,9,1),(162,2,9,1),(163,3,9,1),(164,4,9,1),(165,5,9,1),(166,6,9,1),(167,7,9,1),(168,8,9,1),(169,9,9,1),(170,10,9,1),(171,11,9,1),(172,12,9,1),(173,13,9,1),(174,14,9,1),(175,15,9,1),(176,16,9,1),(177,17,9,1),(178,18,9,1),(179,19,9,1),(180,20,9,1),(181,1,10,1),(182,2,10,1),(183,3,10,1),(184,4,10,1),(185,5,10,1),(186,6,10,1),(187,7,10,1),(188,8,10,1),(189,9,10,1),(190,10,10,1),(191,11,10,1),(192,12,10,1),(193,13,10,1),(194,14,10,1),(195,15,10,1),(196,16,10,1),(197,17,10,1),(198,18,10,1),(199,19,10,1),(200,20,10,1),(201,1,11,1),(202,2,11,1),(203,3,11,1),(204,4,11,1),(205,5,11,1),(206,6,11,1),(207,7,11,1),(208,8,11,1),(209,9,11,1),(210,10,11,1),(211,11,11,1),(212,12,11,1),(213,13,11,1),(214,14,11,1),(215,15,11,1),(216,16,11,1),(217,17,11,1),(218,18,11,1),(219,19,11,1),(220,20,11,1),(221,1,12,1),(222,2,12,1),(223,3,12,1),(224,4,12,1),(225,5,12,1),(226,6,12,1),(227,7,12,1),(228,8,12,1),(229,9,12,1),(230,10,12,1),(231,11,12,1),(232,12,12,1),(233,13,12,1),(234,14,12,1),(235,15,12,1),(236,16,12,1),(237,17,12,1),(238,18,12,1),(239,19,12,1),(240,20,12,1),(241,1,13,1),(242,2,13,1),(243,3,13,1),(244,4,13,1),(245,5,13,1),(246,6,13,1),(247,7,13,1),(248,8,13,1),(249,9,13,1),(250,10,13,1),(251,11,13,1),(252,12,13,1),(253,13,13,1),(254,14,13,1),(255,15,13,1),(256,16,13,1),(257,17,13,1),(258,18,13,1),(259,19,13,1),(260,20,13,1),(261,1,14,1),(262,2,14,1),(263,3,14,1),(264,4,14,1),(265,5,14,1),(266,6,14,1),(267,7,14,1),(268,8,14,1),(269,9,14,1),(270,10,14,1),(271,11,14,1),(272,12,14,1),(273,13,14,1),(274,14,14,1),(275,15,14,1),(276,16,14,1),(277,17,14,1),(278,18,14,1),(279,19,14,1),(280,20,14,1),(281,1,15,1),(282,2,15,1),(283,3,15,1),(284,4,15,1),(285,5,15,1),(286,6,15,1),(287,7,15,1),(288,8,15,1),(289,9,15,1),(290,10,15,1),(291,11,15,1),(292,12,15,1),(293,13,15,1),(294,14,15,1),(295,15,15,1),(296,16,15,1),(297,17,15,1),(298,18,15,1),(299,19,15,1),(300,20,15,1),(301,1,16,1),(302,2,16,1),(303,3,16,1),(304,4,16,1),(305,5,16,1),(306,6,16,1),(307,7,16,1),(308,8,16,1),(309,9,16,1),(310,10,16,1),(311,11,16,1),(312,12,16,1),(313,13,16,1),(314,14,16,1),(315,15,16,1),(316,16,16,1),(317,17,16,1),(318,18,16,1),(319,19,16,1),(320,20,16,1),(321,1,17,1),(322,2,17,1),(323,3,17,1),(324,4,17,1),(325,5,17,1),(326,6,17,1),(327,7,17,1),(328,8,17,1),(329,9,17,1),(330,10,17,1),(331,11,17,1),(332,12,17,1),(333,13,17,1),(334,14,17,1),(335,15,17,1),(336,16,17,1),(337,17,17,1),(338,18,17,1),(339,19,17,1),(340,20,17,1),(341,1,18,1),(342,2,18,1),(343,3,18,1),(344,4,18,1),(345,5,18,1),(346,6,18,1),(347,7,18,1),(348,8,18,1),(349,9,18,1),(350,10,18,1),(351,11,18,1),(352,12,18,1),(353,13,18,1),(354,14,18,1),(355,15,18,1),(356,16,18,1),(357,17,18,1),(358,18,18,1),(359,19,18,1),(360,20,18,1),(361,1,19,1),(362,2,19,1),(363,3,19,1),(364,4,19,1),(365,5,19,1),(366,6,19,1),(367,7,19,1),(368,8,19,1),(369,9,19,1),(370,10,19,1),(371,11,19,1),(372,12,19,1),(373,13,19,1),(374,14,19,1),(375,15,19,1),(376,16,19,1),(377,17,19,1),(378,18,19,1),(379,19,19,1),(380,20,19,1),(381,1,20,1),(382,2,20,1),(383,3,20,1),(384,4,20,1),(385,5,20,1),(386,6,20,1),(387,7,20,1),(388,8,20,1),(389,9,20,1),(390,10,20,1),(391,11,20,1),(392,12,20,1),(393,13,20,1),(394,14,20,1),(395,15,20,1),(396,16,20,1),(397,17,20,1),(398,18,20,1),(399,19,20,1),(400,20,20,1),(401,1,21,1),(402,2,21,1),(403,3,21,1),(404,4,21,1),(405,5,21,1),(406,6,21,1),(407,7,21,1),(408,8,21,1),(409,9,21,1),(410,10,21,1),(411,11,21,1),(412,12,21,1),(413,13,21,1),(414,14,21,1),(415,15,21,1),(416,16,21,1),(417,17,21,1),(418,18,21,1),(419,19,21,1),(420,20,21,1),(421,1,22,1),(422,2,22,1),(423,3,22,1),(424,4,22,1),(425,5,22,1),(426,6,22,1),(427,7,22,1),(428,8,22,1),(429,9,22,1),(430,10,22,1),(431,11,22,1),(432,12,22,1),(433,13,22,1),(434,14,22,1),(435,15,22,1),(436,16,22,1),(437,17,22,1),(438,18,22,1),(439,19,22,1),(440,20,22,1),(441,1,23,1),(442,2,23,1),(443,3,23,1),(444,4,23,1),(445,5,23,1),(446,6,23,1),(447,7,23,1),(448,8,23,1),(449,9,23,1),(450,10,23,1),(451,11,23,1),(452,12,23,1),(453,13,23,1),(454,14,23,1),(455,15,23,1),(456,16,23,1),(457,17,23,1),(458,18,23,1),(459,19,23,1),(460,20,23,1),(461,1,24,1),(462,2,24,1),(463,3,24,1),(464,4,24,1),(465,5,24,1),(466,6,24,1),(467,7,24,1),(468,8,24,1),(469,9,24,1),(470,10,24,1),(471,11,24,1),(472,12,24,1),(473,13,24,1),(474,14,24,1),(475,15,24,1),(476,16,24,1),(477,17,24,1),(478,18,24,1),(479,19,24,1),(480,20,24,1),(481,1,25,1),(482,2,25,1),(483,3,25,1),(484,4,25,1),(485,5,25,1),(486,6,25,1),(487,7,25,1),(488,8,25,1),(489,9,25,1),(490,10,25,1),(491,11,25,1),(492,12,25,1),(493,13,25,1),(494,14,25,1),(495,15,25,1),(496,16,25,1),(497,17,25,1),(498,18,25,1),(499,19,25,1),(500,20,25,1);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtime`
--

DROP TABLE IF EXISTS `showtime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showtime` (
  `id` int NOT NULL AUTO_INCREMENT,
  `showtime` varchar(50) DEFAULT NULL,
  `moviename` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `moviename` (`moviename`),
  CONSTRAINT `showtime_ibfk_1` FOREIGN KEY (`moviename`) REFERENCES `movie` (`movie`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtime`
--

LOCK TABLES `showtime` WRITE;
/*!40000 ALTER TABLE `showtime` DISABLE KEYS */;
INSERT INTO `showtime` VALUES (1,'12:00','Frozen','12-12-2022'),(2,'13:00','Frozen','12-12-2022'),(3,'14:00','Frozen','12-12-2022'),(4,'15:00','Frozen','12-12-2022'),(5,'16:00','Frozen','12-12-2022'),(6,'12:00','Pulp Fiction','4-12-2022'),(7,'13:00','Pulp Fiction','4-12-2022'),(8,'14:00','Pulp Fiction','4-12-2022'),(9,'15:00','Pulp Fiction','4-12-2022'),(10,'16:00','Pulp Fiction','4-12-2022'),(11,'12:00','Titanic','4-12-2022'),(12,'13:00','Titanic','4-12-2022'),(13,'14:00','Titanic','4-12-2022'),(14,'15:00','Titanic','4-12-2022'),(15,'16:00','Titanic','4-12-2022'),(16,'12:00','Inception','4-12-2022'),(17,'13:00','Inception','4-12-2022'),(18,'14:00','Inception','4-12-2022'),(19,'15:00','Inception','4-12-2022'),(20,'16:00','Inception','4-12-2022'),(21,'12:00','The Godfather','4-12-2022'),(22,'13:00','The Godfather','4-12-2022'),(23,'14:00','The Godfather','4-12-2022'),(24,'15:00','The Godfather','4-12-2022'),(25,'16:00','The Godfather','4-12-2022');
/*!40000 ALTER TABLE `showtime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theater`
--

DROP TABLE IF EXISTS `theater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theater` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theater`
--

LOCK TABLES `theater` WRITE;
/*!40000 ALTER TABLE `theater` DISABLE KEYS */;
INSERT INTO `theater` VALUES ('Cineplex');
/*!40000 ALTER TABLE `theater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int NOT NULL AUTO_INCREMENT,
  `useremail` varchar(50) DEFAULT NULL,
  `movieName` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `seatnum` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `useremail` (`useremail`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`useremail`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `email` varchar(50) NOT NULL,
  `cardnum` varchar(50) DEFAULT NULL,
  `registered` tinyint(1) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `lastpayment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('user1@gmail.com','1234',1,'user1','123 st','password','2022-12-06'),('user2@gmail.com','1234',1,'user2','123 blvd','password','2022-01-10');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-05 18:47:46
