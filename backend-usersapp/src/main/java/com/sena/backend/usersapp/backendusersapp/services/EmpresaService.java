package com.sena.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backend.usersapp.backendusersapp.models.entities.Empresa;
import com.sena.backend.usersapp.backendusersapp.repositories.EmpresaRepository;

/**
 * Servicio Empresa:
 * Contiene la lógica de negocio para manejar las operaciones sobre la entidad Empresa.
 */
@Service
public class EmpresaService {

    // Inyectamos el repositorio para acceder a la base de datos
    @Autowired
    private EmpresaRepository empresaRepository;

    /**
     * Obtener todas las empresas registradas.
     */
    public List<Empresa> obtenerTodas() {
        return empresaRepository.findAll();
    }

    /**
     * Obtener una empresa por su ID.
     */
    public Optional<Empresa> obtenerPorId(Long id) {
        return empresaRepository.findById(id);
    }

    /**
     * Guardar o actualizar una empresa.
     */
    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    /**
     * Eliminar una empresa por su ID.
     */
    public void eliminar(Long id) {
        empresaRepository.deleteById(id);
    }
}