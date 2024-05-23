package com.joverpenalva.proyectospringboot.models.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "trabajadores")
public class Trabajador {

    @Id
    @Column(name = "id_trabajador", length = 5)
    private String idTrabajador;

    @Column(name = "dni", length = 9, unique = true, nullable = false)
    private String dni;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 100, nullable = false)
    private String apellidos;

    @Column(name = "especialidad", length = 50, nullable = false)
    private String especialidad;

    @Column(name = "contraseña", length = 50, nullable = false)
    private String contraseña;

    @Column(name = "email", length = 150, unique = true, nullable = false)
    private String email;
    
    @JsonBackReference
    @OneToMany(mappedBy = "trabajador", fetch = FetchType.LAZY)
    private List<Trabajo> trabajos;


 // Getters and Setters
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
