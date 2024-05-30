# ProyectoSpringBoot

# API Trabajadores

Este proyecto contiene un controlador REST para manejar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de la entidad `Trabajador` en una aplicación Spring Boot. Este controlador expone varias rutas API para interactuar con los recursos de `Trabajador`, proporcionando respuestas en formato JSON.

## Contenidos

- Anotaciones Utilizadas
- Dependencias
- Métodos del Controlador
  - Obtener todos los trabajadores
  - Obtener trabajadores por especialidad
  - Crear un nuevo trabajador
  - Actualizar un trabajador existente
  - Eliminar un trabajador
- Ejemplo de Uso

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
```sh
POST /api/trabajadores
```
```json
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
```sh
PUT /api/trabajadores/1
```
```json
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


# API Trabajos

Este proyecto contiene un controlador REST para manejar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de la entidad `Trabajo` en una aplicación Spring Boot. Este controlador expone varias rutas API para interactuar con los recursos de `Trabajo`, proporcionando respuestas en formato JSON.

## Contenidos

- Anotaciones Utilizadas
- Dependencias
- Métodos del Controlador
  - Obtener todos los trabajos
  - Obtener trabajadores por especialidad
  - Crear un nuevo trabajador
  - Actualizar un trabajador existente
  - Eliminar un trabajador
- Ejemplo de Uso

### Anotaciones Utilizadas

- `@CrossOrigin(origins = {"*"})`: Permite peticiones desde cualquier origen, habilitando CORS (Cross-Origin Resource Sharing).
- `@RestController`: Indica que la clase es un controlador REST.
- `@RequestMapping(value = "api/trabajos", produces = "application/json;charset=UTF-8")`: Define la ruta base de las peticiones y especifica que las respuestas serán en formato JSON con codificación UTF-8.

### Dependencias

- `ITrabajoService`: Servicio que maneja la lógica de negocio relacionada con `Trabajo`.
- `ITrabajadorService`: Servicio que maneja la lógica de negocio relacionada con `Trabajador`.

### Métodos del Controlador

#### Obtener todos los trabajos

- **Ruta**: `GET /api/trabajos`
- **Descripción**: Devuelve una lista de todos los trabajos.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de trabajos.
  - **Fallo**: Estado HTTP 404 si no se encuentran trabajos.

#### Crear un nuevo trabajo

- **Ruta**: `POST /api/trabajos`
- **Descripción**: Crea un nuevo trabajo.
- **Parámetros**:
  - `@RequestBody Trabajo trabajo`: Objeto `Trabajo` que se va a crear.
- **Respuesta**:
  - **Éxito**: Estado HTTP 201 con el trabajo creado.
  - **Fallo**: Manejo de errores no especificado explícitamente en el código, pero se podría agregar.

#### Actualizar un trabajo existente

- **Ruta**: `PUT /api/trabajos/{id}`
- **Descripción**: Actualiza un trabajo existente con la información proporcionada.
- **Parámetros**:
  - `@PathVariable String id`: ID del trabajo que se va a actualizar.
  - `@RequestBody Trabajo trabajo`: Objeto `Trabajo` con la información actualizada.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con el trabajo actualizado.
  - **Fallo**: Estado HTTP 404 si no se encuentra el trabajo con el ID especificado.

#### Eliminar un trabajo

- **Ruta**: `DELETE /api/trabajos/{id}`
- **Descripción**: Elimina un trabajo existente.
- **Parámetros**:
  - `@PathVariable String id`: ID del trabajo que se va a eliminar.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con un mensaje de confirmación de eliminación.
  - **Fallo**: Estado HTTP 404 si no se encuentra el trabajo con el ID especificado.

#### Obtener trabajos pendientes de un trabajador

- **Ruta**: `GET /api/trabajos/pendientes/trabajador`
- **Descripción**: Devuelve una lista de trabajos pendientes para un trabajador específico.
- **Parámetros**:
  - `@RequestParam String idTrabajador`: ID del trabajador.
  - `@RequestParam String contraseña`: Contraseña del trabajador.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de trabajos pendientes.
  - **Fallo**: Estado HTTP 404 si no se encuentran trabajos pendientes para el trabajador.

#### Obtener trabajos finalizados de un trabajador

- **Ruta**: `GET /api/trabajos/finalizados/trabajador`
- **Descripción**: Devuelve una lista de trabajos finalizados para un trabajador específico.
- **Parámetros**:
  - `@RequestParam String idTrabajador`: ID del trabajador.
  - `@RequestParam String contraseña`: Contraseña del trabajador.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de trabajos finalizados.
  - **Fallo**: Estado HTTP 404 si no se encuentran trabajos finalizados para el trabajador.

#### Finalizar un trabajo

- **Ruta**: `PUT /api/trabajos/{id}/finalizar`
- **Descripción**: Finaliza un trabajo específico.
- **Parámetros**:
  - `@PathVariable String id`: ID del trabajo que se va a finalizar.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con el trabajo finalizado.
  - **Fallo**: Estado HTTP 404 si no se encuentra el trabajo con el ID especificado.

#### Asignar un trabajo a un trabajador

- **Ruta**: `PUT /api/trabajos/{idTrabajo}/asignar/{idTrabajador}`
- **Descripción**: Asigna un trabajo a un trabajador específico.
- **Parámetros**:
  - `@PathVariable String idTrabajo`: ID del trabajo que se va a asignar.
  - `@PathVariable String idTrabajador`: ID del trabajador al que se va a asignar el trabajo.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con un mensaje de éxito.
  - **Fallo**: Estado HTTP 404 si no se encuentra el trabajo o el trabajador, o estado HTTP 400 si la categoría del trabajo y la especialidad del trabajador no coinciden.

#### Crear un trabajo con trabajador asignado

- **Ruta**: `POST /api/trabajos/trabajador/{idTrabajador}/crear-trabajo`
- **Descripción**: Crea un nuevo trabajo con un trabajador asignado.
- **Parámetros**:
  - `@RequestBody Trabajo trabajo`: Objeto `Trabajo` que se va a crear.
  - `@PathVariable String idTrabajador`: ID del trabajador que se va a asignar al trabajo.
- **Respuesta**:
  - **Éxito**: Estado HTTP 201 con el trabajo creado y el trabajador asignado.
  - **Fallo**: Estado HTTP 404 si no se encuentra el trabajador.

#### Obtener tareas sin asignar

- **Ruta**: `GET /api/trabajos/sin-asignar`
- **Descripción**: Devuelve una lista de tareas que aún no han sido asignadas.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de tareas sin asignar.
  - **Fallo**: Estado HTTP 404 si no se encuentran tareas sin asignar.

#### Obtener tareas asignadas

- **Ruta**: `GET /api/trabajos/asignadas`
- **Descripción**: Devuelve una lista de tareas que han sido asignadas.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de tareas asignadas.
  - **Fallo**: Estado HTTP 404 si no se encuentran tareas asignadas.

#### Obtener tareas sin finalizar

- **Ruta**: `GET /api/trabajos/sin-finalizar`
- **Descripción**: Devuelve una lista de tareas que aún no han sido finalizadas.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de tareas sin finalizar.
  - **Fallo**: Estado HTTP 404 si no se encuentran tareas sin finalizar.

#### Obtener tareas finalizadas

- **Ruta**: `GET /api/trabajos/finalizadas`
- **Descripción**: Devuelve una lista de tareas que han sido finalizadas.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de tareas finalizadas.
  - **Fallo**: Estado HTTP 404 si no se encuentran tareas finalizadas.

#### Obtener tareas finalizadas por trabajador en un rango de fechas

- **Ruta**: `GET /api/trabajos/trabajador/{idTrabajador}/finalizadas`
- **Descripción**: Devuelve una lista de tareas finalizadas por un trabajador en un rango de fechas especificado.
- **Parámetros**:
  - `@PathVariable String idTrabajador`: ID del trabajador.
  - `@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate`: Fecha de inicio del rango.
  - `@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate`: Fecha de fin del rango.
- **Respuesta**:
  - **Éxito**: Estado HTTP 200 con una lista de tareas finalizadas en el rango de fechas especificado.
  - **Fallo**: Estado HTTP 404 si no se encuentran tareas finalizadas para el trabajador en el rango de fechas especificado.

#### Listar tareas por prioridad de un trabajador

- **Ruta**: `GET /api/trabajos/prioridad`
- **Descripción**: Devuelve una lista de tareas pendientes de un trabajador, ordenadas por prioridad.
- **Parámetros**:
  - `idTrabajador` (Requerido, String): ID del trabajador.
  - `contraseña` (Requerido, String): Contraseña del trabajador.
- **Respuesta**:
  - **Éxito**:
    - Código: 200 OK
    - Contenido: Lista de tareas pendientes ordenadas por prioridad.
  - **Error**:
    - Código: 404 Not Found

#### Listar tareas por prioridad concreta de un trabajador

- **Ruta**: `GET /api/trabajos/prioridad/concreta`
- **Descripción**: Devuelve una lista de tareas pendientes de un trabajador, solo de la prioridad que se le pase en la petición.
- **Parámetros**:
  - `idTrabajador` (Requerido, String): ID del trabajador.
  - `contraseña` (Requerido, String): Contraseña del trabajador.
  - `prioridad` (Requerido, int): Prioridad de las tareas a filtrar.
- **Respuesta**:
  - **Éxito**:
    - Código: 200 OK
    - Contenido: Lista de tareas pendientes de la prioridad especificada.
  - **Error**:
    - Código: 404 Not Found

### Ejemplo de Uso

#### Ejemplo: Obtener todos los trabajos

***Solicitud***:
```sh
GET /api/trabajos
```
***Respuesta***:
```json
{"result":[
  {
    "codTrabajo":"001",
    "categoria":"Limpieza",
    "descripcion":"aaa",
    "fechaInicio":"2024-05-23",
    "fechaFin":"2024-05-23",
    "tiempo":null,
    "idTrabajador":null,
    "prioridad":1
  }
  {
    "codTrabajo":"T002",
    "categoria":"Limpieza",
    "descripcion":"asdasd",
    "fechaInicio":"2024-05-23",
    "fechaFin":"2024-05-24",
    "tiempo":null,
    "idTrabajador":"T002",
    "prioridad":2
    }],
"message":"Success",
"status":200}
```
***Solicitud***:
```sh
POST /api/trabajos
```
```json
{
    "codTrabajo":"001",
    "categoria":"Limpieza",
    "descripcion":"aaa",
    "fechaInicio":"2024-05-23",
    "fechaFin":"2024-05-23",
    "tiempo":null,
    "idTrabajador":null,
    "prioridad":1
}
```
***Resultado***:
```json
{
  "result": {
    "codTrabajo": "001",
    "categoria": "Limpieza",
    "descripcion": "aaa",
    "fechaInicio": "2024-05-26T18:02:37.102+00:00",
    "fechaFin": "2024-05-23T00:00:00.000+00:00",
    "tiempo": null,
    "idTrabajador": null,
    "prioridad": 1
  },
  "message": "Trabajo creado exitosamente",
  "status": 201
}
```
***Solicitud***:
```sh
PUT /api/trabajos/003
```
```json
{
    "codTrabajo":"002",
    "categoria":"Limpieza",
    "descripcion":"aaa",
    "fechaInicio":"2024-05-23",
    "fechaFin":"2024-05-23",
    "tiempo":null,
    "idTrabajador":null,
    "prioridad":1
}
```
***Resultado***:
```json
{
  "result": {
    "codTrabajo": "003",
    "categoria": "Limpieza",
    "descripcion": "aaa",
    "fechaInicio": "2024-05-26T18:02:37.102+00:00",
    "fechaFin": "2024-05-23T00:00:00.000+00:00",
    "tiempo": null,
    "idTrabajador": null,
    "prioridad": 1
  },
  "message": "Trabajo actualizado exitosamente",
  "status": 200
}
```
***Solicitud***:
```sh
DELETE /api/trabajos/003
```
***Respuesta***:
```json
{
  "message": "Trabajo eliminado exitosamente",
  "status": 200
}
```
***Solicitud***:
```sh
GET /api/trabajos/pendientes/trabajador?idTrabajador=T005&contraseña=1234
```
***Respuesta***:
```json
{
  "message": "No se encontraron trabajos pendientes",
  "status": 200
}
```
***Solicitud***:
```sh
GET /api/trabajos/finalizados/trabajador?idTrabajador=T005&contraseña=1234
```
***Respuesta***:
```json
{
  "message": "No se encontraron trabajos finalizados",
  "status": 200
}
```
***Solicitud***:
```sh
PUT /api/trabajos/002/finalizar
```
***Respuesta***:
```json
{
  "result": {
    "codTrabajo": "002",
    "categoria": "Limpieza",
    "descripcion": "aaa",
    "fechaInicio": "2024-05-26",
    "fechaFin": "2024-05-26T18:25:17.548+00:00",
    "tiempo": null,
    "idTrabajador": null,
    "prioridad": 1
  },
  "message": "Trabajo finalizado exitosamente",
  "status": 200
}
```
***Solicitud***:
```sh
PUT /api/trabajos/001/asignar/T005
```
***Respuesta***:
```json
{
  "message": "Trabajo asignado exitosamente",
  "status": 200
}
```
***Solicitud***:
```sh
POST /api/trabajos/trabajador/T005/crear-trabajo
```
***Respuesta***:
```json
{
  "message": "Trabajo creado exitosamente con trabajador asignado",
  "status": 200
}
```
***Solicitud***:
```sh
GET /api/trabajos/sin-asignar
```
***Respuesta***:
```json
{
  "result": [
    {
      "codTrabajo": "002",
      "categoria": "Limpieza",
      "descripcion": "aaa",
      "fechaInicio": "2024-05-26",
      "fechaFin": "2024-05-26",
      "tiempo": null,
      "idTrabajador": null,
      "prioridad": 1
    }
  ],
  "message": "Lista de tareas sin asignar mostrada exitosamente",
  "status": 200
}
```
***Solicitud***:
```sh
GET /api/trabajos/asignadas
```
***Respuesta***:
```json
{
  "result": [
    {
      "codTrabajo": "T002",
      "categoria": "Limpieza",
      "descripcion": "asdasd",
      "fechaInicio": "2024-05-23",
      "fechaFin": "2024-05-24",
      "tiempo": null,
      "idTrabajador": "T002",
      "prioridad": 2
    },
    {
      "codTrabajo": "001",
      "categoria": "Limpieza",
      "descripcion": "aaa",
      "fechaInicio": "2024-05-26",
      "fechaFin": "2024-05-23",
      "tiempo": null,
      "idTrabajador": "T005",
      "prioridad": 1
    }
  ],
  "message": "Lista de tareas asignadas mostrada exitosamente",
  "status": 200
}
```
***Solicitud***:
```sh
GET /api/trabajos/sin-finalizar
```
***Respuesta***:
```json
{
  "message": "No se encontraron tareas sin finalizar",
  "status": 404
}
```
***Solicitud***:
```sh
GET /api/trabajos/finalizadas
```
***Respuesta***:
```json
{
  "result": [
    {
      "codTrabajo": "T002",
      "categoria": "Limpieza",
      "descripcion": "asdasd",
      "fechaInicio": "2024-05-23",
      "fechaFin": "2024-05-24",
      "tiempo": null,
      "idTrabajador": "T002",
      "prioridad": 2
    },
    {
      "codTrabajo": "001",
      "categoria": "Limpieza",
      "descripcion": "aaa",
      "fechaInicio": "2024-05-26",
      "fechaFin": "2024-05-23",
      "tiempo": null,
      "idTrabajador": "T005",
      "prioridad": 1
    }
  ],
  "message": "Lista de tareas finalizadas mostrada exitosamente",
  "status": 200
}
```
***Solicitud***:
```sh
GET /api/trabajos/trabajador/T001/finalizadas?startDate=2024-01-01&endDate=2024-12-31
```
***Respuesta***:
```json
{
  "message": "No se encontraron tareas finalizadas para el trabajador en el rango de fechas especificado",
  "status": 404
}
```

***Solicitud***:
```sh
GET /api/trabajos/prioridad?idTrabajador=11111&contraseña=1234
```
***Respuesta***:
```json
{
  "result": [
    {
      "codTrabajo": "22222",
      "categoria": "Limpieza",
      "descripcion": "prioridades2",
      "fechaInicio": "2024-05-30",
      "fechaFin": null,
      "tiempo": null,
      "idTrabajador": "11111",
      "prioridad": 1
    },
    {
      "codTrabajo": "11111",
      "categoria": "Limpieza",
      "descripcion": "prioridades",
      "fechaInicio": "2024-05-30",
      "fechaFin": null,
      "tiempo": null,
      "idTrabajador": "11111",
      "prioridad": 2
    },
    {
      "codTrabajo": "33333",
      "categoria": "Limpieza",
      "descripcion": "prioridad3",
      "fechaInicio": "2024-05-30",
      "fechaFin": null,
      "tiempo": null,
      "idTrabajador": "11111",
      "prioridad": 3
    }
  ],
  "message": "Success",
  "status": 200
}
```
***Solicitud***:
```sh
GET /api/trabajos/prioridad/concreta?idTrabajador=11111&contraseña=1234&prioridad=1
```
***Respuesta***:
```json
{
  "result": [
    {
      "codTrabajo": "22222",
      "categoria": "Limpieza",
      "descripcion": "prioridades2",
      "fechaInicio": "2024-05-30",
      "fechaFin": null,
      "tiempo": null,
      "idTrabajador": "11111",
      "prioridad": 1
    }
  ],
  "message": "Success",
  "status": 200
}
```



