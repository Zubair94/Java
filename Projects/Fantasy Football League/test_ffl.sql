-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 17, 2015 at 07:15 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test_ffl`
--

-- --------------------------------------------------------

--
-- Table structure for table `player_profile_ffl`
--

CREATE TABLE `player_profile_ffl` (
  `Player_Id` int(100) NOT NULL,
  `Player_Name` varchar(255) NOT NULL,
  `Player_Position` varchar(255) NOT NULL,
  `Player_Country` varchar(255) NOT NULL,
  `Player_Age` int(3) NOT NULL,
  `Player_Club` varchar(255) NOT NULL,
  `Player_Values` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `player_profile_ffl`
--

INSERT INTO `player_profile_ffl` (`Player_Id`, `Player_Name`, `Player_Position`, `Player_Country`, `Player_Age`, `Player_Club`, `Player_Values`) VALUES
(1, 'David Ospina', 'GK', 'Columbia', 27, 'Arsenal', 5800000),
(2, 'Petr Cech', 'GK', 'Czech Republic', 33, 'Arsenal', 8400000),
(3, 'Thibaut Courtis', 'GK', 'Belgium', 23, 'Chelsea', 24500000),
(4, 'Asmir Begovic', 'GK', 'Bosnia-Herzegovina', 28, 'Chelsea', 8400000),
(5, 'Tim Howard', 'GK', 'USA', 36, 'Everton', 1800000),
(6, 'Joel Robles', 'GK', 'Spain', 25, 'Everton', 2100000),
(7, 'David De Gea', 'GK', 'Spain', 25, 'Manchester United', 21000000),
(8, 'Sergio Romero ', 'GK', 'Argentina', 28, 'Manchester United', 3500000),
(9, 'Joe Hart', 'GK', 'England', 28, 'Manchester City', 18000000),
(10, 'Willy Caballero', 'GK', 'Argentina', 34, 'Manchester City', 1860000),
(11, 'Simon Mignolet', 'GK', 'Belgium', 27, 'Liverpool', 8400000),
(12, 'Adam Bogdan', 'Gk', 'Hungary', 28, 'Liverpool', 1400000),
(13, 'Hugo Lloris', 'GK', 'France', 28, 'Tottenham Hotspur', 15400000),
(14, 'Michel Vorm', 'GK', 'Netherlands ', 32, 'Tottenham Hotspur', 3500000),
(15, 'Laurent Koscielny', 'CB', 'France', 30, 'Arsenal', 14000000),
(16, 'Per Mertesacker', 'CB', 'Germany', 31, 'Arsenal', 10500000),
(17, 'Gabriel Paulista', 'CB', 'Brazil', 25, 'Arsenal', 8400000),
(18, 'Hector Bellerin', 'RB', 'Spain', 20, 'Arsenal', 3500000),
(19, 'Kieran Gibbs', 'LB', 'England', 26, 'Arsenal', 9100000),
(20, 'Gary Cahill', 'CB', 'England', 29, 'Chelsea', 14000000),
(21, 'John Terry\r\n ', 'CB', 'England', 35, 'Chelsea', 2800000),
(22, 'Kurt Zouma', 'CB', 'France', 21, 'Chelsea', 8400000),
(23, 'Cesar Azpilicueta', 'LB', 'Spain', 26, 'Chelsea', 16100000),
(24, 'Branislav Ivanovic', 'RB', 'Serbia', 31, 'Chelsea', 11000000),
(25, 'Vincent Kompany\r\n ', 'CB', 'Belgium', 29, 'Manchester City', 21000000),
(26, 'Nicolas Otamendi', 'CB', 'Argentina', 27, 'Manchester City', 22400000),
(27, 'Aleksandar Kolarov', 'LB', 'Serbia', 30, 'Manchester City', 7700000),
(28, 'Gael Clichy', 'LB', 'France', 30, 'Manchester City', 7700000),
(29, 'Pablo Zabaleta', 'RB', 'Argentina', 30, 'Manchester City', 12600000),
(30, 'Bacary Sagna', 'RB', 'France', 32, 'Manchester City', 4200000),
(31, 'Daley Blind', 'CB', 'Netherlands', 25, 'Manchester United', 11900000),
(32, 'Marcos Rojo\r\n ', 'CB', 'Argentina', 25, 'Manchester United', 12600000),
(33, 'Chris Smalling', 'CB', 'England', 26, 'Manchester United', 9800000),
(34, 'Luke Shaw', 'LB', 'England', 20, 'Manchester United', 14700000),
(35, 'Antonio Valencia', 'RB', 'Ecuador', 30, 'Manchester United', 7000000),
(36, 'Matteo Darmian', 'RB', 'Italy', 26, 'Manchester United', 10500000),
(37, 'John Stones', 'CB', 'England', 21, 'Everton', 17500000),
(38, 'Phil Jagielka', 'CB', 'England', 33, 'Everton', 3150000),
(39, 'Bryan Oviedo', 'LB', 'Costa Rica', 25, 'Everton', 2100000),
(40, 'Seamus Coleman', 'RB', 'Ireland', 27, 'Everton', 13300000),
(41, 'Leighton Baines', 'LB', 'Eengland', 31, 'Everton', 12600000),
(42, 'Federico Fazio', 'CB', 'Spain', 28, 'Tottenham Hotspur', 5600000),
(43, 'Jan Vertonghen', 'CB', 'Belgium', 28, 'Tottenham Hotspur', 13300000),
(44, 'Toby Alderweireld', 'CB', 'Belgium ', 26, 'Tottenham Hotspur', 10500000),
(45, 'Danny Rose', 'LB', 'England', 25, 'Tottenham Hotspur', 7700000),
(46, 'Kyle Walker', 'RB', 'England', 25, 'Tottenham Hotspur', 9100000),
(47, 'Roberto Firmino', 'AM', 'Brazil', 24, 'Liverpool', 24500000),
(48, 'Coutinho', 'AM', 'Brazil', 23, 'Liverpool', 21000000),
(49, 'Nemanja Matic	', 'DM', 'Serbia', 27, 'Chelsea', 28000000),
(50, 'Cesc Fabregas', 'CM', 'Spain', 28, 'Chelsea', 35000000),
(51, 'Eden Hazard', 'LW', 'Belgium', 24, 'Chelsea', 49000000),
(52, 'Oscar', 'AM', 'Brazil', 24, 'Chelsea', 26600000),
(53, 'Ramires', 'DM', 'Brazil', 28, 'Chelsea', 17500000),
(54, 'Willian', 'RW', 'Brazil', 27, 'Chelsea', 21000000),
(55, 'Diego Costa', 'CF', 'Brazil', 27, 'Chelsea', 35000000),
(56, 'David Silva', 'CM', 'Spain', 29, 'Manchester City', 26700000),
(57, 'Sergio Aguero', 'CF', 'Argentina', 27, 'Manchester City', 42000000),
(58, 'Mesut Ozil', 'CM', 'Germany', 27, 'Arsenal', 28000000),
(59, 'Alexis Sanchez', 'LW', 'Chile', 26, 'Arsenal', 38600000),
(60, 'Theo Walcott', 'RW', 'England', 26, 'Arsenal', 17500000);

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `Username` varchar(255) NOT NULL,
  `Team_Name` varchar(255) NOT NULL,
  `Player1` varchar(255) NOT NULL,
  `Player1GS` int(10) NOT NULL DEFAULT '0',
  `Player2` varchar(255) NOT NULL,
  `Player2GS` int(10) NOT NULL DEFAULT '0',
  `Player3` varchar(255) NOT NULL,
  `Player3GS` int(10) NOT NULL DEFAULT '0',
  `Player4` varchar(255) NOT NULL,
  `Player4GS` int(10) NOT NULL DEFAULT '0',
  `Player5` varchar(255) NOT NULL,
  `Player5GS` int(10) NOT NULL DEFAULT '0',
  `Player6` varchar(255) NOT NULL,
  `Player6GS` int(10) NOT NULL DEFAULT '0',
  `Player7` varchar(255) NOT NULL,
  `Player7GS` int(10) NOT NULL DEFAULT '0',
  `Player8` varchar(255) NOT NULL,
  `Player8GS` int(10) NOT NULL DEFAULT '0',
  `Player9` varchar(255) NOT NULL,
  `Player9GS` int(10) NOT NULL DEFAULT '0',
  `Player10` varchar(255) NOT NULL,
  `Player10GS` int(10) NOT NULL DEFAULT '0',
  `Player11` varchar(255) NOT NULL,
  `Player11GS` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `Name` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Age` int(20) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Favourite_Team` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Transfer_Balance` int(255) NOT NULL DEFAULT '300000000'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`Name`, `Username`, `Email`, `Age`, `Gender`, `Favourite_Team`, `Password`, `Transfer_Balance`) VALUES
('admin', 'admin', 'admin@admin@gmail.com', 21, 'Male', 'none', 'admin', 300000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `player_profile_ffl`
--
ALTER TABLE `player_profile_ffl`
  ADD PRIMARY KEY (`Player_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `player_profile_ffl`
--
ALTER TABLE `player_profile_ffl`
  MODIFY `Player_Id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
