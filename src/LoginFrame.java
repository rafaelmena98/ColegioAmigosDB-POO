import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Login - Sistema Biblioteca");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titulo = new JLabel("Sistema Biblioteca");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(80, 30, 250, 30);
        add(titulo);

        JLabel usuario = new JLabel("Usuario:");
        usuario.setBounds(50, 90, 100, 25);
        add(usuario);

        JTextField txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 90, 180, 25);
        add(txtUsuario);

        JLabel password = new JLabel("Contraseña:");
        password.setBounds(50, 130, 100, 25);
        add(password);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 130, 180, 25);
        add(txtPassword);

        JButton ingresar = new JButton("Iniciar sesión");
        ingresar.setBounds(120, 190, 150, 35);
        add(ingresar);
        ingresar.addActionListener(e -> {
            new MenuFrame().setVisible(true);
            dispose();
        });
    }
}