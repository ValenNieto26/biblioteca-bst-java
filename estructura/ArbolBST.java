package estructura;

import modelo.Libro;
import modelo.NodoBST;

public class ArbolBST {

    private NodoBST raiz;

    public ArbolBST() {
        this.raiz = null;
    }

    
    private String claveAutor(Libro libro) {
        return claveAutor(libro.getAutor());
    }

    private String claveAutor(String autor) {
        // Asume formato "Apellido, Nombre"
        String[] partes = autor.split(",");
        return partes[0].trim().toLowerCase();
    }

    
    public void insertar(Libro libro) throws Exception {
        raiz = insertarRec(raiz, libro);
    }

    private NodoBST insertarRec(NodoBST actual, Libro libro) throws Exception {
        if (actual == null) {
            return new NodoBST(libro);
        }
        String claveNueva = claveAutor(libro);
        String claveActual = claveAutor(actual.libro);

        int cmp = claveNueva.compareTo(claveActual);
        if (cmp < 0) {
            actual.izquierdo = insertarRec(actual.izquierdo, libro);
        } else if (cmp > 0) {
            actual.derecho = insertarRec(actual.derecho, libro);
        } else {
            // Autor duplicado
            throw new Exception("Ya existe un libro con ese autor en el árbol.");
        }
        return actual;
    }

    //  Buscar por autor 
    public Libro buscarPorAutor(String autor) {
        NodoBST nodo = buscarAutorRec(raiz, claveAutor(autor));
        return nodo != null ? nodo.libro : null;
    }

    private NodoBST buscarAutorRec(NodoBST actual, String claveBuscada) {
        if (actual == null) return null;
        String claveActual = claveAutor(actual.libro);
        int cmp = claveBuscada.compareTo(claveActual);
        if (cmp == 0) return actual;
        if (cmp < 0) return buscarAutorRec(actual.izquierdo, claveBuscada);
        return buscarAutorRec(actual.derecho, claveBuscada);
    }

    // Eliminar por autor 
    public void eliminar(String autor) throws Exception {
        raiz = eliminarRec(raiz, claveAutor(autor));
    }

    private NodoBST eliminarRec(NodoBST actual, String claveBuscada) throws Exception {
        if (actual == null) {
            throw new Exception("No se encontró un libro con ese autor.");
        }
        String claveActual = claveAutor(actual.libro);
        int cmp = claveBuscada.compareTo(claveActual);

        if (cmp < 0) {
            actual.izquierdo = eliminarRec(actual.izquierdo, claveBuscada);
        } else if (cmp > 0) {
            actual.derecho = eliminarRec(actual.derecho, claveBuscada);
        } else {
            // Caso 1: sin hijos
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }
            // Caso 2: un hijo
            if (actual.izquierdo == null) return actual.derecho;
            if (actual.derecho == null) return actual.izquierdo;

            // Caso 3: dos hijos -> reemplazar por mínimo del subárbol derecho
            NodoBST sucesor = encontrarMinNodo(actual.derecho);
            actual.libro = sucesor.libro;
            actual.derecho = eliminarRec(actual.derecho, claveAutor(sucesor.libro));
        }
        return actual;
    }

    //  Recorridos
    public void recorridoInOrden() {
        inOrden(raiz);
    }

    private void inOrden(NodoBST nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println(nodo.libro);
            inOrden(nodo.derecho);
        }
    }

    public void recorridoPreOrden() {
        preOrden(raiz);
    }

    private void preOrden(NodoBST nodo) {
        if (nodo != null) {
            System.out.println(nodo.libro);
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    public void recorridoPostOrden() {
        postOrden(raiz);
    }

    private void postOrden(NodoBST nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.println(nodo.libro);
        }
    }

    
    public Libro encontrarMinimo() {
        NodoBST min = encontrarMinNodo(raiz);
        return min != null ? min.libro : null;
    }

    private NodoBST encontrarMinNodo(NodoBST nodo) {
        if (nodo == null) return null;
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    public Libro encontrarMaximo() {
        NodoBST max = encontrarMaxNodo(raiz);
        return max != null ? max.libro : null;
    }

    private NodoBST encontrarMaxNodo(NodoBST nodo) {
        if (nodo == null) return null;
        while (nodo.derecho != null) {
            nodo = nodo.derecho;
        }
        return nodo;
    }

    // Contar nodos
    public int contarNodos() {
        return contarRec(raiz);
    }

    private int contarRec(NodoBST nodo) {
        if (nodo == null) return 0;
        return 1 + contarRec(nodo.izquierdo) + contarRec(nodo.derecho);
    }

    // Altura 
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoBST nodo) {
        if (nodo == null) return 0;
        int hi = alturaRec(nodo.izquierdo);
        int hd = alturaRec(nodo.derecho);
        return 1 + Math.max(hi, hd);
    }

    // Búsqueda por ISBN (recorrido completo)
    public Libro buscarPorIsbn(String isbn) {
        return buscarIsbnRec(raiz, isbn);
    }

    private Libro buscarIsbnRec(NodoBST nodo, String isbn) {
        if (nodo == null) return null;
        if (nodo.libro.getIsbn().equals(isbn)) return nodo.libro;
        Libro izq = buscarIsbnRec(nodo.izquierdo, isbn);
        if (izq != null) return izq;
        return buscarIsbnRec(nodo.derecho, isbn);
    }

    //  Listar por categoría 
    public void listarPorCategoria(String categoria) {
        listarCategoriaRec(raiz, categoria.toLowerCase());
    }

    private void listarCategoriaRec(NodoBST nodo, String categoria) {
        if (nodo != null) {
            listarCategoriaRec(nodo.izquierdo, categoria);
            if (nodo.libro.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(nodo.libro);
            }
            listarCategoriaRec(nodo.derecho, categoria);
        }
    }

    // Listar disponibles / prestados 
    public void listarDisponibles(boolean disponibles) {
        listarDisponiblesRec(raiz, disponibles);
    }

    private void listarDisponiblesRec(NodoBST nodo, boolean disponibles) {
        if (nodo != null) {
            listarDisponiblesRec(nodo.izquierdo, disponibles);
            if (nodo.libro.isDisponible() == disponibles) {
                System.out.println(nodo.libro);
            }
            listarDisponiblesRec(nodo.derecho, disponibles);
        }
    }

    //  Contar disponibles / prestados 
    public int contarDisponibles(boolean disponibles) {
        return contarDisponiblesRec(raiz, disponibles);
    }

    private int contarDisponiblesRec(NodoBST nodo, boolean disponibles) {
        if (nodo == null) return 0;
        int suma = (nodo.libro.isDisponible() == disponibles) ? 1 : 0;
        return suma + contarDisponiblesRec(nodo.izquierdo, disponibles)
                    + contarDisponiblesRec(nodo.derecho, disponibles);
    }
}

