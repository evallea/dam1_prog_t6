package paquete1.tarea7;

import java.io.*;

/**
 *
 * @author Enrique Valle Alcega
 */
public class Alumno implements Serializable {

    // ATRIBUTOS:
    String nombre;
    double calificacion;

    // CONSTRUCTOR CON PARÁMETROS:
    public Alumno(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    // CONSTRUCTOR POR DEFECTO:
    public Alumno() {
    }

    // GETS Y SETS:
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
