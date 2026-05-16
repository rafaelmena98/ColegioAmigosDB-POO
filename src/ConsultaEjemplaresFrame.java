import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import control.MetodosCRUD;
import java.util.ArrayList;

public class ConsultaEjemplaresFrame extends JFrame {

    private DefaultTableModel modelo;
    private JTable tabla;

    public ConsultaEjemplaresFrame() {

        setTitle("Consulta de ejemplares - Sistema Biblioteca");
        setSize(850, 520);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titulo = new JLabel("Consulta de ejemplares");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(300, 20, 400, 35);
        add(titulo);

        JLabel lblCampo1 = new JLabel("Código/Título:");
        lblCampo1.setBounds(40, 80, 140, 25);
        add(lblCampo1);

        JTextField txtCampo1 = new JTextField();
        txtCampo1.setBounds(180, 80, 220, 25);
        add(txtCampo1);

        JLabel lblCampo2 = new JLabel("Autor:");
        lblCampo2.setBounds(40, 120, 140, 25);
        add(lblCampo2);

        JTextField txtCampo2 = new JTextField();
        txtCampo2.setBounds(180, 120, 220, 25);
        add(txtCampo2);

        JLabel lblCampo3 = new JLabel("Categoría:");
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

        String[] columnas = {"Código", "Título", "Autor", "Estado"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 230, 760, 180);
        add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(360, 430, 120, 30);
        add(btnCerrar);

        btnCerrar.addActionListener(e -> dispose());

        cargarDatosTabla();
    }

    private void cargarDatosTabla() {
        modelo.setRowCount(0);
        MetodosCRUD crud = new MetodosCRUD();
        ArrayList<Object[]> listaDatos = crud.obtenerEjemplares();
        for (Object[] fila : listaDatos) {
            modelo.addRow(fila);
        }
    }
}