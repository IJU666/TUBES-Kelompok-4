-- phpMyAdmin SQL Dump
-- version 4.9.11
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 09 Jan 2025 pada 09.27
-- Versi server: 8.0.40
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manajemenkeuangan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `aset`
--

CREATE TABLE `aset` (
  `id_aset` int NOT NULL,
  `namaAset` varchar(50) DEFAULT NULL,
  `bulan` varchar(50) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `nilaiAset` decimal(15,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `danadarurat`
--

CREATE TABLE `danadarurat` (
  `id_danaDarurat` int NOT NULL,
  `catatanDanaDarurat` varchar(50) DEFAULT NULL,
  `bulan` varchar(50) DEFAULT NULL,
  `tanggal` varchar(50) DEFAULT NULL,
  `jumlahDanaDarurat` decimal(15,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `laporan`
--

CREATE TABLE `laporan` (
  `id_laporan` char(36) NOT NULL DEFAULT (uuid()),
  `total_pemasukan` decimal(15,3) DEFAULT NULL,
  `total_pengeluaran` decimal(15,3) DEFAULT NULL,
  `total_aset` decimal(15,2) DEFAULT NULL,
  `bulan` varchar(20) DEFAULT NULL,
  `id_pemasukan` int DEFAULT NULL,
  `id_pengeluaran` int DEFAULT NULL,
  `id_aset` int DEFAULT NULL,
  `id_rencanaBudget` int DEFAULT NULL,
  `id_danaDarurat` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemasukan`
--

CREATE TABLE `pemasukan` (
  `id_pemasukan` int NOT NULL,
  `catatanPemasukan` varchar(50) DEFAULT NULL,
  `bulan` varchar(50) DEFAULT NULL,
  `tanggal` varchar(50) DEFAULT NULL,
  `jumlahPemasukan` decimal(15,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `id_pengeluaran` int NOT NULL,
  `catatanPengeluaran` varchar(50) DEFAULT NULL,
  `bulan` varchar(50) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `tanggal` varchar(50) DEFAULT NULL,
  `jumlahPengeluaran` decimal(15,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `rencanabudget`
--

CREATE TABLE `rencanabudget` (
  `id_rencanaBudget` int NOT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `jumlahBudget` decimal(15,3) DEFAULT NULL,
  `bulan` varchar(50) DEFAULT NULL,
  `tglAwal_RB` varchar(50) DEFAULT NULL,
  `tglAkhir_RB` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `aset`
--
ALTER TABLE `aset`
  ADD PRIMARY KEY (`id_aset`);

--
-- Indeks untuk tabel `danadarurat`
--
ALTER TABLE `danadarurat`
  ADD PRIMARY KEY (`id_danaDarurat`);

--
-- Indeks untuk tabel `laporan`
--
ALTER TABLE `laporan`
  ADD PRIMARY KEY (`id_laporan`),
  ADD KEY `id_pemasukan` (`id_pemasukan`),
  ADD KEY `id_pengeluaran` (`id_pengeluaran`),
  ADD KEY `id_aset` (`id_aset`),
  ADD KEY `id_rencanaBudget` (`id_rencanaBudget`),
  ADD KEY `id_danaDarurat` (`id_danaDarurat`);

--
-- Indeks untuk tabel `pemasukan`
--
ALTER TABLE `pemasukan`
  ADD PRIMARY KEY (`id_pemasukan`);

--
-- Indeks untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`id_pengeluaran`);

--
-- Indeks untuk tabel `rencanabudget`
--
ALTER TABLE `rencanabudget`
  ADD PRIMARY KEY (`id_rencanaBudget`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `aset`
--
ALTER TABLE `aset`
  MODIFY `id_aset` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `danadarurat`
--
ALTER TABLE `danadarurat`
  MODIFY `id_danaDarurat` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pemasukan`
--
ALTER TABLE `pemasukan`
  MODIFY `id_pemasukan` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  MODIFY `id_pengeluaran` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `rencanabudget`
--
ALTER TABLE `rencanabudget`
  MODIFY `id_rencanaBudget` int NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `laporan`
--
ALTER TABLE `laporan`
  ADD CONSTRAINT `laporan_ibfk_1` FOREIGN KEY (`id_pemasukan`) REFERENCES `pemasukan` (`id_pemasukan`),
  ADD CONSTRAINT `laporan_ibfk_2` FOREIGN KEY (`id_pengeluaran`) REFERENCES `pengeluaran` (`id_pengeluaran`),
  ADD CONSTRAINT `laporan_ibfk_3` FOREIGN KEY (`id_aset`) REFERENCES `aset` (`id_aset`),
  ADD CONSTRAINT `laporan_ibfk_4` FOREIGN KEY (`id_rencanaBudget`) REFERENCES `rencanabudget` (`id_rencanaBudget`),
  ADD CONSTRAINT `laporan_ibfk_5` FOREIGN KEY (`id_danaDarurat`) REFERENCES `danadarurat` (`id_danaDarurat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
