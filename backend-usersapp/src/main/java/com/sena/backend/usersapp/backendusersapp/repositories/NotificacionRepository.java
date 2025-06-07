package com.sena.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.backend.usersapp.backendusersapp.models.entities.Notificacion;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    // Aquí podrías agregar métodos personalizados, como buscar por usuario
}
