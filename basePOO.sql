-- 1. Crear la base de datos y usarla
CREATE DATABASE IF NOT EXISTS biblioteca_don_bosco;
USE biblioteca_don_bosco;

-- 2. Tabla de Usuarios (Módulo: Usuarios / Restablecer contraseña)
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    tipo_usuario ENUM('Administrador', 'Estudiante', 'Profesor') NOT NULL DEFAULT 'Estudiante',
    estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo'
);

-- 3. Tabla principal de Ejemplares (Superclase: Documento)
-- Aquí van los atributos compartidos por todos los documentos
CREATE TABLE ejemplares (
    codigo VARCHAR(20) PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    anio_publicacion INT NOT NULL,
    tipo_documento ENUM('Libro', 'Tesis', 'Revista', 'Articulo', 'Memoria') NOT NULL,
    descripcion TEXT,
    estado ENUM('Disponible', 'Prestado', 'Extraviado', 'Baja') DEFAULT 'Disponible'
);

-- 4. Tablas Hijas (Atributos específicos)
-- Heredan el 'codigo' de la tabla ejemplares como Llave Foránea y Primaria a la vez
CREATE TABLE libros (
    codigo_ejemplar VARCHAR(20) PRIMARY KEY,
    editorial VARCHAR(100),
    num_paginas INT,
    FOREIGN KEY (codigo_ejemplar) REFERENCES ejemplares(codigo) ON DELETE CASCADE
);

CREATE TABLE tesis (
    codigo_ejemplar VARCHAR(20) PRIMARY KEY,
    grado_academico VARCHAR(100),
    facultad VARCHAR(100),
    FOREIGN KEY (codigo_ejemplar) REFERENCES ejemplares(codigo) ON DELETE CASCADE
);

-- 5. Tabla de Préstamos (Módulo: Préstamos y Devoluciones)
CREATE TABLE prestamos (
    id_prestamo INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    codigo_ejemplar VARCHAR(20) NOT NULL,
    fecha_prestamo DATE NOT NULL,
    fecha_limite DATE NOT NULL,
    fecha_devolucion DATE,
    estado ENUM('En curso', 'Devuelto', 'Atrasado') DEFAULT 'En curso',
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (codigo_ejemplar) REFERENCES ejemplares(codigo)
);

-- 6. Tabla de Mora (Módulo: Mora)
CREATE TABLE moras (
    id_mora INT AUTO_INCREMENT PRIMARY KEY,
    id_prestamo INT NOT NULL,
    dias_atraso INT NOT NULL,
    monto_mora DECIMAL(10,2) NOT NULL,
    estado ENUM('Pendiente', 'Pagado') DEFAULT 'Pendiente',
    FOREIGN KEY (id_prestamo) REFERENCES prestamos(id_prestamo)
);

-- ==========================================
-- DATOS DE PRUEBA (Para poblar las tablas y probar la interfaz)
-- ==========================================

-- Insertar un usuario administrador de prueba
INSERT INTO usuarios (nombre, correo, contrasena, tipo_usuario) 
VALUES ('Admin Sistema', 'admin@amigosdonbosco.edu', 'admin123', 'Administrador');

-- Insertar un usuario estudiante
INSERT INTO usuarios (nombre, correo, contrasena, tipo_usuario) 
VALUES ('Estudiante Prueba', 'estudiante@amigosdonbosco.edu', '12345', 'Estudiante');

-- Insertar un Libro en la tabla padre (Ejemplar)
INSERT INTO ejemplares (codigo, titulo, autor, anio_publicacion, tipo_documento, descripcion)
VALUES ('LIB-001', 'Java Programming', 'Herbert Schildt', 2012, 'Libro', 'Libro base de la Unidad 4');

-- Insertar los detalles específicos de ese Libro en la tabla hija
INSERT INTO libros (codigo_ejemplar, editorial, num_paginas)
VALUES ('LIB-001', 'Anaya Multimedia', 1150);

-- Insertar una Tesis en la tabla padre
INSERT INTO ejemplares (codigo, titulo, autor, anio_publicacion, tipo_documento, descripcion)
VALUES ('TES-001', 'Sistema Automatizado de Bibliotecas', 'Ingeniería en Computación', 2026, 'Tesis', 'Proyecto de graduación');

-- Insertar los detalles de esa Tesis en la tabla hija
INSERT INTO tesis (codigo_ejemplar, grado_academico, facultad)
VALUES ('TES-001', 'Ingeniero en Computación', 'Facultad de Ingeniería');