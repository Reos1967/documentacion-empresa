package com.sena.backend.usersapp.backendusersapp.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad Usuario:
 * Representa a los usuarios del sistema (asesores, líderes, admins).
 * Está relacionada con la tabla 'usuario' en la base de datos.
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    // Clave primaria autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    // Nombre completo del usuario
    @Column(nullable = false, length = 100)
    private String nombre;

    // Correo único (usado como login)
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    // Contraseña (encriptada, en un futuro)
    @Column(nullable = false, length = 255)
    private String password;

    // Rol del usuario: asesor, lider, admin
    @Column(nullable = false, length = 20)
    private String rol;

    // Relación con empresa (muchos usuarios pertenecen a una empresa)
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    // ----- CONSTRUCTORES -----

    public Usuario() {
    }

    public Usuario(String nombre, String email, String password, String rol, Empresa empresa) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.empresa = empresa;
    }

    // ----- GETTERS Y SETTERS -----

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    // ----- MÉTODO TO STRING -----

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", empresa=" + (empresa != null ? empresa.getIdEmpresa() : null) +
                '}';
    }
}