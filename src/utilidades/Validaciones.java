package utilidades;

public class Validaciones {


    public static boolean camposEstanLlenos(String titulo, String autor, String anioStr) {

        if (titulo.trim().isEmpty() || autor.trim().isEmpty() || anioStr.trim().isEmpty()) {
            System.out.println("Validación fallida: Hay campos obligatorios vacíos.");
            return false;
        }
        return true;
    }


    public static int validarAnioPublicacion(String anioStr) {
        try {

            int anio = Integer.parseInt(anioStr.trim());


            if (anio <= 0) {
                System.out.println("Validación fallida: El año debe ser mayor a cero.");
                return -1;
            }
            return anio;

        } catch (NumberFormatException e) {

            System.out.println("Error de validación: Ingresaste letras en un campo numérico. Detalles: " + e.getMessage());
            return -1;
        }
    }
}