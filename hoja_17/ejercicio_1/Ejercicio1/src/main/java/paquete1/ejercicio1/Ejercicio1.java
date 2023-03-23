package paquete1.ejercicio1;

import java.io.*;

public class Ejercicio1 {

    public static void main(String[] args) throws IOException {

        int edad = 0;
        double altura = 0;
        String leerEdad;
        String leerAltura;
        String nombre;
        boolean error;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferTeclado = new BufferedReader(isr);

        System.out.println("\nIntroduce el nombre:");
        nombre = bufferTeclado.readLine();

        do {

            try {

                System.out.println("\nIntroduce la edad:");
                leerEdad = bufferTeclado.readLine();
                edad = Integer.parseInt(leerEdad);
                error = false;

            } catch (IOException e) {
                System.out.println("Ocurrió una IOException.");
                error = true;
            } catch (NumberFormatException e) {
                System.out.println("El número debe ser entero.");
                error = true;
            }

        } while (edad < 0 || edad > 10 || error == true);

        do {

            try {

                System.out.println("\nIntroduce la altura (en metros):");
                leerAltura = bufferTeclado.readLine();
                altura = Double.parseDouble(leerAltura);
                error = false;

            } catch (IOException e) {
                System.out.println("Ocurrió una IOException.");
                error = true;
            } catch (NumberFormatException e) {
                System.out.println("El número debe ser decimal.");
                error = true;
            }

        } while (error == true);

        System.out.println("\nLos datos dentro de 10 años son los siguientes:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + (edad + 10));
        System.out.println("Altura (en metros): " + (altura + 0.7));
    }
}
