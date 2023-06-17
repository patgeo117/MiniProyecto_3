package Interfaz;

import Bibliotecarios.*;

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
        try {
            FileInputStream inputB = new FileInputStream("src/Archivos_Bin/dataB.bin");
            ObjectInputStream leerB = new ObjectInputStream(inputB);

            // creo un HashMap donde se van a almacenar los
            HashMap<String, String> hashNormal = new HashMap<>();
            // Creo un lista tipo Employees que almacena los datos agregados
            System.out.println("**** Normals Users ****");
            Employees[] temo = SerizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataB.bin");

            for (Employees e : temo) {
                hashNormal.put(e.getKey(), e.getValue());
            }

            inputB.close();
            leerB.close();

            for (String clave : hashNormal.keySet()) {
                String valor = hashNormal.get(clave);
                if (Usuario.equals(clave) && Contrasena.equals(valor)) {
                    bibliotecarioValido = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Validaciones para los bibliotecarios Maestros
        try {
            FileInputStream inputB = new FileInputStream("src/Archivos_Bin/dataM.bin");
            ObjectInputStream leerB = new ObjectInputStream(inputB);

            // creo un HashMap donde se van a almacenar los
            HashMap<String, String> newMaster = new HashMap<>();
            // Creo un lista tipo Employees que almacena los datos agregados
            System.out.println("\n**** Normals Maestro ****");
            Employees[] temo = SerizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataM.bin");

            for (Employees e : temo) {
                newMaster.put(e.getKey(), e.getValue());
            }

            inputB.close();
            leerB.close();

            for (String clave : newMaster.keySet()) {
                String valor = newMaster.get(clave);
                if (Usuario.equals(clave) && Contrasena.equals(valor)) {
                    maestroValido = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

            interfaz2.lDeleteUser.setVisible(true);
            interfaz2.bDeleteUser.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrecta. Vuelve a intentarlo");
            txtUsuario.setText("");
            txtContrasena.setText("");
        }
    }

}