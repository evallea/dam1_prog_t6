package paquete1.ejercicio7;

import java.io.Serializable;

public class Alumno implements Serializable {
    String nombre;
    double calificacion;

    public Alumno(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "\nCalificación: " + calificacion;
    }
}
