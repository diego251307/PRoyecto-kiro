// ==========================================================
// CAPA DE PRESENTACIÓN (Controlador)
// Traduce entre el mundo HTTP (req, res) y la lógica de negocio.
// Lee datos de la petición, llama al servicio y devuelve la respuesta.
// NO contiene reglas de negocio ni accede a los datos directamente.
// ==========================================================
const service = require("../services/user.service");

function getAll(req, res) {
  const users = service.getAllUsers();
  res.json(users);
}

function getById(req, res) {
  const id = Number(req.params.id);
  const user = service.getUserById(id);

  if (!user) {
    return res.status(404).json({ error: "Usuario no encontrado" });
  }
  res.json(user);
}

function create(req, res) {
  try {
    const newUser = service.createUser(req.body);
    res.status(201).json(newUser);
  } catch (err) {
    // El servicio lanza un error si los datos no son válidos
    res.status(400).json({ error: err.message });
  }
}

module.exports = { getAll, getById, create };
