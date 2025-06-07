package com.sena.backend.usersapp.backendusersapp.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad Empresa:
 * Representa la tabla 'empresa' en la base de datos.
 * Contiene la información básica de cada empresa que usa el sistema.
 */

@Entity
@Table(name = "empresa")
public class Empresa {

    // Clave primaria autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    // Nombre de la empresa (no puede ser nulo)
    @Column(nullable = false, length = 100)
    private String nombre;

    // Fecha de creación (se asigna automáticamente)
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    // ----- CONSTRUCTORES -----

    // Constructor vacío (necesario para JPA)
    public Empresa() {
        // Al crear una nueva instancia, asignamos la fecha actual
        this.fechaCreacion = LocalDateTime.now();
    }

    // Constructor con parámetros
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDateTime.now();
    }

    // ----- GETTERS Y SETTERS -----

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // ----- MÉTODO TO STRING -----

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nombre='" + nombre + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
