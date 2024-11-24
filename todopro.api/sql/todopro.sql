-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2024 a las 04:36:03
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `todopro`
--
CREATE DATABASE IF NOT EXISTS `todopro` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `todopro`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `todo`
--

CREATE TABLE `todo` (
  `id` bigint(20) NOT NULL,
  `completed` bit(1) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `todo_list_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `todo_list`
--

CREATE TABLE `todo_list` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id_user` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `name`, `password`, `role`, `username`) VALUES
(1, 'Eliezer Navarro P.', '$2a$10$DRtD6u4iWycTIrKGcrYuTOITp0JZq88lClhTIgzJ3YMvzlB7LnWOG', 'USER', 'enp');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK46ccwnsi9409t36lurvtyljak` (`name`);

--
-- Indices de la tabla `todo`
--
ALTER TABLE `todo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeh6uro943emclp6kr1d4wysmo` (`category_id`),
  ADD KEY `FKln1nkwl9wnw9jhi4q9ehea164` (`todo_list_id`);

--
-- Indices de la tabla `todo_list`
--
ALTER TABLE `todo_list`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjm6lu9puvw8wsvw5tal7pw7iv` (`user_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `todo`
--
ALTER TABLE `todo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `todo_list`
--
ALTER TABLE `todo_list`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `todo`
--
ALTER TABLE `todo`
  ADD CONSTRAINT `FKeh6uro943emclp6kr1d4wysmo` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKln1nkwl9wnw9jhi4q9ehea164` FOREIGN KEY (`todo_list_id`) REFERENCES `todo_list` (`id`);

--
-- Filtros para la tabla `todo_list`
--
ALTER TABLE `todo_list`
  ADD CONSTRAINT `FKjm6lu9puvw8wsvw5tal7pw7iv` FOREIGN KEY (`user_id`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
