-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2016. Ápr 01. 12:45
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

--
-- A tábla adatainak kiíratása `actor`
--

INSERT INTO `actor` (`id`, `name`, `personal_details`) VALUES
  (1, 'John Travolta', 'John Joseph Travolta was born in Englewood, New Jersey, one of six children of Helen Travolta (née Helen Cecilia Burke) and Salvatore/Samuel J. Travolta. His father was of Italian descent and his mother was of Irish ancestry.'),
  (2, 'Uma Thurman', 'Uma Karuna Thurman was born in Boston, Massachusetts, into a highly unorthodox and Eurocentric family. She is the daughter of Nena Thurman (née Birgitte Caroline von Schlebrügge), a fashion model and socialite who now runs a mountain retreat, and of Robert Thurman (Robert Alexander Farrar Thurman)'),
  (3, 'Samuel L. Jackson', 'Samuel L. Jackson was born in Washington, D.C., to Elizabeth (Montgomery) and Roy Henry Jackson. He was raised by his mother, a factory worker. Jackson was active in the black student movement. In the seventies, he joined the Negro Ensemble Company (together with Morgan Freeman).'),
  (4, 'Leonardo DiCaprio', 'Leonardo Wilhelm DiCaprio was born November 11, 1974 in Los Angeles, California, the only child of Irmelin DiCaprio (née Indenbirken) and former comic book artist George DiCaprio. His father is of Italian and German descent, and his mother, who is German-born, is of German and Russian ancestry. His middle name, "Wilhelm", was his maternal grandfather''s first name.'),
  (5, 'Jonah Hill', 'Jonah Hill was born and raised in Los Angeles, the son of Sharon (Chalkin), a fashion designer and costume stylist, and Richard Feldstein, a tour accountant for Guns N'' Roses. He graduated from Crossroads School in Santa Monica and went on to The New School in New York to study drama.'),
  (6, 'Margot Robbie', 'Margot Robbie is an Australian actress born in Dalby, Queensland, and raised on the Gold Coast, spending much of her time at the farm belonging to her grandparents. Her mother, Sarie Kessler, is a physiotherapist. Robbie attended and graduated from Somerset College. In her late teens, she moved to Melbourne to pursue an acting career.'),
  (7, 'Jack Nicholson', 'Jack Nicholson, an American actor, producer, screen-writer and director, is a three-time Academy Award winner and twelve-time nominee. Nicholson is also notable for being one of two actors - the other being Michael Caine - who have received Oscar nods in every decade from sixties through the naughts.'),
  (8, 'Shelley Duvall', 'Shelley Alexis Duvall was born in Houston, Texas, to Bobbie Ruth (Massengale) and Robert Richardson Duvall, a lawyer. During her childhood, Shelley''s mother humorously gave Shelley the nickname "Manic Mouse", because she would often run around her house and tip over furniture.');

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
  (4, 'NasaMozi', 'Pasadena', '4800 Oak Grove Drive Pasadena, CA 91109', 34.1986494, -118.174585, 'hallo nasa', 'moziadmin@moziadmin.hu'),
  (12, 'HáziMozi', 'Zalaegerszeg', 'Zalaegerszeg Egry József utca 4/C', 46.833847, 16.8272419, 'Mekkora király vagyok', 'moziadmin@moziadmin.hu'),
  (15, 'teszt1', 'Budapest', 'Budapest', 47.497912, 19.040235, 'teszt mozi1', 'moziadmin@moziadmin.hu'),
  (16, 'teszt2', 'Kiskunhalas', 'Kiskunhalas', 46.4354409, 19.4834284, 'teszt mozi2', 'moziadmin@moziadmin.hu'),
  (17, 'teszt3', 'Veszprém', 'Veszprém', 47.1028087, 17.9093019, 'teszt mozi3', 'moziadmin@moziadmin.hu'),
  (18, 'teszt4', 'Debrecen', 'Debrecen', 47.5316049, 21.6273123, 'teszt mozi4', 'moziadmin@moziadmin.hu'),
  (19, 'teszt4', 'Kiskunhalas', 'Kiskunhalas', 46.4354409, 19.4834284, 'Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ', 'moziadmin@moziadmin.hu'),
  (20, 'Árvízt?r?tükörfúrógép', 'Árvízt?r?tükörfúrógép', 'Zalaszentmihály', 46.7256048, 16.9476533, 'Árvízt?r?tükörfúrógép', 'moziadmin@moziadmin.hu');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `director`
--

CREATE TABLE `director` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_hungarian_ci NOT NULL,
  `personal_details` text COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `director`
--

INSERT INTO `director` (`id`, `name`, `personal_details`) VALUES
  (1, 'Quentin Tarantino', 'Quentin Jerome Tarantino was born in Knoxville, Tennessee. His father, Tony Tarantino, is an Italian-American actor and musician from New York, and his mother, Connie (McHugh), is a nurse from Tennessee. Quentin moved with his mother to Torrance, California, when he was four years old.'),
  (2, 'Stanley Kubrick', 'Stanley Kubrick was born in Manhattan, New York City, to Sadie Gertrude (Perveler) and Jacob Leonard Kubrick, a physician. His family were Jewish immigrants (from Austria, Romania, and Russia). Stanley was considered intelligent, despite poor grades at school.'),
  (3, 'Martin Scorsese', 'Martin Charles Scorsese was born on November 17, 1942, in New York City, to Italian-American parents Catherine (Cappa) and Charles Scorsese.');

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
  `title` varchar(50) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `genre`
--

INSERT INTO `genre` (`id`, `title`) VALUES
  (1, 'Action'),
  (2, 'Animation'),
  (3, 'Comedy'),
  (4, 'Documentary'),
  (5, 'Family'),
  (6, 'Horror'),
  (7, 'Musical'),
  (8, 'Romance'),
  (9, 'Sport'),
  (10, 'War'),
  (11, 'Adventure'),
  (12, 'Biography'),
  (13, 'Crime'),
  (14, 'Drama'),
  (15, 'Fantasy'),
  (16, 'History'),
  (17, 'Sci-Fi'),
  (18, 'Thriller'),
  (19, 'Western');

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

--
-- A tábla adatainak kiíratása `movie`
--

INSERT INTO `movie` (`id`, `title`, `original_title`, `duration`, `premiere`, `rate`, `imdb_url`, `youtube_url`, `description`, `director_id`) VALUES
  (1, 'Ponyvaregény', 'Pulp Fiction', 154, '1995-04-13 00:00:00', 9, 'http://www.imdb.com/title/tt0110912/', 'https://www.youtube.com/watch?v=s7EdQ4FqbhY', 'Adott két idősödő, szabad szájú, tökös, szimpatikus gengszter, Vincent (John Travolta) és Jules (Samuel L. Jackson), akik igyekeznek főnöküknek visszaszerezni egy aktatáskát. Ehhez persze meg kell ölniük pár embert, de ez az egyszerű bérgyilkosokkal gyakran megesik. Jules a rá célzott golyókat csodával határos módon elkerüli, s ezt jelnek tekintvén úgy dönt, felhagy eddigi életével. Társának viszont el kell vinnie szórakozni a gengszterfőnök feleségét... Van továbbá egy boxoló, Butch (Bruce Willis), aki a hírhedt marffiafőnök, Marselleus Wallace (Ving Rhames) átvágását tervezi. Hogy-hogy nem, odáig fajul a történet, hogy végül már inkább a megmentésére készül, mint a lelövésére... Nem utolsósorban, pedig, van egy piti rabló-párosunk is (Tim Roth és Amanda Plummer), akik éppen egy étterem kirablására készülnek. Ám ott reggelizik Vincent és Jules.', 1),
  (2, 'A Wall Street farkasa', 'The World of Wall Street', 180, '2013-12-26 00:00:00', 8, 'http://www.imdb.com/title/tt0993846/', 'https://www.youtube.com/watch?v=iszwuX1AK6A', 'A pénz sosem elég. Jordan Belfort (Leonardo DiCaprio) becsületes tőzsdeügynökként kezdte pályafutását, de az amerikai álom őt is utolérte. A 80-as évek végére az egyik legnagyobb brókercég tulajdonosa lett, 26 évesen heti 1 millió dollárt keresett. Az idáig vezető út azonban korrupcióval és tisztességtelen üzletekkel kikövezett csábító hullámvasútnak bizonyult. Mert minél nagyobb volt a kísértés ő annál többet akart, mit sem törődve az illegális üzelmekkel és a nyomában loholó FBI ügynökökkel. Még több pénz, még több hatalom, még több nő és megint még több pénz: ez Jordan életfilozófiája. És hogy a szerénység egy túlértékelt erény. Jordan és falkája azt sem tudták mit kezdjenek az illegálisan megszerzett milliárdokkal, de vajon a jéghegy csúcsáról merre vezet az út?', 3),
  (3, 'Ragyogás', 'The Shining', 146, '1980-05-23 00:00:00', 8, 'http://www.imdb.com/title/tt0081505/', 'https://www.youtube.com/watch?v=5Cb3ik6zP2I', 'A Stephen King azonos című regénye alapján készült mesterműben Jack Nicholson élete egyik legjobb alakítását nyújtja, mint Jack Torrace, aki a családjával a téli holtszezon idejére egy, a világtól elzárt kísérteties hotelba költözik gondnoknak. Ha az évszázados falak mesélni tudnának, hátborzongató történetek tucatjai kerülnének a felszínre. Úgy tűnik, hogy Jack kisfia előtt nincsenek is titkai a háznak, mert látja a fürdőkádba fulladt nőt, az elegáns lakosztályban kivégzett férfit és az összes holt lelket, amelyek nem találnak nyugalmat. De lehet, hogy mindezek a rémképek csupán jeleznek valamit. A Jack agyát elborító őrületet, a folyamatot, amelynek hatására a szerető apa vérszomjas, gyilkos indulatokkal teli szörnyeteggé válik.', 2);

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

--
-- A tábla adatainak kiíratása `movie_actor`
--

INSERT INTO `movie_actor` (`movie_id`, `actor_id`, `character`, `main_character`) VALUES
  (1, 1, 'Vincent Vega', 1),
  (1, 2, 'Mia Wallace', 0),
  (1, 3, 'Jules Winnfield', 1),
  (2, 4, 'Jordan Belfort', 1),
  (2, 5, 'Donnie Azoff', 0),
  (2, 6, 'Naomi Lapaglia', 0),
  (3, 7, 'Jack Torrance', 1),
  (3, 8, 'Wendy Torrance', 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `movie_genre`
--

CREATE TABLE `movie_genre` (
  `movie_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `movie_genre`
--

INSERT INTO `movie_genre` (`movie_id`, `genre_id`) VALUES
  (1, 13),
  (1, 14),
  (2, 3),
  (2, 12),
  (2, 13),
  (3, 6),
  (3, 14);

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
  (44, 'LoremIpsum', '2016-03-06', 'The day of the Dude'),
  (46, 'asd', '2016-03-14', 'asd'),
  (51, 'kjlémáéáééá', '2016-03-18', '??');

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
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT a táblához `cinema`
--
ALTER TABLE `cinema`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT a táblához `director`
--
ALTER TABLE `director`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT a táblához `discount`
--
ALTER TABLE `discount`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT a táblához `genre`
--
ALTER TABLE `genre`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT a táblához `hall`
--
ALTER TABLE `hall`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT a táblához `movie`
--
ALTER TABLE `movie`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT a táblához `news`
--
ALTER TABLE `news`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
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
