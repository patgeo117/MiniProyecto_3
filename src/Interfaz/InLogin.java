package Interfaz;

import Bibliotecarios.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class InLogin extends JFrame {

    // Iconos
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Imagenes/LoginIcon.png")));
    ImageIcon img2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Imagenes/LoginIcon2.png")));

    // JText Field
    JTextField txtUsuario;
    JPasswordField txtContrasena;

    // JLabel
    JLabel lUsuario;
    JLabel lContrasena;
    JLabel lImagen;

    // Jbutton
    JButton bLogin;

    SerizalizaDeseralizaUs SerizalizaDeseralizaUs = new SerizalizaDeseralizaUs();

    public InLogin() {

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
            loginUsers();
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

    public void loginUsers() {
        // Se toman los valores del JtextField
        String Usuario = txtUsuario.getText();
        char[] Clave = txtContrasena.getPassword();
        String Contrasena = new String(Clave);  // Se transforma la clave a String

        boolean bibliotecarioValido = false;  // me va ha permitir validar el bibliotecario
        boolean maestroValido = false; // Permite validar el login del bibliotecario maestro

        // validación para los Empleados Normal
        // Creo un lista tipo Employees que almacena los datos agregados
        System.out.println("**** Normals Users ****");
        Employees[] temoNormal = SerizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataB.bin");

        for (Employees n : temoNormal) {
            if (Usuario.equals(n.getKey()) & Contrasena.equals(n.getValue())) {
                bibliotecarioValido = true;
                break;
            }
        }

        // Validaciones para los bibliotecarios Maestros
        System.out.println("\n**** Maestros ****");
        Employees[] temoMaestro = SerizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataM.bin");

        for (Employees m : temoMaestro) {
            if (Usuario.equals(m.getKey()) & Contrasena.equals(m.getValue())) {
                maestroValido = true;
                break;
            }
        }

        if (bibliotecarioValido) {
            setVisible(false);
            new InBiblioteca();
        } else if (maestroValido) {
            setVisible(false);
            new InBiblioteca();
            // Se habilita el botón crear cuenta
            InBiblioteca.lCrearCuenta.setVisible(true);
            InBiblioteca.bCrearCuentas.setVisible(true);

            InBiblioteca.lDeleteUser.setVisible(true);
            InBiblioteca.bDeleteUser.setVisible(true);

            InBiblioteca.bDeleteBook.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrecta. Vuelve a intentarlo");
            txtUsuario.setText("");
            txtContrasena.setText("");
        }
    }
}