package com.sena.backend.usersapp.backendusersapp.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



/**
 * Entidad Tarea:
 * Representa las tareas asignadas a usuarios, con progreso y fecha límite.
 */
@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarea;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false, length = 50)
    private String estado = "pendiente";

    @Column(nullable = false)
    private int porcentajeProgreso;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // ----- CONSTRUCTORES -----

    public Tarea() {
    }

    public Tarea(String titulo, String descripcion, int porcentajeProgreso, LocalDate fechaLimite, Usuario usuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.porcentajeProgreso = porcentajeProgreso;
        this.fechaLimite = fechaLimite;
        this.usuario = usuario;
    }

    // ----- GETTERS Y SETTERS -----

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPorcentajeProgreso() {
        return porcentajeProgreso;
    }

    public void setPorcentajeProgreso(int porcentajeProgreso) {
        this.porcentajeProgreso = porcentajeProgreso;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // ----- MÉTODO TO STRING -----

    @Override
    public String toString() {
        return "Tarea{" +
                "idTarea=" + idTarea +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", porcentajeProgreso=" + porcentajeProgreso +
                ", fechaLimite=" + fechaLimite +
                ", usuario=" + (usuario != null ? usuario.getIdUsuario() : null) +
                '}';
    }
}