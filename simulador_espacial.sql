-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-03-2020 a las 16:45:54
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `simulador_espacial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadistica`
--

CREATE TABLE `estadistica` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `equipo` enum('rojo','azul') NOT NULL,
  `cantidad_viper` int(10) UNSIGNED NOT NULL,
  `cantidad_escolta` int(10) UNSIGNED NOT NULL,
  `cantidad_linea` int(10) UNSIGNED NOT NULL,
  `superviviente_viper` int(10) UNSIGNED NOT NULL,
  `superviviente_escolta` int(10) UNSIGNED NOT NULL,
  `superviviente_linea` int(10) UNSIGNED NOT NULL,
  `dano_emitido` bigint(20) UNSIGNED NOT NULL,
  `dano_recibido` bigint(20) UNSIGNED NOT NULL,
  `dano_mitigado` bigint(20) UNSIGNED NOT NULL,
  `disparo_acertado` bigint(20) UNSIGNED NOT NULL,
  `disparo_fallido` bigint(20) UNSIGNED NOT NULL,
  `disparo_evadido` bigint(20) UNSIGNED NOT NULL,
  `disparo_total` bigint(20) UNSIGNED NOT NULL,
  `poder_militar` bigint(20) UNSIGNED NOT NULL,
  `id_partida` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `id` int(10) UNSIGNED NOT NULL,
  `vencedor` varchar(100) NOT NULL,
  `derrotado` varchar(100) NOT NULL,
  `fecha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estadistica`
--
  ALTER TABLE `estadistica`
    ADD PRIMARY KEY (`id`),
    ADD KEY `estadistica_ibfk_1` (`id_partida`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estadistica`
--
ALTER TABLE `estadistica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `estadistica`
--
ALTER TABLE `estadistica`
  ADD CONSTRAINT `estadistica_ibfk_1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
