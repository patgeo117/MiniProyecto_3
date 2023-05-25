import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Interfaz_1 extends JFrame {

    UsuarioMaestro usuarioMaestro = new UsuarioMaestro();
    // Iconos
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Recursos/LoginIcon.png")));
    ImageIcon img2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Recursos/LoginIcon2.png")));

    // JText Field
    JTextField txtUsuario;
    JPasswordField txtContrasena;

    // JLabel
    JLabel lUsuario;
    JLabel lContrasena;
    JLabel lImagen;

    // Jbutton
    JButton bLogin;


    public Interfaz_1() {

        // JTextField
        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 110, 100, 20);
        add(txtUsuario);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(100, 150, 100, 20);
        add(txtContrasena);

        // JLabel
        lUsuario = new JLabel();
        lUsuario.setText("Username:");
        lUsuario.setBounds(100, 90, 100, 20);
        add(lUsuario);

        lContrasena = new JLabel();
        lContrasena.setText("Password:");
        lContrasena.setBounds(100, 130, 100, 20);
        add(lContrasena);

        lImagen = new JLabel(img2);
        lImagen.setBounds(105, 5, img2.getIconWidth(), img2.getIconHeight());
        add(lImagen);

        // JButton
        bLogin = new JButton("Log In");
        bLogin.setBackground(Color.BLUE);
        bLogin.setBounds(100, 190, 100, 30);
        // agregamos el método de escucha al botón
        bLogin.addActionListener(e -> {
            // Se toman los valores del JtextField
            String Usuario = txtUsuario.getText();
            char[] Clave = txtContrasena.getPassword();
            String Contrasena = new String(Clave);  // Se transforma la clave a String

            boolean usuarioValido = false;  // me va ha permitir validar el bibliotecario

            // validación para los Bibliotecarios Normal
            for (int i = 0; i < Bibliotecario.name.size(); i++) { // Recorro la lista de bibliotecarios
                if (Usuario.equals(Bibliotecario.name.get(i)) && Contrasena.equals(Bibliotecario.password.get(i))) {
                    usuarioValido = true;
                    break;
                }
            }
            if (usuarioValido) {
                setVisible(false);
                new Interfaz_2();
            }
            // Se realizan las validaciones del Bibliotecario Maestro
            else if (Usuario.equals(usuarioMaestro.setUsuario()) && Contrasena.equals(usuarioMaestro.setContrasena())) { // validó la contraseña
                setVisible(false);
                Interfaz_2 interfaz2 = new Interfaz_2();
                // Se habilita el botón crear cuenta
                interfaz2.lCrearCuenta.setVisible(true);
                interfaz2.bCrearCuentas.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrecta. Vuelve a intentarlo");
                txtUsuario.setText("");
                txtContrasena.setText("");
            }
        });

        add(bLogin);

        // Configuración Ventana 1

        setLayout(null);

        setSize(300, 325);

        setTitle("Login");

        setLocationRelativeTo(null);

        setResizable(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setIconImage(img.getImage());

        setVisible(true);

    }

}