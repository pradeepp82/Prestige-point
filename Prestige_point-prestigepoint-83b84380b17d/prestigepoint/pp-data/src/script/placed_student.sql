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

/*Table structure for table `placed_student` */

DROP TABLE IF EXISTS `placed_student`;

CREATE TABLE `placed_student` (
  `STUDENT_ID` int(30) NOT NULL auto_increment,
  `COMPANY_NAME` varchar(250) default NULL,
  `PACKAGE` varchar(30) default NULL,
  `JOINING_DATE` varchar(250) default NULL,
  `RELEASE_DATE_FROM_AARTEK` varchar(250) default NULL,
  `JOB_LOCATION` varchar(250) default NULL,
  `EXPERIENCE` varchar(30) default NULL,
  `YEAR` varchar(30) default NULL,
  `IS_DELETED` int(30) default NULL,
  `REGISTRATION_ID` int(30) NOT NULL,
  PRIMARY KEY  (`STUDENT_ID`),
  KEY `REGISTRATION_ID` (`REGISTRATION_ID`),
  CONSTRAINT `placed_student_ibfk_1` FOREIGN KEY (`REGISTRATION_ID`) REFERENCES `registration` (`REGISTRATION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
