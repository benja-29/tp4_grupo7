package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        HashMap<String, Empleado> empleados = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("Menu de opciones: ");
            System.out.println("1 – Alta de empleado.");
            System.out.println("2 – Mostrar empleados.");
            System.out.println("3 – Eliminar empleado.");
            System.out.println("4 – Consultar los datos de un empleado.");
            System.out.println("5 – Salir.");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese DNI: ");
                    int dni = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese Sueldo: ");
                    double sueldo = scanner.nextDouble();
                    System.out.print("Ingrese Categoría (un solo carácter, ej. A): ");
                    char categoria = scanner.next().toUpperCase().charAt(0);

                    String clave = String.valueOf(dni) + categoria;

                    Empleado emp = new Empleado(dni, nombre, apellido, sueldo, categoria);
                    empleados.put(clave, emp);

                    System.out.println("¡Empleado registrado con éxito! Clave asignada: " + clave);
                    break;

                case 2:
                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados registrados en el sistema.");
                    } else {
                        System.out.println("\n--- LISTADO DE EMPLEADOS ---");
                        Iterator<Map.Entry<String, Empleado>> iterator = empleados.entrySet().iterator();
                        
                        while (iterator.hasNext()) {
                            Map.Entry<String, Empleado> entry = iterator.next();
                            System.out.println("Clave: [" + entry.getKey() + "] -> Datos: " + entry.getValue().toString());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la clave del empleado a eliminar (ej. 20310458A): ");
                    String claveEliminar = scanner.nextLine().trim();

                    if (empleados.containsKey(claveEliminar)) {
                        empleados.remove(claveEliminar);
                        System.out.println("¡Empleado eliminado con éxito!");
                    } else {
                        System.out.println("La clave ingresada no existe en el registro.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la clave del empleado a consultar (ej. 20310458A): ");
                    String claveBuscar = scanner.nextLine().trim();

                    if (empleados.containsKey(claveBuscar)) {
                        Empleado e = empleados.get(claveBuscar);
                        System.out.println("Empleado encontrado:");
                        System.out.println(e.toString());
                    } else {
                        System.out.println("La clave ingresada no existe en el registro.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}