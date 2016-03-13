-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2016. Már 13. 20:40
-- Kiszolgáló verziója: 10.1.10-MariaDB
-- PHP verzió: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `webalapu_mozi`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `actor`
--

CREATE TABLE `actor` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `personal_details` text COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `cinema`
--

CREATE TABLE `cinema` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `city` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `description` text COLLATE utf8_hungarian_ci NOT NULL,
  `admin_id` varchar(100) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `cinema`
--

INSERT INTO `cinema` (`id`, `name`, `city`, `address`, `latitude`, `longitude`, `description`, `admin_id`) VALUES
(1, 'FlowMozi', 'Passadena', '100 N. Garfield Ave., Pasadena, CA  91109', 47.085166, 17.910768, 'Go with the flow...\r\nTake it easy...', 'moziadmin@moziadmin.hu'),
(2, 'TheDudeCinema', 'Pacsa', 'Pacsa,Szabadság tér', 46.724712, 16.976591, 'Im gonna kill you', 'moziadmin@moziadmin.hu'),
(3, 'TesztMozi', 'Zalaegerszeg', 'Zalaegerszeg Egry József utca 4/C', 46.833847, 16.8272419, 'Mozi hozzáadva az oldalról', 'moziadmin@moziadmin.hu'),
(4, 'NasaMozi', 'Pasadena', '4800 Oak Grove Drive Pasadena, CA 91109', 34.1986494, -118.174585, 'hallo nasa', 'moziadmin@moziadmin.hu');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `director`
--

CREATE TABLE `director` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `personal_details` text COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `discount`
--

CREATE TABLE `discount` (
  `id` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- A tábla adatainak kiíratása `discount`
--

INSERT INTO `discount` (`id`, `type`, `amount`) VALUES
(1, 'Teljes árú', 1),
(2, 'Diák', 0.6),
(3, 'Nyugdíjas', 0.7),
(4, 'Alkalmazott', 0.8);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `title` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `description` text COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `hall`
--

CREATE TABLE `hall` (
  `id` int(11) NOT NULL,
  `cinema_id` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8_hungarian_ci NOT NULL,
  `rows` int(11) NOT NULL,
  `cols` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `title` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `original_title` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `duration` int(11) NOT NULL,
  `premiere` datetime NOT NULL,
  `rate` int(11) NOT NULL,
  `imdb_url` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `youtube_url` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `description` text COLLATE utf8_hungarian_ci NOT NULL,
  `director_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `movie_actor`
--

CREATE TABLE `movie_actor` (
  `movie_id` int(11) NOT NULL,
  `actor_id` int(11) NOT NULL,
  `character` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `main_character` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `movie_genre`
--

CREATE TABLE `movie_genre` (
  `movie_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `news`
--

CREATE TABLE `news` (
  `id` int(11) NOT NULL,
  `title` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `date` date NOT NULL,
  `content` text COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `news`
--

INSERT INTO `news` (`id`, `title`, `date`, `content`) VALUES
(36, 'Jók a formázások', '2016-03-06', '<span style="font-style: normal; font-weight: bold;">asd</span><div><span style="font-style: italic;">asd</span></div><div><span style="text-decoration: underline;">asd</span></div><div><span style="text-decoration: underline; font-weight: bold; font-style: italic;">asd</span></div><div><span style="text-decoration: underline; font-weight: bold; font-style: italic; color: rgb(255, 204, 51);">asdasdasd</span></div>'),
(38, 'Ékezetek', '2016-03-06', 'Árvízt?r?tükörfúrógép'),
(43, 'Ékezetek v2', '2016-03-06', 'ÁRVÍZT?R?TÖKÜRFÚRÓGÉP'),
(44, 'LoremIpsum', '2016-03-06', 'The day of the Dude');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `screening`
--

CREATE TABLE `screening` (
  `id` int(11) NOT NULL,
  `hall_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `start` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `priece` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ticket`
--

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `screening_id` int(11) NOT NULL,
  `user_id` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `reservation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `used` tinyint(1) NOT NULL DEFAULT '0',
  `paid` tinyint(1) NOT NULL DEFAULT '0',
  `hall_row` int(11) NOT NULL,
  `hall_col` int(11) NOT NULL,
  `discount_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `first_name` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8_hungarian_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `credit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`first_name`, `last_name`, `email`, `password`, `credit`) VALUES
('Teszt', 'Admin', 'admin@admin.hu', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 100),
('Teszt', 'MoziAdmin', 'moziadmin@moziadmin.hu', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 100),
('Teszt', 'User', 'testuser@user.hu', '5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5', 100);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user_role`
--

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `user_id` varchar(100) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `user_role`
--

INSERT INTO `user_role` (`id`, `group_id`, `user_id`) VALUES
(6, 3, 'admin@admin.hu'),
(8, 2, 'moziadmin@moziadmin.hu'),
(10, 1, 'testuser@user.hu');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `cinema`
--
ALTER TABLE `cinema`
  ADD PRIMARY KEY (`id`),
  ADD KEY `admin_id` (`admin_id`);

--
-- A tábla indexei `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `hall`
--
ALTER TABLE `hall`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cinema_id` (`cinema_id`);

--
-- A tábla indexei `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `director_id` (`director_id`);

--
-- A tábla indexei `movie_actor`
--
ALTER TABLE `movie_actor`
  ADD PRIMARY KEY (`movie_id`,`actor_id`),
  ADD KEY `actor_id` (`actor_id`);

--
-- A tábla indexei `movie_genre`
--
ALTER TABLE `movie_genre`
  ADD PRIMARY KEY (`movie_id`,`genre_id`),
  ADD KEY `genre_id` (`genre_id`);

--
-- A tábla indexei `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `screening`
--
ALTER TABLE `screening`
  ADD PRIMARY KEY (`id`),
  ADD KEY `hall_id` (`hall_id`),
  ADD KEY `movie_id` (`movie_id`);

--
-- A tábla indexei `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `screening_id` (`screening_id`),
  ADD KEY `discount_id` (`discount_id`),
  ADD KEY `user_id` (`user_id`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- A tábla indexei `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`),
  ADD KEY `group_id` (`group_id`),
  ADD KEY `user_id` (`user_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `actor`
--
ALTER TABLE `actor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT a táblához `cinema`
--
ALTER TABLE `cinema`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT a táblához `director`
--
ALTER TABLE `director`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT a táblához `discount`
--
ALTER TABLE `discount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT a táblához `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT a táblához `hall`
--
ALTER TABLE `hall`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT a táblához `movie`
--
ALTER TABLE `movie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT a táblához `news`
--
ALTER TABLE `news`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT a táblához `screening`
--
ALTER TABLE `screening`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT a táblához `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT a táblához `user_role`
--
ALTER TABLE `user_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `cinema`
--
ALTER TABLE `cinema`
  ADD CONSTRAINT `cinema_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `hall`
--
ALTER TABLE `hall`
  ADD CONSTRAINT `hall_ibfk_1` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `movie`
--
ALTER TABLE `movie`
  ADD CONSTRAINT `movie_ibfk_1` FOREIGN KEY (`director_id`) REFERENCES `director` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `movie_actor`
--
ALTER TABLE `movie_actor`
  ADD CONSTRAINT `movie_actor_ibfk_1` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `movie_actor_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `movie_genre`
--
ALTER TABLE `movie_genre`
  ADD CONSTRAINT `movie_genre_ibfk_1` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `movie_genre_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `screening`
--
ALTER TABLE `screening`
  ADD CONSTRAINT `screening_ibfk_1` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `screening_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`screening_id`) REFERENCES `screening` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
