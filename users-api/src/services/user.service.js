// ==========================================================
// CAPA DE LÓGICA DE NEGOCIO (Servicio)
// Aquí viven las REGLAS: validaciones, cálculos, decisiones.
// No sabe nada de HTTP ni de cómo se guardan los datos.
// Pide y guarda datos a través del repositorio.
// ==========================================================
const repository = require("../repositories/user.repository");

function getAllUsers() {
  return repository.findAll();
}

function getUserById(id) {
  return repository.findById(id);
}

function createUser(data) {
  // Regla de negocio: el nombre y el email son obligatorios
  if (!data.name || !data.email) {
    throw new Error("El nombre y el email son obligatorios");
  }

  // Regla de negocio: el email no puede estar repetido
  const existing = repository.findByEmail(data.email);
  if (existing) {
    throw new Error("Ya existe un usuario con ese email");
  }

  return repository.create({ name: data.name, email: data.email });
}

module.exports = { getAllUsers, getUserById, createUser };
