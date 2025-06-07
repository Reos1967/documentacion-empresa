package com.sena.backend.usersapp.backendusersapp.controllers;

import com.sena.backend.usersapp.backendusersapp.models.entities.Empresa;
import com.sena.backend.usersapp.backendusersapp.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador Empresa:
 * Define los endpoints REST para gestionar empresas.
 */
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    /**
     * Obtener todas las empresas.
     * GET /api/empresas
     */
    @GetMapping
    public List<Empresa> obtenerTodas() {
        return empresaService.obtenerTodas();
    }

    /**
     * Obtener una empresa por ID.
     * GET /api/empresas/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerPorId(@PathVariable Long id) {
        return empresaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crear una nueva empresa.
     * POST /api/empresas
     */
    @PostMapping
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return empresaService.guardar(empresa);
    }

    /**
     * Actualizar una empresa existente.
     * PUT /api/empresas/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        return empresaService.obtenerPorId(id)
                .map(empresaExistente -> {
                    empresaExistente.setNombre(empresa.getNombre());
                    return ResponseEntity.ok(empresaService.guardar(empresaExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Eliminar una empresa.
     * DELETE /api/empresas/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Long id) {
        if (empresaService.obtenerPorId(id).isPresent()) {
            empresaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}