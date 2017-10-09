/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.7.8-rc-log : Database - aartek14_prestigepoint_dbpro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`aartek14_prestigepoint_dbpro` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `aartek14_prestigepoint_dbpro`;

/*Table structure for table `placed_student_fee_structure` */

DROP TABLE IF EXISTS `placed_student_fee_structure`;

CREATE TABLE `placed_student_fee_structure` (
  `PLACED_STUDENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTACT_NUMBER` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `SUBMITED_FEE` varchar(255) DEFAULT NULL,
  `TOTLE_FEE` varchar(255) DEFAULT NULL,
  `REMAINING_FEE` varchar(255) DEFAULT NULL,
  `IS_DELETED` int(10) DEFAULT NULL,
  `STUDENT_PACKAGE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`PLACED_STUDENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
