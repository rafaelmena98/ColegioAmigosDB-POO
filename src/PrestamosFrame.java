import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PrestamosFrame extends JFrame {

    public PrestamosFrame() {

        setTitle("Préstamos - Sistema Biblioteca");
        setSize(850, 520);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titulo = new JLabel("Préstamos");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(370, 20, 200, 35);
        add(titulo);

        JLabel lblCampo1 = new JLabel("ID Usuario:");
        lblCampo1.setBounds(40, 80, 140, 25);
        add(lblCampo1);

        JTextField txtCampo1 = new JTextField();
        txtCampo1.setBounds(180, 80, 220, 25);
        add(txtCampo1);

        JLabel lblCampo2 = new JLabel("Código ejemplar:");
        lblCampo2.setBounds(40, 120, 140, 25);
        add(lblCampo2);

        JTextField txtCampo2 = new JTextField();
        txtCampo2.setBounds(180, 120, 220, 25);
        add(txtCampo2);

        JLabel lblCampo3 = new JLabel("Fecha préstamo:");
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

        String[] columnas = {"Usuario", "Ejemplar", "Fecha", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
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