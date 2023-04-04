package paquete1.ejercicio7;

import java.io.*;
import java.util.List;

public class MetodosAlumno {
    
    public static void grabar_alumnos(String fileName, List<Alumno> alumnos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Alumno alumno : alumnos) {
                oos.writeObject(alumno);
            }
            System.out.println("Alumnos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los alumnos: " + e.getMessage());
        }
    }

    public static void listar_alumnos(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Alumno alumno;
            while (true) {
                alumno = (Alumno) ois.readObject();
                System.out.println(alumno);
            }
        } catch (EOFException eof) {
            System.out.println("Fin de la lista de alumnos.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al listar los alumnos: " + e.getMessage());
        }
    }

    public static void borrar_fichero(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Fichero borrado correctamente.");
        } else {
            System.out.println("Error al borrar el fichero.");
        }
    }

    public static void renombrar_fichero(String oldName, String newName) {
        File oldFile = new File(oldName);
        File newFile = new File(newName);

        if (oldFile.renameTo(newFile)) {
            System.out.println("Fichero renombrado correctamente.");
        } else {
            System.out.println("Error al renombrar el fichero.");
        }
    }
}
