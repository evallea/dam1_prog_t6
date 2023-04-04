package paquete1.ejercicio5;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        FileOutputStream fos = null;
        ObjectOutputStream flujoSalidaObjetos = null;

        try {
            fos = new FileOutputStream("calificaciones.dat");
            flujoSalidaObjetos = new ObjectOutputStream(fos);
            String listaNombres[] = {"Enrique", "Rocío", "Juan", "Adrián", "Julio"};
            int listaNotas[] = {7, 6, 5, 8, 4};

            Alumno a1;
            for (int i = 0; i < listaNombres.length; i++) {
                a1 = new Alumno(listaNombres[i], listaNotas[i]);
                flujoSalidaObjetos.writeObject(a1);
            }
            System.out.println("Objetos guardados correctamente.");
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Hay un problema con el array.");
        } catch (FileNotFoundException fnfe) {
            System.out.println("No se encontró el fichero.");
        } catch (IOException e) {
            System.out.println("Ocurrió una IOException.");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                    System.out.println("Flujo cerrado correctamente.");
                }
            } catch (IOException e) {
                System.out.println("Ocurrió una IOException.");
            }
        }
    }
}
