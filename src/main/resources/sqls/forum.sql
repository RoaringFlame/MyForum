CREATE DATABASE  IF NOT EXISTS `db_forum` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_forum`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: forum
-- ------------------------------------------------------
-- Server version	5.6.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `t_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `reply_count` int(11) NOT NULL,
  `thread_count` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `last_reply_id` int(11) DEFAULT NULL,
  `last_thread_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3D5FEC6264DFFAE` (`category_id`),
  KEY `FK3D5FEC66AD9BECF` (`last_reply_id`),
  KEY `FK3D5FEC6B0A9BAC5` (`last_thread_id`),
  CONSTRAINT `FK3D5FEC6264DFFAE` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`id`),
  CONSTRAINT `FK3D5FEC66AD9BECF` FOREIGN KEY (`last_reply_id`) REFERENCES `t_reply` (`id`),
  CONSTRAINT `FK3D5FEC6B0A9BAC5` FOREIGN KEY (`last_thread_id`) REFERENCES `t_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `t_board` WRITE;
/*!40000 ALTER TABLE `t_board` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board_administrator`
--

DROP TABLE IF EXISTS `board_administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board_administrator` (
  `board_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`board_id`,`person_id`),
  KEY `FKBDEF7934FCBEE94E` (`person_id`),
  KEY `FKBDEF7934C09B45C6` (`board_id`),
  CONSTRAINT `FKBDEF7934C09B45C6` FOREIGN KEY (`board_id`) REFERENCES `t_board` (`id`),
  CONSTRAINT `FKBDEF7934FCBEE94E` FOREIGN KEY (`person_id`) REFERENCES `t_person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_administrator`
--

LOCK TABLES `board_administrator` WRITE;
/*!40000 ALTER TABLE `board_administrator` DISABLE KEYS */;
/*!40000 ALTER TABLE `board_administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `t_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `t_category` WRITE;
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `t_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `date_last_actived` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ip_created` varchar(255) DEFAULT NULL,
  `ip_last_actived` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `t_person` WRITE;
/*!40000 ALTER TABLE `t_person` DISABLE KEYS */;
INSERT INTO `t_person` VALUES (1,'2016-11-20 14:25:05','\0',1,'Admin','1993-04-05','2016-11-20 14:25:40','chenheng120@126.com','0:0:0:0:0:0:0:1','0:0:0:0:0:0:0:1','陈恒','21232f297a57a5a743894a0e4a801fc3','男');
/*!40000 ALTER TABLE `t_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `t_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `content` longtext,
  `floor` int(11) NOT NULL,
  `ip_created` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `thread_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4B322CA73C3F12E` (`thread_id`),
  KEY `FK4B322CA21D82F58` (`author_id`),
  CONSTRAINT `FK4B322CA21D82F58` FOREIGN KEY (`author_id`) REFERENCES `t_person` (`id`),
  CONSTRAINT `FK4B322CA73C3F12E` FOREIGN KEY (`thread_id`) REFERENCES `t_thread` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `t_reply` WRITE;
/*!40000 ALTER TABLE `t_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thread`
--

DROP TABLE IF EXISTS `t_thread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_thread` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_created` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `content` longtext,
  `date_last_replied` datetime DEFAULT NULL,
  `hit` int(11) NOT NULL,
  `ip_created` varchar(255) DEFAULT NULL,
  `readonly` bit(1) NOT NULL,
  `reply_count` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `topped` bit(1) NOT NULL,
  `author_id` int(11) DEFAULT NULL,
  `author_last_replied_id` int(11) DEFAULT NULL,
  `board_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9545FA2A7238BBF` (`author_last_replied_id`),
  KEY `FK9545FA2A21D82F58` (`author_id`),
  KEY `FK9545FA2AC09B45C6` (`board_id`),
  CONSTRAINT `FK9545FA2A21D82F58` FOREIGN KEY (`author_id`) REFERENCES `t_person` (`id`),
  CONSTRAINT `FK9545FA2A7238BBF` FOREIGN KEY (`author_last_replied_id`) REFERENCES `t_person` (`id`),
  CONSTRAINT `FK9545FA2AC09B45C6` FOREIGN KEY (`board_id`) REFERENCES `t_board` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thread`
--

LOCK TABLES `t_thread` WRITE;
/*!40000 ALTER TABLE `t_thread` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_thread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'forum'
--

--
-- Dumping routines for database 'forum'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-22 16:21:27
