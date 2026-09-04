package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("Menu de opciones: ");
            System.out.println("1 – Alta de jugador.");
            System.out.println("2 – Modificar los datos de un jugador.");
            System.out.println("3 – Eliminar un jugador.");
            System.out.println("4 – Mostrar todos los jugadores.");
            System.out.println("5 – Mostrar la cantidad de jugadores en la lista.");
            System.out.println("6 – Limpiar toda la lista de jugadores.");
            System.out.println("7 – Salir.");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Jugador jugador = new Jugador();
                    System.out.print("Ingrese DNI: ");
                    jugador.setDni(scanner.nextInt());
                    scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    jugador.setNombre(scanner.nextLine());
                    System.out.print("Ingrese Equipo: ");
                    jugador.setEquipo(scanner.nextLine());
                    System.out.print("Ingrese Nacionalidad: ");
                    jugador.setNacionalidad(scanner.nextLine());
                    System.out.print("Ingrese Estatura (ej. 1,85): ");
                    jugador.setEstatura(scanner.nextDouble());
                    
                    jugadores.add(jugador);
                    System.out.println("¡Jugador agregado con éxito!");
                    break;

                case 2:
                    System.out.print("Ingrese el DNI del jugador a modificar: ");
                    int dniBuscar = scanner.nextInt();
                    scanner.nextLine();
                    
                    boolean encontradoMod = false;
                    for (Jugador j : jugadores) {
                        if (j.getDni() == dniBuscar) {
                            encontradoMod = true;
                            System.out.println("Jugador encontrado:");
                            j.mostrarDatos();
                            
                            System.out.println("\n--- Ingrese los nuevos datos ---");
                            System.out.print("Nuevo Nombre: ");
                            j.setNombre(scanner.nextLine());
                            System.out.print("Nuevo Equipo: ");
                            j.setEquipo(scanner.nextLine());
                            System.out.print("Nueva Nacionalidad: ");
                            j.setNacionalidad(scanner.nextLine());
                            System.out.print("Nueva Estatura: ");
                            j.setEstatura(scanner.nextDouble());
                            System.out.println("¡Datos actualizados con éxito!");
                            break;
                        }
                    }
                    if (!encontradoMod) {
                        System.out.println("No se encuentra el dni.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el DNI del jugador a eliminar: ");
                    int dniEliminar = scanner.nextInt();
                    
                    boolean encontradoElim = false;
                    for (int i = 0; i < jugadores.size(); i++) {
                        if (jugadores.get(i).getDni() == dniEliminar) {
                            jugadores.remove(i);
                            encontradoElim = true;
                            System.out.println("¡Jugador eliminado correctamente!");
                            break;
                        }
                    }
                    if (!encontradoElim) {
                        System.out.println("No se encuentra el dni.");
                    }
                    break;

                case 4:
                    if (jugadores.isEmpty()) {
                        System.out.println("La lista de jugadores está vacía.");
                    } else {
                        System.out.println("\n--- LISTA DE JUGADORES ---");
                        for (Jugador j : jugadores) {
                            j.mostrarDatos();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Cantidad de jugadores en la lista: " + jugadores.size());
                    break;

                case 6:
                    jugadores.clear();
                    System.out.println("La lista de jugadores se ha limpiado por completo.");
                    break;

                case 7:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}