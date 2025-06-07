package com.sena.backend.usersapp.backendusersapp.controllers;

import java.util.List;

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

import com.sena.backend.usersapp.backendusersapp.models.entities.Manual;
import com.sena.backend.usersapp.backendusersapp.services.ManualService;

/**
 * Controlador Manual:
 * Define los endpoints REST para administrar manuales.
 */
@RestController
@RequestMapping("/api/manuales")
public class ManualController {

    @Autowired
    private ManualService manualService;

    @GetMapping
    public List<Manual> obtenerTodos() {
        return manualService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manual> obtenerPorId(@PathVariable Long id) {
        return manualService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Manual crearManual(@RequestBody Manual manual) {
        return manualService.guardar(manual);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manual> actualizarManual(@PathVariable Long id, @RequestBody Manual manual) {
        return manualService.obtenerPorId(id)
                .map(manualExistente -> {
                    manualExistente.setTitulo(manual.getTitulo());
                    manualExistente.setContenido(manual.getContenido());
                    manualExistente.setCategoria(manual.getCategoria());
                    manualExistente.setUsuario(manual.getUsuario());
                    return ResponseEntity.ok(manualService.guardar(manualExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarManual(@PathVariable Long id) {
        if (manualService.obtenerPorId(id).isPresent()) {
            manualService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
