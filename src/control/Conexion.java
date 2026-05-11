package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca_don_bosco";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";


    public Connection conectar() {
        Connection conexion = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println(">>> ÉXITO: Conexión a la base de datos establecida.");

        } catch (SQLException e) {
            System.err.println("ERROR SQL: Fallo al conectar a la base de datos. Detalle: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR DRIVER: No se encontró la librería de MySQL. Detalle: " + e.getMessage());
        }
        return conexion;
    }


    public void desconectar(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println(">>> Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("ERROR: Fallo al intentar cerrar la conexión. Detalle: " + e.getMessage());
        }
    }
}