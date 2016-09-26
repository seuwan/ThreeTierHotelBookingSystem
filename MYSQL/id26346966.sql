-- MySQL dump 10.13  Distrib 5.7.3-m13, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelnew
-- ------------------------------------------------------
-- Server version	5.7.3-m13

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
-- Table structure for table `bj7days`
--

DROP TABLE IF EXISTS `bj7days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bj7days` (
  `hotelName` varchar(45) NOT NULL DEFAULT 'beijing_7days',
  `roomID` varchar(45) NOT NULL,
  `rate` varchar(45) NOT NULL,
  `vacancy` varchar(45) NOT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bj7days`
--

LOCK TABLES `bj7days` WRITE;
/*!40000 ALTER TABLE `bj7days` DISABLE KEYS */;
INSERT INTO `bj7days` VALUES ('beijing_7days','100','300','0'),('beijing_7days','101','300','0'),('beijing_7days','102','300','0'),('beijing_7days','103','300','0'),('beijing_7days','104','300','0'),('beijing_7days','105','350','0'),('beijing_7days','106','350','0'),('beijing_7days','107','350','0'),('beijing_7days','108','350','0'),('beijing_7days','109','350','0');
/*!40000 ALTER TABLE `bj7days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bjjjstar`
--

DROP TABLE IF EXISTS `bjjjstar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bjjjstar` (
  `hotelName` varchar(45) NOT NULL DEFAULT 'beijing_jjstar',
  `roomID` varchar(45) NOT NULL,
  `rate` varchar(45) NOT NULL,
  `vacancy` varchar(45) NOT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bjjjstar`
--

LOCK TABLES `bjjjstar` WRITE;
/*!40000 ALTER TABLE `bjjjstar` DISABLE KEYS */;
INSERT INTO `bjjjstar` VALUES ('beijing_jjstar','200','400','0'),('beijing_jjstar','201','400','0'),('beijing_jjstar','202','400','0'),('beijing_jjstar','203','400','0'),('beijing_jjstar','204','400','0'),('beijing_jjstar','205','450','0'),('beijing_jjstar','206','450','0'),('beijing_jjstar','207','450','0'),('beijing_jjstar','208','450','0'),('beijing_jjstar','209','450','0');
/*!40000 ALTER TABLE `bjjjstar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cityhotel`
--

DROP TABLE IF EXISTS `cityhotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cityhotel` (
  `id` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `hotel` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cityhotel`
--

LOCK TABLES `cityhotel` WRITE;
/*!40000 ALTER TABLE `cityhotel` DISABLE KEYS */;
INSERT INTO `cityhotel` VALUES ('1','beijing','7days'),('2','beijing','jjstar'),('3','shanghai','7days'),('4','shanghai','jjstar');
/*!40000 ALTER TABLE `cityhotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roomcheck`
--

DROP TABLE IF EXISTS `roomcheck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roomcheck` (
  `roomID` varchar(45) NOT NULL,
  `checkInDay` varchar(45) NOT NULL,
  `checkOutDay` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomcheck`
--

LOCK TABLES `roomcheck` WRITE;
/*!40000 ALTER TABLE `roomcheck` DISABLE KEYS */;
/*!40000 ALTER TABLE `roomcheck` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sh7days`
--

DROP TABLE IF EXISTS `sh7days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sh7days` (
  `hotelName` varchar(45) NOT NULL DEFAULT 'shanghai_7days',
  `roomID` varchar(45) NOT NULL,
  `rate` varchar(45) NOT NULL,
  `vacancy` varchar(45) NOT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sh7days`
--

LOCK TABLES `sh7days` WRITE;
/*!40000 ALTER TABLE `sh7days` DISABLE KEYS */;
INSERT INTO `sh7days` VALUES ('shanghai_7days','300','100','0'),('shanghai_7days','301','100','0'),('shanghai_7days','302','100','0'),('shanghai_7days','303','100','0'),('shanghai_7days','304','100','0'),('shanghai_7days','305','150','0'),('shanghai_7days','306','150','0'),('shanghai_7days','307','150','0'),('shanghai_7days','308','150','0'),('shanghai_7days','309','150','0');
/*!40000 ALTER TABLE `sh7days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shjjstar`
--

DROP TABLE IF EXISTS `shjjstar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shjjstar` (
  `hotelName` varchar(45) NOT NULL DEFAULT 'shanghai_jjstar',
  `roomID` varchar(45) NOT NULL,
  `rate` varchar(45) NOT NULL,
  `vacancy` varchar(45) NOT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shjjstar`
--

LOCK TABLES `shjjstar` WRITE;
/*!40000 ALTER TABLE `shjjstar` DISABLE KEYS */;
INSERT INTO `shjjstar` VALUES ('shanghai_jjstar','400','200','0'),('shanghai_jjstar','401','200','0'),('shanghai_jjstar','402','200','0'),('shanghai_jjstar','403','200','0'),('shanghai_jjstar','404','200','0'),('shanghai_jjstar','405','250','0'),('shanghai_jjstar','406','250','0'),('shanghai_jjstar','407','250','0'),('shanghai_jjstar','408','250','0'),('shanghai_jjstar','409','250','0');
/*!40000 ALTER TABLE `shjjstar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `hotelName` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `inDay` varchar(45) NOT NULL,
  `outDay` varchar(45) NOT NULL,
  `creCard` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2015-05-20 15:52:07
