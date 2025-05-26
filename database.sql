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

CREATE TABLE IF NOT EXISTS `brands` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO `brands` (`id`, `name`) VALUES
	(1, 'Motul'),
	(2, 'Liqui Moly');

CREATE TABLE IF NOT EXISTS `products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_code` varchar(20) DEFAULT NULL,
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `capacity` varchar(20) DEFAULT NULL,
  `brand` int(11) DEFAULT NULL,
  `current_stock` int(11) DEFAULT 0,
  `new_stock` int(11) DEFAULT 0,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk_brand` (`brand`),
  CONSTRAINT `fk_brand` FOREIGN KEY (`brand`) REFERENCES `brands` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO `products` (`product_id`, `product_code`, `product_name`, `capacity`, `brand`, `current_stock`, `new_stock`, `image_url`) VALUES
	(23, '', 'Scooter Le 10W40', '800ML', 1, 0, 0, NULL),
	(24, '', 'Scooter Le MB 10W40', '800ML', 1, 0, 0, NULL),
	(25, '', 'GP Power 10W40', '800ML', 1, 0, 0, NULL),
	(26, '', '7100 10W40', '1L2', 1, 0, 0, NULL),
	(27, '', '7100 10W40', '1L', 1, 0, 0, NULL),
	(28, '', '7100 10W50', '1L', 1, 0, 0, NULL),
	(29, '', 'Nhớt Láp', 'Tuýp', 1, 0, 0, NULL),
	(30, '', 'Nhớt AVANA 10W40', '800ML', 1, 100, 50, NULL),
	(31, '20753', 'Street Race 10W40', '1L', 2, 0, 0, NULL),
	(32, '20826', 'Scooter Race 10W40', '1L', 2, 0, 0, NULL),
	(33, '21718', 'Molygen Scooter 5W30', '1L', 2, 0, 0, NULL),
	(34, '21895', 'Molygen Scooter 5W30', '800ML', 2, 0, 0, NULL),
	(35, '3036', 'Formula 4T 10W400', '800ML', 2, 0, 0, NULL),
	(36, '1521', 'Synthetic 10W40 Street', '1L', 2, 0, 0, NULL),
	(37, '6924', 'Nước Làm Mát', '1L', 2, 0, 0, NULL),
	(38, '1803', 'Xúc Pet Xăng Xe Hơi', '300ML', 2, 0, 0, NULL),
	(39, '7916', 'Xúc Pet Xăng Xe Máy', '80ML', 2, 0, 0, NULL),
	(40, '1516', 'Nhớt Láp', '500ML', 2, 0, 0, NULL),
	(41, '2427', 'Súc Rửa Động Cơ', '500ML', 2, 0, 0, NULL),
	(42, '1680', 'Nhớt Hộp Số Xe Ga 80W90', '150ML', 2, 0, 0, NULL),
	(44, '21611', 'VS Bóng Nhanh Detailing', '500ML', 2, 0, 0, NULL);

DELIMITER //
CREATE PROCEDURE `sp_export_stock`(
    IN p_user_id INT,
    IN p_product_id INT,
    IN p_quantity INT,
    IN p_note TEXT
)
BEGIN
    -- Kiểm tra tồn kho đủ không
    IF (SELECT sl_ton FROM products WHERE product_id = p_product_id) < p_quantity THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không đủ hàng trong kho để xuất.';
    END IF;

    -- Thêm phiếu xuất
    INSERT INTO export_receipts (user_id, note) VALUES (p_user_id, p_note);
    SET @receipt_id = LAST_INSERT_ID();

    -- Chi tiết xuất
    INSERT INTO export_details (receipt_id, product_id, quantity) 
    VALUES (@receipt_id, p_product_id, p_quantity);

    -- Ghi nhật ký
    INSERT INTO stock_logs (product_id, user_id, action, quantity, note)
    VALUES (p_product_id, p_user_id, 'export', p_quantity, p_note);

    -- Cập nhật tồn kho
    UPDATE products SET sl_ton = sl_ton - p_quantity WHERE product_id = p_product_id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE `sp_import_stock`(
    IN p_user_id INT,
    IN p_product_id INT,
    IN p_quantity INT,
    IN p_note TEXT
)
BEGIN
    -- Thêm phiếu nhập (đơn giản)
    INSERT INTO import_receipts (user_id, note) VALUES (p_user_id, p_note);
    SET @receipt_id = LAST_INSERT_ID();

    -- Chi tiết sản phẩm nhập
    INSERT INTO import_details (receipt_id, product_id, quantity) 
    VALUES (@receipt_id, p_product_id, p_quantity);

    -- Ghi nhật ký
    INSERT INTO stock_logs (product_id, user_id, action, quantity, note)
    VALUES (p_product_id, p_user_id, 'import', p_quantity, p_note);

    -- Cập nhật tồn kho
    UPDATE products SET sl_ton = sl_ton + p_quantity WHERE product_id = p_product_id;
END//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) DEFAULT NULL,
  `role` enum('admin','staff') DEFAULT 'staff',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

INSERT INTO `users` (`user_id`, `username`, `password`, `full_name`, `role`) VALUES
	(1, 'staff', 'Hongbiet@123', 'Tui Là Staff', 'staff'),
	(2, 'admin', 'Caigivay@123', 'khong biet', 'admin');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
