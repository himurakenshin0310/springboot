-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 13, 2022 at 11:12 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project1`
--
CREATE DATABASE IF NOT EXISTS `project1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `project1`;

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `id` bigint(20) NOT NULL,
  `productid` bigint(20) DEFAULT NULL,
  `orderid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`id`, `productid`, `orderid`) VALUES
(4, 53, 5);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `total_price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `user_id`, `total_price`) VALUES
(5, 2, 10100);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL DEFAULT 1,
  `type` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `enable` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `image`, `quantity`, `type`, `description`, `enable`) VALUES
(1, 'product 1', 1111110, 'Bai tap 2 Thong tin khach hang.PNG', 1, 1, 'san pham 1', b'1'),
(2, 'product 2', 1111110, 'Bai tap 1 Thong tin hang sua.PNG', 0, 2, '123123', b'1'),
(3, 'product 10', 10000, 'Bai tap 2 Thong tin khach hang.PNG', 1, 2, 'aaaasdasd', b'1'),
(4, 'product 11', 10002, 'Bai tap 1 Thong tin hang sua.PNG', 2, 1, 'aaaasdasd', b'0'),
(5, 'product 12', 10004, 'Bai tap 2 Thong tin khach hang.PNG', 3, 2, 'aaaasdasd', b'1'),
(6, 'product 13', 10006, 'Bai tap 1 Thong tin hang sua.PNG', 4, 1, 'aaaasdasd', b'0'),
(7, 'product 14', 10008, 'Bai tap 2 Thong tin khach hang.PNG', 5, 2, 'aaaasdasd', b'1'),
(8, 'product 15', 10010, 'Bai tap 1 Thong tin hang sua.PNG', 6, 1, 'aaaasdasd', b'0'),
(9, 'product 16', 10012, 'Bai tap 2 Thong tin khach hang.PNG', 7, 2, 'aaaasdasd', b'1'),
(10, 'product 17', 10014, 'Bai tap 1 Thong tin hang sua.PNG', 8, 1, 'aaaasdasd', b'0'),
(11, 'product 18', 10016, 'Bai tap 2 Thong tin khach hang.PNG', 9, 2, 'aaaasdasd', b'1'),
(12, 'product 19', 10018, 'Bai tap 1 Thong tin hang sua.PNG', 10, 1, 'aaaasdasd', b'0'),
(13, 'product 110', 10020, 'Bai tap 2 Thong tin khach hang.PNG', 11, 2, 'aaaasdasd', b'1'),
(14, 'product 111', 10022, 'Bai tap 1 Thong tin hang sua.PNG', 12, 1, 'aaaasdasd', b'0'),
(15, 'product 112', 10024, 'Bai tap 2 Thong tin khach hang.PNG', 13, 2, 'aaaasdasd', b'1'),
(16, 'product 113', 10026, 'Bai tap 1 Thong tin hang sua.PNG', 14, 1, 'aaaasdasd', b'0'),
(17, 'product 114', 10028, 'Bai tap 2 Thong tin khach hang.PNG', 15, 2, 'aaaasdasd', b'1'),
(18, 'product 115', 10030, 'Bai tap 1 Thong tin hang sua.PNG', 16, 1, 'aaaasdasd', b'0'),
(19, 'product 116', 10032, 'Bai tap 2 Thong tin khach hang.PNG', 17, 2, 'aaaasdasd', b'1'),
(20, 'product 117', 10034, 'Bai tap 1 Thong tin hang sua.PNG', 18, 1, 'aaaasdasd', b'0'),
(21, 'product 118', 10036, 'Bai tap 2 Thong tin khach hang.PNG', 19, 2, 'aaaasdasd', b'1'),
(22, 'product 119', 10038, 'Bai tap 1 Thong tin hang sua.PNG', 20, 1, 'aaaasdasd', b'0'),
(23, 'product 120', 10040, 'Bai tap 2 Thong tin khach hang.PNG', 21, 2, 'aaaasdasd', b'1'),
(24, 'product 121', 10042, 'Bai tap 1 Thong tin hang sua.PNG', 22, 1, 'aaaasdasd', b'0'),
(25, 'product 122', 10044, 'Bai tap 2 Thong tin khach hang.PNG', 23, 2, 'aaaasdasd', b'1'),
(26, 'product 123', 10046, 'Bai tap 1 Thong tin hang sua.PNG', 24, 1, 'aaaasdasd', b'0'),
(27, 'product 124', 10048, 'Bai tap 2 Thong tin khach hang.PNG', 25, 2, 'aaaasdasd', b'1'),
(28, 'product 125', 10050, 'Bai tap 1 Thong tin hang sua.PNG', 26, 1, 'aaaasdasd', b'0'),
(29, 'product 126', 10052, 'Bai tap 2 Thong tin khach hang.PNG', 27, 2, 'aaaasdasd', b'1'),
(30, 'product 127', 10054, 'Bai tap 1 Thong tin hang sua.PNG', 28, 1, 'aaaasdasd', b'0'),
(31, 'product 128', 10056, 'Bai tap 2 Thong tin khach hang.PNG', 29, 2, 'aaaasdasd', b'1'),
(32, 'product 129', 10058, 'Bai tap 1 Thong tin hang sua.PNG', 30, 1, 'aaaasdasd', b'0'),
(33, 'product 130', 10060, 'Bai tap 2 Thong tin khach hang.PNG', 31, 2, 'aaaasdasd', b'1'),
(34, 'product 131', 10062, 'Bai tap 1 Thong tin hang sua.PNG', 32, 1, 'aaaasdasd', b'0'),
(35, 'product 132', 10064, 'Bai tap 2 Thong tin khach hang.PNG', 33, 2, 'aaaasdasd', b'1'),
(36, 'product 133', 10066, 'Bai tap 1 Thong tin hang sua.PNG', 34, 1, 'aaaasdasd', b'0'),
(37, 'product 134', 10068, 'Bai tap 2 Thong tin khach hang.PNG', 35, 2, 'aaaasdasd', b'1'),
(38, 'product 135', 10070, 'Bai tap 1 Thong tin hang sua.PNG', 36, 1, 'aaaasdasd', b'0'),
(39, 'product 136', 10072, 'Bai tap 2 Thong tin khach hang.PNG', 37, 2, 'aaaasdasd', b'1'),
(40, 'product 137', 10074, 'Bai tap 1 Thong tin hang sua.PNG', 38, 1, 'aaaasdasd', b'0'),
(41, 'product 138', 10076, 'Bai tap 2 Thong tin khach hang.PNG', 39, 2, 'aaaasdasd', b'1'),
(42, 'product 139', 10078, 'Bai tap 1 Thong tin hang sua.PNG', 40, 1, 'aaaasdasd', b'0'),
(43, 'product 140', 10080, 'Bai tap 2 Thong tin khach hang.PNG', 41, 2, 'aaaasdasd', b'1'),
(44, 'product 141', 10082, 'Bai tap 1 Thong tin hang sua.PNG', 42, 1, 'aaaasdasd', b'0'),
(45, 'product 142', 10084, 'Bai tap 2 Thong tin khach hang.PNG', 43, 2, 'aaaasdasd', b'1'),
(46, 'product 143', 10086, 'Bai tap 1 Thong tin hang sua.PNG', 44, 1, 'aaaasdasd', b'0'),
(47, 'product 144', 10088, 'Bai tap 2 Thong tin khach hang.PNG', 45, 2, 'aaaasdasd', b'1'),
(48, 'product 145', 10090, 'Bai tap 1 Thong tin hang sua.PNG', 46, 1, 'aaaasdasd', b'0'),
(49, 'product 146', 10092, 'Bai tap 2 Thong tin khach hang.PNG', 47, 2, 'aaaasdasd', b'1'),
(50, 'product 147', 10094, 'Bai tap 1 Thong tin hang sua.PNG', 48, 1, 'aaaasdasd', b'0'),
(51, 'product 148', 10096, 'Bai tap 2 Thong tin khach hang.PNG', 49, 2, 'aaaasdasd', b'1'),
(52, 'product 149', 10098, 'Bai tap 1 Thong tin hang sua.PNG', 50, 1, 'aaaasdasd', b'0'),
(53, 'product 150', 10100, 'Bai tap 2 Thong tin khach hang.PNG', 51, 2, 'aaaasdasd', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `rolename` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `rolename`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` tinyint(2) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id`, `name`, `status`) VALUES
(1, 'loai 1', 1),
(2, 'loai 2', 1),
(3, 'aaa', 1);

-- --------------------------------------------------------

--
-- Table structure for table `userroles`
--

CREATE TABLE `userroles` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userroles`
--

INSERT INTO `userroles` (`id`, `user_id`, `role_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `name`, `phone`, `enable`) VALUES
(1, 'admin@gmail.com', '$2a$10$EfOP4W12bti/RJVnSAAKrux3HtUvoXukUXoD.vCuBC5/ktKwI3yva', 'admin', '091366565', 1),
(2, 'user@gmail.com', '$2a$10$s6f8rUNR/XtHyalv/CE5H.3ci0I1nRRiZcmyxtaMi6t4NtBdmCT.K', 'User1', '0911651561', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `productid` (`productid`),
  ADD KEY `orderid` (`orderid`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type` (`type`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userroles`
--
ALTER TABLE `userroles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `role_id` (`role_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orderdetail`
--
ALTER TABLE `orderdetail`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `userroles`
--
ALTER TABLE `userroles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`orderid`) REFERENCES `orders` (`id`) ON UPDATE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`type`) REFERENCES `type` (`id`);

--
-- Constraints for table `userroles`
--
ALTER TABLE `userroles`
  ADD CONSTRAINT `userroles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `userroles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
