package Interfaz;

import Bibliotecarios.Bibliotecario;
import Bibliotecarios.UsuarioMaestro;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Objects;

public class InLogin extends JFrame {

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

    Bibliotecario bibliotecario = new Bibliotecario();



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
            // Se toman los valores del JtextField
            String Usuario = txtUsuario.getText();
            char[] Clave = txtContrasena.getPassword();
            String Contrasena = new String(Clave);  // Se transforma la clave a String

            boolean bibliotecarioValido = false;  // me va ha permitir validar el bibliotecario
            boolean maestroValido = false; // Permite validar el login del bibliotecario maestro

            // validación para los Bibliotecarios Normal
            try{
                FileInputStream inputB = new FileInputStream("src/Archivos_Bin/dataBibliotecarios.bin");
                ObjectInputStream leerB = new ObjectInputStream(inputB);

                HashMap<String, String> newHash = (HashMap<String, String>) leerB.readObject();

                inputB.close();
                leerB.close();

                for(String clave : newHash.keySet()){
                    String valor = newHash.get(clave);
                    if (Usuario.equals(clave) && Contrasena.equals(valor)) {
                        bibliotecarioValido = true;
                    }
                }
            }catch (IOException | ClassNotFoundException error) {
                error.printStackTrace();
            }

            // Validaciones para los bibliotecarios Maestros
            try{
                FileInputStream inputM = new FileInputStream("src/Archivos_Bin/dataMaestros.bin");
                ObjectInputStream leerM = new ObjectInputStream(inputM);

                HashMap<String, String> newMaster = (HashMap<String, String>) leerM.readObject();

                inputM.close();
                leerM.close();

                for(String key : newMaster.keySet()){
                    String value = newMaster.get(key);
                    // Se realizan las validaciones para los Bibliotecarios Maestros
                    if (Usuario.equals(key) && Contrasena.equals(value)) {
                        maestroValido = true;
                    }
                }
            }catch (IOException | ClassNotFoundException error) {
                error.printStackTrace();
            }


            if (bibliotecarioValido) {
                setVisible(false);
                new InBiblioteca();
            } else if (maestroValido) {
                setVisible(false);
                InBiblioteca interfaz2 = new InBiblioteca();
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