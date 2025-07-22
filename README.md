# Sistema de Gestión de Consultas Médicas

## 📋 Descripción
Sistema web para la gestión integral de consultas médicas, permitiendo el registro de pacientes, historial médico y administración de consultas para centros de salud.

## ✨ Características principales

- **Gestión de Pacientes**: Registro, edición y consulta de información de pacientes
- **Historial Médico**: Registro y seguimiento del historial clínico de cada paciente
- **Panel de Administración**: Dashboard para médicos y personal administrativo
- **Reportes**: Generación de reportes de consultas y estadísticas

## 🚀 Tecnologías utilizadas

- **Frontend**: HTML5, CSS3, JavaScript
- **Backend**: Java/ Spring/ Spring boot
- **Base de Datos**: MySQL 
- **Framework**: Bootstrap 
- **Autenticación**: Sessions

## 📦 Instalación

### Prerrequisitos
- Node.js (v14 o superior)
- MySQL
- Git

### Pasos de instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/StivenBravo/ProyectoInalIntegrador.git
   cd ProyectoFinalIntegrador
   ```

2. **Instalar dependencias**
   ```bash
   npm install
   ```

3. **Configurar base de datos**
   - Crear base de datos `cancerdb`
   - Importar el archivo `database/schema.sql`
   - Configurar credenciales en `config/database.js`

4. **Configurar variables de entorno**
   ```bash
# Conexión a la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/cancerdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

# Driver JDBC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Codificación
spring.thymeleaf.encoding=UTF-8
spring.thymeleaf.cache=false

# Puerto del servidor (opcional)
server.port=8080
   # Editar .env con tus configuraciones
   ```

5. **Ejecutar el proyecto**
   ```bash
   npm start
   # o
   npm run dev
   ```

6. **Acceder a la aplicación**
   - Abrir navegador en: `http://localhost:8080`

## 🎯 Uso

### Para Administradores
1. Iniciar sesión con credenciales de administrador
2. Gestionar usuarios y permisos
4. Generar reportes del sistema

### Para Médicos
4. Consultar información de pacientes

## 📁 Estructura del proyecto

```
ProyectoIntegrador/
├── src/
│   ├── controllers/    
│   ├── entidades/        
│   ├── servicios/           
│   ├── repositorios/        
│   ├── css/            # Estilos CSS
│   ├── js/             # Scripts JavaScript
│   └── images/         # Imágenes y recursos
├── database/
│   ├── migrations/     # Migraciones de BD
│   └── seeders/        # Datos de prueba
├── config/             # Configuraciones
└── tests/              # Pruebas unitarias
```

## 🔧 API Endpoints

### Pacientes
- `GET /api/pacientes` - Listar todos los pacientes
- `POST /api/pacientes` - Crear nuevo paciente
- `GET /api/pacientes/:id` - Obtener paciente específico
- `PUT /api/pacientes/:id` - Actualizar paciente
- `DELETE /api/pacientes/:id` - Eliminar paciente

### Consultas
- `GET /api/consultas` - Listar consultas
- `POST /api/consultas` - Crear nueva consulta
- `GET /api/consultas/:id` - Obtener consulta específica
- `PUT /api/consultas/:id` - Actualizar consulta

## 🧪 Testing

```bash
# Ejecutar todas las pruebas
npm test

# Ejecutar pruebas con cobertura
npm run test:coverage
```

## 👥 Equipo de desarrollo

- **StivenBravo** - **FabianArroyo**
## 📞 Contacto

## 🚀 Estado del proyecto

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Version](https://img.shields.io/badge/version-1.0.0-blue)
![License](https://img.shields.io/badge/license-MIT-green)

---

⭐ **¡No olvides dar una estrella al proyecto si te ha sido útil!** ⭐
