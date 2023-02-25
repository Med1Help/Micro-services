-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : sam. 25 fév. 2023 à 23:28
-- Version du serveur : 8.0.32
-- Version de PHP : 8.1.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `fraud`
--

-- --------------------------------------------------------

--
-- Structure de la table `black_list`
--

CREATE TABLE `black_list` (
  `id` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `id_customer` int DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `black_list_seq`
--

CREATE TABLE `black_list_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `black_list_seq`
--

INSERT INTO `black_list_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `fraudulen_customer`
--

CREATE TABLE `fraudulen_customer` (
  `id` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `id_customer` int DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `fraudulen_customer`
--

INSERT INTO `fraudulen_customer` (`id`, `created_at`, `customer_name`, `id_customer`, `updated_at`) VALUES
(2, '2023-02-24 23:00:05.000000', 'fake customer', 56, '2023-02-24 23:00:05.000000');

-- --------------------------------------------------------

--
-- Structure de la table `fraudulen_customer_seq`
--

CREATE TABLE `fraudulen_customer_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `fraudulen_customer_seq`
--

INSERT INTO `fraudulen_customer_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `warned_customer`
--

CREATE TABLE `warned_customer` (
  `id` int NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `id_customer` int DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `warnnings_nbr` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `warned_customer_seq`
--

CREATE TABLE `warned_customer_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `warned_customer_seq`
--

INSERT INTO `warned_customer_seq` (`next_val`) VALUES
(1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `black_list`
--
ALTER TABLE `black_list`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `fraudulen_customer`
--
ALTER TABLE `fraudulen_customer`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `warned_customer`
--
ALTER TABLE `warned_customer`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
