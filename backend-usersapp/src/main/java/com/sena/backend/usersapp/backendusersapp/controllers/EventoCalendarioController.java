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

import com.sena.backend.usersapp.backendusersapp.models.entities.EventoCalendario;
import com.sena.backend.usersapp.backendusersapp.services.EventoCalendarioService;

@RestController
@RequestMapping("/api/eventos")
public class EventoCalendarioController {

    @Autowired
    private EventoCalendarioService eventoService;

    @GetMapping
    public List<EventoCalendario> obtenerTodos() {
        return eventoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoCalendario> obtenerPorId(@PathVariable Long id) {
        return eventoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EventoCalendario crear(@RequestBody EventoCalendario evento) {
        return eventoService.guardar(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoCalendario> actualizar(@PathVariable Long id, @RequestBody EventoCalendario e) {
        return eventoService.obtenerPorId(id)
                .map(actual -> {
                    actual.setTitulo(e.getTitulo());
                    actual.setDescripcion(e.getDescripcion());
                    actual.setFechaInicio(e.getFechaInicio());
                    actual.setFechaFin(e.getFechaFin());
                    return ResponseEntity.ok(eventoService.guardar(actual));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (eventoService.obtenerPorId(id).isPresent()) {
            eventoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

