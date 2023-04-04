package paquete1.ejercicio4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuardarDatosPersonales {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce tu nombre, edad y altura separados por un espacio: ");
        String datos = scanner.nextLine();
        
        try {
            FileWriter fileWriter = new FileWriter("datos personales.txt");
            fileWriter.write(datos);
            fileWriter.close();
            System.out.println("Los datos se han guardado correctamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar los datos.");
            e.printStackTrace();
        }
    }
}
