package paquete1.bytetobyte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Enrique Valle Alcega
 */
public class ByteToByte {

    public static void main(String[] args) {

        FileInputStream forigen = null;
        FileOutputStream fdestino = null;
        File origen = new File("mifichero1.txt");

        // Se comprueba que el fichero origen existe. 
        if (origen.exists()) {
            File destino = new File("copiamifichero1.txt");
            int c;

            try {
                // Flujo de lectura.
                forigen = new FileInputStream(origen);

                // Flujo de escritura.
                fdestino = new FileOutputStream(destino);

                // Se lee el fichero a copiar hasta detectar el final.
                while ((c = forigen.read()) != -1) {
                    fdestino.write((char) c);
                }
            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {

            } finally {
                if (forigen != null) {
                    try {
                        forigen.close();
                    } catch (IOException ex) {
                        System.err.println("Error al cerrar.");
                    }
                }
                if (fdestino != null) {
                    try {
                        fdestino.close();
                    } catch (IOException ex) {
                        System.err.println("Error al cerrar.");
                    }
                }
            }
        } else {
            System.out.println("El fichero a copiar no existe.");
        }
    }
}

