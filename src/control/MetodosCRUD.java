package control;

import modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetodosCRUD {

    private Conexion conexionBD;

    public MetodosCRUD() {
        this.conexionBD = new Conexion();
    }

    public void registrarLibro(Libro nuevoLibro) {
        String sql = "INSERT INTO ejemplares (titulo, autor, anio_publicacion) VALUES (?, ?, ?)";

        // Abrimos la conexión
        Connection conn = conexionBD.conectar();

        if (conn != null) {
            try {

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, nuevoLibro.getTitulo());
                pstmt.setString(2, nuevoLibro.getAutor());
                pstmt.setInt(3, nuevoLibro.getAnioPublicacion());

                pstmt.executeUpdate();
                System.out.println(">>> ÉXITO: Libro guardado permanentemente en XAMPP.");

            } catch (SQLException e) {
                System.err.println("ERROR AL GUARDAR: " + e.getMessage());
            } finally {
                conexionBD.desconectar(conn);
            }
        }
    }
}