CREATE DATABASE  IF NOT EXISTS `ykm_moda` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ykm_moda`;
-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: ykm_moda
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `icerik`
--

DROP TABLE IF EXISTS `icerik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `icerik` (
  `icerikID` int(11) NOT NULL,
  `turID` bit(1) NOT NULL,
  `icerik` varchar(500) NOT NULL,
  PRIMARY KEY (`icerikID`),
  KEY `fk_Icerik_IcerikTuru1_idx` (`turID`),
  CONSTRAINT `fk_Icerik_IcerikTuru1` FOREIGN KEY (`turID`) REFERENCES `icerikturu` (`turID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icerik`
--

LOCK TABLES `icerik` WRITE;
/*!40000 ALTER TABLE `icerik` DISABLE KEYS */;
/*!40000 ALTER TABLE `icerik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icerikturu`
--

DROP TABLE IF EXISTS `icerikturu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `icerikturu` (
  `turID` bit(1) NOT NULL,
  `turAdı` varchar(45) NOT NULL,
  PRIMARY KEY (`turID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icerikturu`
--

LOCK TABLES `icerikturu` WRITE;
/*!40000 ALTER TABLE `icerikturu` DISABLE KEYS */;
/*!40000 ALTER TABLE `icerikturu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullanici`
--

DROP TABLE IF EXISTS `kullanici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kullanici` (
  `kullaniciID` int(11) NOT NULL AUTO_INCREMENT,
  `ad` varchar(45) NOT NULL,
  `kullaniciTip` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sifre` varchar(255) NOT NULL,
  `telefon` varchar(15) NOT NULL,
  `cinsiyet` bit(1) NOT NULL,
  `yas` varchar(3) NOT NULL,
  `kilo` varchar(3) NOT NULL,
  `boy` varchar(3) NOT NULL,
  `durum` bit(1) NOT NULL,
  PRIMARY KEY (`kullaniciID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanici`
--

LOCK TABLES `kullanici` WRITE;
/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullanicitarz`
--

DROP TABLE IF EXISTS `kullanicitarz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kullanicitarz` (
  `ktID` int(11) NOT NULL AUTO_INCREMENT,
  `kullaniciID` int(11) NOT NULL,
  `tarzID` int(11) NOT NULL,
  PRIMARY KEY (`ktID`,`kullaniciID`,`tarzID`),
  KEY `fk_KullaniciTarz_Tarz1_idx` (`tarzID`),
  KEY `fk_KullaniciTarz_Kullanici1` (`kullaniciID`),
  CONSTRAINT `fk_KullaniciTarz_Kullanici1` FOREIGN KEY (`kullaniciID`) REFERENCES `kullanici` (`kullaniciID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_KullaniciTarz_Tarz1` FOREIGN KEY (`tarzID`) REFERENCES `tarz` (`tarzID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanicitarz`
--

LOCK TABLES `kullanicitarz` WRITE;
/*!40000 ALTER TABLE `kullanicitarz` DISABLE KEYS */;
/*!40000 ALTER TABLE `kullanicitarz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kullanicitipi`
--

DROP TABLE IF EXISTS `kullanicitipi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kullanicitipi` (
  `tipID` bit(1) NOT NULL,
  `tip` varchar(10) NOT NULL,
  PRIMARY KEY (`tipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kullanicitipi`
--

LOCK TABLES `kullanicitipi` WRITE;
/*!40000 ALTER TABLE `kullanicitipi` DISABLE KEYS */;
/*!40000 ALTER TABLE `kullanicitipi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesaj`
--

DROP TABLE IF EXISTS `mesaj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mesaj` (
  `mesajID` int(11) NOT NULL AUTO_INCREMENT,
  `sohbetID` int(11) NOT NULL,
  `gondericiID` int(11) NOT NULL,
  `aliciID` int(11) NOT NULL,
  `icerikID` int(11) NOT NULL,
  `mesaj` varchar(500) NOT NULL,
  PRIMARY KEY (`mesajID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesaj`
--

LOCK TABLES `mesaj` WRITE;
/*!40000 ALTER TABLE `mesaj` DISABLE KEYS */;
/*!40000 ALTER TABLE `mesaj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `silinenmesajlar`
--

DROP TABLE IF EXISTS `silinenmesajlar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `silinenmesajlar` (
  `silinenMesajID` int(11) NOT NULL AUTO_INCREMENT,
  `mesajID` int(11) NOT NULL,
  `kullaniciID` int(11) NOT NULL,
  `tarih` datetime NOT NULL,
  PRIMARY KEY (`silinenMesajID`),
  KEY `fk_SilinenMesajlar_Mesaj1_idx` (`mesajID`),
  CONSTRAINT `fk_SilinenMesajlar_Mesaj1` FOREIGN KEY (`mesajID`) REFERENCES `mesaj` (`mesajID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `silinenmesajlar`
--

LOCK TABLES `silinenmesajlar` WRITE;
/*!40000 ALTER TABLE `silinenmesajlar` DISABLE KEYS */;
/*!40000 ALTER TABLE `silinenmesajlar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `silinensohbetler`
--

DROP TABLE IF EXISTS `silinensohbetler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `silinensohbetler` (
  `silinenSohbetID` int(11) NOT NULL AUTO_INCREMENT,
  `sohbetID` int(11) NOT NULL,
  `kullaniciID` int(11) NOT NULL,
  `tarih` datetime NOT NULL,
  PRIMARY KEY (`silinenSohbetID`),
  KEY `fk_SilinenSohbetler_Sohbet1_idx` (`sohbetID`),
  CONSTRAINT `fk_SilinenSohbetler_Sohbet1` FOREIGN KEY (`sohbetID`) REFERENCES `sohbet` (`sohbetID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `silinensohbetler`
--

LOCK TABLES `silinensohbetler` WRITE;
/*!40000 ALTER TABLE `silinensohbetler` DISABLE KEYS */;
/*!40000 ALTER TABLE `silinensohbetler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sohbet`
--

DROP TABLE IF EXISTS `sohbet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sohbet` (
  `sohbetID` int(11) NOT NULL AUTO_INCREMENT,
  `kullaniciID` int(11) NOT NULL,
  `olusturulmaTarih` datetime NOT NULL,
  `guncellenmeTarih` datetime NOT NULL,
  PRIMARY KEY (`sohbetID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sohbet`
--

LOCK TABLES `sohbet` WRITE;
/*!40000 ALTER TABLE `sohbet` DISABLE KEYS */;
/*!40000 ALTER TABLE `sohbet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarz`
--

DROP TABLE IF EXISTS `tarz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarz` (
  `tarzID` int(11) NOT NULL AUTO_INCREMENT,
  `tarzAdi` varchar(15) NOT NULL,
  PRIMARY KEY (`tarzID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarz`
--

LOCK TABLES `tarz` WRITE;
/*!40000 ALTER TABLE `tarz` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yorum`
--

DROP TABLE IF EXISTS `yorum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yorum` (
  `yorumID` int(11) NOT NULL AUTO_INCREMENT,
  `kullaniciID` int(11) NOT NULL,
  `yorumIcerik` varchar(500) NOT NULL,
  PRIMARY KEY (`yorumID`),
  KEY `fk_Yorum_Kullanici1_idx` (`kullaniciID`),
  CONSTRAINT `fk_Yorum_Kullanici1` FOREIGN KEY (`kullaniciID`) REFERENCES `kullanici` (`kullaniciID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yorum`
--

LOCK TABLES `yorum` WRITE;
/*!40000 ALTER TABLE `yorum` DISABLE KEYS */;
/*!40000 ALTER TABLE `yorum` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-27 11:49:27
