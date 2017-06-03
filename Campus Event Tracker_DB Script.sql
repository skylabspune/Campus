/*
SQLyog Community v12.16 (32 bit)
MySQL - 5.1.44-community : Database - campuseventtracker
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`campuseventtracker` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `campuseventtracker`;

/*Table structure for table `event_info` */

DROP TABLE IF EXISTS `event_info`;

CREATE TABLE `event_info` (
  `eventId` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `eventName` char(50) DEFAULT NULL,
  PRIMARY KEY (`eventId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `event_info` */

insert  into `event_info`(`eventId`,`latitude`,`longitude`,`time`,`eventName`) values 
(1,12.12,22.22,'2016-02-25 08:13:47','event2'),
(2,44.454,21.456,'2016-02-25 08:16:20','event3'),
(3,44.454,21.456,'2016-02-25 08:18:18','event4'),
(4,33.33,11.11,'2016-02-25 08:18:51','event1'),
(5,98,98,'2016-02-27 15:58:43','kjfsdfj'),
(6,65,65,'2016-02-27 15:59:32','jfgsjk'),
(7,87,65,'2016-02-27 16:00:09','iasodu'),
(8,56,65,'2016-02-27 16:01:39','lksdfj'),
(9,87,787,'2016-02-27 16:04:20','jkgskldj'),
(10,76.767,56.87,'2016-03-24 23:56:00','dskjdfk'),
(11,45.65,23.456,'2016-03-01 01:59:00','kldfja'),
(12,76.45,767.76,'2016-03-24 14:12:00','dsfjk'),
(13,65,76.67,'2016-03-12 01:56:00','sdfjh'),
(14,767.8768,765.786,'2016-04-06 23:00:00','kljds');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
