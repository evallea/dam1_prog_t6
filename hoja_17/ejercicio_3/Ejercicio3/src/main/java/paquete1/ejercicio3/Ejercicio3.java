package paquete1.ejercicio3;

import java.io.*;

public class Ejercicio3 {

    public static void main(String[] args) {

        FileInputStream fis = null;
        String texto = "";
        char c;

        try {
            fis = new FileInputStream("datos personales.txt");
            int longitud = fis.available();
            for (int i = 0; i < longitud; i++) {
                c = (char) fis.read();
                texto = texto + c;
            }
            System.out.println(texto);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException e) {
            System.out.println("Ocurrió una IOException.");
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
