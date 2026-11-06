package com.example.repository;

import com.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// ==========================================================
// CAPA DE ACCESO A DATOS (implementación en memoria)
// Única clase que "habla" con el almacén de datos.
// Aquí usamos una lista en memoria para que sea simple, pero
// ESTE es el único archivo que cambiarías si usaras una base
// de datos real. Las demás capas no se enterarían del cambio,
// porque dependen de la interfaz UserRepository, no de esta clase.
// ==========================================================
public class InMemoryUserRepository implements UserRepository {

    private final List<User> users = new ArrayList<>();
    private int nextId = 1;

    public InMemoryUserRepository() {
        // Datos iniciales de ejemplo
        create("Ana", "ana@example.com");
        create("Luis", "luis@example.com");
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> findById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findFirst();
    }

    @Override
    public User create(String name, String email) {
        User user = new User(nextId++, name, email);
        users.add(user);
        return user;
    }
}
