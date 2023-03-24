package paquete1.tarea7;

import java.io.*;
import java.util.*;

/**
 *
 * @author Enrique Valle Alcega
 */
public class MetodosAlumno {

    private static ArrayList<Alumno> array_alumnos = new ArrayList<>();
    private static File fichero = null;

    // Este método graba el array en el fichero:
    public static void grabar_coleccion_en_fichero() {
        FileOutputStream salidaFichero = null;
        ObjectOutputStream salidaObjeto = null;
        try {
            salidaFichero = new FileOutputStream(fichero);
            salidaObjeto = new ObjectOutputStream(salidaFichero);
            salidaObjeto.writeObject(array_alumnos);
            System.out.println("Se grabaron los datos correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió una IOException.");
        } finally {
            try {
                if (salidaFichero != null) {
                    salidaFichero.close();
                    salidaObjeto.close();
                }
            } catch (IOException e) {
                System.out.println("Ocurrió una IOException.");
            }
        }
    }

    // Este método lee la colección:
    public static void leer_coleccion_del_fichero() {
        FileInputStream entradaFichero = null;
        ObjectInputStream entradaObjeto = null;
        try {
            entradaFichero = new FileInputStream(fichero);
            entradaObjeto = new ObjectInputStream(entradaFichero);
            ArrayList<Alumno> array = (ArrayList<Alumno>) entradaObjeto.readObject();
            array_alumnos.clear();
            array_alumnos.addAll(array);
        } catch (IOException e) {
            System.out.println("Ocurrió una IOException.");
        } catch (ClassNotFoundException e2) {
            System.out.println("Ocurrió una ClassNotFoundException.");
        }
    }

    // Este método añade alumnos:
    public static void anadir_alumno() {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Introduce el nombre del alumno:");
        String nombre = lectura.nextLine();
        System.out.println("Introduce la calificación del alumno:");
        double calificacion = lectura.nextDouble();
        Alumno alumno = new Alumno(nombre, calificacion);
        array_alumnos.add(alumno);
    }

    // Este método lista los alumnos mediante un bucle for each:
    public static void listar_alumnos() {
        for (Alumno i : array_alumnos) {
            System.out.println(i.toString());
        }
    }

    // Este método busca alumnos:
    public static void buscar_alumno() {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Introduce el nombre del alumno para buscarlo:");
        String nombre = lectura.nextLine();
        for (Alumno alumno : array_alumnos) {
            if (alumno.getNombre().equals(nombre)) {
                System.out.println("\nNombre: " + alumno.getNombre() + ", calificación: " + alumno.getCalificacion());
                return;
            }
        }
        System.out.println("¡No se encontró el alumno!");
    }

    public static void borrar_alumno() {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Introduce el nombre del alumno para borrarlo:");
        String nombre = lectura.nextLine();
        Iterator<Alumno> iterator = array_alumnos.iterator();
        while (iterator.hasNext()) {
            Alumno alumno = iterator.next();
            if (alumno.getNombre().equals(nombre)) {
                iterator.remove();
                System.out.println("¡Alumno borrado!");
                return;
            }
        }
        System.out.println("¡No se encontró el alumno!");
    }

    // Este método borra el fichero:
    public static void borrar_fichero() {
        if (fichero.delete()) {
            System.out.println("Fichero borrado.");
        } else {
            System.out.println("No se pudo borrar.");
        }
    }

    // Este método renombra el fichero:
    public static void renombrar_fichero(String nombre_actual, String nombre_nuevo) {
        File fichero_actual = new File(nombre_actual);
        File fichero_nuevo = new File(nombre_nuevo);

        if (fichero_actual.exists()) {
            if (fichero_actual.renameTo(fichero_nuevo)) {
                System.out.println("Fichero renombrado.");
            }
        } else {
            System.out.println("El fichero no existe.");
        }
    }

    // Este método crea el fichero:
    public static void setFichero(File fichero) {
        MetodosAlumno.fichero = fichero;
    }
}
