package com.sena.backend.usersapp.backendusersapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.backend.usersapp.backendusersapp.models.entities.Tarea;
import com.sena.backend.usersapp.backendusersapp.services.TareaService;

/**
 * Controlador Tarea:
 * Define los endpoints REST para gestionar tareas.
 */
@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    /**
     * Obtener todas las tareas.
     * GET /api/tareas
     */
    @GetMapping
    public List<Tarea> obtenerTodas() {
        return tareaService.obtenerTodas();
    }

    /**
     * Obtener una tarea por ID.
     * GET /api/tareas/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerPorId(@PathVariable Long id) {
        return tareaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crear una nueva tarea.
     * POST /api/tareas
     */
    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaService.guardar(tarea);
    }

    /**
     * Actualizar estado y progreso de una tarea.
     * PUT /api/tareas/{id}/estado
     */
    @PutMapping("/{id}/estado")
    public ResponseEntity<Tarea> actualizarEstadoYProgreso(
            @PathVariable Long id,
            @RequestBody Map<String, Object> datos) {

        String estado = (String) datos.get("estado");
        int progreso = (int) datos.get("porcentajeProgreso");

        return tareaService.actualizarEstadoYProgreso(id, estado, progreso)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Eliminar una tarea.
     * DELETE /api/tareas/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        if (tareaService.obtenerPorId(id).isPresent()) {
            tareaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
