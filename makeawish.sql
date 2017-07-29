-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 29, 2017 at 04:11 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `makeawish`
--

-- --------------------------------------------------------

--
-- Table structure for table `childprofile`
--

CREATE TABLE `childprofile` (
  `id` int(11) NOT NULL,
  `case_no` varchar(10) DEFAULT NULL,
  `hospital` varchar(10) DEFAULT NULL,
  `child_name` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `mother_tongue` varchar(10) DEFAULT NULL,
  `father_name` varchar(20) DEFAULT NULL,
  `mother_name` varchar(20) DEFAULT NULL,
  `contact_no` bigint(20) DEFAULT NULL,
  `disease` varchar(20) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `vol_id` int(11) DEFAULT NULL,
  `wish1` varchar(30) DEFAULT NULL,
  `wish2` varchar(30) DEFAULT NULL,
  `wish3` varchar(30) DEFAULT NULL,
  `date_submit` date DEFAULT NULL,
  `approved_wish` varchar(30) DEFAULT NULL,
  `date_approve` date DEFAULT NULL,
  `donor_id` int(11) DEFAULT NULL,
  `family` varchar(150) DEFAULT NULL,
  `friends` varchar(150) DEFAULT NULL,
  `color` varchar(10) DEFAULT NULL,
  `book` varchar(20) DEFAULT NULL,
  `game` varchar(20) DEFAULT NULL,
  `food` varchar(20) DEFAULT NULL,
  `muisc_movie` varchar(20) DEFAULT NULL,
  `hobby` varchar(20) DEFAULT NULL,
  `cartoon` varchar(20) DEFAULT NULL,
  `actor` varchar(20) DEFAULT NULL,
  `trip` varchar(20) DEFAULT NULL,
  `ambition` varchar(20) DEFAULT NULL,
  `bigwish1` varchar(200) DEFAULT NULL,
  `bigwish2` varchar(200) DEFAULT NULL,
  `bigwish3` varchar(200) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `wishtype` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `childprofile`
--

INSERT INTO `childprofile` (`id`, `case_no`, `hospital`, `child_name`, `sex`, `dob`, `age`, `mother_tongue`, `father_name`, `mother_name`, `contact_no`, `disease`, `doctor_id`, `vol_id`, `wish1`, `wish2`, `wish3`, `date_submit`, `approved_wish`, `date_approve`, `donor_id`, `family`, `friends`, `color`, `book`, `game`, `food`, `muisc_movie`, `hobby`, `cartoon`, `actor`, `trip`, `ambition`, `bigwish1`, `bigwish2`, `bigwish3`, `status`, `wishtype`) VALUES
(1, '1545df5', 'Tata', 'John Doe', 'm', '2017-07-04', 10, 'hindi', 'John', 'Jane', 987456321, '--', 1, 1, 'mobile', 'cycle', 'doll', '2017-07-05', 'mobile', '2017-07-10', 1, 'qheiqwhle', 'trtrt3', 'red', 'jhrgkwr', 'y56y56', 'y56y5', 'tgeger', 'ghiuyvkuv', 'hjbb', 'hbilb', 'hbiu', 'bliub', 'hbkbkvkbvksdkdskfdfkbf', 'hbkbkvkbvksdkdskfdfkbf', 'hbkbkvkbvksdkdskfdfkbf', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `Doctor_id` int(11) NOT NULL,
  `Doctor_name` varchar(50) NOT NULL,
  `Hospital` varchar(50) NOT NULL,
  `Contact` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Doctor_id`, `Doctor_name`, `Hospital`, `Contact`) VALUES
(1, ' Ria', 'tata', 123456789);

-- --------------------------------------------------------

--
-- Table structure for table `doctor_refer`
--

CREATE TABLE `doctor_refer` (
  `doctor_id` int(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contact` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `donor_id` int(10) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contact` bigint(10) NOT NULL,
  `points` int(5) NOT NULL,
  `amount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `donor_refer`
--

CREATE TABLE `donor_refer` (
  `donor_id` int(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contact` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `donor_id` int(11) DEFAULT NULL,
  `child_id` int(11) DEFAULT NULL,
  `amt` int(11) DEFAULT NULL,
  `method` varchar(20) DEFAULT NULL,
  `dateofPay` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `volunteer`
--

CREATE TABLE `volunteer` (
  `Volunteer_id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Area` varchar(50) NOT NULL,
  `GovtID` varchar(10) NOT NULL,
  `IDno` int(20) NOT NULL,
  `Hospital` varchar(50) NOT NULL,
  `Approved` tinyint(1) NOT NULL,
  `Points` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `volunteer`
--

INSERT INTO `volunteer` (`Volunteer_id`, `Name`, `Area`, `GovtID`, `IDno`, `Hospital`, `Approved`, `Points`) VALUES
(1, 'xyz', 'andheri', 'adhaar', 123456789, 'tata', 1, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `childprofile`
--
ALTER TABLE `childprofile`
  ADD PRIMARY KEY (`id`),
  ADD KEY `doctor_id` (`doctor_id`),
  ADD KEY `vol_id` (`vol_id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`Doctor_id`);

--
-- Indexes for table `doctor_refer`
--
ALTER TABLE `doctor_refer`
  ADD KEY `doctor_id` (`doctor_id`);

--
-- Indexes for table `donor`
--
ALTER TABLE `donor`
  ADD PRIMARY KEY (`donor_id`);

--
-- Indexes for table `donor_refer`
--
ALTER TABLE `donor_refer`
  ADD KEY `donor_id` (`donor_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD KEY `donor_id` (`donor_id`),
  ADD KEY `child_id` (`child_id`);

--
-- Indexes for table `volunteer`
--
ALTER TABLE `volunteer`
  ADD PRIMARY KEY (`Volunteer_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `childprofile`
--
ALTER TABLE `childprofile`
  ADD CONSTRAINT `childprofile_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`Doctor_id`),
  ADD CONSTRAINT `childprofile_ibfk_2` FOREIGN KEY (`vol_id`) REFERENCES `volunteer` (`Volunteer_id`);

--
-- Constraints for table `doctor_refer`
--
ALTER TABLE `doctor_refer`
  ADD CONSTRAINT `doctor_refer_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`Doctor_id`);

--
-- Constraints for table `donor_refer`
--
ALTER TABLE `donor_refer`
  ADD CONSTRAINT `donor_refer_ibfk_1` FOREIGN KEY (`donor_id`) REFERENCES `donor` (`donor_id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`donor_id`) REFERENCES `donor` (`donor_id`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`child_id`) REFERENCES `childprofile` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
