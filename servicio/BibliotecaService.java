package servicio;

import estructura.ArbolBST;
import modelo.Libro;

public class BibliotecaService {

    private ArbolBST arbol;

    public BibliotecaService() {
        this.arbol = new ArbolBST();
        precargarLibros();
    }

    public ArbolBST getArbol() {
        return arbol;
    }

    private void precargarLibros() {
        try {
            arbol.insertar(new Libro("978-0-06", "Cien Años de Soledad", "García M., Gabriel",
                    "Sudamericana", 1967, "Literatura"));
            arbol.insertar(new Libro("978-0-07", "Ficciones", "Borges, Jorge L.",
                    "Sur", 1944, "Ficción"));
            arbol.insertar(new Libro("978-0-08", "Rayuela", "Cortázar, Julio",
                    "Sudamericana", 1963, "Literatura"));
            arbol.insertar(new Libro("978-0-09", "La Casa de los Espíritus", "Allende, Isabel",
                    "Plaza & Janés", 1982, "Ficción"));
            arbol.insertar(new Libro("978-0-10", "Veinte Poemas de Amor", "Neruda, Pablo",
                    "Nascimento", 1924, "Poesía"));
            arbol.insertar(new Libro("978-0-11", "Desolación", "Mistral, Gabriela",
                    "Instituto Hisp.", 1922, "Poesía"));
            arbol.insertar(new Libro("978-0-12", "La Ciudad y los Perros", "Vargas Ll., Mario",
                    "Seix Barral", 1963, "Literatura"));
            arbol.insertar(new Libro("978-0-13", "Pedro Páramo", "Rulfo, Juan",
                    "FCE", 1955, "Literatura"));
        } catch (Exception e) {
            System.out.println("Error precargando libros: " + e.getMessage());
        }
    }

    //  Préstamo 
    public void registrarPrestamo(String isbn, String nombreEstudiante) throws Exception {
        Libro libro = arbol.buscarPorIsbn(isbn);
        if (libro == null) {
            throw new Exception("No existe un libro con ese ISBN.");
        }
        if (!libro.isDisponible()) {
            throw new Exception("El libro ya está prestado.");
        }
        libro.setDisponible(false);
        libro.setPrestatario(nombreEstudiante);
    }

    //  Devolución 
    public void registrarDevolucion(String isbn) throws Exception {
        Libro libro = arbol.buscarPorIsbn(isbn);
        if (libro == null) {
            throw new Exception("No existe un libro con ese ISBN.");
        }
        if (libro.isDisponible()) {
            throw new Exception("El libro no está registrado como prestado.");
        }
        libro.setDisponible(true);
        libro.setPrestatario("");
    }

    //  Estadísticas 
    public void mostrarEstadisticas() {
        int total = arbol.contarNodos();
        int altura = arbol.altura();
        Libro min = arbol.encontrarMinimo();
        Libro max = arbol.encontrarMaximo();
        int disponibles = arbol.contarDisponibles(true);
        int prestados = arbol.contarDisponibles(false);

        System.out.println("=== Estadísticas del Catálogo ===");
        System.out.println("Total de libros: " + total);
        System.out.println("Altura del árbol: " + altura);
        System.out.println("Autor primero alfabéticamente: " + (min != null ? min.getAutor() : "N/A"));
        System.out.println("Autor último alfabéticamente: " + (max != null ? max.getAutor() : "N/A"));
        System.out.println("Libros disponibles: " + disponibles);
        System.out.println("Libros prestados: " + prestados);
    }
}

