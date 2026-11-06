// ==========================================================
// CAPA DE ACCESO A DATOS (Repositorio)
// Única capa que "habla" con el almacén de datos.
// Aquí usamos un array en memoria para que sea simple, pero
// ESTE es el único archivo que cambiarías si usaras una base
// de datos real (MySQL, MongoDB, etc.). Las demás capas no se enteran.
// ==========================================================

// "Base de datos" falsa en memoria
let users = [
  { id: 1, name: "Ana", email: "ana@example.com" },
  { id: 2, name: "Luis", email: "luis@example.com" },
];

let nextId = 3;

function findAll() {
  return users;
}

function findById(id) {
  return users.find((u) => u.id === id);
}

function findByEmail(email) {
  return users.find((u) => u.email === email);
}

function create(user) {
  const newUser = { id: nextId++, ...user };
  users.push(newUser);
  return newUser;
}

module.exports = { findAll, findById, findByEmail, create };
