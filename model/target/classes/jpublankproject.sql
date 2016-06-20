
CREATE DATABASE jpublankproject;

USE jpublankproject;

--
-- Base de données :  `jpublankproject`
--

DELIMITER $$
--
-- Procédures
--

CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapById` (IN `p_id` INT)  NO SQL
SELECT * FROM map WHERE map_id = p_id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `loadmapByKey` (IN `p_key` VARCHAR(50))  NO SQL
SELECT * FROM jpublankproject.map where `map_name`=p_key$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateScoreNickname` (IN `points` INT(15), IN `p_nickname` VARCHAR(15))  NO SQL
INSERT INTO score (score, nickname) VALUES(points, p_nickname)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

CREATE TABLE `map` (
  `id` int(11) NOT NULL,
  `map_name` varchar(50) CHARACTER SET latin1 NOT NULL,
  `map` text CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `map`
--

INSERT INTO `map` (`id`, `map_name`, `map`) VALUES
(1, 'MAP1', 'O---O--------------O\nI   I              I\nI I I     -O--O-O  I\nY I   O--- I  I I  I\nO-O-O I111O-O-O O- I\nI   I O---I@I   I  I\nI I I I I I I --O -O\nI I I I     I   I  I\nI IQI I I1I O-- I  I\nI O-O-O O-O      --O\nI         I        I\nO---------O--------O'),
(2, 'MAP2', 'O------------------O\nI     O ---@       I\nI  OOO I11O------- I\nI   OOOI1OO        I\nO--O   IOO  -------O\nI      IO          I\nI -----O---------O I\nI      I         I I\nI I A          I1I I\nI I    I       O-O I\nIQI    I           I\nO-O----O---------OYO'),
(3, 'MAP3', 'O------------------O\nIQO O  O           I\nI O O O OOOOO      I\nIO O OOO1O1A       I\nO-------O-O------- I\nI        @O   O1O  I\nI O-----OYO O OO  OI\nI      BI O OO OOO I\nI O--O--OO O OO O  I\nI I  I  IOOO O OO OI\nI  I   I     O   O1I\nO--O---O-----------O'),
(4, 'MAP4', 'O------------------O\nI       1    AI    I\nI OO    --OYO-O OO I\nI  OO     OOO  IO OI\nIOO O          IOO I\nIBO O          IO  I\nI O O1------O--O --O\nI  OOI      I      I\nI OOQI  C   I      I\nIO O I      I      I\nI1   I1     I     @I\nO----O------O------O'),
(5, 'MAP5', 'O------O-----O-----O\nIA     I11111I     I\nI     I  111  I    I\nI    I         I   I\nIB   I  II II  I   I\nI  Q I I1I I1I I  @I\nI    I III III I   I\nIC    I  I I  I    I\nI      I     I     I\nI      I I I I     I\nID     I I I I     I\nO------O-O-O-O-----O'),
(10, 'TEST', 'OQ-IYX1\n@\nABCD'),
(17, 'MENU', 'O------------------O\nI         @        I\nI  O-O--------O-O  I\nI    I        I    I\nO--O I        I O--O\nX  O I        I O  X\nOO   I        I   OO\nOO---O        O---OO\nI    I        I    I\nO----O--------O----O\nI         D        I\nO------------------O');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `map`
--
ALTER TABLE `map`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--
--
-- AUTO_INCREMENT pour la table `map`
--
ALTER TABLE `map`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
