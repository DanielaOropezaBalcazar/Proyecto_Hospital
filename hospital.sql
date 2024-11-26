SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `consulta` (
  `codigo` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `detalle` text DEFAULT NULL,
  `doctorCodigo` int(11) DEFAULT NULL,
  `historialCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `doctor` (
  `codigo` int(11) NOT NULL,
  `especialidad` varchar(100) DEFAULT NULL,
  `empleadoCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `empleado` (
  `codigo` int(11) NOT NULL,
  `ci` varchar(20) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `enfermero` (
  `codigo` int(11) NOT NULL,
  `area` varchar(100) DEFAULT NULL,
  `empleadoCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `habitacion` (
  `codigo` int(11) NOT NULL,
  `piso` int(11) DEFAULT NULL,
  `cant_camas` int(11) DEFAULT NULL,
  `enfermeroCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `historial` (
  `codigo` int(11) NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `pacienteCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `internacion` (
  `codigo` int(11) NOT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `historialCodigo` int(11) DEFAULT NULL,
  `habitacionCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `laboratorio` (
  `codigo` int(11) NOT NULL,
  `tipo_muestra` varchar(100) DEFAULT NULL,
  `tipo_laboratorio` varchar(100) DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `laboratoristaCodigo` int(11) DEFAULT NULL,
  `doctorCodigo` int(11) DEFAULT NULL,
  `historialCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `laboratorista` (
  `codigo` int(11) NOT NULL,
  `especialidad` varchar(100) DEFAULT NULL,
  `empleadoCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `medicacion` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `laboratorio` varchar(100) DEFAULT NULL,
  `detalle` text DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `paciente` (
  `codigo` int(11) NOT NULL,
  `ci` varchar(20) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `tipo_sangre` varchar(10) DEFAULT NULL,
  `genero` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `receta` (
  `codigo` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `consultaCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `receta_medicacion` (
  `codigo` int(11) NOT NULL,
  `recetaCodigo` int(11) DEFAULT NULL,
  `medicacionCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `consulta`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `doctorCodigo` (`doctorCodigo`),
  ADD KEY `historialCodigo` (`historialCodigo`);

ALTER TABLE `doctor`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `empleadoCodigo` (`empleadoCodigo`);

ALTER TABLE `empleado`
  ADD PRIMARY KEY (`codigo`);

ALTER TABLE `enfermero`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `empleadoCodigo` (`empleadoCodigo`);

ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `enfermeroCodigo` (`enfermeroCodigo`);

ALTER TABLE `historial`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `pacienteCodigo` (`pacienteCodigo`);

ALTER TABLE `internacion`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `historialCodigo` (`historialCodigo`),
  ADD KEY `habitacionCodigo` (`habitacionCodigo`);

ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `laboratoristaCodigo` (`laboratoristaCodigo`),
  ADD KEY `doctorCodigo` (`doctorCodigo`),
  ADD KEY `historialCodigo` (`historialCodigo`);

ALTER TABLE `laboratorista`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `empleadoCodigo` (`empleadoCodigo`);

ALTER TABLE `medicacion`
  ADD PRIMARY KEY (`codigo`);

ALTER TABLE `paciente`
  ADD PRIMARY KEY (`codigo`);

ALTER TABLE `receta`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `consultaCodigo` (`consultaCodigo`);

ALTER TABLE `receta_medicacion`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `recetaCodigo` (`recetaCodigo`),
  ADD KEY `medicacionCodigo` (`medicacionCodigo`);


ALTER TABLE `consulta`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `doctor`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `empleado`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `enfermero`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `habitacion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `historial`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `internacion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `laboratorio`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `laboratorista`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `medicacion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `paciente`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `receta`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `receta_medicacion`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`doctorCodigo`) REFERENCES `doctor` (`codigo`),
  ADD CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`historialCodigo`) REFERENCES `historial` (`codigo`);

ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`empleadoCodigo`) REFERENCES `empleado` (`codigo`);

ALTER TABLE `enfermero`
  ADD CONSTRAINT `enfermero_ibfk_1` FOREIGN KEY (`empleadoCodigo`) REFERENCES `empleado` (`codigo`);

ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`enfermeroCodigo`) REFERENCES `enfermero` (`codigo`);

ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`pacienteCodigo`) REFERENCES `paciente` (`codigo`);

ALTER TABLE `internacion`
  ADD CONSTRAINT `internacion_ibfk_1` FOREIGN KEY (`historialCodigo`) REFERENCES `historial` (`codigo`),
  ADD CONSTRAINT `internacion_ibfk_2` FOREIGN KEY (`habitacionCodigo`) REFERENCES `habitacion` (`codigo`);

ALTER TABLE `laboratorio`
  ADD CONSTRAINT `laboratorio_ibfk_1` FOREIGN KEY (`laboratoristaCodigo`) REFERENCES `laboratorista` (`codigo`),
  ADD CONSTRAINT `laboratorio_ibfk_2` FOREIGN KEY (`doctorCodigo`) REFERENCES `doctor` (`codigo`),
  ADD CONSTRAINT `laboratorio_ibfk_3` FOREIGN KEY (`historialCodigo`) REFERENCES `historial` (`codigo`);

ALTER TABLE `laboratorista`
  ADD CONSTRAINT `laboratorista_ibfk_1` FOREIGN KEY (`empleadoCodigo`) REFERENCES `empleado` (`codigo`);

ALTER TABLE `receta`
  ADD CONSTRAINT `receta_ibfk_1` FOREIGN KEY (`consultaCodigo`) REFERENCES `consulta` (`codigo`);

ALTER TABLE `receta_medicacion`
  ADD CONSTRAINT `receta_medicacion_ibfk_1` FOREIGN KEY (`recetaCodigo`) REFERENCES `receta` (`codigo`),
  ADD CONSTRAINT `receta_medicacion_ibfk_2` FOREIGN KEY (`medicacionCodigo`) REFERENCES `medicacion` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
