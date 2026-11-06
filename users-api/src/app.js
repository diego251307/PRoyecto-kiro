// ----------------------------------------------------------
// CONFIGURACIÓN DE LA APP EXPRESS
// Conecta las rutas y los middlewares. No arranca el servidor
// (eso lo hace server.js) para poder reutilizar la app en tests.
// ----------------------------------------------------------
const express = require("express");
const userRoutes = require("./routes/user.routes");

const app = express();

// Middleware para leer JSON en el cuerpo de las peticiones
app.use(express.json());

// Ruta de salud (para comprobar que todo funciona)
app.get("/", (req, res) => {
  res.json({ message: "API de usuarios funcionando 🚀" });
});

// Todas las rutas de usuarios cuelgan de /api/users
app.use("/api/users", userRoutes);

module.exports = app;
