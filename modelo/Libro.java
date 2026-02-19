package modelo;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;          
    private String editorial;
    private int anioPublicacion;
    private String categoria;
    private boolean disponible;
    private String prestatario;   

    public Libro(String isbn, String titulo, String autor, String editorial,
                 int anioPublicacion, String categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.categoria = categoria;
        this.disponible = true;
        this.prestatario = "";
    }

    // Getters y setters

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getEditorial() { return editorial; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public String getCategoria() { return categoria; }
    public boolean isDisponible() { return disponible; }
    public String getPrestatario() { return prestatario; }

    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public void setPrestatario(String prestatario) { this.prestatario = prestatario; }

    @Override
    public String toString() {
        return "ISBN: " + isbn +
               ", Título: " + titulo +
               ", Autor: " + autor +
               ", Editorial: " + editorial +
               ", Año: " + anioPublicacion +
               ", Categoría: " + categoria +
               ", Disponible: " + (disponible ? "Sí" : "No") +
               (disponible ? "" : ", Prestatario: " + prestatario);
    }
}
