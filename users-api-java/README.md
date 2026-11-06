# Users API (Java) — Ejemplo de Arquitectura en Capas

Aplicación sencilla de gestión de usuarios en **Java puro** (sin frameworks)
organizada en **3 capas**: presentación → negocio → datos.

## ¿Por qué Java puro y no Spring Boot?

Spring Boot es el estándar real para APIs en Java, pero necesita Maven/Gradle
para descargar dependencias de internet. Este entorno no tiene acceso a la red,
así que usamos Java puro: se compila con `javac` y, además, deja ver cada capa
sin la "magia" de las anotaciones. La arquitectura en capas es exactamente la misma.

## Estructura de carpetas

```
users-api-java/
├── README.md
└── src/
    └── com/example/
        ├── Main.java                          # Punto de entrada: arma y conecta las capas
        ├── model/
        │   └── User.java                       # Entidad: los datos de un usuario
        ├── controller/
        │   └── UserController.java             # 🟦 CAPA PRESENTACIÓN
        ├── service/
        │   └── UserService.java                # 🟨 CAPA NEGOCIO (reglas/validaciones)
        └── repository/
            ├── UserRepository.java             # 🟩 CAPA DATOS (interfaz)
            └── InMemoryUserRepository.java     #     CAPA DATOS (implementación)
```

## Flujo de una petición

```
Main (arranca)
   │
   ▼  Controller  →  recibe la petición y presenta el resultado   (NO tiene reglas)
   ▼  Service     →  valida, decide, aplica reglas de negocio      (NO sabe de consola/web)
   ▼  Repository  →  lee/escribe los datos                         (NO sabe de reglas)
   ▼
 Datos (lista en memoria)
```

## Reglas de oro de las capas

- **Controller**: solo traduce entre el exterior (consola/HTTP) y la lógica. No valida.
- **Service**: el cerebro. Aquí viven las reglas (ej: email obligatorio, email único).
  No sabe cómo se muestran ni cómo se guardan los datos.
- **Repository**: único que toca los datos. Es una **interfaz** (`UserRepository`) con
  una implementación en memoria (`InMemoryUserRepository`). Para usar una BD real solo
  crearías otra implementación; **las demás capas no cambiarían**.

## Cómo compilar y ejecutar

```bash
cd users-api-java
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out com.example.Main
```
