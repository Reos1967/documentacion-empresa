package com.sena.backend.usersapp.backendusersapp.models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidad Manual:
 * Representa un contenido o instructivo creado por un usuario.
 */
@Entity
@Table(name = "manual")
public class Manual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManual;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(length = 100)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario; // Usuario que creó el manual

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    // ----- CONSTRUCTORES -----

    public Manual() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Manual(String titulo, String contenido, String categoria, Usuario usuario) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.categoria = categoria;
        this.usuario = usuario;
        this.fechaCreacion = LocalDateTime.now();
    }

    // ----- GETTERS Y SETTERS -----

    public Long getIdManual() {
        return idManual;
    }

    public void setIdManual(Long idManual) {
        this.idManual = idManual;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    // ----- TO STRING -----

    @Override
    public String toString() {
        return "Manual{" +
                "idManual=" + idManual +
                ", titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", usuario=" + (usuario != null ? usuario.getIdUsuario() : null) +
                '}';
    }
}
