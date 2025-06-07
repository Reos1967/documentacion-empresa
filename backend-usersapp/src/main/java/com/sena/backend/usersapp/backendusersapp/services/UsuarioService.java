package com.sena.backend.usersapp.backendusersapp.services;

import com.sena.backend.usersapp.backendusersapp.models.entities.Usuario;
import com.sena.backend.usersapp.backendusersapp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio Usuario:
 * Contiene la lógica de negocio para manejar operaciones sobre la entidad Usuario.
 */
@Service
public class UsuarioService {

    // Inyectamos el repositorio para acceder a la base de datos
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtener todos los usuarios registrados.
     */
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    /**
     * Obtener un usuario por su ID.
     */
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Guardar o actualizar un usuario.
     */
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Eliminar un usuario por su ID.
     */
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}

