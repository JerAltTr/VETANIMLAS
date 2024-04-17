package veterinariaapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VeterinariaApp {

    private static ArrayList<CPaciente> pacientes = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("=====================================");
            System.out.println("Bienvenido a la Veterinaria");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Ver lista de pacientes");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        agregarPaciente(scanner);
                        break;
                    case 2:
                        verListaPacientes();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción invalida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }
        
        guardarDatosEnArchivo();
        System.out.println("Gracias por usar la aplicación de la Veterinaria.");
        scanner.close();
    }

    private static void agregarPaciente(Scanner scanner) {
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del paciente: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese la raza del paciente: ");
        String raza = scanner.nextLine();
        System.out.print("Ingrese el peso del paciente: ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        CPaciente paciente = new CPaciente(nombre, edad, raza, peso);
        pacientes.add(paciente);
        System.out.println("Paciente agregado correctamente.");
    }

    private static void verListaPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            System.out.println("Lista de pacientes:");
            for (CPaciente paciente : pacientes) {
                System.out.println("Nombre: " + paciente.getNombre() + ", Edad: " + paciente.getEdad() +
                        ", Raza: " + paciente.getRaza() + ", Peso: " + paciente.getPeso() + "kg");
            }
        }
    }

    private static void guardarDatosEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("pacientes.txt"))) {
            for (CPaciente paciente : pacientes) {
                writer.println(paciente.getNombre() + "," + paciente.getEdad() + "," +
                        paciente.getRaza() + "," + paciente.getPeso());
            }
            System.out.println("Datos guardados en pacientes.txt");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos en el archivo.");
            e.printStackTrace();
        }
    }
    
}
