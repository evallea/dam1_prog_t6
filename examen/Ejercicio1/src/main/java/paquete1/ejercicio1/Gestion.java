package paquete1.ejercicio1;

import java.io.*;
import java.util.*;

/**
 *
 * @author damt124
 */
public class Gestion {

    // Colección donde se almacenarán objetos de la clase Personal:
    LinkedList<Personal> gestion;

    // Constructor por defecto que inicializa la colección:
    public Gestion() {
        gestion = new LinkedList();
    }

    // Método que añade un empleado al LinkedList:
    public void anadirEmpleado() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);

        // Declaración de variables:
        int salario;
        String dni;
        boolean existe;

        // Creación del objeto persona1 de la clase Personal:
        Personal persona1 = new Personal();

        try {
            do {
                existe = false;
                System.out.println("Introduce el DNI de la persona:");
                dni = teclado.readLine(); // Se introduce el DNI por teclado, y si es igual que uno existente, salta un mensaje indicándolo.
                for (Personal a : gestion) {
                    if (dni.equals(a.getDni())) {
                        existe = true;
                        System.out.println("Ya existe un empleado registrado con ese DNI.");
                    }
                }
            } while (persona1.validarDNI(dni) == false || existe == true);

            do {
                System.out.println("Introduce el salario de la persona:");
                salario = Integer.parseInt(teclado.readLine()); // Se introduce el salario por teclado.
            } while (!persona1.validarSalario(salario));

        } catch (IOException e) {
            System.err.println("IOException.");
        }
    }

    // Método eliminar mediante DNI:
    public void eliminarEmpleado() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(isr);
        String dni;
        boolean borrado = false;
        try {
            System.out.println("Introduce el DNI de la persona a eliminar:");
            dni = teclado.readLine();
            Iterator<Personal> it = gestion.iterator();
            while (it.hasNext() && borrado == false) {
                Personal p = it.next();
                if (p.getDni().equals(dni)) {
                    it.remove();
                    borrado = true;
                    System.out.println("La persona ha sido eliminada.");
                }
            }
            if (borrado == false) {
                System.out.println("No se pudo eliminar, la persona no se encuentra registrada.");
            }
        } catch (IOException ex) {
            System.err.println("IOException.");
        }
    }

    // Método para generar el fichero .dat con los datos de los empleados:
    public void generarFichero() {
        ObjectOutputStream oos = null;
        try {

            FileOutputStream fos = new FileOutputStream("datos_empleados.dat"); // Se genera el fichero.
            oos = new ObjectOutputStream(fos);
            oos.writeObject(gestion);
        } catch (IOException ex) {
            System.err.println("IOException.");
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                System.err.println("IOException.");
            }
        }
    }

    public void leerFichero() {
        ObjectInputStream ois = null;
        File gestion = new File("datos_empleados.dat");
        try {
            if (gestion.exists()) {
                FileInputStream fis = new FileInputStream("datos_empleados.dat");
                ois = new ObjectInputStream(fis);
                this.gestion = (LinkedList) ois.readObject();
            } else {
                System.out.println("Creando archivo...");
                gestion.createNewFile();
            }
        } catch (IOException ex) {
            System.err.println("IOException.");
        } catch (ClassNotFoundException ex) {
            System.err.println("Clase no encontrada.");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
                System.out.println("IOException.");
            }
        }
    }
}
