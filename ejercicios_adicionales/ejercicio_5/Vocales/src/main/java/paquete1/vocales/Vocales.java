package paquete1.vocales;

import java.util.*;
import java.io.*;

public class Vocales {

    public static void main(String[] args) {

        System.out.println("Introduce el nombre del fichero:");
        String ruta = new Scanner(System.in).nextLine();
        File fichero = new File(ruta);
        FileInputStream finicio = null;
        int valor;
        int contador = 0;
        char vocales[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        try {
            finicio = new FileInputStream(fichero);

            while ((valor = finicio.read()) != -1) {
                for (char v : vocales) {
                    if (v == (char) valor) {
                        contador++;
                    }
                }
            }
            
            System.out.println("Hay " + contador + " vocales.");
            System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
            System.out.println("Tamaño del fichero: " + fichero.length());
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el fichero.");
        } catch (IOException e) {
            System.out.println("Ocurrió una IOException.");
        }
    }
}
