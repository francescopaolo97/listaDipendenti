-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 29, 2024 alle 17:54
-- Versione del server: 10.4.27-MariaDB
-- Versione PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dipendenti`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `dipendente`
--

CREATE TABLE `dipendente` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id_ruolo` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `dipendente`
--

INSERT INTO `dipendente` (`id`, `email`, `password`, `username`, `id_ruolo`) VALUES
(1, 'francesco@mail.com', 'Password1!', 'francesco', 1),
(2, 'christian@mail.com', 'Password1!', 'christian', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `dipendenti_skill`
--

CREATE TABLE `dipendenti_skill` (
  `livello` varchar(255) DEFAULT NULL,
  `id_dipendente` bigint(20) NOT NULL,
  `id_skill` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `dipendenti_skill`
--

INSERT INTO `dipendenti_skill` (`livello`, `id_dipendente`, `id_skill`) VALUES
('Avanzato', 1, 1),
('Avanzato', 2, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `ruolo`
--

CREATE TABLE `ruolo` (
  `id` bigint(20) NOT NULL,
  `tipo_ruolo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `ruolo`
--

INSERT INTO `ruolo` (`id`, `tipo_ruolo`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Struttura della tabella `skill`
--

CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL,
  `competenza` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `skill`
--

INSERT INTO `skill` (`id`, `competenza`) VALUES
(1, 'HTML'),
(2, 'CSS'),
(3, 'JAVA'),
(4, 'JAVASCRIPT'),
(5, 'SQL');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `dipendente`
--
ALTER TABLE `dipendente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmx65oe12q24e90eewqduci5hl` (`id_ruolo`);

--
-- Indici per le tabelle `dipendenti_skill`
--
ALTER TABLE `dipendenti_skill`
  ADD PRIMARY KEY (`id_dipendente`,`id_skill`),
  ADD KEY `FKcch7boa1ys2w8sfggoq0l9ede` (`id_skill`);

--
-- Indici per le tabelle `ruolo`
--
ALTER TABLE `ruolo`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `dipendente`
--
ALTER TABLE `dipendente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `ruolo`
--
ALTER TABLE `ruolo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `skill`
--
ALTER TABLE `skill`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `dipendente`
--
ALTER TABLE `dipendente`
  ADD CONSTRAINT `FKmx65oe12q24e90eewqduci5hl` FOREIGN KEY (`id_ruolo`) REFERENCES `ruolo` (`id`);

--
-- Limiti per la tabella `dipendenti_skill`
--
ALTER TABLE `dipendenti_skill`
  ADD CONSTRAINT `FK45ud1xcr6mtyjjetl8ra5rsya` FOREIGN KEY (`id_dipendente`) REFERENCES `dipendente` (`id`),
  ADD CONSTRAINT `FKcch7boa1ys2w8sfggoq0l9ede` FOREIGN KEY (`id_skill`) REFERENCES `skill` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
