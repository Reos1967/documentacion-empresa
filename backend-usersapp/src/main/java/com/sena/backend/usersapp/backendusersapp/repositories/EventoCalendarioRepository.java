package com.sena.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.backend.usersapp.backendusersapp.models.entities.EventoCalendario;

@Repository
public interface EventoCalendarioRepository extends JpaRepository<EventoCalendario, Long> {
    // Se pueden agregar consultas personalizadas si se desea
}

