package paquete1.escribirficheros;

import java.io.*;

public class EscribirFicheros {

    // Programa que escribe un texto completo en un fichero, por defecto dentro del propio proyecto.
    public static void main(String[] args) {

        FileWriter fw = null; // Se declara el flujo de salida.
        String texto = "En un lugar de La Mancha de cuyo nombre no quiero acordarme...";

        try {
            fw = new FileWriter("datos1.txt");
            // Al instanciar se crea datos1.txt en la carpeta por defecto.
            // Se puede acceder y leer.
            fw.write(texto); // write() es un método de la clase FileWriter.
            System.out.println("Texto escrito.");
        } catch (IOException e) {
            System.out.println("Ocurrió una 'IOException'");
        } finally {
            try {
                fw.close(); // Se recomienda cerrar los flujos una vez utilizados.
            } catch (IOException e) { // Se pone un 'try' porque close() lanza IOException.
                System.out.println("Ocurrió una 'IOException'");
            }
        }
    }
}
