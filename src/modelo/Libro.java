package modelo;

public class Libro extends Documento {

    private String editorial;

    public Libro() {
        super();
    }

    public Libro(int id, String titulo, String autor, int anioPublicacion, String editorial) {

        super(id, titulo, autor, anioPublicacion);
        this.editorial = editorial;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}