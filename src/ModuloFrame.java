import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ModuloFrame extends JFrame {

    public ModuloFrame(String nombreModulo) {

        setTitle(nombreModulo + " - Sistema Biblioteca");
        setSize(850, 520);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titulo = new JLabel(nombreModulo);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(300, 20, 400, 35);
        add(titulo);

        String campo1 = "Código:";
        String campo2 = "Nombre/Título:";
        String campo3 = "Descripción:";

        String[] columnas = {"Código", "Nombre/Título", "Descripción", "Estado"};

        if (nombreModulo.equals("Usuarios")) {
            campo1 = "ID Usuario:";
            campo2 = "Nombre:";
            campo3 = "Correo:";
            columnas = new String[]{"ID", "Nombre", "Correo", "Tipo"};
        } else if (nombreModulo.equals("Restablecer contraseña")) {
            campo1 = "ID Usuario:";
            campo2 = "Nueva contraseña:";
            campo3 = "Confirmar contraseña:";
            columnas = new String[]{"ID", "Usuario", "Estado", "Acción"};
        } else if (nombreModulo.equals("Registrar ejemplares")) {
            campo1 = "Código:";
            campo2 = "Título:";
            campo3 = "Autor:";
            columnas = new String[]{"Código", "Título", "Autor", "Disponible"};
        } else if (nombreModulo.equals("Consulta de ejemplares")) {
            campo1 = "Código/Título:";
            campo2 = "Autor:";
            campo3 = "Categoría:";
            columnas = new String[]{"Código", "Título", "Autor", "Estado"};
        } else if (nombreModulo.equals("Préstamos")) {
            campo1 = "ID Usuario:";
            campo2 = "Código ejemplar:";
            campo3 = "Fecha préstamo:";
            columnas = new String[]{"Usuario", "Ejemplar", "Fecha", "Estado"};
        } else if (nombreModulo.equals("Devoluciones")) {
            campo1 = "ID Préstamo:";
            campo2 = "Código ejemplar:";
            campo3 = "Fecha devolución:";
            columnas = new String[]{"Préstamo", "Ejemplar", "Fecha", "Estado"};
        } else if (nombreModulo.equals("Mora")) {
            campo1 = "ID Préstamo:";
            campo2 = "Días atraso:";
            campo3 = "Monto mora:";
            columnas = new String[]{"Préstamo", "Días", "Mora", "Estado"};
        } else if (nombreModulo.equals("Configuración")) {
            campo1 = "Parámetro:";
            campo2 = "Valor:";
            campo3 = "Descripción:";
            columnas = new String[]{"Parámetro", "Valor", "Descripción", "Estado"};
        }

        JLabel lblCampo1 = new JLabel(campo1);
        lblCampo1.setBounds(40, 80, 140, 25);
        add(lblCampo1);

        JTextField txtCampo1 = new JTextField();
        txtCampo1.setBounds(180, 80, 220, 25);
        add(txtCampo1);

        JLabel lblCampo2 = new JLabel(campo2);
        lblCampo2.setBounds(40, 120, 140, 25);
        add(lblCampo2);

        JTextField txtCampo2 = new JTextField();
        txtCampo2.setBounds(180, 120, 220, 25);
        add(txtCampo2);

        JLabel lblCampo3 = new JLabel(campo3);
        lblCampo3.setBounds(40, 160, 140, 25);
        add(lblCampo3);

        JTextField txtCampo3 = new JTextField();
        txtCampo3.setBounds(180, 160, 220, 25);
        add(txtCampo3);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(460, 80, 120, 30);
        add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(610, 80, 120, 30);
        add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(460, 130, 120, 30);
        add(btnEliminar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(610, 130, 120, 30);
        add(btnBuscar);

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        modelo.addRow(new Object[]{"001", "Dato de ejemplo", "Información de prueba", "Activo"});
        modelo.addRow(new Object[]{"002", "Dato de ejemplo", "Información de prueba", "Disponible"});

        JTable tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 230, 760, 180);
        add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(360, 430, 120, 30);
        add(btnCerrar);

        btnCerrar.addActionListener(e -> dispose());
    }
}