-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: detranrecords
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `artist`
--

DROP TABLE IF EXISTS `artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artist` (
  `id` bigint NOT NULL,
  `nameArtist` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (6,'pH-1'),(7,'Văn Mai Hương'),(8,'Taylor Swift'),(9,'Travis Scott'),(10,'Vũ'),(11,'Bruno Mars'),(12,'OneRepublic'),(13,'Ngọt'),(14,'Rosé'),(15,'The Weeknd'),(16,'Post Malone'),(17,'H1GHR MUSIC'),(18,'Kendrick Lamar'),(19,'Cá Hồi Hoang'),(20,'Colde'),(21,'Justin Bieber'),(22,'DPR Ian'),(23,'Zico'),(24,'The Chainsmokers'),(25,'Drake'),(26,'Trang'),(27,'Tiên Tiên'),(28,'Epik High');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `id` bigint NOT NULL,
  `genreName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (32,'Pop'),(33,'Rock'),(34,'R&B'),(35,'HipHop'),(36,'Country'),(37,'EDM'),(38,'Indie'),(39,'Jazz');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (162);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nation`
--

DROP TABLE IF EXISTS `nation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nation` (
  `id` bigint NOT NULL,
  `nation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nation`
--

LOCK TABLES `nation` WRITE;
/*!40000 ALTER TABLE `nation` DISABLE KEYS */;
INSERT INTO `nation` VALUES (29,'Việt Nam'),(30,'Mỹ'),(31,'Hàn Quốc');
/*!40000 ALTER TABLE `nation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL,
  `customerAddress` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `customerEmail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `customerName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `customerPhone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `dateTime` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `delivery` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `orderCode` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `vinyl_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf7dqwetawldcw87rxnxo1hc9t` (`vinyl_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (148,'abcxyz','trantrongdai308@gmai.com','trần trọng đại','0123456789','2021-11-01 13:11:50','Giao hàng thành công','20211101131150147',33.99,1,72),(155,'123 abc, xyz','trantrongdai308@gmail.com','trần trọng đại ','0123456789','2021-11-01 22:56:27','Đang xử lý','20211101225627155',59.95,5,71),(156,'Gotham City','batman123@gmail.com','Bruce Wayne','0123456789','2021-11-02 09:06:14','Đang xử lý','20211102090614156',23.98,2,71),(157,'Gotham City','batman123@gmail.com','Bruce Wayne','0123456789','2021-11-02 09:37:27','Đang xử lý','20211102093727157',11.99,1,71),(158,'Gotham City','batman123@gmail.com','Bruce Wayne','0123456789','2021-11-02 09:53:02','Đang xử lý','20211102095302158',35.97,3,71);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `roleName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER'),(2,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `track` (
  `id` bigint NOT NULL,
  `trackName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vinyl_id` bigint DEFAULT NULL,
  `artists` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `trackPreview` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsak9gf22njsuoaue6d02igckq` (`vinyl_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
INSERT INTO `track` VALUES (102,'BLAME MY CIRCLE',71,'pH-1 (feat. JUSTHIS, Owen)','trackPreview\\X-pH-1\\BLAME MY CIRCLE-pH-1 (feat. JUSTHIS, Owen).mp3'),(103,'MEET N GREET',71,'pH-1 (Feat. Kid Milli) ','trackPreview\\X-pH-1\\MEET N GREET-pH-1 (Feat. Kid Milli) .mp3'),(104,'OKAY',71,'pH-1 (Feat. Simon Dominic, MUSHVENOM)','trackPreview\\X-pH-1\\OKAY-pH-1 (Feat. Simon Dominic, MUSHVENOM).mp3'),(105,'PACKITUP!',71,'pH-1','trackPreview\\X-pH-1\\PACKITUP!-pH-1.mp3'),(106,'TELÉFONO',71,'pH-1 (Feat. HAON, Woodie Gochild, Jay Park, Sik-K)','trackPreview\\X-pH-1\\TELÉFONO-pH-1 (Feat. HAON, Woodie Gochild, Jay Park, Sik-K).mp3'),(107,'FRONTIN',71,'pH-1','trackPreview\\X-pH-1\\ANYMORE-pH-1 (Feat. ASH ISLAND).mp3'),(108,'ANYMORE',71,'pH-1 (Feat. ASH ISLAND)','trackPreview\\X-pH-1\\ANYMORE-pH-1 (Feat. ASH ISLAND).mp3'),(109,'I CAN TELL',71,'pH-1 (Feat. BRADYSTREET, Verbal Jint)','trackPreview\\X-pH-1\\I CAN TELL-pH-1 (Feat. BRADYSTREET, Verbal Jint).mp3'),(110,'MORAGO',71,'pH-1 (Feat. Blase, Coogie)','trackPreview\\X-pH-1\\MORAGO-pH-1 (Feat. Blase, Coogie).mp3'),(111,'DRESSING ROOM',71,'pH-1','trackPreview\\X-pH-1\\DRESSING ROOM-pH-1.mp3'),(139,'Cách mình xa nhau',95,'Trang','trackPreview\\Tỉnh giấc khi ông trời đang ngủ-Trang\\Cách mình xa nhau-Trang.mp3'),(140,'Chẳng một ai thấy',95,'Trang','trackPreview\\Tỉnh giấc khi ông trời đang ngủ-Trang\\Chẳng một ai thấy-Trang.mp3'),(141,'Đừng hát về cơn mưa',95,'Trang, Madihu, Mac Mai Suong','trackPreview\\Tỉnh giấc khi ông trời đang ngủ-Trang\\Đừng hát về cơn mưa-Trang, Madihu, Mac Mai Suong.mp3');
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track_artist`
--

DROP TABLE IF EXISTS `track_artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `track_artist` (
  `Track_id` bigint NOT NULL,
  `artists_id` bigint NOT NULL,
  KEY `FKi4ejqu0y9tder10sw8udlrwtf` (`artists_id`),
  KEY `FKnxywtr79jc85sf8kmcefckuhj` (`Track_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `track_artist`
--

LOCK TABLES `track_artist` WRITE;
/*!40000 ALTER TABLE `track_artist` DISABLE KEYS */;
/*!40000 ALTER TABLE `track_artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phoneNumber` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `userName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'Gotham City','batman123@gmail.com','Bruce Wayne','$2a$10$zOF3yiNshRnF6t8Qt8jW.eLzIqhVP0SMQqCv64PmS/.swVqMIzncS','0123456789','Batman'),(4,'Gotham City','ironman123@gmail.com','Tony Start','$2a$10$mIo0/oENQAyK/XmbCWRSa.g7DHahib64m8vGOt9Tz/vFsM2JDYR/u','0123456789','Ironman'),(5,'Gotham City','captainamerican@gmail.com','Steve Roger','$2a$10$WYVJ1oILV6LLiOvYe4guluN8xUb7EfNqeSthSBuFFEa39xB0sV2Qa','0123456789','CaptainA'),(40,'Metrol City','superman123@gmail.com','Clark Kent','$2a$10$Z2m/m2UcH3oNZOBFmqY9K.Wdz4IU4nIdC0X7yal5uMRp9FooMRyUy','0123456789','Superman'),(41,'Barcelona','messi123@gmail.com','Lionel Messi','$2a$10$t7OCtFvIKjZAXVmPqpjHNOhOGT1tN.jcVKWFT93a5.W53Wr.jY5JO','0123456789','M10');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `User_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  KEY `FK7qnwwe579g9frolyprat52l4d` (`roles_id`),
  KEY `FKc52d1rv3ijbpu6lo2v3rej1tx` (`User_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (3,1),(3,2),(5,1),(40,1),(41,1),(42,1),(43,1),(44,1),(48,1),(53,1),(4,2),(4,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vinyl`
--

DROP TABLE IF EXISTS `vinyl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vinyl` (
  `id` bigint NOT NULL,
  `discount` bigint DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `realPrice` float DEFAULT NULL,
  `thumbnail1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `thumbnail2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vinylName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `artist_id` bigint DEFAULT NULL,
  `nation_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqane2rj43cd3fxbyk987flwep` (`artist_id`),
  KEY `FKi0vjqkgee0yupxy906rmc49ib` (`nation_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vinyl`
--

LOCK TABLES `vinyl` WRITE;
/*!40000 ALTER TABLE `vinyl` DISABLE KEYS */;
INSERT INTO `vinyl` VALUES (71,0,11.99,9,11.99,'images\\vinylsImage\\X - pH-1\\1.jpg','images\\vinylsImage\\X - pH-1\\2.jpg','X',6,31),(72,0,33.99,35,33.99,'images\\vinylsImage\\hương - Văn Mai Hương\\1.jpg','images\\vinylsImage\\hương - Văn Mai Hương\\2.jpg','hương',7,29),(73,0,45,7,45,'images\\vinylsImage\\1989 - Taylor Swift\\1.jpg','images\\vinylsImage\\1989 - Taylor Swift\\2.jpg','1989',8,30),(74,0,50.5,0,50.5,'images\\vinylsImage\\ASTROWORLD - Travis Scott\\1.jpg','images\\vinylsImage\\ASTROWORLD - Travis Scott\\2.jpg','ASTROWORLD',9,30),(75,0,22,4,22,'images\\vinylsImage\\Vũ trụ song song - Vũ\\1.jpg','images\\vinylsImage\\Vũ trụ song song - Vũ\\2.jpg','Vũ trụ song song',10,29),(77,5,55.49,5,52.72,'images\\vinylsImage\\24K Magic - Bruno Mars\\1.jpg','images\\vinylsImage\\24K Magic - Bruno Mars\\2.jpg','24K Magic',11,30),(78,0,12,18,12,'images\\vinylsImage\\Human - OneRepublic\\1.jpg','images\\vinylsImage\\Human - OneRepublic\\2.jpg','Human',12,30),(79,0,23,10,23,'images\\vinylsImage\\3 (Tuyển Tập Nhạc Ngọt Mới Trẻ Sôi Động 2019) - Ngọt\\1.jpg','images\\vinylsImage\\3 (Tuyển Tập Nhạc Ngọt Mới Trẻ Sôi Động 2019) - Ngọt\\2.jpg','3 (Tuyển Tập Nhạc Ngọt Mới Trẻ Sôi Động 2019)',13,29),(80,0,23.99,9,23.99,'images\\vinylsImage\\-R- - Rosé\\1.png','images\\vinylsImage\\-R- - Rosé\\2.png','-R-',14,31),(81,7,23,12,21.39,'images\\vinylsImage\\BLUE TAPE - H1GHR MUSIC\\1.jpg','images\\vinylsImage\\BLUE TAPE - H1GHR MUSIC\\2.jpg','BLUE TAPE',17,31),(82,0,44,45,44,'images\\vinylsImage\\DAMN - Kendrick Lamar\\1.jpg','images\\vinylsImage\\DAMN - Kendrick Lamar\\2.jpg','DAMN',18,30),(83,50,1000,13,500,'images\\vinylsImage\\Epik High Is Here - Epik High\\1.png','images\\vinylsImage\\Epik High Is Here - Epik High\\2.jpg','Epik High Is Here',28,31),(84,0,11.99,4,11.99,'images\\vinylsImage\\Gấp gáp - Cá Hồi Hoang\\1.jpg','images\\vinylsImage\\Gấp gáp - Cá Hồi Hoang\\2.jpg','Gấp gáp',19,29),(85,0,23,23,23,'images\\vinylsImage\\Hiệu ứng chạy trốn - Cá Hồi Hoang\\1.jpg','images\\vinylsImage\\Hiệu ứng chạy trốn - Cá Hồi Hoang\\2.jpg','Hiệu ứng chạy trốn',19,29),(86,0,55,33,55,'images\\vinylsImage\\Hollywood Bleeding - Post Malone\\1.jpg','images\\vinylsImage\\Hollywood Bleeding - Post Malone\\2.jpg','Hollywood Bleeding',16,30),(87,23,13,42,10.01,'images\\vinylsImage\\idealism - Colde\\1.jpg','images\\vinylsImage\\idealism - Colde\\2.jpg','idealism',20,31),(88,10,23,21,20.7,'images\\vinylsImage\\Justice - Justin Bieber\\1.jpg','images\\vinylsImage\\Justice - Justin Bieber\\2.jpg','Justice',21,30),(89,0,18,33,18,'images\\vinylsImage\\Moodswings In This Order - DPR Ian\\1.jpg','images\\vinylsImage\\Moodswings In This Order - DPR Ian\\2.jpg','Moodswings In This Order',22,31),(90,0,32,0,32,'images\\vinylsImage\\Random Box - Zico\\1.jpg','images\\vinylsImage\\Random Box - Zico\\2.jpg','Random Box',23,31),(91,6,22,10,20.68,'images\\vinylsImage\\RED TAPE - H1GHR MUSIC\\1.jpg','images\\vinylsImage\\RED TAPE - H1GHR MUSIC\\2.jpg','RED TAPE',17,31),(92,0,44,14,44,'images\\vinylsImage\\Sick Boy - The Chainsmokers\\1.png','images\\vinylsImage\\Sick Boy - The Chainsmokers\\2.jpg','Sick Boy',24,30),(93,5,21.99,12,20.89,'images\\vinylsImage\\Stoney - Post Malone\\1.jpg','images\\vinylsImage\\Stoney - Post Malone\\2.jpg','Stoney',16,30),(94,0,22.99,1,22.99,'images\\vinylsImage\\Thank Me Later - Drake\\1.jpg','images\\vinylsImage\\Thank Me Later - Drake\\2.jpg','Thank Me Later',25,30),(95,0,1999.99,0,1999.99,'images\\vinylsImage\\Tỉnh giấc khi ông trời đang ngủ - Trang\\1.jpg','images\\vinylsImage\\Tỉnh giấc khi ông trời đang ngủ - Trang\\2.jpg','Tỉnh giấc khi ông trời đang ngủ',26,29),(125,0,12,23,12,'images\\vinylsImage\\CHILL with me - Tiên Tiên\\asdfasdf.png','images\\vinylsImage\\CHILL with me - Tiên Tiên\\2.png','CHILL with me',27,29);
/*!40000 ALTER TABLE `vinyl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vinyl_genre`
--

DROP TABLE IF EXISTS `vinyl_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vinyl_genre` (
  `Vinyl_id` bigint NOT NULL,
  `genres_id` bigint NOT NULL,
  KEY `FKbvx9m6huu3w0cfeha6sixojay` (`genres_id`),
  KEY `FKak5c7bocb29hbjj5s3nh4ldq8` (`Vinyl_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vinyl_genre`
--

LOCK TABLES `vinyl_genre` WRITE;
/*!40000 ALTER TABLE `vinyl_genre` DISABLE KEYS */;
INSERT INTO `vinyl_genre` VALUES (71,35),(72,32),(72,34),(73,36),(73,32),(74,35),(75,32),(77,34),(77,32),(78,33),(79,32),(80,32),(81,34),(81,35),(82,35),(83,35),(84,38),(85,38),(86,35),(86,34),(87,35),(87,34),(88,35),(88,34),(88,32),(89,35),(89,34),(90,35),(91,35),(92,33),(93,34),(93,35),(94,35),(95,38),(95,32),(97,35),(98,35),(99,35),(100,35),(101,35),(112,32),(114,32),(125,34),(125,35);
/*!40000 ALTER TABLE `vinyl_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vinyl_track`
--

DROP TABLE IF EXISTS `vinyl_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vinyl_track` (
  `Vinyl_id` bigint NOT NULL,
  `tracks_id` bigint NOT NULL,
  UNIQUE KEY `UK_j58p5umqw0e6iipl374cafc2j` (`tracks_id`),
  KEY `FK5akigan754k7nciqkknqacevr` (`Vinyl_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vinyl_track`
--

LOCK TABLES `vinyl_track` WRITE;
/*!40000 ALTER TABLE `vinyl_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `vinyl_track` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-09 17:25:17
