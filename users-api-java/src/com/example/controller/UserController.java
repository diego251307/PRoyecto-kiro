package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;

import java.util.List;
import java.util.Optional;

// ==========================================================
// CAPA DE PRESENTACIÓN (Controlador)
// Traduce entre el "mundo exterior" (aquí, la consola) y la
// lógica de negocio. Recibe peticiones, llama al servicio y
// presenta el resultado. NO contiene reglas de negocio ni
// accede a los datos directamente.
//
// En una app web real, esta clase sería un @RestController de
// Spring que recibe peticiones HTTP; la idea es la misma.
// ==========================================================
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public void listUsers() {
        System.out.println("\n--- Lista de usuarios ---");
        List<User> users = service.getAllUsers();
        users.forEach(System.out::println);
    }

    public void findUser(int id) {
        System.out.println("\n--- Buscar usuario id=" + id + " ---");
        Optional<User> user = service.getUserById(id);
        if (user.isPresent()) {
            System.out.println("Encontrado: " + user.get());
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    public void addUser(String name, String email) {
        System.out.println("\n--- Crear usuario (" + name + ", " + email + ") ---");
        try {
            User created = service.createUser(name, email);
            System.out.println("Creado: " + created);
        } catch (IllegalArgumentException e) {
            // El servicio lanza el error si los datos no son válidos
            System.out.println("Error de validación: " + e.getMessage());
        }
    }
}
