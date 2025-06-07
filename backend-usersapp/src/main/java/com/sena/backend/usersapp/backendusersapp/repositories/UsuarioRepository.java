package com.sena.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.backend.usersapp.backendusersapp.models.entities.Usuario;

/**
 * Repositorio Usuario:
 * Extiende JpaRepository para manejar operaciones CRUD sobre la entidad Usuario.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    // Aquí puedes agregar métodos personalizados, como buscar por email, si lo necesitas en el futuro.
}

