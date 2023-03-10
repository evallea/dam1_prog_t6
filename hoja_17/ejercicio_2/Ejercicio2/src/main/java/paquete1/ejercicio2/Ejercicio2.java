package paquete1.ejercicio2;

import java.io.*;

public class Ejercicio2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferTeclado = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream fos = null;

        try {
            System.out.println("Nombre:");
            String nombre = bufferTeclado.readLine();
            System.out.println("Edad:");
            int edad = Integer.parseInt(bufferTeclado.readLine());
            System.out.println("Altura:");
            double altura = Double.parseDouble(bufferTeclado.readLine());
            String texto = "NOMBRE: " + nombre + ", EDAD: " + edad + ", ALTURA: " + altura;

            fos = new FileOutputStream("datos personales.txt");
            for (int i = 0; i < texto.length(); i++) {
                fos.write(texto.charAt(i));
            }
            System.out.println("Texto escrito correctamente.");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Ruta no válida.");
        } catch (IOException e) {
            System.out.println("Ocurrió una IOException.");
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Ocurrió una IOException.");
            }
        }
    }
}
