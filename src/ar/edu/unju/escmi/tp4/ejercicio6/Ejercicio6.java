package ar.edu.unju.escmi.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		ArrayList<Libro> libros = new ArrayList<>();

		int opcion = 0;

		do {

			System.out.println();
			System.out.println("--- MENU DE LIBROS ---");
			System.out.println("1 - Alta de libro");
			System.out.println("2 - Mostrar libros");
			System.out.println("3 - Buscar y mostrar un libro");
			System.out.println("4 - Ordenar libros");
			System.out.println("5 - Modificar datos de un libro");
			System.out.println("6 - Eliminar un libro");
			System.out.println("7 - Salir");

			opcion = ingresarOpcion(scanner);

			switch (opcion) {

			case 1:

				System.out.println();
				System.out.println("--- ALTA DE LIBRO ---");

				String isbn = ingresarIsbn(scanner);

				if (buscarLibro(libros, isbn) != null) {

					System.out.println(
							"Ya existe un libro con ese ISBN.");

					break;
				}

				String titulo = ingresarTexto(
						scanner,
						"Ingrese el titulo: ");

				int cantidadPaginas =
						ingresarCantidadPaginas(scanner);

				String autor = ingresarTexto(
						scanner,
						"Ingrese el autor: ");

				Libro libro = new Libro();

				libro.setIsbn(isbn);
				libro.setTitulo(titulo);
				libro.setCantidadPaginas(cantidadPaginas);
				libro.setAutor(autor);

				libros.add(libro);

				System.out.println(
						"Libro agregado correctamente.");

				break;

			case 2:

				System.out.println();
				System.out.println("--- LISTA DE LIBROS ---");

				if (libros.isEmpty()) {

					System.out.println(
							"No hay libros cargados.");

				} else {

					for (Libro libroActual : libros) {

						System.out.println();

						libroActual.mostrarDatos();

						System.out.println(
								"-------------------------");
					}
				}

				break;

			case 3:

				System.out.println();
				System.out.println("--- BUSCAR LIBRO ---");

				if (libros.isEmpty()) {

					System.out.println(
							"No hay libros cargados.");

					break;
				}

				String isbnBuscado =
						ingresarIsbn(scanner);

				Libro libroEncontrado =
						buscarLibro(libros, isbnBuscado);

				if (libroEncontrado != null) {

					System.out.println();
					libroEncontrado.mostrarDatos();

				} else {

					System.out.println(
							"Libro no encontrado.");
				}

				break;

			case 4:

				System.out.println();
				System.out.println("--- ORDENAR LIBROS ---");

				if (libros.isEmpty()) {

					System.out.println(
							"No hay libros para ordenar.");

				} else {

					Collections.sort(libros);

					System.out.println(
							"Libros ordenados por titulo.");

					System.out.println();

					for (Libro libroActual : libros) {

						libroActual.mostrarDatos();

						System.out.println(
								"-------------------------");
					}
				}

				break;

			case 5:

				System.out.println();
				System.out.println("--- MODIFICAR LIBRO ---");

				if (libros.isEmpty()) {

					System.out.println(
							"No hay libros cargados.");

					break;
				}

				String isbnModificar =
						ingresarIsbn(scanner);

				Libro libroModificar =
						buscarLibro(libros, isbnModificar);

				if (libroModificar != null) {

					System.out.println();
					System.out.println(
							"Datos actuales:");

					libroModificar.mostrarDatos();

					System.out.println();
					System.out.println(
							"Ingrese los nuevos datos:");

					String nuevoTitulo =
							ingresarTexto(
									scanner,
									"Nuevo titulo: ");

					int nuevasPaginas =
							ingresarCantidadPaginas(scanner);

					String nuevoAutor =
							ingresarTexto(
									scanner,
									"Nuevo autor: ");

					libroModificar.setTitulo(nuevoTitulo);

					libroModificar.setCantidadPaginas(
							nuevasPaginas);

					libroModificar.setAutor(nuevoAutor);

					System.out.println(
							"Libro modificado correctamente.");

				} else {

					System.out.println(
							"Libro no encontrado.");
				}

				break;

			case 6:

				System.out.println();
				System.out.println("--- ELIMINAR LIBRO ---");

				if (libros.isEmpty()) {

					System.out.println(
							"No hay libros cargados.");

					break;
				}

				String isbnEliminar =
						ingresarIsbn(scanner);

				Libro libroEliminar =
						buscarLibro(libros, isbnEliminar);

				if (libroEliminar != null) {

					libros.remove(libroEliminar);

					System.out.println(
							"Libro eliminado correctamente.");

				} else {

					System.out.println(
							"Libro no encontrado.");
				}

				break;

			case 7:

				System.out.println();
				System.out.println(
						"Programa finalizado.");

				break;
			}

		} while (opcion != 7);

		scanner.close();
	}


	private static int ingresarOpcion(
			Scanner scanner) {

		while (true) {

			System.out.print(
					"Seleccione una opcion: ");

			String entrada =
					scanner.nextLine().trim();

			try {

				int opcion =
						Integer.parseInt(entrada);

				if (opcion >= 1 && opcion <= 7) {

					return opcion;
				}

				System.out.println(
						"La opcion debe estar entre 1 y 7.");

			} catch (NumberFormatException e) {

				System.out.println(
						"Debe ingresar un numero entero.");
			}
		}
	}


	private static String ingresarIsbn(
			Scanner scanner) {

		while (true) {

			System.out.print(
					"Ingrese el ISBN: ");

			String isbn =
					scanner.nextLine().trim();

			if (!isbn.isEmpty()) {

				return isbn;
			}

			System.out.println(
					"El ISBN no puede estar vacio.");
		}
	}


	private static String ingresarTexto(
			Scanner scanner,
			String mensaje) {

		while (true) {

			System.out.print(mensaje);

			String texto =
					scanner.nextLine().trim();

			if (!texto.isEmpty()) {

				return texto;
			}

			System.out.println(
					"El dato no puede estar vacio.");
		}
	}


	private static int ingresarCantidadPaginas(
			Scanner scanner) {

		while (true) {

			System.out.print(
					"Ingrese la cantidad de paginas: ");

			String entrada =
					scanner.nextLine().trim();

			try {

				int paginas =
						Integer.parseInt(entrada);

				if (paginas > 0) {

					return paginas;
				}

				System.out.println(
						"La cantidad de paginas debe ser mayor que cero.");

			} catch (NumberFormatException e) {

				System.out.println(
						"Debe ingresar un numero entero.");
			}
		}
	}


	private static Libro buscarLibro(
			ArrayList<Libro> libros,
			String isbn) {

		for (Libro libro : libros) {

			if (libro.getIsbn()
					.equalsIgnoreCase(isbn)) {

				return libro;
			}
		}

		return null;
	}
}