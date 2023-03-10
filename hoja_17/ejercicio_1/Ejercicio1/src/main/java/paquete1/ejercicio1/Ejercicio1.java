package paquete1.ejercicio1;

import java.io.*;

public class Ejercicio1 {

    public static void main(String[] args) {

        boolean seguir = true;

        do {

            try {

                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader bufferTeclado = new BufferedReader(isr);

                System.out.println("\nIntroduce el nombre:");
                String nombre = bufferTeclado.readLine();

                System.out.println("Introduce la edad:");
                String edad = bufferTeclado.readLine();
                // Integer.parseInt(edad);

                System.out.println("Introduce la altura:");
                String altura = bufferTeclado.readLine();
                // Double.parseDouble(altura);

                System.out.println("\nLos datos dentro de 10 años son los siguientes:");
                System.out.println("Nombre: " + nombre);
                System.out.println("Edad: " + (Integer.parseInt(edad) + 10));
                System.out.println("Altura: " + (Double.parseDouble(altura) + 70));

            } catch (IOException e) {
                System.out.println("Ocurrió una IOException.");
            }

        } while (seguir);
    }
}
