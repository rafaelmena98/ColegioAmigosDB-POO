import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import control.MetodosCRUD;
import utilidades.Validaciones;
import control.Conexion;
import modelo.Libro;

public class ModuloFrame extends JFrame {

    private JTextField txtCampo1;
    private JTextField txtCampo2;
    private JTextField txtCampo3;
    private JTextField txtCampo4;
    private JButton btnAgregar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JTable tabla;
    private DefaultTableModel modelo;

    private MetodosCRUD crud = new MetodosCRUD();

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
        String campo4 = "Año:";
        String[] columnas = {"Código", "Nombre/Título", "Descripción", "Estado", "Año"};

        if (nombreModulo.equals("Registrar ejemplares")) {
            campo1 = "Código:";
            campo2 = "Título:";
            campo3 = "Autor:";
            campo4 = "Año:";
            columnas = new String[]{"Código", "Título", "Autor", "Disponible", "Año"};
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

        JLabel lblCampo4 = new JLabel(campo4);
        lblCampo4.setBounds(40, 200, 140, 25);
        add(lblCampo4);

        txtCampo4 = new JTextField();
        txtCampo4.setBounds(180, 200, 220, 25);
        add(txtCampo4);

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
        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 230, 760, 180);
        add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(360, 430, 120, 30);
        add(btnCerrar);

        btnCerrar.addActionListener(e -> dispose());

        cargarDatosTabla();

        btnAgregar.addActionListener(e -> {
            String codigo = txtCampo1.getText();
            String tituloLibro = txtCampo2.getText();
            String autor = txtCampo3.getText();
            String anioStr = txtCampo4.getText();

            if (!Validaciones.camposEstanLlenos(tituloLibro, autor, anioStr)) {
                JOptionPane.showMessageDialog(this, "Por favor llena todos los campos obligatorios.");
                return;
            }

            int anioValidado = Validaciones.validarAnioPublicacion(anioStr);
            if (anioValidado == -1) {
                JOptionPane.showMessageDialog(this, "Año inválido. Debe ser un número mayor a cero.");
                return;
            }

            Libro nuevoLibro = new Libro();
            nuevoLibro.setCodigo(codigo);
            nuevoLibro.setTitulo(tituloLibro);
            nuevoLibro.setAutor(autor);
            nuevoLibro.setAnioPublicacion(anioValidado);

            crud.registrarLibro(nuevoLibro);

            JOptionPane.showMessageDialog(this, "Registro guardado correctamente.");
            limpiarCampos();
            cargarDatosTabla();
        });

        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada >= 0) {
                String codigoAEliminar = tabla.getValueAt(filaSeleccionada, 0).toString();
                JOptionPane.showMessageDialog(this, "Funcionalidad de eliminación pendiente de implementación en CRUD.");
                cargarDatosTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.");
            }
        });
    }

    private void cargarDatosTabla() {
        modelo.setRowCount(0);
        ArrayList<Object[]> listaDatos = crud.obtenerEjemplares();
        for (Object[] fila : listaDatos) {
            modelo.addRow(fila);
        }
    }

    private void limpiarCampos() {
        txtCampo1.setText("");
        txtCampo2.setText("");
        txtCampo3.setText("");
        txtCampo4.setText("");
    }

    public JTextField getTxtCampo1() { return txtCampo1; }
    public JTextField getTxtCampo2() { return txtCampo2; }
    public JTextField getTxtCampo3() { return txtCampo3; }
    public JTextField getTxtCampo4() { return txtCampo4; }
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public DefaultTableModel getModelo() { return modelo; }
    public JTable getTabla() { return tabla; }
}