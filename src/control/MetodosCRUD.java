package control;

import modelo.Libro;
import java.util.ArrayList;
import java.util.List;

public class MetodosCRUD {


    private List<Libro> baseDeDatosSimulada;

    public MetodosCRUD() {
        this.baseDeDatosSimulada = new ArrayList<>();
    }


    public void registrarLibro(Libro nuevoLibro) {
        baseDeDatosSimulada.add(nuevoLibro);
        System.out.println(">>> ÉXITO: Simulando guardado en la Base de Datos...");
        System.out.println(">>> Se ha registrado el libro: " + nuevoLibro.getTitulo() + " del autor " + nuevoLibro.getAutor());
    }

    public List<Libro> obtenerTodosLosLibros() {

        System.out.println(">>> LECTURA: Extrayendo registros para mostrar en la tabla...");
        return baseDeDatosSimulada;
    }


    public void actualizarLibro(Libro libroModificado) {

        System.out.println(">>> ACTUALIZACIÓN: Simulando actualización en BD...");
        System.out.println(">>> Se actualizaron los datos del documento con ID: " + libroModificado.getId());
    }


    public void eliminarLibro(int idLibro) {

        System.out.println(">>> ELIMINACIÓN: Simulando borrado en BD del registro con ID: " + idLibro);
    }
}