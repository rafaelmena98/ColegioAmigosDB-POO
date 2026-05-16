import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import control.MetodosCRUD;
import modelo.Libro;
import java.util.ArrayList;

public class RegistrarEjemplaresFrame extends JFrame {

    private DefaultTableModel modelo;
    private JTable tabla;

    public RegistrarEjemplaresFrame() {

        setTitle("Registrar ejemplares - Sistema Biblioteca");
        setSize(850, 520);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titulo = new JLabel("Registrar ejemplares");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(300, 20, 400, 35);
        add(titulo);

        JLabel lblCampo1 = new JLabel("Código:");
        lblCampo1.setBounds(40, 80, 140, 25);
        add(lblCampo1);

        JTextField txtCampo1 = new JTextField();
        txtCampo1.setBounds(180, 80, 220, 25);
        add(txtCampo1);

        JLabel lblCampo2 = new JLabel("Título:");
        lblCampo2.setBounds(40, 120, 140, 25);
        add(lblCampo2);

        JTextField txtCampo2 = new JTextField();
        txtCampo2.setBounds(180, 120, 220, 25);
        add(txtCampo2);

        JLabel lblCampo3 = new JLabel("Autor:");
        lblCampo3.setBounds(40, 160, 140, 25);
        add(lblCampo3);

        JTextField txtCampo3 = new JTextField();
        txtCampo3.setBounds(180, 160, 220, 25);
        add(txtCampo3);

        JLabel lblCampo4 = new JLabel("Año:");
        lblCampo4.setBounds(40, 200, 140, 25);
        add(lblCampo4);

        JTextField txtCampo4 = new JTextField();
        txtCampo4.setBounds(180, 200, 220, 25);
        add(txtCampo4);

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

        String[] columnas = {"Código", "Título", "Autor", "Disponible", "Año"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 250, 760, 160);
        add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(360, 430, 120, 30);
        add(btnCerrar);

        btnCerrar.addActionListener(e -> dispose());

        btnAgregar.addActionListener(e -> {
            String codigo = txtCampo1.getText();
            String tituloLibro = txtCampo2.getText();
            String autor = txtCampo3.getText();
            String anioStr = txtCampo4.getText();

            // CORRECCIÓN: Se envían 3 parámetros al método y el cuarto se evalúa de manera independiente
            if (utilidades.Validaciones.camposEstanLlenos(codigo, tituloLibro, autor) && !anioStr.trim().isEmpty()) {
                int anioValidado = utilidades.Validaciones.validarNumeroEntero(anioStr);
                if (anioValidado != -1) {
                    Libro nuevoLibro = new Libro();
                    nuevoLibro.setCodigo(codigo);
                    nuevoLibro.setTitulo(tituloLibro);
                    nuevoLibro.setAutor(autor);
                    nuevoLibro.setAnioPublicacion(anioValidado);

                    MetodosCRUD crud = new MetodosCRUD();
                    crud.registrarLibro(nuevoLibro);

                    JOptionPane.showMessageDialog(this, "Registro guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarDatosTabla();

                    txtCampo1.setText("");
                    txtCampo2.setText("");
                    txtCampo3.setText("");
                    txtCampo4.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Año inválido. Debe ser un número mayor a cero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        });

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