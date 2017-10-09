/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.0.24-community-nt : Database - aartek14_prestigepoint_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`aartek14_prestigepoint_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `aartek14_prestigepoint_db`;

/*Table structure for table `add_challenge` */

DROP TABLE IF EXISTS `add_challenge`;

CREATE TABLE `add_challenge` (
  `CHALLENGE_ID` int(80) NOT NULL auto_increment,
  `TITLE` varchar(80) default NULL,
  `DISCRIPTION` varchar(80) default NULL,
  `PRICE` float(80,2) default NULL,
  `CHALLENGE_CONDITION` varchar(80) default NULL,
  `DURATION` varchar(80) default NULL,
  `TECHNOLOGY` varchar(80) default NULL,
  `IS_DELETED` int(80) default NULL,
  PRIMARY KEY  (`CHALLENGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
USE `aartek14_prestigepoint_db`;

/*Table structure for table `add_challenge` */

DROP TABLE IF EXISTS `add_challenge`;

CREATE TABLE `add_challenge` (
  `CHALLENGE_ID` int(80) NOT NULL auto_increment,
  `TITLE` varchar(250) default NULL,
  `DISCRIPTION` varchar(10000) default NULL,
  `PRICE` float(80,2) default NULL,
  `CHALLENGE_CONDITION` varchar(1000) default NULL,
  `DURATION` varchar(1000) default NULL,
  `TECHNOLOGY` varchar(1000) default NULL,
  `IS_DELETED` int(80) default NULL,
  `IS_ACTIVE` int(80) default NULL,
  PRIMARY KEY  (`CHALLENGE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

