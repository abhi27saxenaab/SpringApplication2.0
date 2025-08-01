-- MySQL dump 10.13  Distrib 5.5.41, for Win32 (x86)
--
-- Host: localhost    Database: book_management_system
-- ------------------------------------------------------
-- Server version	5.5.41

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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authors` (
  `author_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `biography` text,
  `date_of_birth` date DEFAULT NULL,
  `date_of_death` date DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'George','Orwell',NULL,'1903-06-25',NULL,'2025-08-01 07:11:36','0000-00-00 00:00:00'),(2,'J.K.','Rowling',NULL,'1965-07-31',NULL,'2025-08-01 07:11:36','0000-00-00 00:00:00'),(3,'Stephen','King',NULL,'1947-09-21',NULL,'2025-08-01 07:11:36','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author_id` int(11) NOT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  `isbn` varchar(20) NOT NULL,
  `publication_date` date DEFAULT NULL,
  `edition` varchar(20) DEFAULT NULL,
  `language` varchar(30) DEFAULT NULL,
  `page_count` int(11) DEFAULT NULL,
  `description` text,
  `cover_image` varchar(255) DEFAULT NULL,
  `quantity_in_stock` int(11) DEFAULT '0',
  `status` enum('available','checked_out','lost','damaged') DEFAULT 'available',
  `bookcondition` enum('new','good','fair','poor') DEFAULT 'good',
  `acquisition_date` date DEFAULT NULL,
  `acquisition_price` decimal(10,2) DEFAULT NULL,
  `barcode` varchar(50) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `isbn` (`isbn`),
  UNIQUE KEY `barcode` (`barcode`),
  KEY `author_id` (`author_id`),
  KEY `publisher_id` (`publisher_id`),
  KEY `genre_id` (`genre_id`),
  CONSTRAINT `books_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `authors` (`author_id`),
  CONSTRAINT `books_ibfk_2` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`publisher_id`),
  CONSTRAINT `books_ibfk_3` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'1984',1,1,1,'9780451524935',NULL,NULL,NULL,NULL,NULL,NULL,5,'available','good',NULL,NULL,NULL,'2025-08-01 07:11:51','0000-00-00 00:00:00'),(2,'Harry Potter and the Philosopher\'s Stone',2,2,2,'9780747532743',NULL,NULL,NULL,NULL,NULL,NULL,3,'available','good',NULL,NULL,NULL,'2025-08-01 07:11:51','0000-00-00 00:00:00'),(3,'The Shining',3,3,3,'9780307743657',NULL,NULL,NULL,NULL,NULL,NULL,2,'available','good',NULL,NULL,NULL,'2025-08-01 07:11:51','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genres`
--

DROP TABLE IF EXISTS `genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genres` (
  `genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genres`
--

LOCK TABLES `genres` WRITE;
/*!40000 ALTER TABLE `genres` DISABLE KEYS */;
INSERT INTO `genres` VALUES (1,'Science Fiction',NULL,'2025-08-01 07:11:45','0000-00-00 00:00:00'),(2,'Fantasy',NULL,'2025-08-01 07:11:45','0000-00-00 00:00:00'),(3,'Horror',NULL,'2025-08-01 07:11:45','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publishers`
--

DROP TABLE IF EXISTS `publishers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publishers` (
  `publisher_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address` text,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `website` varchar(100) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`publisher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publishers`
--

LOCK TABLES `publishers` WRITE;
/*!40000 ALTER TABLE `publishers` DISABLE KEYS */;
INSERT INTO `publishers` VALUES (1,'Penguin Books',NULL,NULL,NULL,'https://www.penguin.co.uk','2025-08-01 07:11:41','0000-00-00 00:00:00'),(2,'Bloomsbury',NULL,NULL,NULL,'https://www.bloomsbury.com','2025-08-01 07:11:41','0000-00-00 00:00:00'),(3,'Simon & Schuster',NULL,NULL,NULL,'https://www.simonandschuster.com','2025-08-01 07:11:41','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `publishers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `checkout_date` datetime NOT NULL,
  `due_date` datetime NOT NULL,
  `return_date` datetime DEFAULT NULL,
  `status` enum('checked_out','returned','overdue','lost') DEFAULT 'checked_out',
  `notes` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`transaction_id`),
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,1,1,'2025-08-01 00:14:41','2025-08-15 00:14:41',NULL,'checked_out',NULL,'2025-08-01 07:14:41','0000-00-00 00:00:00'),(2,2,2,'2025-08-01 00:14:41','2025-08-15 00:14:41',NULL,'checked_out',NULL,'2025-08-01 07:14:41','0000-00-00 00:00:00'),(3,1,3,'2023-05-15 10:00:00','2023-05-29 10:00:00','2023-05-28 14:30:00','returned',NULL,'2025-08-01 07:14:41','0000-00-00 00:00:00'),(4,3,1,'2023-06-01 11:00:00','2023-06-15 11:00:00',NULL,'overdue',NULL,'2025-08-01 07:14:41','0000-00-00 00:00:00'),(5,2,3,'2023-04-10 09:30:00','2023-04-24 09:30:00',NULL,'lost',NULL,'2025-08-01 07:14:41','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` text,
  `date_of_birth` date DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  `membership_type` enum('regular','premium','staff','admin') DEFAULT 'regular',
  `status` enum('active','inactive','suspended') DEFAULT 'active',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'John','Doe','john.doe@example.com',NULL,NULL,NULL,NULL,'regular','active','2025-08-01 07:11:58','0000-00-00 00:00:00'),(2,'Jane','Smith','jane.smith@example.com',NULL,NULL,NULL,NULL,'regular','active','2025-08-01 07:11:58','0000-00-00 00:00:00'),(3,'Robert','Johnson','robert.johnson@example.com',NULL,NULL,NULL,NULL,'regular','active','2025-08-01 07:11:58','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-01  0:29:17
