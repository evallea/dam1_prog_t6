package paquete1.leerconbufferreader;

import java.io.*;

public class LeerConBufferReader {

    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bufferTeclado = new BufferedReader(isr);
            System.out.println("Introduce un entero:");
            String cadena = bufferTeclado.readLine();
            Integer.parseInt(cadena);
            System.out.println("Gracias por introducir " + cadena + ".");
        } catch (IOException e) {
            System.out.println("Ocurrió una IOException.");
        }
    }
}
