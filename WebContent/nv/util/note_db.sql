-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 29 Juillet 2018 à 18:51
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `note_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `date_naissance` date NOT NULL,
  `email` varchar(60) NOT NULL,
  `password` varchar(20) NOT NULL,
  `image` varchar(200) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `admin`
--

INSERT INTO `admin` (`id_user`, `nom`, `prenom`, `date_naissance`, `email`, `password`, `image`) VALUES
(1, 'Fatima', 'zahra', '0000-00-00', 'fatima@gmail.com', '1111', ''),
(2, 'baha', 'fatima zahra', '1996-12-13', 'akherrazfatimazahra@gmail.com', '', ''),
(3, 'baha', 'fatima zahra', '1996-12-13', 'akherrazfatimazahra@gmail.com', '', ''),
(4, 'akherraz', 'hafifa', '1996-12-13', 'akherrazfatimazahra@gmail.com', '', ''),
(6, 'rifki', 'chaima', '1996-12-13', 'fatima@gmail.com', '7777', ''),
(7, 'akherraz', 'Visiteur', '1996-12-13', 'fatima@gmail.com', '2222', ''),
(8, 'akherraz', 'Visiteur', '1996-12-13', 'fatima@gmail.com', '2222', ''),
(9, 'akherraz', 'Visiteur', '1996-12-13', 'fatima@gmail.com', '2222', ''),
(10, 'akherraz', 'Visiteur', '1996-12-13', 'fatima@gmail.com', '33333', ''),
(11, 'akherraz', 'Visiteur', '1996-12-13', 'fatima@gmail.com', '666', ''),
(12, 'baha', 'hafifa', '1996-12-13', 'fatima@gmail.com', '5555', '568x300_mcdsfootball_football.jpg'),
(13, 'lkhatiri', 'sanaa', '1995-09-16', 'sanaaelkhatiri@gmail.com', '5555', 'profil2.png');

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE IF NOT EXISTS `module` (
  `Num_Module` int(11) NOT NULL AUTO_INCREMENT,
  `Nom_Module` varchar(20) NOT NULL,
  `Nb_Heures` int(11) NOT NULL,
  PRIMARY KEY (`Num_Module`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `module`
--

INSERT INTO `module` (`Num_Module`, `Nom_Module`, `Nb_Heures`) VALUES
(4, 'Francais', 10),
(5, 'Sql', 7),
(6, 'RO', 34);

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `Num_Note` int(11) NOT NULL AUTO_INCREMENT,
  `Date_Note` datetime NOT NULL,
  `Idee_Generale` varchar(100) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL,
  `Resume` text NOT NULL,
  `Rappel` varchar(100) NOT NULL,
  `Num_Module` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`Num_Note`),
  KEY `Num_Module` (`Num_Module`),
  KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `note`
--

INSERT INTO `note` (`Num_Note`, `Date_Note`, `Idee_Generale`, `Resume`, `Rappel`, `Num_Module`, `id_user`) VALUES
(6, '2017-12-19 00:00:00', 'modification des tables', 'modifier une table a l aide d un ID', 'cours sur les bases de donnees et sql', 4, 1),
(8, '2017-12-20 00:00:00', 'modification des tables', 'modifier les tables', 'base de donnes', 5, 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `idUser` FOREIGN KEY (`id_user`) REFERENCES `admin` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `num_module` FOREIGN KEY (`Num_Module`) REFERENCES `module` (`Num_Module`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
