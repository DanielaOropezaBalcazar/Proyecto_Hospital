-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-05-2025 a las 19:23:05
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
-- Base de datos: `hospital2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

CREATE TABLE `consulta` (
  `codigo` int(11) NOT NULL,
  `detalle` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `precio` int(11) NOT NULL,
  `doctor_codigo` int(11) NOT NULL,
  `paciente_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `consulta`
--

INSERT INTO `consulta` (`codigo`, `detalle`, `fecha`, `precio`, `doctor_codigo`, `paciente_codigo`) VALUES
(1, 'Chequeo general', '2025-01-10', 300, 1, 1),
(2, 'Control pediátrico', '2025-01-10', 250, 2, 2),
(3, 'Revisión traumatológica', '2025-01-15', 400, 3, 3),
(4, 'Consulta dermatológica', '2025-01-17', 350, 4, 4),
(5, 'Control neurológico', '2025-01-20', 500, 5, 5),
(6, 'Consulta ginecológica', '2025-01-25', 450, 6, 6),
(7, 'Chequeo oftalmológico', '2025-02-02', 380, 7, 7),
(8, 'Control de presión arterial', '2025-02-05', 320, 8, 8),
(9, 'Evaluación post-operatoria', '2025-02-10', 600, 9, 9),
(10, 'Consulta psiquiátrica', '2025-02-14', 550, 10, 10),
(11, 'Análisis de laboratorio', '2025-02-20', 450, 11, 3),
(12, 'Control endocrinológico', '2025-02-28', 470, 12, 1),
(13, 'Consulta de rutina', '2025-03-03', 300, 1, 10),
(14, 'Chequeo post-natal', '2025-03-07', 400, 6, 3),
(15, 'Consulta por alergias', '2025-03-10', 330, 4, 5),
(16, 'Dolor de espalda', '2025-03-15', 360, 3, 6),
(17, 'Chequeo visual', '2025-03-20', 370, 7, 9),
(18, 'Consulta digestiva', '2025-03-25', 420, 8, 9),
(19, 'Evaluación cardiológica', '2025-03-28', 500, 1, 4),
(20, 'Consulta general', '2025-04-01', 290, 2, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE `doctor` (
  `codigo` int(11) NOT NULL,
  `ci` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `salario` int(11) NOT NULL,
  `especialidad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `doctor`
--

INSERT INTO `doctor` (`codigo`, `ci`, `nombre`, `apellido`, `fecha_nacimiento`, `fecha_ingreso`, `cargo`, `salario`, `especialidad`) VALUES
(1, 12345678, 'Carlos', 'Ramirez', '1980-05-12', '2010-03-01', 'Jefe de Cardiologia', 18000, 'Cardiologia'),
(2, 23456789, 'Laura', 'Gonzalez', '1975-09-30', '2005-08-15', 'Medica Titular', 16000, 'Pediatria'),
(3, 34567890, 'Andres', 'Perez', '1988-12-10', '2016-11-20', 'Medico Residente', 12000, 'Traumatologia'),
(4, 45678901, 'Maria', 'Lopez', '1990-04-18', '2018-01-05', 'Medica Adjunta', 13000, 'Dermatologia'),
(5, 56789012, 'Jose', 'Martinez', '1983-07-25', '2012-06-10', 'Jefe de Urgencias', 17500, 'Neurologia'),
(6, 67890123, 'Lucia', 'Fernandez', '1985-02-14', '2011-09-01', 'Coordinadora de Guardias', 14500, 'Ginecologia'),
(7, 78901234, 'Ricardo', 'Soto', '1979-11-05', '2009-07-20', 'Medico Titular', 15000, 'Oftalmologia'),
(8, 89012345, 'Elena', 'Vera', '1986-03-22', '2014-04-11', 'Jefa de Internacion', 16000, 'Medicina Interna'),
(9, 90123456, 'Marco', 'Delgado', '1982-06-30', '2008-12-19', 'Director Medico', 20000, 'Cirugia General'),
(10, 11223344, 'Valeria', 'Reyes', '1991-10-08', '2019-03-02', 'Medica Residente', 11000, 'Psiquiatria'),
(11, 22334455, 'David', 'Cano', '1987-08-16', '2013-05-25', 'Jefe de Laboratorio', 16500, 'Laboratorio Clinico'),
(12, 33445566, 'Patricia', 'Navarro', '1984-01-12', '2010-10-10', 'Coordinadora de Consultas Externas', 15500, 'Endocrinologia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `codigo` int(11) NOT NULL,
  `piso` int(11) NOT NULL,
  `cant_camas` int(11) NOT NULL,
  `tipo_habitacion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `internacion`
--

CREATE TABLE `internacion` (
  `codigo` int(11) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `duracion` int(11) NOT NULL,
  `habitacion_codigo` int(11) NOT NULL,
  `paciente_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `codigo` int(11) NOT NULL,
  `tipo_muestra` varchar(50) NOT NULL,
  `tipo_laboratorio` varchar(50) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_entrega` date NOT NULL,
  `doctor_codigo` int(11) NOT NULL,
  `paciente_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicacion`
--

CREATE TABLE `medicacion` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `laboratorio` varchar(50) NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `codigo` int(11) NOT NULL,
  `ci` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `tipo_sangre` varchar(10) NOT NULL,
  `genero` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`codigo`, `ci`, `nombre`, `apellido`, `fecha_nacimiento`, `tipo_sangre`, `genero`) VALUES
(1, 20202020, 'Luis', 'Flores', '1988-07-03', 'A-', 1),
(2, 30303030, 'Camila', 'Diaz', '2000-11-22', 'B+', 0),
(3, 40404040, 'Jorge', 'Mejia', '1976-04-09', 'AB-', 1),
(4, 50505050, 'Sofia', 'Acosta', '1992-09-17', 'A+', 0),
(5, 60606060, 'Miguel', 'Figueroa', '1985-12-30', 'O-', 1),
(6, 70707070, 'Paula', 'Herrera', '1999-06-06', 'B-', 0),
(7, 80808080, 'Diego', 'Navarrete', '1990-01-01', 'AB+', 1),
(8, 90909090, 'Valentina', 'Salazar', '2001-03-15', 'O+', 0),
(9, 11112222, 'Fabian', 'Lugo', '1983-08-23', 'A-', 1),
(10, 22223333, 'Gabriela', 'Moreno', '1996-05-11', 'B+', 0),
(11, 33334444, 'Andres', 'Ramos', '1978-10-28', 'AB+', 1),
(12, 44445555, 'Mauro', 'Lombardo', '1996-06-24', 'O+', 1),
(13, 30303030, 'Camila', 'Diaz', '2000-11-22', 'B+', 0),
(14, 40404040, 'Ezequiel', 'Quiroga', '1995-07-25', 'A+', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `codigo` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `consulta_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta_medicacion`
--

CREATE TABLE `receta_medicacion` (
  `receta_codigo` int(11) NOT NULL,
  `medicacion_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `consulta_doctor` (`doctor_codigo`),
  ADD KEY `consulta_paciente` (`paciente_codigo`);

--
-- Indices de la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `internacion`
--
ALTER TABLE `internacion`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `internacion_habitacion` (`habitacion_codigo`),
  ADD KEY `internacion_paciente` (`paciente_codigo`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `laboratorio_doctor` (`doctor_codigo`),
  ADD KEY `laboratorio_paciente` (`paciente_codigo`);

--
-- Indices de la tabla `medicacion`
--
ALTER TABLE `medicacion`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `receta_consulta` (`consulta_codigo`);

--
-- Indices de la tabla `receta_medicacion`
--
ALTER TABLE `receta_medicacion`
  ADD PRIMARY KEY (`receta_codigo`,`medicacion_codigo`),
  ADD KEY `receta_medicacion_medicacion` (`medicacion_codigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_doctor` FOREIGN KEY (`doctor_codigo`) REFERENCES `doctor` (`codigo`),
  ADD CONSTRAINT `consulta_paciente` FOREIGN KEY (`paciente_codigo`) REFERENCES `paciente` (`codigo`);

--
-- Filtros para la tabla `internacion`
--
ALTER TABLE `internacion`
  ADD CONSTRAINT `internacion_habitacion` FOREIGN KEY (`habitacion_codigo`) REFERENCES `habitacion` (`codigo`),
  ADD CONSTRAINT `internacion_paciente` FOREIGN KEY (`paciente_codigo`) REFERENCES `paciente` (`codigo`);

--
-- Filtros para la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD CONSTRAINT `laboratorio_doctor` FOREIGN KEY (`doctor_codigo`) REFERENCES `doctor` (`codigo`),
  ADD CONSTRAINT `laboratorio_paciente` FOREIGN KEY (`paciente_codigo`) REFERENCES `paciente` (`codigo`);

--
-- Filtros para la tabla `receta`
--
ALTER TABLE `receta`
  ADD CONSTRAINT `receta_consulta` FOREIGN KEY (`consulta_codigo`) REFERENCES `consulta` (`codigo`);

--
-- Filtros para la tabla `receta_medicacion`
--
ALTER TABLE `receta_medicacion`
  ADD CONSTRAINT `receta_medicacion_medicacion` FOREIGN KEY (`medicacion_codigo`) REFERENCES `medicacion` (`codigo`),
  ADD CONSTRAINT `receta_medicacion_receta` FOREIGN KEY (`receta_codigo`) REFERENCES `receta` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
