package com.example;

import com.example.controller.UserController;
import com.example.repository.InMemoryUserRepository;
import com.example.repository.UserRepository;
import com.example.service.UserService;

// ==========================================================
// PUNTO DE ENTRADA (arranca la aplicación)
// Aquí se "arma" la aplicación: se crean las capas y se conectan
// unas con otras de abajo hacia arriba:
//     repository  ->  service  ->  controller
// Esto se llama "inyección de dependencias" hecha a mano.
// ==========================================================
public class Main {

    public static void main(String[] args) {
        // 1) Capa de datos
        UserRepository repository = new InMemoryUserRepository();

        // 2) Capa de negocio (recibe el repositorio)
        UserService service = new UserService(repository);

        // 3) Capa de presentación (recibe el servicio)
        UserController controller = new UserController(service);

        // --- Demostración de uso ---
        controller.listUsers();                                   // muestra Ana y Luis
        controller.addUser("Marta", "marta@example.com");         // crea correctamente
        controller.addUser("SinEmail", "");                       // falla: campos obligatorios
        controller.addUser("Otra", "ana@example.com");            // falla: email repetido
        controller.findUser(1);                                   // encuentra a Ana
        controller.findUser(99);                                  // no encuentra
        controller.listUsers();                                   // lista final
    }
}
