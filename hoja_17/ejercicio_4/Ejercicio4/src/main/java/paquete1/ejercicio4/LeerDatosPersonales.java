package paquete1.ejercicio4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeerDatosPersonales {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("datos personales.txt");
            Scanner scanner = new Scanner(fileReader);
            String datos = scanner.nextLine();
            scanner.close();
            fileReader.close();
            String[] datosSeparados = datos.split(" ");
            String nombre = datosSeparados[0];
            int edad = Integer.parseInt(datosSeparados[1]);
            double altura = Double.parseDouble(datosSeparados[2]);
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Altura: " + altura);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer los datos.");
            e.printStackTrace();
        }
    }
}
