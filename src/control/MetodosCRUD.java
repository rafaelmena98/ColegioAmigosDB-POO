package control;

import modelo.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetodosCRUD {

    private Conexion conexionBD;

    public MetodosCRUD() {
        this.conexionBD = new Conexion();
    }


    public void registrarLibro(Libro nuevoLibro) {

        String sql = "INSERT INTO ejemplares (codigo, titulo, autor, anio_publicacion, tipo_documento) VALUES (?, ?, ?, ?, ?)";

        Connection conn = conexionBD.conectar();

        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);


                pstmt.setString(1, nuevoLibro.getCodigo());
                pstmt.setString(2, nuevoLibro.getTitulo());
                pstmt.setString(3, nuevoLibro.getAutor());
                pstmt.setInt(4, nuevoLibro.getAnioPublicacion());
                pstmt.setString(5, "Libro"); // Lo forzamos a 'Libro' por ahora según el ENUM

                pstmt.executeUpdate();
                System.out.println(">>> ÉXITO: Libro guardado en biblioteca_don_bosco.");

            } catch (SQLException e) {
                System.err.println("ERROR AL GUARDAR: " + e.getMessage());
            } finally {
                conexionBD.desconectar(conn);
            }
        }
    }


    public ArrayList<Object[]> obtenerEjemplares() {
        ArrayList<Object[]> listaEjemplares = new ArrayList<>();
        String sql = "SELECT * FROM ejemplares";

        Connection conn = conexionBD.conectar();

        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Object[] fila = new Object[5];

                    fila[0] = rs.getString("codigo");
                    fila[1] = rs.getString("titulo");
                    fila[2] = rs.getString("autor");
                    fila[3] = rs.getString("estado");
                    fila[4] = rs.getInt("anio_publicacion");

                    listaEjemplares.add(fila);
                }
            } catch (SQLException e) {
                System.err.println("ERROR AL CONSULTAR: " + e.getMessage());
            } finally {
                conexionBD.desconectar(conn);
            }
        }
        return listaEjemplares;
    }


    public boolean validarLogin(String correo, String contrasena) {
        boolean accesoConcedido = false;
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ? AND estado = 'Activo'";

        Connection conn = conexionBD.conectar();

        if (conn != null) {
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, correo);
                pstmt.setString(2, contrasena);

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    accesoConcedido = true;
                    System.out.println(">>> LOGIN EXITOSO: Bienvenido, " + rs.getString("nombre"));
                }

            } catch (SQLException e) {
                System.err.println("ERROR EN LOGIN: " + e.getMessage());
            } finally {
                conexionBD.desconectar(conn);
            }
        }
        return accesoConcedido;
    }


}