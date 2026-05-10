import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {

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

        JButton btnUsuarios = new JButton("Usuarios");
        btnUsuarios.setBounds(90, 110, 220, 45);
        add(btnUsuarios);

        JButton btnRestablecer = new JButton("Restablecer contraseña");
        btnRestablecer.setBounds(370, 110, 220, 45);
        add(btnRestablecer);

        JButton btnEjemplares = new JButton("Registrar ejemplares");
        btnEjemplares.setBounds(90, 180, 220, 45);
        add(btnEjemplares);

        JButton btnConsulta = new JButton("Consulta de ejemplares");
        btnConsulta.setBounds(370, 180, 220, 45);
        add(btnConsulta);

        JButton btnPrestamos = new JButton("Préstamos");
        btnPrestamos.setBounds(90, 250, 220, 45);
        add(btnPrestamos);

        JButton btnDevoluciones = new JButton("Devoluciones");
        btnDevoluciones.setBounds(370, 250, 220, 45);
        add(btnDevoluciones);

        JButton btnMora = new JButton("Mora");
        btnMora.setBounds(90, 320, 220, 45);
        add(btnMora);

        JButton btnConfiguracion = new JButton("Configuración");
        btnConfiguracion.setBounds(370, 320, 220, 45);
        add(btnConfiguracion);
        btnUsuarios.addActionListener(e -> {
            new ModuloFrame("Usuarios").setVisible(true);
        });

        btnRestablecer.addActionListener(e -> {
            new ModuloFrame("Restablecer contraseña").setVisible(true);
        });

        btnEjemplares.addActionListener(e -> {
            new ModuloFrame("Registrar ejemplares").setVisible(true);
        });

        btnConsulta.addActionListener(e -> {
            new ModuloFrame("Consulta de ejemplares").setVisible(true);
        });

        btnPrestamos.addActionListener(e -> {
            new ModuloFrame("Préstamos").setVisible(true);
        });

        btnDevoluciones.addActionListener(e -> {
            new ModuloFrame("Devoluciones").setVisible(true);
        });

        btnMora.addActionListener(e -> {
            new ModuloFrame("Mora").setVisible(true);
        });

        btnConfiguracion.addActionListener(e -> {
            new ModuloFrame("Configuración").setVisible(true);
        });
    }
}