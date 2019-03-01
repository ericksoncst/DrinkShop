-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 01/03/2019 às 20:49
-- Versão do servidor: 10.1.37-MariaDB
-- Versão do PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `DrinkShop`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `banner`
--

CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `link` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `banner`
--

INSERT INTO `banner` (`id`, `name`, `link`) VALUES
(1, 'Special Series', 'https://preview.ibb.co/g1a067/31.jpg'),
(2, 'Ice Summer', 'https://preview.ibb.co/ma7DR7/2.jpg'),
(3, 'Signature Series', 'https://preview.ibb.co/fQXDR7/1.jpg');

-- --------------------------------------------------------

--
-- Estrutura para tabela `drink`
--

CREATE TABLE `drink` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `link` text NOT NULL,
  `price` float NOT NULL,
  `menuId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `drink`
--

INSERT INTO `drink` (`id`, `name`, `link`, `price`, `menuId`) VALUES
(1, 'Squash tea\r\n', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-Milkfoam-1.png', 3.75, 10),
(3, 'Oolong tea\r\n', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Oolong-Milkfoam-2.png', 3.75, 10),
(4, 'Alisan tea\r\n', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Alisan-Milkfoam-1.png', 3.75, 10),
(5, 'Earl tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Earl-Grey-Milkfoam-1.png', 3.75, 10),
(6, 'Black tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-%C4%90en-Milkfoam-1.png', 3.75, 10),
(7, 'Green tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Xanh-Milkfoam-1.png', 3.75, 10),
(8, 'Milk Tea Red Bean', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Matcha-%C4%91%E1%BA%ADu-%C4%91%E1%BB%8F-1.png', 3.75, 9),
(9, 'Milk Tea Oolong 3J', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Oolong-3J-1.png', 3.75, 9),
(10, 'Milk Tea Pudding Read Bean', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Pudding-%C4%91%E1%BA%ADu-%C4%91%E1%BB%8F-1.png', 3.75, 9),
(11, 'Milk Tea Chocolate', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Chocolate-1.png', 3.75, 9),
(12, 'Milk Tea Caramel', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Caramel-1.png', 3.75, 9),
(13, 'Milk Tea Black Pearl', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Caramel-1.png', 3.75, 9),
(14, 'Squash Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-Alisan-1.png', 3.75, 8),
(15, 'Squash Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-1.png', 3.75, 8),
(16, 'Earl Grey Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Early-Grey-1.png', 3.75, 8),
(17, 'Oolong Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Oolong-1.png', 3.75, 8),
(18, 'Black Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-%C4%90en-1.png', 3.75, 8),
(19, 'Green Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-Xanh-1.png', 3.75, 8),
(20, 'QQ Green Tea ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png', 3.75, 5),
(21, 'Lemon Ai-yu and White Pearl ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Chanh-Aiyu-tr%C3%A2n-ch%C3%A2u-tr%E1%BA%AFng-1.png', 3.75, 5),
(22, 'Pink Peach ', 'http://gongcha.com.vn/wp-content/uploads/2018/02/imgpsh_fullsize.png', 3.75, 5),
(23, 'Fig Oolong Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Oolong-v%E1%BA%A3i-1.png', 3.75, 5),
(24, 'Fig Alisan Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Alisan-v%E1%BA%A3i-1.png', 3.75, 5),
(25, 'Mango Alisan Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Alisan-xo%C3%A0i-1.png', 3.75, 5),
(26, 'Lemon Green Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Xanh-%C4%91%C3%A0o-1.png', 3.75, 5),
(27, 'Lemon Alisan Green Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Xanh-%C4%91%C3%A0o-1.png', 3.75, 5),
(28, 'Peach Black Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/%C4%90en-%C4%91%C3%A0o-1.png', 3.75, 5),
(29, 'Peach Green Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Xanh-%C4%91%C3%A0o-1.png', 3.75, 5),
(30, 'Chocolate Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Chocolate-%C4%91%C3%A1-xay-1.png', 3.75, 6),
(31, 'Taro Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Khoai-m%C3%B4n-%C4%91%C3%A1-xay-1.png', 3.75, 6),
(32, 'Matcha Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Matcha-%C4%91%C3%A1-xay-1.png', 3.75, 6),
(33, 'Yakult Peach Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Yakult-%C4%91%C3%A1-xay-1.png', 3.75, 6),
(34, 'Mango Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Xo%C3%A0i-%C4%91%C3%A1-xay-1.png', 3.75, 6),
(35, 'Peach Tea Grind', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-%C4%91%C3%A0o-%C4%91%C3%A1-tuy%E1%BA%BFt-fix.png', 3.75, 6),
(36, 'Milk Cream', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Kem-S%E1%BB%AFa.png', 2, 7),
(37, 'Vera', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Nha-%C4%90am.png', 2, 7),
(38, 'Seeds', 'http://gongcha.com.vn/wp-content/uploads/2018/03/H%E1%BA%A1t-%C3%89.png', 2, 7),
(39, 'Black Pearl', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Tr%C3%A2n-Ch%C3%A2u-%C4%90en.png', 2, 7),
(40, 'White Pearl', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Tr%C3%A2n-Ch%C3%A2u-Tr%E1%BA%AFng.png', 2, 7),
(41, 'Red Bean', 'http://gongcha.com.vn/wp-content/uploads/2018/03/%C4%90%E1%BA%ADu-%C4%90%E1%BB%8F.png', 2, 7),
(42, 'Jelly Black', 'http://gongcha.com.vn/wp-content/uploads/2018/03/S%C6%B0%C6%A1ng-s%C3%A1o.png', 2, 7),
(43, 'Jelly Brown', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Th%E1%BA%A1ch-N%C3%A2u.png', 2, 7),
(44, 'Jelly Fruits', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Th%E1%BA%A1ch-tr%C3%A1i-c%C3%A2y.png', 2, 7),
(45, 'Jelly Ai-yu', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Th%E1%BA%A1ch-Ai-yu.png', 2, 7),
(46, 'Jelly Coconut', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Th%E1%BA%A1ch-D%E1%BB%ABa.png', 2, 7),
(47, 'Pudding', 'http://gongcha.com.vn/wp-content/uploads/2018/03/%E5%B8%83%E4%B8%81-pudding.png', 2, 7),
(48, 'Combo 2', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Combo2loaihat-2.png', 2.5, 7),
(49, 'Combo 3', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Combo-3-lo%E1%BA%A1i-h%E1%BA%A1t.png', 2.5, 7);

-- --------------------------------------------------------

--
-- Estrutura para tabela `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `link` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Despejando dados para a tabela `menu`
--

INSERT INTO `menu` (`id`, `name`, `link`) VALUES
(5, 'Mixed Drink', 'http://gongcha.com.vn/wp-content/uploads/2018/02/QQ-Tr%C3%A0-xanh-chanh-d%C3%A2y-1.png'),
(6, 'Ice Drink', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Chocolate-%C4%91%C3%A1-xay-1.png'),
(7, 'Topping', 'http://gongcha.com.vn/wp-content/uploads/2018/03/Tr%C3%A2n-Ch%C3%A2u-Tr%E1%BA%AFng.png'),
(8, 'Original Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-Alisan-1.png'),
(9, 'Milk Tea', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-s%E1%BB%AFa-Hokkaido-1.png'),
(10, 'Special Drink', 'http://gongcha.com.vn/wp-content/uploads/2018/02/Tr%C3%A0-B%C3%AD-%C4%90ao-Milkfoam-1.png');

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

CREATE TABLE `user` (
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `birthdate` date NOT NULL,
  `address` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Despejando dados para a tabela `user`
--

INSERT INTO `user` (`phone`, `name`, `birthdate`, `address`) VALUES
('+5511959550063', 'Erickson', '0000-00-00', 'teste mobile'),
('9999', 'Erickson Teixeira', '0000-00-00', 'rua da lei');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `drink`
--
ALTER TABLE `drink`
  ADD PRIMARY KEY (`id`),
  ADD KEY `menuId` (`menuId`);

--
-- Índices de tabela `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`phone`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `banner`
--
ALTER TABLE `banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `drink`
--
ALTER TABLE `drink`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de tabela `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `drink`
--
ALTER TABLE `drink`
  ADD CONSTRAINT `drink_ibfk_1` FOREIGN KEY (`menuId`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
