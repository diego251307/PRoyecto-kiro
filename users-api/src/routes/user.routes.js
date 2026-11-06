// ==========================================================
// CAPA DE PRESENTACIÓN (Rutas)
// Define QUÉ URL + método HTTP llama a QUÉ función del controlador.
// No contiene lógica, solo "cableado".
// ==========================================================
const express = require("express");
const controller = require("../controllers/user.controller");

const router = express.Router();

router.get("/", controller.getAll);       // GET  /api/users
router.get("/:id", controller.getById);   // GET  /api/users/1
router.post("/", controller.create);      // POST /api/users

module.exports = router;
