import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {


    private JButton btnUsuarios;
    private JButton btnRestablecer;
    private JButton btnEjemplares;
    private JButton btnConsulta;
    private JButton btnPrestamos;
    private JButton btnDevoluciones;
    private JButton btnMora;
    private JButton btnConfiguracion;

    public MenuFrame() {

        setTitle("Menú Principal - Sistema Biblioteca");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("Sistema de Gestión de Biblioteca");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(160, 30, 400, 40);
        add(titulo);

        // 2. Inicializamos los botones (ya no usamos la palabra JButton aquí)
        btnUsuarios = new JButton("Usuarios");
        btnUsuarios.setBounds(90, 110, 220, 45);
        add(btnUsuarios);

        btnRestablecer = new JButton("Restablecer contraseña");
        btnRestablecer.setBounds(370, 110, 220, 45);
        add(btnRestablecer);

        btnEjemplares = new JButton("Registrar ejemplares");
        btnEjemplares.setBounds(90, 180, 220, 45);
        add(btnEjemplares);

        btnConsulta = new JButton("Consulta de ejemplares");
        btnConsulta.setBounds(370, 180, 220, 45);
        add(btnConsulta);

        btnPrestamos = new JButton("Préstamos");
        btnPrestamos.setBounds(90, 250, 220, 45);
        add(btnPrestamos);

        btnDevoluciones = new JButton("Devoluciones");
        btnDevoluciones.setBounds(370, 250, 220, 45);
        add(btnDevoluciones);

        btnMora = new JButton("Mora");
        btnMora.setBounds(90, 320, 220, 45);
        add(btnMora);

        btnConfiguracion = new JButton("Configuración");
        btnConfiguracion.setBounds(370, 320, 220, 45);
        add(btnConfiguracion);


        btnUsuarios.addActionListener(e -> new ModuloFrame("Usuarios").setVisible(true));
        btnRestablecer.addActionListener(e -> new ModuloFrame("Restablecer contraseña").setVisible(true));
        btnEjemplares.addActionListener(e -> new ModuloFrame("Registrar ejemplares").setVisible(true));
        btnConsulta.addActionListener(e -> new ModuloFrame("Consulta de ejemplares").setVisible(true));
        btnPrestamos.addActionListener(e -> new ModuloFrame("Préstamos").setVisible(true));
        btnDevoluciones.addActionListener(e -> new ModuloFrame("Devoluciones").setVisible(true));
        btnMora.addActionListener(e -> new ModuloFrame("Mora").setVisible(true));
        btnConfiguracion.addActionListener(e -> new ModuloFrame("Configuración").setVisible(true));
    }


    public JButton getBtnUsuarios() { return btnUsuarios; }
    public JButton getBtnRestablecer() { return btnRestablecer; }
    public JButton getBtnEjemplares() { return btnEjemplares; }
    public JButton getBtnConsulta() { return btnConsulta; }
    public JButton getBtnPrestamos() { return btnPrestamos; }
    public JButton getBtnDevoluciones() { return btnDevoluciones; }
    public JButton getBtnMora() { return btnMora; }
    public JButton getBtnConfiguracion() { return btnConfiguracion; }
}