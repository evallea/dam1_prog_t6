package paquete1.ejercicio3;

import java.io.*;

/**
 *
 * @author damt124
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        // Declaración de clases y variables:
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        
        int cont = 1;
        
        try {
            fr = new FileReader("mensaje_encriptado.txt");
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    System.out.print((char) (linea.charAt(i) - cont));
                }
                System.out.println("");
                cont++;
            }
        } catch (IOException e) {
            System.err.println("Ha ocurrido una IOException");
        } finally {
            try {
                if (fr != null) {
                    br.close();
                    fr.close();
                }
            } catch (IOException es) {
                System.err.println("Ha ocurrido una IOException");
            }
        }
    }
}
