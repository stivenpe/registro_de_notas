package jeisson_proyecto_java;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistroNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> notas = new HashMap<>();

        // 1. Pedir la cantidad de estudiantes
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // 2. Solicitar nombres y notas
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nota de " + nombre + ": ");
            double nota = scanner.nextDouble();
            scanner.nextLine(); // Consumir el salto de línea
            notas.put(nombre, nota);
        }

        // 3. Mostrar la lista completa
        System.out.println("\nLista de estudiantes y sus notas:");
        for (Map.Entry<String, Double> entry : notas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 4. Buscar la nota de un estudiante
        System.out.print("\nIngrese el nombre del estudiante para buscar su nota: ");
        String buscar = scanner.nextLine();
        if (notas.containsKey(buscar)) {
            System.out.println("La nota de " + buscar + " es " + notas.get(buscar));
        } else {
            System.out.println("Estudiante no encontrado.");
        }

        // 5. Encontrar la nota más alta y el estudiante con mejor rendimiento
        String mejorEstudiante = null;
        double mejorNota = Double.MIN_VALUE;

        for (Map.Entry<String, Double> entry : notas.entrySet()) {
            if (entry.getValue() > mejorNota) {
                mejorNota = entry.getValue();
                mejorEstudiante = entry.getKey();
            }
        }

        System.out.println("\nEl estudiante con mejor rendimiento es " + mejorEstudiante + " con una nota de " + mejorNota);
        
        scanner.close();
    }
}
