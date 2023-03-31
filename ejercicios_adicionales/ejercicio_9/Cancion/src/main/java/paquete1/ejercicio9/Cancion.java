package paquete1.ejercicio9;

import java.io.*;

public class Cancion {

    public static void main(String[] args) {

        File archivo = new File("cancion.txt");
        BufferedReader br = null;
        String cadena;
        int lineas = 0;

        try {
            br = new BufferedReader(new FileReader(archivo));
            while ((cadena = br.readLine()) != null) {
                System.out.println(cadena + "\t" + cadena.split(" ").length + " palabras");
                lineas++;
            }
            System.out.println("\nEl número de líneas es: " + lineas);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
