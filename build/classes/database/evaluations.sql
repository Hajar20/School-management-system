-- phpMyAdmin SQL Dump
-- version 2.11.5
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Mar 18, 2023 at 02:52 PM
-- Server version: 5.0.51
-- PHP Version: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `evaluations`
--

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

CREATE TABLE `classe` (
  `idClass` int(10) NOT NULL auto_increment,
  `idF` int(10) default NULL,
  `Niveau` varchar(255) character set utf8 default NULL,
  PRIMARY KEY  (`idClass`),
  KEY `FKClasse348599` (`idF`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`idClass`, `idF`, `Niveau`) VALUES
(1, 1, '1ere annee'),
(2, 1, '2eme annee'),
(3, 2, '1ere annee'),
(4, 2, '2eme annee');

-- --------------------------------------------------------

--
-- Table structure for table `classens`
--

CREATE TABLE `classens` (
  `idClass` int(10) NOT NULL,
  `idUser` int(10) NOT NULL,
  PRIMARY KEY  (`idClass`,`idUser`),
  KEY `FKClassEns407937` (`idClass`),
  KEY `FKClassEns642627` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classens`
--

INSERT INTO `classens` (`idClass`, `idUser`) VALUES
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(2, 2),
(2, 3),
(2, 5),
(2, 15),
(3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `classeunite`
--

CREATE TABLE `classeunite` (
  `idClass` int(11) NOT NULL default '0',
  `idUni` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idClass`,`idUni`),
  KEY `idUni` (`idUni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classeunite`
--

INSERT INTO `classeunite` (`idClass`, `idUni`) VALUES
(1, 1),
(2, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 7),
(2, 8),
(2, 9),
(3, 10),
(4, 11);

-- --------------------------------------------------------

--
-- Table structure for table `contrÃ´lecontinu`
--

CREATE TABLE `contrôlecontinu` (
  `idCc` int(10) NOT NULL auto_increment,
  `idUser` int(10) default NULL,
  `idMod` int(10) default NULL,
  `Date_Cc` date default NULL,
  `idClass` int(11) default NULL,
  PRIMARY KEY  (`idCc`),
  KEY `Avoir` (`idMod`),
  KEY `Accomplir` (`idUser`),
  KEY `idClass` (`idClass`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `contrÃ´lecontinu`
--

INSERT INTO `contrôlecontinu` (`idCc`, `idUser`, `idMod`, `Date_Cc`, `idClass`) VALUES
(8, 3, 8, '2020-07-25', 1),
(9, 3, 7, '2020-07-02', 2);

-- --------------------------------------------------------

--
-- Table structure for table `etudclass`
--

CREATE TABLE `etudclass` (
  `idUser` int(10) NOT NULL,
  `idClass` int(10) NOT NULL,
  PRIMARY KEY  (`idUser`,`idClass`),
  KEY `FKEtudClass614210` (`idUser`),
  KEY `FKEtudClass436354` (`idClass`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etudclass`
--

INSERT INTO `etudclass` (`idUser`, `idClass`) VALUES
(7, 2),
(8, 2),
(10, 2),
(12, 2),
(14, 1),
(16, 1);

-- --------------------------------------------------------

--
-- Table structure for table `examen`
--

CREATE TABLE `examen` (
  `idEx` int(11) NOT NULL,
  `nomEx` varchar(50) character set utf8 default NULL,
  `dateEx` date default NULL,
  `anneeScolaire` varchar(20) character set utf8 default NULL,
  PRIMARY KEY  (`idEx`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `examen`
--

INSERT INTO `examen` (`idEx`, `nomEx`, `dateEx`, `anneeScolaire`) VALUES
(1, 'Passage', '2020-06-15', '2019/2020'),
(2, 'National', '2020-05-04', '2019/2020'),
(3, 'Passage', '2021-06-15', '2020/2021');

-- --------------------------------------------------------

--
-- Table structure for table `examensp`
--

CREATE TABLE `examensp` (
  `idEx` int(11) NOT NULL,
  `idF` int(11) NOT NULL,
  PRIMARY KEY  (`idEx`,`idF`),
  KEY `idF` (`idF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `examensp`
--

INSERT INTO `examensp` (`idEx`, `idF`) VALUES
(1, 1),
(2, 1),
(3, 1),
(1, 2),
(2, 2),
(3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `idMod` int(10) NOT NULL auto_increment,
  `idUni` int(10) default NULL,
  `Nom_mod` varchar(255) character set utf8 default NULL,
  `Coif_mod` int(10) NOT NULL,
  PRIMARY KEY  (`idMod`),
  KEY `Contient3` (`idUni`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`idMod`, `idUni`, `Nom_mod`, `Coif_mod`) VALUES
(1, 2, 'Merise', 10),
(3, 2, 'Architecture des ordinateurs', 15),
(6, 3, 'UML', 20),
(7, 1, 'Java', 15),
(8, 1, 'VB', 14);

-- --------------------------------------------------------

--
-- Table structure for table `moduleclass`
--

CREATE TABLE `moduleclass` (
  `idMod` int(11) NOT NULL default '0',
  `idClass` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idMod`,`idClass`),
  KEY `idClass` (`idClass`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `moduleclass`
--

INSERT INTO `moduleclass` (`idMod`, `idClass`) VALUES
(1, 1),
(3, 1),
(8, 1),
(6, 2),
(7, 2);

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

CREATE TABLE `note` (
  `idNote` int(10) NOT NULL auto_increment,
  `idUser` int(10) default NULL,
  `idCc` int(10) default NULL,
  `Note` float NOT NULL,
  PRIMARY KEY  (`idNote`),
  KEY `Avoir2` (`idCc`),
  KEY `Consulter4` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `note`
--

INSERT INTO `note` (`idNote`, `idUser`, `idCc`, `Note`) VALUES
(18, 7, 9, 17.5),
(19, 8, 9, 18.75),
(20, 10, 9, 19),
(21, 12, 9, 16.4),
(22, 14, 8, 11.5),
(23, 16, 8, 15);

-- --------------------------------------------------------

--
-- Table structure for table `spÃ©cialitÃ©`
--

CREATE TABLE `spécialité` (
  `idF` int(10) NOT NULL auto_increment,
  `Nom` varchar(255) character set utf8 default NULL,
  PRIMARY KEY  (`idF`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `spÃ©cialitÃ©`
--

INSERT INTO `spécialité` (`idF`, `Nom`) VALUES
(1, 'DSI'),
(2, 'CPI');

-- --------------------------------------------------------

--
-- Table structure for table `unitÃ©`
--

CREATE TABLE `unité` (
  `idUni` int(10) NOT NULL auto_increment,
  `Nom_unite` varchar(255) character set utf8 default NULL,
  `Coif_unitÃ©` int(10) NOT NULL,
  PRIMARY KEY  (`idUni`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `unitÃ©`
--

INSERT INTO `unité` (`idUni`, `Nom_unite`, `Coif_unité`) VALUES
(1, 'DAI', 45),
(2, 'ASI', 50),
(3, 'CAI', 50),
(4, 'Langues', 30),
(5, 'Math', 15),
(7, 'CAI', 50),
(8, 'Langues', 30),
(9, 'Math', 30),
(10, 'Langues', 30),
(11, 'Langues', 30);

-- --------------------------------------------------------

--
-- Table structure for table `unitespec`
--

CREATE TABLE `unitespec` (
  `idUni` int(11) NOT NULL default '0',
  `idF` int(11) NOT NULL default '0',
  PRIMARY KEY  (`idUni`,`idF`),
  KEY `idF` (`idF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unitespec`
--

INSERT INTO `unitespec` (`idUni`, `idF`) VALUES
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 2),
(11, 2);

-- --------------------------------------------------------

--
-- Table structure for table `usermodule`
--

CREATE TABLE `usermodule` (
  `idUser` int(10) NOT NULL,
  `idMod` int(10) NOT NULL,
  PRIMARY KEY  (`idUser`,`idMod`),
  KEY `Enseigner` (`idUser`),
  KEY `Enseigner2` (`idMod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usermodule`
--

INSERT INTO `usermodule` (`idUser`, `idMod`) VALUES
(2, 1),
(2, 6),
(3, 7),
(3, 8),
(4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUser` int(10) NOT NULL auto_increment,
  `Nom` varchar(255) character set utf8 default NULL,
  `Prenom` varchar(255) character set utf8 default NULL,
  `Email` varchar(255) character set utf8 default NULL,
  `Matricule` varchar(255) character set utf8 default NULL,
  `DateNaissance` date default NULL,
  `LieuNaissance` varchar(255) character set utf8 default NULL,
  `Adresse` varchar(255) character set utf8 default NULL,
  `Login` varchar(255) character set utf8 default NULL,
  `MotDePass` varchar(255) character set utf8 default NULL,
  `Image` varchar(40) character set utf8 default 'default.png',
  `role` varchar(255) character set utf8 NOT NULL,
  PRIMARY KEY  (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`idUser`, `Nom`, `Prenom`, `Email`, `Matricule`, `DateNaissance`, `LieuNaissance`, `Adresse`, `Login`, `MotDePass`, `Image`, `role`) VALUES
(1, 'Chabbii', 'Hamide', 'Chaabi50@gmail.com', 'DB12345', '1940-06-06', 'KÃ©nitra', 'somewhere ', 'D12345@bts.com', 'BD1278', 'man.jpg', 'Directeur'),
(2, 'Alhiain', 'Hamid', 'Enseignant20@gmail.com', 'En1973', '1955-01-01', '///////////', '/////////', 'En1973@bts.com', 'Ens1298', 'default.png', 'Enseignant'),
(3, 'Bouaabid', 'Mourad', '///////////@gmail.com', 'En0032', '1972-04-01', 'unknown', 'unknown', 'En0032@bts.com', 'mourad', 'mi1.jpg', 'Enseignant'),
(4, 'Benssasi', 'Aicha', '////////@gmail.com', 'En0045', '1985-02-03', '/////////', '///////', 'En0045@bts.com', 'Ens1482', 'default.png', 'Enseignant'),
(5, 'Ehraichou', 'Said', '////////////@gmail.com', 'En1595', '1958-02-02', '//////////', '/////////////', 'En1595@bts.com', 'Ens1873', 'default.png', 'Enseignant'),
(6, 'Boumediani', 'Mostapha', '////////@gmail.com', 'En1982', '1970-05-05', '//////////', '//////////', 'En1982@bts.com', 'Ens1122', 'default.png', 'Enseignant'),
(7, 'Ait abdielmomin', 'hajar', 'aithajar55@gmail.com', 'Et1634', '2000-11-30', 'KÃ©nitra', 'RUE 153 NR 204 AFCA KENITRA', 'Et1634@bts.com', 'hajar', 'images.jpg', 'Etudiant'),
(8, 'Ait youssef', 'salma', '////////@gmail.com', 'Et1793', '2000-06-01', '/////////', '/////////', 'Et1793@bts.com', 'salma', 'images.jpg', 'Etudiant'),
(10, 'Rabai', 'Inass', '/////////@gmail.com', 'Et5500', '1998-05-01', '////////', '//////////', 'Et5500@gmail.com', 'Etd5', 'default.png', 'Etudiant'),
(11, 'Boukamou', 'Ayoube', '/////////////@gmail.com', 'Et2233', '1999-05-01', '///////////', '//////////////', 'Et2233@gmail.com', 'Etd6', 'default.png', 'Etudiant'),
(12, 'Boucherine', 'Fahd', '/////////@gmail.com', 'Et0780', '2000-02-02', '////////////', '////////////', 'Et0780@bts.com', 'Etd6', 'default.png', 'Etudiant'),
(14, 'fatima zahra', '////////////', '////////@gmail.com', 'Etd4576', '2020-07-15', '//////////////', '/////////////', 'Etd4576@bts.com', '197352', 'default.png', 'Etudiant'),
(15, 'ProfTest', 'ProfTest1', '/////////////@gmail.com', 'En4576', '2020-07-12', '//////////////', '/////////////////', 'En4576@bts.com', '197382', 'default.png', 'Enseignant'),
(16, 'Arnoune', 'Hiba1', 'hiba2000@gmail.com', 'Etd1973', '2020-07-04', '///////////', '/////////////', 'Etd1973@bts.com', '197382', 'default.png', 'Etudiant');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_1` FOREIGN KEY (`idF`) REFERENCES `spécialité` (`idF`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkClasse` FOREIGN KEY (`idF`) REFERENCES `spécialité` (`idF`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `classens`
--
ALTER TABLE `classens`
  ADD CONSTRAINT `classensFk1` FOREIGN KEY (`idClass`) REFERENCES `classe` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classensFk2` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classens_ibfk_1` FOREIGN KEY (`idClass`) REFERENCES `classe` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classens_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `classeunite`
--
ALTER TABLE `classeunite`
  ADD CONSTRAINT `classeuniteibfk1` FOREIGN KEY (`idClass`) REFERENCES `classe` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classeuniteibfk2` FOREIGN KEY (`idUni`) REFERENCES `unité` (`idUni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classeunite_ibfk_1` FOREIGN KEY (`idClass`) REFERENCES `classe` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classeunite_ibfk_2` FOREIGN KEY (`idUni`) REFERENCES `unité` (`idUni`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `contrÃ´lecontinu`
--
ALTER TABLE `contrôlecontinu`
  ADD CONSTRAINT `contrôlecontinuibfk1` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contrôlecontinuibfk2` FOREIGN KEY (`idMod`) REFERENCES `module` (`idMod`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contrôlecontinu_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contrôlecontinu_ibfk_2` FOREIGN KEY (`idMod`) REFERENCES `module` (`idMod`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contrôlecontinu_ibfk_3` FOREIGN KEY (`idClass`) REFERENCES `classe` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `etudclass`
--
ALTER TABLE `etudclass`
  ADD CONSTRAINT `etudclass_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudclass_ibfk_2` FOREIGN KEY (`idClass`) REFERENCES `classe` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `examensp`
--
ALTER TABLE `examensp`
  ADD CONSTRAINT `examensp_ibfk_1` FOREIGN KEY (`idEx`) REFERENCES `examen` (`idEx`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examensp_ibfk_2` FOREIGN KEY (`idF`) REFERENCES `spécialité` (`idF`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `module_ibfk_1` FOREIGN KEY (`idUni`) REFERENCES `unité` (`idUni`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `moduleclass`
--
ALTER TABLE `moduleclass`
  ADD CONSTRAINT `moduleclass_ibfk_1` FOREIGN KEY (`idMod`) REFERENCES `module` (`idMod`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `moduleclass_ibfk_2` FOREIGN KEY (`idClass`) REFERENCES `classe` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `note_ibfk_2` FOREIGN KEY (`idCc`) REFERENCES `contrôlecontinu` (`idCc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `unitespec`
--
ALTER TABLE `unitespec`
  ADD CONSTRAINT `unitespec_ibfk_1` FOREIGN KEY (`idUni`) REFERENCES `unité` (`idUni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `unitespec_ibfk_2` FOREIGN KEY (`idF`) REFERENCES `spécialité` (`idF`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usermodule`
--
ALTER TABLE `usermodule`
  ADD CONSTRAINT `usermodule_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `utilisateur` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usermodule_ibfk_2` FOREIGN KEY (`idMod`) REFERENCES `module` (`idMod`) ON DELETE CASCADE ON UPDATE CASCADE;
