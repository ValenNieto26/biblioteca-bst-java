package vista;

import estructura.ArbolBST;
import java.util.Scanner;
import modelo.Libro;
import servicio.BibliotecaService;

public class MenuPrincipal{

    public static void main(String[] args) {
        BibliotecaService service = new BibliotecaService();
        ArbolBST arbol = service.getArbol();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("============================================");
            System.out.println("   SISTEMA DE GESTIÓN DE BIBLIOTECA (BST)");
            System.out.println("============================================");
            System.out.println("  1. Registrar nuevo libro");
            System.out.println("  2. Buscar libro por autor");
            System.out.println("  3. Buscar libro por ISBN");
            System.out.println("  4. Eliminar libro del catálogo");
            System.out.println("  5. Listar libros (InOrden - alfabético)");
            System.out.println("  6. Listar libros (PreOrden - estructura)");
            System.out.println("  7. Listar libros (PostOrden)");
            System.out.println("  8. Registrar préstamo de libro");
            System.out.println("  9. Registrar devolución de libro");
            System.out.println(" 10. Listar libros disponibles");
            System.out.println(" 11. Listar libros prestados");
            System.out.println(" 12. Buscar libros por categoría");
            System.out.println(" 13. Estadísticas del catálogo");
            System.out.println("  0. Salir");
            System.out.println("============================================");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Autor (Apellido, Nombre): ");
                        String autor = sc.nextLine();
                        System.out.print("Editorial: ");
                        String editorial = sc.nextLine();
                        System.out.print("Año de publicación: ");
                        int anio = Integer.parseInt(sc.nextLine());
                        System.out.print("Categoría: ");
                        String categoria = sc.nextLine();

                        Libro nuevo = new Libro(isbn, titulo, autor, editorial, anio, categoria);
                        arbol.insertar(nuevo);
                        System.out.println("Libro registrado correctamente.");
                        break;

                    case 2:
                        System.out.print("Ingrese el autor (Apellido, Nombre): ");
                        String autorBuscado = sc.nextLine();
                        Libro libroAutor = arbol.buscarPorAutor(autorBuscado);
                        if (libroAutor != null) {
                            System.out.println(libroAutor);
                        } else {
                            System.out.println("No se encontró un libro con ese autor.");
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el ISBN: ");
                        String isbnBuscado = sc.nextLine();
                        Libro libroIsbn = arbol.buscarPorIsbn(isbnBuscado);
                        if (libroIsbn != null) {
                            System.out.println(libroIsbn);
                        } else {
                            System.out.println("No se encontró un libro con ese ISBN.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el autor del libro a eliminar (Apellido, Nombre): ");
                        String autorEliminar = sc.nextLine();
                        service.getArbol().eliminar(autorEliminar);
                        System.out.println("Libro eliminado correctamente.");
                        break;

                    case 5:
                        System.out.println("Listado InOrden (alfabético por autor):");
                        arbol.recorridoInOrden();
                        break;

                    case 6:
                        System.out.println("Listado PreOrden (estructura):");
                        arbol.recorridoPreOrden();
                        break;

                    case 7:
                        System.out.println("Listado PostOrden:");
                        arbol.recorridoPostOrden();
                        break;

                    case 8:
                        System.out.print("ISBN del libro a prestar: ");
                        String isbnPrestamo = sc.nextLine();
                        System.out.print("Nombre del estudiante: ");
                        String estudiante = sc.nextLine();
                        service.registrarPrestamo(isbnPrestamo, estudiante);
                        System.out.println("Préstamo registrado correctamente.");
                        break;

                    case 9:
                        System.out.print("ISBN del libro a devolver: ");
                        String isbnDevolucion = sc.nextLine();
                        service.registrarDevolucion(isbnDevolucion);
                        System.out.println("Devolución registrada correctamente.");
                        break;

                    case 10:
                        System.out.println("Libros disponibles:");
                        arbol.listarDisponibles(true);
                        break;

                    case 11:
                        System.out.println("Libros prestados:");
                        arbol.listarDisponibles(false);
                        break;

                    case 12:
                        System.out.print("Categoría a buscar: ");
                        String catBuscada = sc.nextLine();
                        System.out.println("Libros en la categoría \"" + catBuscada + "\":");
                        arbol.listarPorCategoria(catBuscada);
                        break;

                    case 13:
                        service.mostrarEstadisticas();
                        break;

                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();

        } while (opcion != 0);

        sc.close();
    }
}
