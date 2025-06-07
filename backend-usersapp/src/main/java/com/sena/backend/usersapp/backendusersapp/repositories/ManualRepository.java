package com.sena.backend.usersapp.backendusersapp.repositories;

import com.sena.backend.usersapp.backendusersapp.models.entities.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Manual:
 * Acceso a operaciones CRUD para la entidad Manual.
 */
@Repository
public interface ManualRepository extends JpaRepository<Manual, Long> {
    // Puedes añadir consultas como buscar por categoría o por usuario
}
