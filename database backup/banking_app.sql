-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: banking_app
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `acc_id_sequence`
--

DROP TABLE IF EXISTS `acc_id_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acc_id_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acc_id_sequence`
--

LOCK TABLES `acc_id_sequence` WRITE;
/*!40000 ALTER TABLE `acc_id_sequence` DISABLE KEYS */;
INSERT INTO `acc_id_sequence` VALUES (100011);
/*!40000 ALTER TABLE `acc_id_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` bigint NOT NULL,
  `account_name` varchar(255) NOT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6kplolsdtr3slnvx97xsy2kc8` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (100009,'Marcus','4298048918492941',3000,'2026-10-09 08:48:59.354477'),(100010,'Daniel','2105055102382093',2000,'2026-10-09 09:00:02.140197');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` float DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  `transaction_type` enum('DEPOSIT','TRANSFER','WITHDRAW') DEFAULT NULL,
  `reference_account` varchar(255) DEFAULT NULL,
  `transaction_reference` varchar(255) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `balance` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2u05e77l3gh3l82xcjk2iyhr2` (`account_number`),
  CONSTRAINT `FK2u05e77l3gh3l82xcjk2iyhr2` FOREIGN KEY (`account_number`) REFERENCES `accounts` (`account_number`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,150.99,'2026-10-07 14:08:48.262266','DEPOSIT',NULL,'TXN-001','1',NULL),(2,1500,'2026-10-07 14:42:21.179904','DEPOSIT',NULL,'TXN-002','1',NULL),(3,1500,'2026-10-07 14:42:21.894933','DEPOSIT',NULL,'TXN-003','1',NULL),(4,2000,'2026-10-07 14:42:39.451956','WITHDRAW',NULL,'TXN-004','1',NULL),(5,200,'2026-10-07 14:44:43.050345','TRANSFER','2','TXN-005','1',NULL),(6,1,'2026-10-07 14:49:00.692993','TRANSFER','1','TXN-006','2',NULL),(7,10,'2026-10-08 14:34:27.859053','DEPOSIT',NULL,'TXN-007','1',NULL),(8,500,'2026-10-09 09:14:06.293119','DEPOSIT',NULL,'TXN-008','2105055102382093',NULL),(9,2500,'2026-10-09 09:23:37.915614','WITHDRAW',NULL,'TXN-009','4298048918492941',NULL),(10,2500,'2026-10-09 09:24:17.095599','DEPOSIT',NULL,'TXN-010','4298048918492941',NULL),(11,2500,'2026-10-09 09:25:46.342255','WITHDRAW',NULL,'TXN-011','4298048918492941',NULL),(12,500,'2026-10-09 09:55:37.259272','TRANSFER','4298048918492941','TXN-012','2105055102382093',NULL),(13,500,'2026-10-09 12:03:39.721724','DEPOSIT',NULL,'TXN-013','2105055102382093',2000);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-09 13:42:23
