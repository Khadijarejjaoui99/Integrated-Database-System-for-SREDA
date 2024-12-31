-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: kyoto
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data` (
  `ID` varchar(10) DEFAULT NULL,
  `SubSector` varchar(25) DEFAULT NULL,
  `Code` varchar(25) DEFAULT NULL,
  `Type` varchar(25) DEFAULT NULL,
  `Equipment` varchar(25) DEFAULT NULL,
  `Qty` int DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `UnitPrice` double DEFAULT NULL,
  `ProjectPrice` double DEFAULT NULL,
  `Name` varchar(25) DEFAULT NULL,
  `IFI` varchar(25) DEFAULT NULL,
  `Status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
INSERT INTO `data` VALUES ('AF17103001','Spinning','3.1.1','Spinning','Roving Frame',5,86.4,17.28,517.3,'Pahartali','BIFFL','Subproject'),('AF17103001','Spinning','3.1.3','Spinning','Winder',14,176.6,12.61429,517.3,'Pahartali','BIFFL','Subproject'),('AF17103001','Spinning','3.1.4','Spinning','Air jet Spinning',6,211.4,35.23333,517.3,'Pahartali','BIFFL','Subproject'),('AF17103001','Spinning','9.8.1(2)','Air Conditioner','Absorption Chiller',2,29.2,14.6,517.3,'Pahartali','BIFFL','Subproject'),('AF17103001','Spinning','9.10.1','LED','LED',3020,2.8,0.000927,517.3,'Pahartali','BIFFL','Subproject'),('AF17103001','Spinning','9.12.2','Waste Heat Recovery','Exhaust gas boiler',1,10.9,10.9,517.3,'Pahartali','BIFFL','Subproject'),('AD18081601','Garments','3.3','Sewing Machine','Sewing Machine',1464,169.1,0.115505,169.1,'Fakir','BIFFL','NOC'),('AF18080901','Spinning','3.1(3)','Spinning','Winder',8,116.5,14.5625,116.5,'Bandhab','BIFFL','Pipeline'),('AD18070101','Spinning','9.10.1','LED','LED',5000,1.3,0.00026,85.5,'Etafil','BIFFL','Subproject'),('AD18070101','Spinning','9.11.1','Gas Engine Cogeneration','Generator',2,56.7,12,28.35,'Etafil','BIFFL','Subproject'),('AD18070101','Spinning','9.8.1(2)','Air Conditioner','Absorption Chiller',2,56.7,12,28.35,'Etafil','BIFFL','Subproject'),('AF17083101','Spinning','3.1(1)','Spinning','Roving Frame',4,41.4,10.35,253.9,'Aman','BIFFL','NOC'),('AF17083101','Spinning','3.1(2)','Spinning','Ring spinnig',9,123.6,11,13.73333,'Aman','BIFFL','NOC'),('AF17083101','Spinning','3.1 (3)','Spinning','Winder',4,58.5,14.625,12,'Aman','BIFFL','NOC'),('AF17083101','Spinning','9.8.1 (2)','Air Conditioner','Absorption Chiller',3,1,30.4,30.4,'Aman','BIFFL','NOC'),('AD17050301','Cement','5.1','VRM','VRM',1,734,734,734,'Sung Shing Cement','BIFFL','NOC'),('AF17041901','Electronic',' 9.4.2(2)','Air Compressor','Air Compressor',1,10.5,10.5,10.5,'Fair Eletronics','BIFFL','Subproject'),('AD17041201','Cement',' 5.1','VRM','VRM',1,1270,1270,1270,'Meghna','IDCOL','Pipeline'),('AF15100301','Garments',' 3.3','Sewing Machine','Sewing Machine',3045,559.1,0.183612,753.5,'Odyssey Craft','IDCOL','Pipeline'),('AF15100301','Garments','9.4.1(1)','Air Compressor','Air Compressor',4,38.4,9.6,753.5,'Odyssey Craft','IDCOL','Pipeline'),('AF15100301','Garments',' 9.8.1','Air Conditioner','Air Conditioner',6,150,25,753.5,'Odyssey Craft','IDCOL','Pipeline'),('AF15100301','Garments','9.10.1','LED','LED',7500,6,0.0008,753.5,'Odyssey Craft','IDCOL','Pipeline'),('AD19040401','Garments',' 3.3','Sewing Machine','Sewing Machine',4295,791.6,0.184307,805.4,'Pacific Blue','IDCOL','Pipeline'),('AD19040401','Garments',' 9.4.1(1)','Air Compressor','Air Compressor',1,8.9,8.9,805.4,'Pacific Blue','IDCOL','Pipeline'),('AD19040401','Garments','9.6.2','Boiler','Boiler',1,4.9,4.9,805.4,'Pacific Blue','IDCOL','Pipeline'),('AF17120401','Spinning','3.1(1)','Spinning','Roving Frame',8,113,14.125,983,'Roshowa','IDCOL','NOC'),('AF17120401','Spinning',' 3.1(2)','Spinning','Ring spinnig',32,531,16.59375,983,'Roshowa','IDCOL','NOC'),('AF17120401','Spinning','3.1(3)','Spinning','Winder',32,339,10.59375,983,'Roshowa','IDCOL','NOC'),('AD19020301','Paper','2.2','De-inking Plant','De-inking Plant',1,223.7,223.7,223.7,'Modhumoti','IDCOL','Pipeline'),('AD19020302','Garments','3.3','Sewing Machine','Sewing Machine',757,353.5,0.466975,413.2,'Vertex','IDCOL','NOC'),('AD19020302','Garments','9.4.2(2)','Air Compressor','Air Compressor',4,9.6,2.4,413.2,'Vertex','IDCOL','NOC'),('AD19020302','Garments','9.6.2','Boiler','Boiler',6,50.1,8.35,413.2,'Vertex','IDCOL','NOC'),('AF19091501','Cement',' 5.1','VRM','VRM',1,1000,1000,1000,'Confidence','IDCOL','Pipeline'),('AD19073101','Garments','3.3','Sewing Machine','Sewing Machine',7524,938.892346,0.124786,1000.186683,'Snowtex','IDCOL','Pipeline'),('AD19073101','Garments','9.4.2','Air Compressor','Air Compressor',3,3.42252645,1.140842,1000.186683,'Snowtex','IDCOL','Pipeline'),('AD19073101','Garments','9.6.2','Boiler','Boiler',2,11.6365899,5.818295,1000.186683,'Snowtex','IDCOL','Pipeline'),('AD19073101','Garments','9.8.1','Air Conditioner','Air Conditioner',5,4.04480398,0.808961,1000.186683,'Snowtex','IDCOL','Pipeline'),('AD19073101','Garments','9.10.1','LED','LED',25000,17.8593653,0.000714,1000.186683,'Snowtex','IDCOL','Pipeline'),('AD19073101','Garments','2.00.0','Lift','Lift',5,24.3310516,4.86621,1000.186683,'Snowtex','IDCOL','Pipeline'),('AF19052101','Spinning','3.1(3)','Spinning','Winder',35,368.4,10.52571,368.4,'Asia Composite','IDCOL','Pipeline'),('AF19031901','Spinning','3.1 (3)','Spinning','Winder',10,190.2,19.02,190.2,'GreenTex','IDCOL','NOC'),('AD18081401','Garments','3.3','Sewing Machine','Sewing Machine',224,11.1,0.049554,11.1,'Giant','IDCOL','Pipeline'),('AD19092201','Spinning','3.1(1)','Spinning','Roving Frame',11,123.118354,11.19258,1058.864549,'Hamid','IDCOL','NOC'),('AD19092201','Spinning','3.1(2)','Spinning','Ring spinnig',30,510.63389,17.02113,1058.864549,'Hamid','IDCOL','NOC'),('AD19092201','Spinning','3.1(3)','Spinning','Winder',30,203.35589,6.77853,1058.864549,'Hamid','IDCOL','NOC'),('AD19092201','Spinning','3.5','Heat Exchanger','Heat Exchanger',2,20.0939097,10.04695,1058.864549,'Hamid','IDCOL','NOC'),('AD19092201','Spinning','9.6.2','Boiler','Boiler',3,11.4625052,3.820835,1058.864549,'Hamid','IDCOL','NOC'),('AD19092201','Spinning','9.8.1(2)','Air Conditioner','Absorption Chiller',5,190.2,38.04,1058.864549,'Hamid','IDCOL','NOC'),('AF17041901','Electronic','9.4.2 (2)','Air Compressor','Air Compressor',1,10.5,10.5,10.5,'Fair Eletronics','BIFFL','Subproject');
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-04 21:07:06
