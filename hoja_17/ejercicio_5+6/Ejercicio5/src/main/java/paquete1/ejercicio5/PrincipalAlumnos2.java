package paquete1.ejercicio5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class PrincipalAlumnos2 {

    public static void main(String[] args) {
        FileInputStream fis = null;
        ObjectInputStream flujoEntradaObjetos = null;

        try {
            fis = new FileInputStream("calificaciones.dat");
            flujoEntradaObjetos = new ObjectInputStream(fis);

            Alumno a1;
            while (true) {
                a1 = (Alumno) flujoEntradaObjetos.readObject();
                System.out.println(a1);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se encontró el fichero.");
        } catch (IOException e) {
            System.out.println("Fin de la lista de alumnos.");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Clase no encontrada.");
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                    System.out.println("Flujo cerrado correctamente.");
                }
            } catch (IOException e) {
                System.out.println("Ocurrió una IOException.");
            }
        }
    }
}
