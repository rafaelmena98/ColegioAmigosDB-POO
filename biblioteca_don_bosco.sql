-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2026 a las 20:21:50
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
-- Base de datos: `biblioteca_don_bosco`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

CREATE TABLE `ejemplares` (
  `codigo` varchar(20) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `anio_publicacion` int(11) NOT NULL,
  `tipo_documento` enum('Libro','Tesis','Revista','Articulo','Memoria') NOT NULL,
  `descripcion` text DEFAULT NULL,
  `estado` enum('Disponible','Prestado','Extraviado','Baja') DEFAULT 'Disponible'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplares`
--

INSERT INTO `ejemplares` (`codigo`, `titulo`, `autor`, `anio_publicacion`, `tipo_documento`, `descripcion`, `estado`) VALUES
('LIB-001', 'Java Programming', 'Herbert Schildt', 2012, 'Libro', 'Libro base de la Unidad 4', 'Disponible'),
('LIB-002', 'Harry Potter', 'J.K Rowling', 1999, 'Libro', NULL, 'Disponible'),
('TES-001', 'Sistema Automatizado de Bibliotecas', 'Ingeniería en Computación', 2026, 'Tesis', 'Proyecto de graduación', 'Disponible');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `codigo_ejemplar` varchar(20) NOT NULL,
  `editorial` varchar(100) DEFAULT NULL,
  `num_paginas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`codigo_ejemplar`, `editorial`, `num_paginas`) VALUES
('LIB-001', 'Anaya Multimedia', 1150);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moras`
--

CREATE TABLE `moras` (
  `id_mora` int(11) NOT NULL,
  `id_prestamo` int(11) NOT NULL,
  `dias_atraso` int(11) NOT NULL,
  `monto_mora` decimal(10,2) NOT NULL,
  `estado` enum('Pendiente','Pagado') DEFAULT 'Pendiente'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `id_prestamo` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `codigo_ejemplar` varchar(20) NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_limite` date NOT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `estado` enum('En curso','Devuelto','Atrasado') DEFAULT 'En curso'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tesis`
--

CREATE TABLE `tesis` (
  `codigo_ejemplar` varchar(20) NOT NULL,
  `grado_academico` varchar(100) DEFAULT NULL,
  `facultad` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tesis`
--

INSERT INTO `tesis` (`codigo_ejemplar`, `grado_academico`, `facultad`) VALUES
('TES-001', 'Ingeniero en Computación', 'Facultad de Ingeniería');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `tipo_usuario` enum('Administrador','Estudiante','Profesor') NOT NULL DEFAULT 'Estudiante',
  `estado` enum('Activo','Inactivo') DEFAULT 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre`, `correo`, `contrasena`, `tipo_usuario`, `estado`) VALUES
(1, 'Admin Sistema', 'admin@amigosdonbosco.edu', 'admin123', 'Administrador', 'Activo'),
(2, 'Estudiante Prueba', 'estudiante@amigosdonbosco.edu', '12345', 'Estudiante', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`codigo_ejemplar`);

--
-- Indices de la tabla `moras`
--
ALTER TABLE `moras`
  ADD PRIMARY KEY (`id_mora`),
  ADD KEY `id_prestamo` (`id_prestamo`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`id_prestamo`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `codigo_ejemplar` (`codigo_ejemplar`);

--
-- Indices de la tabla `tesis`
--
ALTER TABLE `tesis`
  ADD PRIMARY KEY (`codigo_ejemplar`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `moras`
--
ALTER TABLE `moras`
  MODIFY `id_mora` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `id_prestamo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`codigo_ejemplar`) REFERENCES `ejemplares` (`codigo`) ON DELETE CASCADE;

--
-- Filtros para la tabla `moras`
--
ALTER TABLE `moras`
  ADD CONSTRAINT `moras_ibfk_1` FOREIGN KEY (`id_prestamo`) REFERENCES `prestamos` (`id_prestamo`);

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`codigo_ejemplar`) REFERENCES `ejemplares` (`codigo`);

--
-- Filtros para la tabla `tesis`
--
ALTER TABLE `tesis`
  ADD CONSTRAINT `tesis_ibfk_1` FOREIGN KEY (`codigo_ejemplar`) REFERENCES `ejemplares` (`codigo`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
