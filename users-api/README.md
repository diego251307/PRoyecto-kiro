# Users API — Ejemplo de Arquitectura en Capas

API sencilla de usuarios (Node.js + Express) organizada en **4 capas**.

## ¿Qué es la arquitectura en capas?

Cada capa tiene **una sola responsabilidad** y solo habla con la capa de abajo.
Así el código es ordenado, fácil de probar y de cambiar.

```
Petición HTTP
     │
     ▼
┌─────────────────────────┐
│  Rutas (routes)         │  ← Qué URL llama a qué función
└─────────────────────────┘
     │
     ▼
┌─────────────────────────┐
│  Controlador (controller)│  ← Traduce HTTP ⇄ lógica
└─────────────────────────┘
     │
     ▼
┌─────────────────────────┐
│  Servicio (service)     │  ← Reglas de negocio / validaciones
└─────────────────────────┘
     │
     ▼
┌─────────────────────────┐
│  Repositorio (repository)│  ← Acceso a los datos
└─────────────────────────┘
     │
     ▼
   Datos (array en memoria / BD)
```

## Estructura de carpetas

```
users-api/
├── package.json
├── README.md
└── src/
    ├── server.js                      # Arranca el servidor
    ├── app.js                         # Configura Express y conecta rutas
    ├── routes/
    │   └── user.routes.js             # CAPA presentación: define las URLs
    ├── controllers/
    │   └── user.controller.js         # CAPA presentación: maneja req/res
    ├── services/
    │   └── user.service.js            # CAPA negocio: reglas y validaciones
    └── repositories/
        └── user.repository.js         # CAPA datos: lee/escribe los datos
```

## Cómo ejecutar

```bash
npm install
npm start
```

El servidor queda en `http://localhost:3000`.

## Endpoints

| Método | URL              | Descripción              |
|--------|------------------|--------------------------|
| GET    | `/api/users`     | Listar todos             |
| GET    | `/api/users/:id` | Obtener uno por id       |
| POST   | `/api/users`     | Crear uno (name, email)  |

Ejemplo para crear:

```bash
curl -X POST http://localhost:3000/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Marta","email":"marta@example.com"}'
```
