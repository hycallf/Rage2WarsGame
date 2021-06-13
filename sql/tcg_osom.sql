-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Jun 2021 pada 13.40
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
  `gems` int(100) NOT NULL,
  `level` int(100) NOT NULL DEFAULT '1',
  `email` varchar(100) NOT NULL,
  `nickname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `account`
--

INSERT INTO `account` (`account_id`, `username`, `password`, `exp`, `gold`, `gems`, `level`, `email`, `nickname`) VALUES
(1, 'haikaru2001', 'udiin123', 0, 1000, 0, 1, 'ricardohaikal2001@gmail.com', 'RickRolled'),
(2, 'jonny123', 'cage123', 25, 1000, 0, 1, 'johnchena2001@gmail.com', 'JhonnChena'),
(4, 'joker123', 'jojo123', 0, 1000, 0, 1, 'jojo@joestar.com', 'JonathanJoestar'),
(5, 'uus123', 'tuturu123', 0, 1000, 0, 1, 'uusdino@gmail.com', 'UUSDINO'),
(6, 'asdasd', 'asdas', 0, 1000, 0, 1, 'asda', ''),
(7, 'Ucuy', 'jiji', 0, 1000, 0, 1, 'ucuy@gmail.com', 'Jrox');

-- --------------------------------------------------------

--
-- Struktur dari tabel `card`
--

CREATE TABLE `card` (
  `id_card` int(11) NOT NULL,
  `card_name` text NOT NULL,
  `att_power` int(11) NOT NULL,
  `def_power` int(11) NOT NULL,
  `card_type` int(11) NOT NULL,
  `img` varchar(100) NOT NULL,
  `highlight` varchar(100) NOT NULL,
  `gallery` varchar(100) NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `history`
--

CREATE TABLE `history` (
  `id_play` int(20) NOT NULL,
  `p1_card` int(3) NOT NULL,
  `cpu_card` int(3) NOT NULL,
  `p1_hp` int(10) NOT NULL,
  `cpu_hp` int(10) NOT NULL,
  `win_lose` varchar(5) NOT NULL,
  `date` varchar(20) NOT NULL,
  `account_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `history`
--

INSERT INTO `history` (`id_play`, `p1_card`, `cpu_card`, `p1_hp`, `cpu_hp`, `win_lose`, `date`, `account_id`) VALUES
(1, 30, 28, 8200, -400, 'WIN', '13 Jun, 2021', 2),
(2, 19, 18, 0, 900, 'LOSE', '13 Jun, 2021', 2);

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
  ADD PRIMARY KEY (`id_card`),
  ADD KEY `account_id` (`account_id`);

--
-- Indeks untuk tabel `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`id_play`),
  ADD KEY `account_id` (`account_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `account`
--
ALTER TABLE `account`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `card`
--
ALTER TABLE `card`
  MODIFY `id_card` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `history`
--
ALTER TABLE `history`
  MODIFY `id_play` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `card`
--
ALTER TABLE `card`
  ADD CONSTRAINT `card_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);

--
-- Ketidakleluasaan untuk tabel `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
