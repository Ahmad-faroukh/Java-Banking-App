-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2019 at 09:51 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `accountingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `name` varchar(15) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`name`, `password`) VALUES
('admin', '21232f297a57a5a743894a0e4a801fc3'),
('ahmad', '5f4dcc3b5aa765d61d8327deb882cf99'),
('tamer', '25f9e794323b453885f5181f1b624d0b');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `account_id` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `balance` double DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`account_id`, `password`, `name`, `gender`, `phone`, `email`, `balance`) VALUES
('0123456789', '5f4dcc3b5aa765d61d8327deb882cf99', 'ahmad', '1', '0598347573', 'ahmad@email.com', 1215.88),
('1020304050', 'ec597cae68ee2489846132fc330c1d6e', 'mona', '1', '0593257848', 'mona@email.com', 415.66),
('2165479856', '25f9e794323b453885f5181f1b624d0b', 'tamer', '1', '0593256458', 'tamer@email.com', 110.5),
('2222222222', 'e9f6af2ef8239d3b74e408205ecda93a', 'test2', '2', '0598888888', 'test2@email.com', 0),
('2365987459', 'd1c07866d71dc3a09b3b692d0a2086b4', 'asdasd', '1', '123123', 'asda@email.com', 0),
('5621568978', 'f42ae9493029dfa75065aecc57383e94', 'hassan', '1', '0598625365', 'hassan@email.com', 0),
('5645236987', '4297f44b13955235245b2497399d7a93', 'asdasd', '2', '123123', 'aasd@sadas.com', 0),
('9856321457', '14bfa6bb14875e45bba028a21ed38046', 'yolo', '2', '0598654759', 'yolo@email.swag', 442.36);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
