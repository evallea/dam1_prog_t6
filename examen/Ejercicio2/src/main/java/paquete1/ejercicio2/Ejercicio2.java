package paquete1.ejercicio2;

import java.io.*;

/**
 *
 * @author damt124
 */
/*public class Ejercicio2 {

    public static void main(String[] args) {
        
        // Declaración de las clases:
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);
        
        // Se comienzan declarando como "null":
        FileWriter fw = null;
        BufferedWriter bw = null;

        String texto; // Variable para almacenar el texto.

        try {
            fw = new FileWriter("fichero.txt"); // Se genera el fichero.
            bw = new BufferedWriter(fw);
            System.out.println("Introduce texto:");
            do {
                texto = teclado.readLine();
                if (!texto.equals(";")) {
                    bw.write(texto); // Escritura.
                    bw.newLine(); // Salto de línea (no he conseguido hacer que escribiendo / salte de línea).
                }
            } while (!texto.equals(";"));
        } catch (IOException e) {
            System.err.println("Error");
        } finally {
            try {
                if (fw != null) {
                    // Se cierran flujos.
                    bw.close();
                    fw.close();
                }
            } catch (IOException es) {
                System.err.println("Ha ocurrido una IOException");
            }
        }
    }
}
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        // Declaración de las clases:
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);

        // Se comienzan declarando como "null":
        FileWriter fw = null;
        BufferedWriter bw = null;

        String texto; // Variable para almacenar el texto.

        try {
            fw = new FileWriter("fichero.txt"); // Se genera el fichero.
            bw = new BufferedWriter(fw);
            System.out.println("Introduce texto:");
            do {
                texto = teclado.readLine();
                if (!texto.equals(";")) {
                    bw.write(texto); // Escritura.
                }
                if (texto.equalsIgnoreCase("/")) {
                    bw.newLine(); // Salto de linea (no he conseguido borrarlo del programa...).
                }
            } while (!texto.equals(";"));
        } catch (IOException e) {
            System.err.println("Error");
        } finally {
            try {
                if (fw != null) {
                    // Se cierran flujos.
                    bw.close();
                    fw.close();
                }
            } catch (IOException es) {
                System.err.println("Ha ocurrido una IOException");
            }
        }
    }
}
