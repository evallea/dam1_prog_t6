package paquete1.palabraporlinea;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Enrique Valle Alcega
 */
public class PalabraPorLinea {

    public static void main(String[] args) {
        System.out.println("Introduce el nombre del fichero:");
        String ruta = new Scanner(System.in).nextLine();
        File fichero = new File(ruta);
        FileInputStream finicio = null;
        int valor;
        int contador = 0;

        try {
            finicio = new FileInputStream(fichero);

            while ((valor = finicio.read()) != -1) {
                if ((valor == ' ') || (valor == '\r') || (valor == '\n')) {
                    if ((valor != '\r') && (valor != '\n')) {
                        System.out.println(" - " + contador + " caracteres");
                        contador = 0;
                    }
                } else {
                    System.out.print((char) valor);
                    contador++;
                }
            }
            /**
             * Muestro la informacion del fichero **
             */
            System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
            System.out.println("Tamaño del fichero: " + fichero.length());
        } catch (FileNotFoundException ex) {
            System.err.println(ex.toString());
        } catch (IOException ex) {
            System.err.println(ex.toString());
        } finally {
            if (finicio != null) {
                try {
                    finicio.close();
                } catch (IOException e) {
                    System.err.println(e.toString());
                }
            }
        }
    }
}
