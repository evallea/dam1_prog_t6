package paquete1.tarea7;

import java.io.*;
import java.util.*;

/**
 *
 * @author Enrique Valle Alcega
 */
public class Main {

    public static void main(String[] args) {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferTeclado = new BufferedReader(isr);
        Scanner lectura = new Scanner(System.in);

        String leerOpcion; // Variable utilizada para hacer el switch.
        int opcion=0; // Variable utilizada para hacer el switch.
        boolean seguir=true; // Variable utilizada para hacer un bucle con el menú.

        System.out.println("Introduce un nombre para el fichero:");

        try {
            String nombre = bufferTeclado.readLine();
            File fichero = new File(nombre);
            MetodosAlumno.setFichero(fichero);
        } catch (IOException ex) {
            System.err.println("Ocurrió una IOException.");
        }

        do {
            try {
                System.out.println("\n***** SELECCIONA UNA OPCIÓN *****");
                System.out.println("1. Graba un nuevo alumno.");
                System.out.println("2. Lista los alumnos grabados.");
                System.out.println("3. Muestra los alumnos en orden alfabético.");
                System.out.println("4. Media de aprobados y suspensos.");
                System.out.println("5. Busca un alumno.");
                System.out.println("6. Modifica nota de un alumno.");
                System.out.println("7. Borra un alumno.");
                System.out.println("8. Borra fichero.");
                System.out.println("9. Renombra fichero.");
                System.out.println("0. Salir.");

                leerOpcion = bufferTeclado.readLine();
                opcion = Integer.parseInt(leerOpcion);

                switch (opcion) {
                    case 1:
                        MetodosAlumno.anadir_alumno();
                        MetodosAlumno.grabar_coleccion_en_fichero();
                        break;
                    case 2:
                        MetodosAlumno.listar_alumnos();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        MetodosAlumno.buscar_alumno();
                        break;
                    case 6:
                        MetodosAlumno.grabar_coleccion_en_fichero();
                        break;
                    case 7:
                        MetodosAlumno.borrar_alumno();
                        MetodosAlumno.grabar_coleccion_en_fichero();
                        break;
                    case 8:
                        MetodosAlumno.borrar_fichero();
                        break;
                    case 9:
                        System.out.println("Introduce el nombre actual del fichero:");
                        String nombre_actual = lectura.nextLine();
                        System.out.println("Introduce un nuevo nombre para el fichero:");
                        String nombre_nuevo = lectura.nextLine();
                        MetodosAlumno.renombrar_fichero(nombre_actual, nombre_nuevo);
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                }
            } catch (IOException ex) {
                System.err.println("Ocurrió una IOException");
            }
        } while (opcion!=0);
    }
}
