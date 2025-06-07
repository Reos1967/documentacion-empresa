package com.sena.backend.usersapp.backendusersapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.backend.usersapp.backendusersapp.models.entities.Usuario;
import com.sena.backend.usersapp.backendusersapp.repositories.UsuarioRepository;

/**
 * Controlador de Autenticación:
 * Valida usuarios por email y contraseña (versión básica).
 */
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Endpoint de login básico:
     * POST /api/login
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail());

        if (usuario != null && usuario.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(usuario); // Devuelve el usuario si todo está bien
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    // Clase interna para el cuerpo de la solicitud
    static class LoginRequest {
        private String email;
        private String password;

        // Getters y setters
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}