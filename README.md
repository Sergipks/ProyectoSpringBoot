# ProyectoSpringBoot

# API Trabajadores

Este proyecto contiene un controlador REST para manejar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de la entidad `Trabajador` en una aplicación Spring Boot. Este controlador expone varias rutas API para interactuar con los recursos de `Trabajador`, proporcionando respuestas en formato JSON.

## Contenidos

- [Anotaciones Utilizadas](#anotaciones-utilizadas)
- [Dependencias](#dependencias)
- [Métodos del Controlador](#métodos-del-controlador)
  - [Obtener todos los trabajadores](#obtener-todos-los-trabajadores)
  - [Obtener trabajadores por especialidad](#obtener-trabajadores-por-especialidad)
  - [Crear un nuevo trabajador](#crear-un-nuevo-trabajador)
  - [Actualizar un trabajador existente](#actualizar-un-trabajador-existente)
  - [Eliminar un trabajador](#eliminar-un-trabajador)
- [Ejemplo de Uso](#ejemplo-de-uso)

## Anotaciones Utilizadas

- `@CrossOrigin(origins = {"*"})`: Permite peticiones desde cualquier origen, habilitando CORS (Cross-Origin Resource Sharing).
- `@RestController`: Indica que la clase es un controlador REST.
- `@RequestMapping(value = "api/trabajadores", produces = "application/json;charset=UTF-8")`: Define la ruta base de las peticiones y especifica que las respuestas serán en formato JSON con codificación UTF-8.

## Dependencias

- `ITrabajadorService`: Servicio que maneja la lógica de negocio relacionada con `Trabajador`.

## Métodos del Controlador

### Obtener todos los trabajadores

- **Ruta**: `GET /api/trabajadores`
- **Descripción**: Devuelve una lista de todos los trabajadores.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de trabajadores.
  - **Fallo**: Estado HTTP 404 si no se encuentran trabajadores.

### Obtener trabajadores por especialidad

- **Ruta**: `GET /api/trabajadores/especialidad/{especialidad}`
- **Descripción**: Devuelve una lista de trabajadores que tienen la especialidad especificada.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de trabajadores que coinciden con la especialidad.
  - **Fallo**: Estado HTTP 404 si no se encuentran trabajadores con la especialidad dada.

### Crear un nuevo trabajador

- **Ruta**: `POST /api/trabajadores`
- **Descripción**: Crea un nuevo trabajador.
- **Parámetros**: 
  - `@RequestBody Trabajador trabajador`: Objeto `Trabajador` que se va a crear.
- **Respuesta**:
  - **Éxito**: Estado HTTP 201 con el trabajador creado.
  - **Fallo**: Manejo de errores no especificado explícitamente en el código, pero se podría agregar.

### Actualizar un trabajador existente

- **Ruta**: `PUT /api/trabajadores/{id}`
- **Descripción**: Actualiza un trabajador existente con la información proporcionada.
- **Parámetros**:
  - `@PathVariable String id`: ID del trabajador que se va a actualizar.
  - `@RequestBody Trabajador trabajador`: Objeto `Trabajador` con la información actualizada.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con el trabajador actualizado.
  - **Fallo**: Estado HTTP 404 si no se encuentra el trabajador con el ID especificado.

### Eliminar un trabajador

- **Ruta**: `DELETE /api/trabajadores/{id}`
- **Descripción**: Elimina un trabajador existente.
- **Parámetros**:
  - `@PathVariable String id`: ID del trabajador que se va a eliminar.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con un mensaje de confirmación de eliminación.
  - **Fallo**: Estado HTTP 404 si no se encuentra el trabajador con el ID especificado.

## Ejemplo de Uso

### Ejemplo: Obtener todos los trabajadores

**Solicitud**:
```sh
GET /api/trabajadores
```

**Respuesta**:
```json
{
    "status": 200,
    "message": "Success",
    "result": [
        {
            "id": "1",
            "dni": "12345678X",
            "nombre": "Juan",
            "apellidos": "Pérez",
            "especialidad": "Electricista",
            "contraseña": "password123",
            "email": "juan.perez@example.com"
        },
        {
            "id": "2",
            "dni": "87654321X",
            "nombre": "Ana",
            "apellidos": "García",
            "especialidad": "Fontanera",
            "contraseña": "password456",
            "email": "ana.garcia@example.com"
        }
    ]
}
```
***Solcitud***:
```sh
GET /api/trabajadores/especialidad/Electricista
```
**Respuesta**:
```json
{
    "status": 200,
    "message": "Success",
    "result": [
        {
            "id": "1",
            "dni": "12345678X",
            "nombre": "Juan",
            "apellidos": "Pérez",
            "especialidad": "Electricista",
            "contraseña": "password123",
            "email": "juan.perez@example.com"
        }
    ]
}
```
***Solcitud***:
```json
POST /api/trabajadores

{
    "dni": "12345678X",
    "nombre": "Juan",
    "apellidos": "Pérez",
    "especialidad": "Electricista",
    "contraseña": "password123",
    "email": "juan.perez@example.com"
}
```
**Respuesta**:
```json
{
    "status": 201,
    "message": "Trabajador creado exitosamente",
    "result": {
        "id": "1",
        "dni": "12345678X",
        "nombre": "Juan",
        "apellidos": "Pérez",
        "especialidad": "Electricista",
        "contraseña": "password123",
        "email": "juan.perez@example.com"
    }
}
```
**Solicitud**:
```json
PUT /api/trabajadores/1

{
    "dni": "12345678X",
    "nombre": "Juan",
    "apellidos": "Pérez",
    "especialidad": "Electricista",
    "contraseña": "newpassword123",
    "email": "juan.perez@example.com"
}
```
***Respuesta***:
```json
{
    "status": 200,
    "message": "Trabajador actualizado exitosamente",
    "result": {
        "id": "1",
        "dni": "12345678X",
        "nombre": "Juan",
        "apellidos": "Pérez",
        "especialidad": "Electricista",
        "contraseña": "newpassword123",
        "email": "juan.perez@example.com"
    }
}
```
***Solicitud***:
```sh
DELETE /api/trabajadores/1
```
***Respuesta***:
```json
{
    "status": 200,
    "message": "Trabajador eliminado exitosamente"
}
```








