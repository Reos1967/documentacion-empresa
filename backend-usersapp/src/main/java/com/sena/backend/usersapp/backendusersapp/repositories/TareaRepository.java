package com.sena.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.backend.usersapp.backendusersapp.models.entities.Tarea;

/**
 * Repositorio Tarea:
 * Extiende JpaRepository para manejar operaciones CRUD sobre la entidad Tarea.
 */
@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    // Aquí puedes agregar consultas personalizadas, como buscar tareas por usuario.
}
