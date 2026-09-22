# SpaceWorkDesafio

Sistema de gestión de citas para el Centro de Salud Breña, desarrollado en Java con Swing.

## Funcionalidades

- Inicio de sesión.
- Menú principal.
- Registro de citas.
- Validación de DNI de ocho dígitos.
- Prevención de citas duplicadas por DNI.
- Consulta de citas.
- Búsqueda por DNI.
- Reagendamiento de citas.
- Eliminación de citas.
- Ventana informativa de desarrolladores.

## Estructura

- `src/GUI`: ventanas de la aplicación.
- `src/SaludBreña`: modelo de datos de la cita.
- `src/Desarrolladores`: ventana de información del equipo.
- `src/imagen`: recursos gráficos.

## Ejecución

Abrir el proyecto como proyecto Java en Eclipse o ejecutarlo con Java OpenJDK. La clase principal de inicio de sesión es `GUI.Login`; también se puede iniciar desde `GUI.V1`.

## Credenciales de prueba

- Correo: `admin@brena.com`
- Contraseña: `1234`

Los datos se mantienen en memoria durante la ejecución y no se persisten en una base de datos.
