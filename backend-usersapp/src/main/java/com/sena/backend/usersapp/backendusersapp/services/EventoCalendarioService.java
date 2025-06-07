package com.sena.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backend.usersapp.backendusersapp.models.entities.EventoCalendario;
import com.sena.backend.usersapp.backendusersapp.repositories.EventoCalendarioRepository;

@Service
public class EventoCalendarioService {

    @Autowired
    private EventoCalendarioRepository eventoRepo;

    public List<EventoCalendario> obtenerTodos() {
        return eventoRepo.findAll();
    }

    public Optional<EventoCalendario> obtenerPorId(Long id) {
        return eventoRepo.findById(id);
    }

    public EventoCalendario guardar(EventoCalendario evento) {
        return eventoRepo.save(evento);
    }

    public void eliminar(Long id) {
        eventoRepo.deleteById(id);
    }
}

