package paquete1.ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Alumno> alumnos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Introduce el nombre del alumno " + (i + 1) + ":");
            String nombre = sc.nextLine();
            System.out.println("Introduce la calificación del alumno " + (i + 1) + ":");
            double calificacion = sc.nextDouble();
            sc.nextLine(); // Limpia el buffer del Scanner
            alumnos.add(new Alumno(nombre, calificacion));
        }

        System.out.println("Introduce el nombre del archivo donde se guardarán los alumnos:");
        String fileName = sc.nextLine();
        MetodosAlumno.grabar_alumnos(fileName, alumnos);

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1- Listar los alumnos grabados.");
            System.out.println("2- Borrar el fichero guardado.");
            System.out.println("3- Cambiar el nombre del fichero.");
            System.out.println("4- Salir.");
            System.out.println("Introduce el número de la opción deseada:");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el buffer del Scanner

            switch (opcion) {
                case 1:
                    MetodosAlumno.listar_alumnos(fileName);
                    break;
                case 2:
                    MetodosAlumno.borrar_fichero(fileName);
                    break;
                case 3:
                    System.out.println("Introduce el nuevo nombre del fichero:");
                    String newFileName = sc.nextLine();
                    MetodosAlumno.renombrar_fichero(fileName, newFileName);
                    fileName = newFileName;
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduce un número entre 1 y 4.");
            }
        } while (opcion != 4);

        sc.close();
    }
}
