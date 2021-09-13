/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
/**
 *
 * @author
 */
public class Carrera {
    
    private int id;
    private String nombre;
    private int capacidad;
    private float exigencia;
    private boolean modalidad;

    public Carrera(int id, String nombre, int capacidad, float exigencia, boolean modalidad) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.exigencia = exigencia;
        this.modalidad = modalidad;
    }

    public Carrera() {
        this.id = 0;
        this.nombre = "";
        this.capacidad = 0;
        this.exigencia = 0;
        this.modalidad = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public float getExigencia() {
        return exigencia;
    }

    public void setExigencia(float exigencia) {
        this.exigencia = exigencia;
    }

    public boolean isModalidad() {
        return modalidad;
    }

    public void setModalidad(boolean modalidad) {
        this.modalidad = modalidad;
    }
    
    

    
    
}
