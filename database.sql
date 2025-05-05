/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `yeumeent_czmn` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `yeumeent_czmn`;

CREATE TABLE IF NOT EXISTS `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO `brand` (`id`, `name`) VALUES
	(1, 'Motul'),
	(2, 'Liqui Moly');

CREATE TABLE IF NOT EXISTS `export_details` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `receipt_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `receipt_id` (`receipt_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `export_details_ibfk_1` FOREIGN KEY (`receipt_id`) REFERENCES `export_receipts` (`receipt_id`),
  CONSTRAINT `export_details_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


CREATE TABLE IF NOT EXISTS `export_receipts` (
  `receipt_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `export_date` datetime DEFAULT current_timestamp(),
  `customer_name` varchar(100) DEFAULT NULL,
  `note` text DEFAULT NULL,
  PRIMARY KEY (`receipt_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `export_receipts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


CREATE TABLE IF NOT EXISTS `import_details` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `receipt_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `receipt_id` (`receipt_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `import_details_ibfk_1` FOREIGN KEY (`receipt_id`) REFERENCES `import_receipts` (`receipt_id`),
  CONSTRAINT `import_details_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


CREATE TABLE IF NOT EXISTS `import_receipts` (
  `receipt_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `import_date` datetime DEFAULT current_timestamp(),
  `note` text DEFAULT NULL,
  PRIMARY KEY (`receipt_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `import_receipts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


CREATE TABLE IF NOT EXISTS `products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_code` varchar(50) DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `brand` int(11) DEFAULT NULL,
  `volume` varchar(20) DEFAULT NULL,
  `sl_ton` int(11) DEFAULT 0,
  `unit` varchar(20) DEFAULT 'chai',
  `price` decimal(10,2) DEFAULT 0.00,
  `created_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO `products` (`product_id`, `product_code`, `name`, `brand`, `volume`, `sl_ton`, `unit`, `price`, `created_at`) VALUES
	(17, NULL, 'Motul Scooter Le 10W40', 0, '800ML', 0, 'chai', 0.00, '2025-05-05 22:32:13'),
	(18, NULL, 'Motul Scooter Le MB 10W40', 0, '800ML', 0, 'chai', 0.00, '2025-05-05 22:32:13'),
	(19, NULL, 'Motul GP Power 10W40', 0, '800ML', 0, 'chai', 0.00, '2025-05-05 22:32:13'),
	(20, NULL, 'Motul 7100 10W40', 0, '1L2', 0, 'chai', 0.00, '2025-05-05 22:32:13'),
	(21, NULL, 'Motul 7100 10W40', 0, '1L', 0, 'chai', 0.00, '2025-05-05 22:32:13'),
	(22, NULL, 'Motul 7100 10W50', 0, '1L', 0, 'chai', 0.00, '2025-05-05 22:32:13'),
	(23, NULL, 'Motul Nhớt Láp', 0, 'Tuýp', 0, 'tuýp', 0.00, '2025-05-05 22:32:13'),
	(24, NULL, 'Motul Nhớt AVANA 10W40', 0, '800ML', 0, 'chai', 0.00, '2025-05-05 22:32:13'),
	(25, '20753', 'Liqui Moly Street Race 10W40', 0, '1L', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(26, '20826', 'Liqui Moly Scooter Race 10W40', 0, '1L', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(27, '21718', 'Liqui Moly Molygen Scooter 5W30', 0, '1L', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(28, '21895', 'Liqui Moly Molygen Scooter 5W30', 0, '800ML', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(29, '3036', 'Liqui Moly  Formula 4T 10W400', 0, '800ML', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(30, '1521', 'Liqui Moly Synthetic 10W40 Street', 0, '1L', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(31, '6924', 'Liqui Moly Nước Làm Mát', 0, '1L', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(32, '1803', 'Liqui Moly Xúc Pet Xăng Xe Hơi', 0, '300ML', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(33, '7916', 'Liqui Moly Xúc Pet Xăng Xe Máy', 0, '80ML', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(34, '1516', 'Liqui Moly Nhớt Láp', 0, '500ML', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(35, '2427', 'Liqui Moly Súc Rửa Động Cơ', 0, '500ML', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(36, '1680', 'Nhớt Hộp Số Xe Ga 80W90', 0, '150ML', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(37, '3325', 'Liqui Moly VS Cổ Họng Ga', 0, '400ML', 0, 'chai', 0.00, '2025-05-05 22:33:33'),
	(38, '21611', 'Liqui Moly VS Bóng Nhanh Detalinh', 0, '500ML', 0, 'chai', 0.00, '2025-05-05 22:33:33');

CREATE TABLE IF NOT EXISTS `stock_logs` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `action` enum('import','export') DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `note` text DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`log_id`),
  KEY `product_id` (`product_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `stock_logs_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  CONSTRAINT `stock_logs_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `role` enum('admin','nhanvien') DEFAULT 'nhanvien',
  `created_at` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
