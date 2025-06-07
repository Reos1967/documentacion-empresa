package com.sena.backend.usersapp.backendusersapp.services;

import com.sena.backend.usersapp.backendusersapp.models.entities.Manual;
import com.sena.backend.usersapp.backendusersapp.repositories.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio Manual:
 * Lógica para gestionar la entidad Manual.
 */
@Service
public class ManualService {

    @Autowired
    private ManualRepository manualRepository;

    public List<Manual> obtenerTodos() {
        return manualRepository.findAll();
    }

    public Optional<Manual> obtenerPorId(Long id) {
        return manualRepository.findById(id);
    }

    public Manual guardar(Manual manual) {
        return manualRepository.save(manual);
    }

    public void eliminar(Long id) {
        manualRepository.deleteById(id);
    }
}
