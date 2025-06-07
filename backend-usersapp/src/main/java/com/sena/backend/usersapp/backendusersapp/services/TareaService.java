package com.sena.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.backend.usersapp.backendusersapp.models.entities.Tarea;
import com.sena.backend.usersapp.backendusersapp.models.entities.Usuario;
import com.sena.backend.usersapp.backendusersapp.repositories.TareaRepository;

/**
 * Servicio Tarea:
 * Contiene la lógica de negocio para manejar operaciones sobre la entidad Tarea.
 */
@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Obtener todas las tareas.
     */
    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    /**
     * Obtener una tarea por su ID.
     */
    public Optional<Tarea> obtenerPorId(Long id) {
        return tareaRepository.findById(id);
    }

    /**
     * Guardar o actualizar una tarea (con usuario cargado).
     */
    public Tarea guardar(Tarea tarea) {
        Long idUsuario = tarea.getUsuario().getIdUsuario();

        Usuario usuarioCompleto = usuarioService.obtenerPorId(idUsuario).orElseThrow(() ->
            new RuntimeException("Usuario no encontrado con ID: " + idUsuario)
        );

        tarea.setUsuario(usuarioCompleto);
        return tareaRepository.save(tarea);
    }

    /**
     * Actualizar estado y progreso de una tarea existente.
     */
    public Optional<Tarea> actualizarEstadoYProgreso(Long id, String estado, int progreso) {
        return tareaRepository.findById(id).map(tarea -> {
            tarea.setEstado(estado);
            tarea.setPorcentajeProgreso(progreso);
            return tareaRepository.save(tarea);
        });
    }

    /**
     * Eliminar una tarea por su ID.
     */
    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }
}
