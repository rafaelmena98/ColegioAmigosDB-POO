import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ModuloFrame extends JFrame {


    private JTextField txtCampo1;
    private JTextField txtCampo2;
    private JTextField txtCampo3;
    private JButton btnAgregar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JTable tabla;
    private DefaultTableModel modelo;

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

        if (nombreModulo.equals("Registrar ejemplares")) {
            campo1 = "Código:";
            campo2 = "Título:";
            campo3 = "Autor:";
            columnas = new String[]{"Código", "Título", "Autor", "Disponible"};
        }


        JLabel lblCampo1 = new JLabel(campo1);
        lblCampo1.setBounds(40, 80, 140, 25);
        add(lblCampo1);

        txtCampo1 = new JTextField();
        txtCampo1.setBounds(180, 80, 220, 25);
        add(txtCampo1);

        JLabel lblCampo2 = new JLabel(campo2);
        lblCampo2.setBounds(40, 120, 140, 25);
        add(lblCampo2);

        txtCampo2 = new JTextField();
        txtCampo2.setBounds(180, 120, 220, 25);
        add(txtCampo2);

        JLabel lblCampo3 = new JLabel(campo3);
        lblCampo3.setBounds(40, 160, 140, 25);
        add(lblCampo3);

        txtCampo3 = new JTextField();
        txtCampo3.setBounds(180, 160, 220, 25);
        add(txtCampo3);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(460, 80, 120, 30);
        add(btnAgregar);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(610, 80, 120, 30);
        add(btnEditar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(460, 130, 120, 30);
        add(btnEliminar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(610, 130, 120, 30);
        add(btnBuscar);

        modelo = new DefaultTableModel(columnas, 0);
        modelo.addRow(new Object[]{"001", "Dato de ejemplo", "Información de prueba", "Activo"});

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 230, 760, 180);
        add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(360, 430, 120, 30);
        add(btnCerrar);

        btnCerrar.addActionListener(e -> dispose());
    }

    public JTextField getTxtCampo1() { return txtCampo1; }
    public JTextField getTxtCampo2() { return txtCampo2; }
    public JTextField getTxtCampo3() { return txtCampo3; }
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public DefaultTableModel getModelo() { return modelo; }
    public JTable getTabla() { return tabla; }
}