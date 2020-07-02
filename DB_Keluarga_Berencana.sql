/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.5.5-10.1.37-MariaDB : Database - db_keluarga_berencana
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
USE `db_keluarga_berencana`;

/*Table structure for table `list_kontrasepsi` */

DROP TABLE IF EXISTS `list_kontrasepsi`;

CREATE TABLE `list_kontrasepsi` (
  `Id_Kontrasepsi` int(11) NOT NULL AUTO_INCREMENT,
  `Nama_Kontrasepsi` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_Kontrasepsi`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `list_kontrasepsi` */

insert  into `list_kontrasepsi`(`Id_Kontrasepsi`,`Nama_Kontrasepsi`) values (1,'Pil');
insert  into `list_kontrasepsi`(`Id_Kontrasepsi`,`Nama_Kontrasepsi`) values (2,'Kondom');
insert  into `list_kontrasepsi`(`Id_Kontrasepsi`,`Nama_Kontrasepsi`) values (3,'IUD');

/*Table structure for table `list_propinsi` */

DROP TABLE IF EXISTS `list_propinsi`;

CREATE TABLE `list_propinsi` (
  `Id_Propinsi` int(11) NOT NULL AUTO_INCREMENT,
  `Nama_Propinsi` varchar(30) NOT NULL,
  PRIMARY KEY (`Id_Propinsi`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `list_propinsi` */

insert  into `list_propinsi`(`Id_Propinsi`,`Nama_Propinsi`) values (1,'Aceh');
insert  into `list_propinsi`(`Id_Propinsi`,`Nama_Propinsi`) values (2,'Sumatera Utara');
insert  into `list_propinsi`(`Id_Propinsi`,`Nama_Propinsi`) values (3,'Sumatera Barat');
insert  into `list_propinsi`(`Id_Propinsi`,`Nama_Propinsi`) values (4,'Riau');
insert  into `list_propinsi`(`Id_Propinsi`,`Nama_Propinsi`) values (5,'Kepulauan Riau');
insert  into `list_propinsi`(`Id_Propinsi`,`Nama_Propinsi`) values (6,'Jambi');
insert  into `list_propinsi`(`Id_Propinsi`,`Nama_Propinsi`) values (7,'Bangka Belitung');
insert  into `list_propinsi`(`Id_Propinsi`,`Nama_Propinsi`) values (8,'Sumatera Selatan');
insert  into `list_propinsi`(`Id_Propinsi`,`Nama_Propinsi`) values (9,'Lampung');

/*Table structure for table `list_pemakai_kontrasepsi` */

DROP TABLE IF EXISTS `list_pemakai_kontrasepsi`;

CREATE TABLE `list_pemakai_kontrasepsi` (
  `Id_List` int(11) NOT NULL AUTO_INCREMENT,
  `Id_Propinsi` int(11) NOT NULL,
  `Id_Kontrasepsi` int(11) NOT NULL,
  `Jumlah_Pemakai` int(11) NOT NULL,
  PRIMARY KEY (`Id_List`),
  KEY `FK_list_pemakai_kontrasepsi_id_kontrasepsi` (`Id_Kontrasepsi`),
  KEY `FK_list_pemakai_kontrasepsi_id_propinsi` (`Id_Propinsi`),
  CONSTRAINT `FK_list_pemakai_kontrasepsi_id_kontrasepsi` FOREIGN KEY (`Id_Kontrasepsi`) REFERENCES `list_kontrasepsi` (`Id_Kontrasepsi`),
  CONSTRAINT `FK_list_pemakai_kontrasepsi_id_propinsi` FOREIGN KEY (`Id_Propinsi`) REFERENCES `list_propinsi` (`Id_Propinsi`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Data for the table `list_pemakai_kontrasepsi` */

insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (1,1,1,50);
insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (2,1,2,66);
insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (3,1,3,25);
insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (4,2,1,100);
insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (5,2,2,75);
insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (6,2,3,50);
insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (7,1,2,40);
insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (8,2,2,65);
insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (9,3,1,90);
insert  into `list_pemakai_kontrasepsi`(`Id_List`,`Id_Propinsi`,`Id_Kontrasepsi`,`Jumlah_Pemakai`) values (10,3,2,80);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
