package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;

import java.util.List;
import java.util.Optional;

// ==========================================================
// CAPA DE LÓGICA DE NEGOCIO (Servicio)
// Aquí viven las REGLAS: validaciones, decisiones, cálculos.
// No sabe nada de cómo se muestran los datos (consola/web) ni
// de cómo se guardan. Pide y guarda datos a través del repositorio.
// ==========================================================
public class UserService {

    private final UserRepository repository;

    // El repositorio se "inyecta" desde fuera (inyección de dependencias
    // a mano). Así el servicio no crea ni conoce la implementación concreta.
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return repository.findById(id);
    }

    public User createUser(String name, String email) {
        // Regla de negocio: nombre y email son obligatorios
        if (name == null || name.isBlank() || email == null || email.isBlank()) {
            throw new IllegalArgumentException("El nombre y el email son obligatorios");
        }

        // Regla de negocio: el email no puede estar repetido
        if (repository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Ya existe un usuario con ese email");
        }

        return repository.create(name, email);
    }
}
