import javax.swing.*;
import java.awt.*;
import control.MetodosCRUD;

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

        JLabel usuario = new JLabel("Usuario (Correo):");
        usuario.setBounds(50, 90, 120, 25);
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

            String correo = txtUsuario.getText();
            String contrasena = new String(txtPassword.getPassword());

            if (correo.trim().isEmpty() || contrasena.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa tu usuario y contraseña.");
                return;
            }

            MetodosCRUD crud = new MetodosCRUD();
            boolean esValido = crud.validarLogin(correo, contrasena);

            if (esValido) {
                JOptionPane.showMessageDialog(this, "¡Bienvenido al sistema!");
                new MenuFrame().setVisible(true); // Abre tu menú principal
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas o usuario inactivo.", "Error de Acceso", JOptionPane.ERROR_MESSAGE);
            }
        });

    }
}