package com.sena.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.backend.usersapp.backendusersapp.models.entities.Empresa;

/**
 * Repositorio Empresa:
 * Extiende JpaRepository para manejar operaciones CRUD (crear, leer, actualizar, eliminar)
 * sobre la entidad Empresa de forma automática.
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Aquí puedes agregar consultas personalizadas si lo necesitas en el futuro
}