-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 21 Décembre 2016 à 00:09
-- Version du serveur :  10.1.19-MariaDB
-- Version de PHP :  5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pizzeriacodefirst`
--

-- --------------------------------------------------------

--
-- Structure de la table `pizza`
--

CREATE TABLE `pizza` (
  `id` int(11) NOT NULL,
  `categoriePizza` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `pizza`
--

INSERT INTO `pizza` (`id`, `categoriePizza`, `code`, `nom`, `prix`,`url` ) VALUES
(1, 'VIANDE', 'ORI', 'Oriental', 15.5, 'http://us.123rf.com/450wm/foodandmore/foodandmore1509/foodandmore150900088/44952168-au-four-en-forme-de-c-ur-pizza-maison-garni-de-mozzarella-et-de-tranches-de-tomate-sur-du-papier-sul.jpg?ver=6'),
(2, 'VIANDE', 'PEP', 'Pepperoni', 18.5, 'http://previews.123rf.com/images/dolgachov/dolgachov1603/dolgachov160305223/53928639-nourriture-cuisine-italienne-et-de-manger-concept-gros-plan-des-mains-tenant-et-le-partage-de-la-piz-Banque-d''images.jpg'),
(3, 'SANS_VIANDE', 'MAR', 'Margherita', 12.5, 'http://us.123rf.com/450wm/Timmary/Timmary1506/Timmary150600010/41635397-d-licieuse-pizza-savoureuse-sur-l-ancien-conseil.jpg?ver=6'),
(4, 'POISSON', 'SAU', 'Saumoneta', 15.5,  'http://www.gopizz.fr/images/pizza/pizza-thon.jpg');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `pizza`
--
ALTER TABLE `pizza`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
