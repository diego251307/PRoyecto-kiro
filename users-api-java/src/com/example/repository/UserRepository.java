package com.example.repository;

import com.example.model.User;

import java.util.List;
import java.util.Optional;

// ==========================================================
// CAPA DE ACCESO A DATOS (interfaz del Repositorio)
// Define QUÉ operaciones de datos existen, sin decir CÓMO.
// Gracias a esta interfaz, el servicio no depende de si los
// datos vienen de memoria, MySQL o MongoDB.
// ==========================================================
public interface UserRepository {

    List<User> findAll();

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);

    User create(String name, String email);
}
