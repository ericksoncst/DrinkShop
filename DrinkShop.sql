CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `link` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `banner` (`id`, `name`, `link`) VALUES
(1, 'Special Series', 'https://preview.ibb.co/g1a067/31.jpg'),
(2, 'Ice Summer', 'https://preview.ibb.co/ma7DR7/2.jpg'),
(3, 'Signature Series', 'https://preview.ibb.co/fQXDR7/1.jpg');

CREATE TABLE `user` (
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `birthdate` date NOT NULL,
  `address` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`phone`);

ALTER TABLE `banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

