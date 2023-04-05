package paquete1.ejercicio1;

import java.io.*;

/**
 *
 * @author damt124
 */
public class Personal implements Serializable {

    // ATRIBUTOS:
    private String dni;
    private int salario;

    // CONSTRUCTOR POR DEFECTO:
    public Personal() {
    }

    // CONSTRUCTOR CON PARÁMETROS:
    public Personal(String dni, int salario) {
        this.dni = dni;
        this.salario = salario;
    }

    // MÉTODOS GET Y SET:
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    // MÉTODOS PARA VALIDAR ATRIBUTOS DE LA CLASE:
    public boolean validarDNI(String dni) {
        return (dni.length() == 8); // La longitud de caracteres del DNI debe ser 8.
    }

    public boolean validarSalario(int salario) {
        return (salario >= 1400 && salario <= 2100); // El salario debe estar entre 1400 y 2100.
    }
}
