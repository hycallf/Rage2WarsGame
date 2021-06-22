-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Jun 2021 pada 12.29
-- Versi server: 10.1.32-MariaDB
-- Versi PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tcg_osom`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `account`
--

CREATE TABLE `account` (
  `account_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `exp` int(255) NOT NULL DEFAULT '0',
  `gold` int(255) NOT NULL DEFAULT '1000',
  `gems` int(100) NOT NULL DEFAULT '0',
  `level` int(100) NOT NULL DEFAULT '1',
  `email` varchar(100) NOT NULL,
  `nickname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `account`
--

INSERT INTO `account` (`account_id`, `username`, `password`, `exp`, `gold`, `gems`, `level`, `email`, `nickname`) VALUES
(1, 'rangga123', 'rangga123', 0, 1000, 0, 1, 'lordrangga123@gmail.com', 'LordRangga');

-- --------------------------------------------------------

--
-- Struktur dari tabel `card`
--

CREATE TABLE `card` (
  `account_id` int(11) NOT NULL,
  `id_card` int(11) NOT NULL,
  `card_name` text NOT NULL,
  `att_power` int(11) NOT NULL,
  `def_power` int(11) NOT NULL,
  `card_type` varchar(11) NOT NULL,
  `img` varchar(100) NOT NULL,
  `hand_card` varchar(30) NOT NULL,
  `highlight` varchar(100) NOT NULL,
  `selectImg` varchar(100) NOT NULL,
  `rarity` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `card`
--

INSERT INTO `card` (`account_id`, `id_card`, `card_name`, `att_power`, `def_power`, `card_type`, `img`, `hand_card`, `highlight`, `selectImg`, `rarity`) VALUES
(1, 14, 'Cat getting yelled', 2400, 1000, 'batu', 'IV014.png', 'HC014.png', 'BC014.png', 'DC014.png', 'A'),
(1, 15, 'Diccbudd', 2300, 1100, 'kertas', 'IV015.png', 'HC015.png', 'BC015.png', 'DC015.png', 'A'),
(1, 16, 'Think Mark!', 1500, 900, 'batu', 'IV016.png', 'HC016.png', 'BC016.png', 'DC016.png', 'B'),
(1, 17, 'Mark, who can\'t think', 1500, 900, 'gunting', 'IV017.png', 'HC017.png', 'BC017.png', 'DC017.png', 'B'),
(1, 18, 'The Blurred Girl', 1000, 1400, 'kertas', 'IV018.png', 'HC018.png', 'BC018.png', 'DC018.png', 'B'),
(1, 19, 'The Distracted Guy', 1100, 1300, 'batu', 'IV019.png', 'HC019.png', 'BC019.png', 'DC019.png', 'B'),
(1, 20, 'Angry GF', 1200, 1200, 'gunting', 'IV020.png', 'HC020.png', 'BC020.png', 'DC020.png', 'B'),
(1, 21, 'Lol is u ded?', 1200, 1200, 'kertas', 'IV021.png', 'HC021.png', 'BC021.png', 'DC021.png', 'B'),
(1, 22, 'Ded guy', 1000, 1500, 'batu', 'IV022.png', 'HC022.png', 'BC022.png', 'DC022.png', 'B'),
(1, 23, 'U see that guy?', 1500, 700, 'gunting', 'IV023.png', 'HC023.png', 'BC023.png', 'DC023.png', 'B'),
(1, 24, 'That Guy', 1400, 900, 'kertas', 'IV024.png', 'HC024.png', 'BC024.png', 'DC024.png', 'B'),
(1, 25, 'Now angry guy', 1600, 500, 'batu', 'IV025.png', 'HC025.png', 'BC025.png', 'DC025.png', 'B'),
(1, 26, 'No U', 0, 3000, 'gunting', 'IV026.png', 'HC026.png', 'BC026.png', 'DC026.png', 'B'),
(1, 27, 'Meme Man', 1000, 1000, 'kertas', 'IV027.png', 'HC027.png', 'BC027.png', 'DC027.png', 'B'),
(1, 28, 'Orang Man', 1000, 1000, 'batu', 'IV028.png', 'HC028.png', 'BC028.png', 'DC028.png', 'B'),
(1, 29, 'Ara ara nee-san', 1500, 600, 'gunting', 'IV029.png', 'HC029.png', 'BC029.png', 'DC029.png', 'B'),
(1, 30, 'Shota-kun', 1000, 1200, 'kertas', 'IV030.png', 'HC030.png', 'BC030.png', 'DC030.png', 'B'),
(1, 31, 'Lord Elon', 1300, 900, 'batu', 'IV031.png', 'HC031.png', 'BC031.png', 'DC031.png', 'B'),
(1, 32, 'Elons Dolphin.exe', 900, 1300, 'gunting', 'IV032.png', 'HC032.png', 'BC032.png', 'DC032.png', 'B'),
(1, 33, 'Lord Zucc', 2700, 0, 'kertas', 'IV033.png', 'HC033.png', 'BC033.png', 'DC033.png', 'B');

-- --------------------------------------------------------

--
-- Struktur dari tabel `deck`
--

CREATE TABLE `deck` (
  `account_id` int(11) NOT NULL,
  `card_name` varchar(20) NOT NULL,
  `att_power` int(11) NOT NULL,
  `def_power` int(11) NOT NULL,
  `card_type` varchar(11) NOT NULL,
  `battle_card` varchar(100) NOT NULL,
  `hand_card` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `history`
--

CREATE TABLE `history` (
  `p1_card` int(3) NOT NULL,
  `cpu_card` int(3) NOT NULL,
  `p1_hp` int(10) NOT NULL,
  `cpu_hp` int(10) NOT NULL,
  `win_lose` varchar(5) NOT NULL,
  `date` varchar(20) NOT NULL,
  `play_time` varchar(15) NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `card`
--
ALTER TABLE `card`
  ADD KEY `account_id` (`account_id`);

--
-- Indeks untuk tabel `deck`
--
ALTER TABLE `deck`
  ADD KEY `account_id` (`account_id`);

--
-- Indeks untuk tabel `history`
--
ALTER TABLE `history`
  ADD KEY `account_id` (`account_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `account`
--
ALTER TABLE `account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `card_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Ketidakleluasaan untuk tabel `deck`
--
ALTER TABLE `deck`
  ADD CONSTRAINT `deck_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Ketidakleluasaan untuk tabel `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
