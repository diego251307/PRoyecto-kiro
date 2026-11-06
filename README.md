# Proyecto Kiro — Arquitectura en Capas

Dos ejemplos del mismo concepto (**arquitectura en capas**: presentación → negocio → datos),
implementados en dos tecnologías distintas para comparar.

## Contenido

| Carpeta            | Tecnología            | Cómo ejecutar                                |
|--------------------|-----------------------|----------------------------------------------|
| `users-api/`       | Node.js + Express     | `npm install && npm start`                   |
| `users-api-java/`  | Java puro (sin frameworks) | ver su README (compila con `javac`)     |

Ambos implementan una pequeña gestión de usuarios con 3 capas:

- **Presentación** (rutas/controlador): recibe peticiones y devuelve respuestas.
- **Negocio** (servicio): reglas y validaciones (ej: email obligatorio y único).
- **Datos** (repositorio): lee/escribe los datos (aquí, en memoria).

Cada carpeta tiene su propio `README.md` con la estructura detallada y el flujo de una petición.
