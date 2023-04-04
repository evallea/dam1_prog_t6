package paquete1.leercaracter;

import java.io.*;

/**
 *
 * @author Enrique Valle Alcega
 */
public class LeerCaracter {

    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        File inputFile = new File("archivo_entrada.txt");

        // Comprueba si el archivo de entrada existe.
        if (inputFile.exists()) {
            File outputDir = new File("directorio_salida");
            if (!outputDir.exists()) {
                outputDir.mkdir();
            }
            File outputFile = new File(outputDir, "archivo_salida.txt");
            int c;

            try {
                // Flujo de lectura.
                fis = new FileInputStream(inputFile);

                // Flujo de escritura.
                fos = new FileOutputStream(outputFile);

                // Lee el archivo carácter por carácter hasta llegar al final.
                while ((c = fis.read()) != -1) {
                    fos.write((char) c);
                }
            } catch (FileNotFoundException ex) {
                System.err.println("Archivo no encontrado.");
            } catch (IOException ex) {
                System.err.println("Error de entrada/salida.");
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ex) {
                        System.err.println("Error al cerrar.");
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException ex) {
                        System.err.println("Error al cerrar.");
                    }
                }
            }
        } else {
            System.out.println("El archivo de entrada no existe.");
        }
    }
}
