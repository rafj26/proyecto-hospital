-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 24-07-2024 a las 02:29:22
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `semestral`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `Id` int NOT NULL,
  `codigo` varchar(4) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `cedula` varchar(15) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `nombre` varchar(20) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `apellido` varchar(20) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `telefono` varchar(7) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `especialidad` varchar(20) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `pacientes_mes` int DEFAULT NULL,
  `pacientes_anual` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`Id`, `codigo`, `cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `especialidad`, `pacientes_mes`, `pacientes_anual`) VALUES
(2, 'M002', '2-345-6789', 'Dra. Ana', 'López', 'Consultorio Médico Principal', '6939355', 'Pediatría', 20, 240),
(3, 'M003', '9-876-5432', 'Dr. Carlos', 'Hernández', 'Centro de Salud San Miguel', '6829233', 'Oftalmología', 18, 200),
(4, 'M004', '3-456-7890', 'Dra. Laura', 'Díaz', 'Hospital Infantil', '6009345', 'Pediatría', 22, 260),
(5, 'M005', '7-654-3210', 'Dr. Pedro', 'Ramírez', 'Centro Médico Sur', '6550193', 'Ginecología', 17, 190),
(6, 'M006', '4-567-8901', 'Dra. Ana María', 'Chávez', 'Consultorio Médico Norte', '6783443', 'Dermatología', 16, 195),
(7, 'M007', '5-678-9012', 'Dr. Javier', 'Castro', 'Hospital del Este', '6894093', 'Neurología', 19, 210),
(8, 'M008', '6-789-0123', 'Dra. Luisa', 'Morales', 'Clínica San Judas', '6738443', 'Endocrinología', 21, 245),
(9, 'M009', '0-987-6543', 'Dr. Fernando', 'Fernández', 'Hospital Metropolitano', '6223743', 'Ortopedia', 20, 230),
(10, 'M010', '8-789-1234', 'Dra. Marta', 'López', 'Centro Médico Plaza', '6989234', 'Psiquiatría', 18, 205),
(11, NULL, '10-5-1450', 'Dr. Emilio', 'Cozzarelli', NULL, '2556987', 'Oftamologia', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `Id` int NOT NULL,
  `cedula` varchar(15) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `nombre` varchar(30) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `apellido` varchar(30) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `direccion` varchar(50) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `telefono` varchar(7) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `provincia` varchar(20) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `sexo` char(1) COLLATE utf8mb3_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`Id`, `cedula`, `nombre`, `apellido`, `direccion`, `telefono`, `provincia`, `edad`, `sexo`) VALUES
(2, '8-234-5678', 'Juan', 'González', 'Avenida Balboa, Edificio Panorama', '6212345', 'Panamá', 35, 'M'),
(3, '4-345-6789', 'Ana', 'Martínez', 'Boquete', '6234567', 'Chirqui', 25, 'F'),
(4, '8-876-5432', 'Carlos', 'Pérez', 'Calle 50, PH Pacific Point', '6345678', 'Panamá', 50, 'M'),
(5, '8-456-7890', 'Laura', 'Díaz', 'San Francisco, Plaza las Américas', '6456789', 'Panamá', 30, 'F'),
(6, '1-654-3210', 'Pedro', 'Ramírez', 'Isla', '6567890', 'Bocas del Toro', 45, 'M'),
(7, '4-567-8901', 'Ana María', 'Chávez', 'David', '6678901', 'Chiriqui', 28, 'F'),
(8, '8-678-9012', 'Javier', 'Castro', 'El Cangrejo, PH Diamond Tower', '6789012', 'Panamá', 32, 'M'),
(9, '3-789-0123', 'Luis', 'Morales', 'Los lagos', '6890123', 'Colon', 55, 'M'),
(13, '8-337-437', 'Alma', 'Jimenez', 'Tecal City', '2478372', 'Panama Oeste', NULL, NULL),
(14, '10-8-655', 'Hernan', 'Caballero', NULL, '2558789', 'Colon', NULL, NULL),
(15, '9-20-1025', 'Victor1', 'Aleman1', NULL, '2214587', 'Cocle1', NULL, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `medico`
--
ALTER TABLE `medico`
  MODIFY `Id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `Id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
