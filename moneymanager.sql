-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: moneymanager
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

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
-- Table structure for table `pendapatan`
--

DROP TABLE IF EXISTS `pendapatan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pendapatan` (
  `id_pendapatan` char(11) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlah` int(100) NOT NULL,
  `catatan` varchar(200) NOT NULL,
  PRIMARY KEY (`id_pendapatan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pendapatan`
--

LOCK TABLES `pendapatan` WRITE;
/*!40000 ALTER TABLE `pendapatan` DISABLE KEYS */;
INSERT INTO `pendapatan` VALUES ('PDN-001','2020-03-19',10000,'jual permen'),('PDN-002','2020-03-14',50000,'warung'),('PDN-004','2020-01-03',3000,'uww'),('PDN-005','2020-01-04',10000,'untuk beli seblak'),('PDN-006','2020-01-20',20000,'AJHSJ'),('PDN-007','1999-02-22',5000000,'ngoding');
/*!40000 ALTER TABLE `pendapatan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pengeluaran`
--

DROP TABLE IF EXISTS `pengeluaran`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pengeluaran` (
  `id_pengeluaran` char(11) NOT NULL,
  `tanggal_pilih` date NOT NULL,
  `transportasi` int(100) NOT NULL,
  `makanan` int(100) NOT NULL,
  `kesehatan` int(100) NOT NULL,
  `kecantikan` int(100) NOT NULL,
  `pakaian` int(100) NOT NULL,
  `komunikasi` int(100) NOT NULL,
  `lainnya` int(100) NOT NULL,
  `jumlah` int(100) NOT NULL,
  `catatan` varchar(128) NOT NULL,
  PRIMARY KEY (`id_pengeluaran`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pengeluaran`
--

LOCK TABLES `pengeluaran` WRITE;
/*!40000 ALTER TABLE `pengeluaran` DISABLE KEYS */;
INSERT INTO `pengeluaran` VALUES ('PGN-001','2020-01-04',0,1000,0,0,0,0,0,1000,'-'),('PGN-002','2020-01-04',500,200,1000,0,0,0,0,1700,'makan rada elit dikit,\nsakit ceunah'),('PGN-003','2020-01-05',0,5000,0,0,0,0,0,5000,'jajan seblak'),('PGN-009','2020-01-04',1000,200,0,0,0,0,0,0,'beli permen');
/*!40000 ALTER TABLE `pengeluaran` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saldobalance`
--

DROP TABLE IF EXISTS `saldobalance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `saldobalance` (
  `id` char(11) NOT NULL,
  `id_pendapatan` char(11) DEFAULT NULL,
  `id_pengeluaran` char(11) DEFAULT NULL,
  `jumlah` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pendapatan` (`id_pendapatan`),
  KEY `id_pengeluaran` (`id_pengeluaran`),
  CONSTRAINT `saldobalance_ibfk_1` FOREIGN KEY (`id_pendapatan`) REFERENCES `pendapatan` (`id_pendapatan`),
  CONSTRAINT `saldobalance_ibfk_2` FOREIGN KEY (`id_pengeluaran`) REFERENCES `pengeluaran` (`id_pengeluaran`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saldobalance`
--

LOCK TABLES `saldobalance` WRITE;
/*!40000 ALTER TABLE `saldobalance` DISABLE KEYS */;
INSERT INTO `saldobalance` VALUES ('33','PDN-002',NULL,2000),('36',NULL,'PGN-001',1000),('37',NULL,'PGN-002',1700),('39','PDN-004',NULL,3000),('40','PDN-005',NULL,10000),('41',NULL,'PGN-003',5000);
/*!40000 ALTER TABLE `saldobalance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` char(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `id_saldo` char(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `fk_user_1_idx` (`id_saldo`),
  CONSTRAINT `fk_user_1` FOREIGN KEY (`id_saldo`) REFERENCES `saldobalance` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('u-002','ana','1234',NULL),('u001','evi','1234','33');
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

-- Dump completed on 2020-06-07 10:53:17
