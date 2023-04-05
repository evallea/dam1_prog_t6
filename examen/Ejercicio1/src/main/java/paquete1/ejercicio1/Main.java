package paquete1.ejercicio1;

import java.io.*;

/**
 *
 * @author damt124
 */
public class Main {

    public static void main(String[] args) {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);

        Gestion gestion = new Gestion(); // Creación del objeto "gestion".
        int opcion = 0; // Variable para usar en la selección del switch.

        do {
            try {
                System.out.println("\n********** Menú: **********");
                System.out.println("\t1. Añadir empleado.");
                System.out.println("\t2. Eliminar empleado.");
                System.out.println("\t3. Generar fichero .dat con los datos de los empleados.");
                System.out.println("\t4. Leer fichero .dat (en caso de haber sido generado).");
                System.out.println("\t5. Salir.");

                opcion = Integer.parseInt(teclado.readLine());

                switch (opcion) {
                    case 1:
                        gestion.anadirEmpleado(); // Llama al método para añadir un empleado.
                        break;
                    case 2:
                        gestion.eliminarEmpleado(); // Llama al método para eliminar un empleado.
                        break;
                    case 3:
                        gestion.generarFichero(); // Llama al método para generar un fichero.
                        break;
                    case 4:
                        gestion.leerFichero(); // Llama al método para leer el fichero.
                        break;
                    case 5:
                        gestion.generarFichero(); // Genera fichero y sale del programa.
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Has escogido una opción incorrecta.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Tipo de dato no válido.");
            } catch (IOException e) {
                System.err.println("IOException.");
            }
        } while (opcion != 5);
    }
}
