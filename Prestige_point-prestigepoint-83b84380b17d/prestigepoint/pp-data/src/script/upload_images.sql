/*
SQLyog Enterprise - MySQL GUI v7.15 
MySQL - 5.7.6-m16-log : Database - aartek14_prestigepoint_dbpro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`aartek14_prestigepoint_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `aartek14_prestigepoint_db`;

/*Table structure for table `upload_images` */

DROP TABLE IF EXISTS `upload_images`;

CREATE TABLE `upload_images` (
  `IMAGES_ID` int(60) NOT NULL AUTO_INCREMENT,
  `NAME_OF_IMAGES` varchar(60) DEFAULT NULL,
  `IS_DELETED` int(60) DEFAULT NULL,
  `IS_ACTIVE` int(60) DEFAULT NULL,
  PRIMARY KEY (`IMAGES_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
