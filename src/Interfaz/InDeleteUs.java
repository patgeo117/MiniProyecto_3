package Interfaz;

import Bibliotecarios.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class InDeleteUs extends JFrame implements ActionListener {
    // icono
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Imagenes/LoginIcon.png")));
    // Jlabel
    JLabel lUsuario;
    JLabel lContrasena;
    // JtextField
    public JTextField Usuario;
    public JPasswordField Contrasena;
    // Jbutton
    JButton cuentaUsuario;
    JButton cuentaMaestro;
    JButton volver;

    SerizalizaDeseralizaUs serizalizaDeseralizaUs = new SerizalizaDeseralizaUs();

    public InDeleteUs() {
        super("Elminar Cuenta");
        // Configuración Jlabel
        lUsuario = new JLabel("Usuario");
        lUsuario.setBounds(100, 15, 100, 40);
        add(lUsuario);

        lContrasena = new JLabel("Contraseña");
        lContrasena.setBounds(100, 70, 100, 40);
        add(lContrasena);

        // Configuración JtextField
        Usuario = new JTextField();
        Usuario.setBounds(100, 50, 100, 25);
        add(Usuario);

        Contrasena = new JPasswordField();
        Contrasena.setBounds(100, 105, 100, 25);
        add(Contrasena);

        // Configuración Jbutton
        cuentaUsuario = new JButton("Eliminar Bibliotecario");
        cuentaUsuario.setBounds(65, 145, 170, 30);
        cuentaUsuario.addActionListener(this);
        add(cuentaUsuario);

        cuentaMaestro = new JButton("Eliminar Master");
        cuentaMaestro.setBounds(70, 185, 160, 30);
        cuentaMaestro.addActionListener(this);
        add(cuentaMaestro);

        volver = new JButton("Volver");
        volver.setBounds(10, 10, 80, 20);
        volver.addActionListener(this);
        add(volver);


        // Configuración de ventana
        setLayout(null);
        setSize(300, 280);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img.getImage());
        setVisible(true);
    }

    public void deleteB() {
        // Se toma el usuario del JTextField
        String name = Usuario.getText();
        // Se toma la Contraseña del JTestField
        char[] clave = Contrasena.getPassword();
        String password = new String(clave);

        Employees[] tempNormal = serizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataB.bin");

        int indexToRemove = -1; // Índice del elemento a eliminar
        for (int i = 0; i < tempNormal.length; i++) {
            if (tempNormal[i].getKey().equals(name) & tempNormal[i].getValue().equals(password)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            Employees[] newTempNormal = new Employees[tempNormal.length - 1]; // nueva matriz con un tamaño menor a tempNormal
            System.arraycopy(tempNormal, 0, newTempNormal, 0, indexToRemove); //  copio la matriz menos el dato en la posición i
            // copio los datos despues del dato de la posicio i
            System.arraycopy(tempNormal, indexToRemove + 1, newTempNormal, indexToRemove, tempNormal.length - indexToRemove - 1);

            JOptionPane.showMessageDialog(null, "La cuenta:\n" + tempNormal[indexToRemove] + "\nSe ha eliminado correctamente");

            tempNormal = newTempNormal;

        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario." + "\nVuelve a intentarlo");
        }

        serizalizaDeseralizaUs.setDataB(tempNormal, "src/Archivos_Bin/dataB.bin");
    }

    public void deleteM() {
        // Se toma el usuario del JTextField
        String name = Usuario.getText();
        // Se toma la Contraseña del JTestField
        char[] clave = Contrasena.getPassword();
        String password = new String(clave);

        HashMap<String, String> usuarioMaestro = new HashMap<>();
        Employees[] tempMaestro = serizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataM.bin");

        int indexToRemove = -1; // Índice del elemento a eliminar
        for (int i = 0; i < tempMaestro.length; i++) {
            if (tempMaestro[i].getKey().equals(name) & tempMaestro[i].getValue().equals(password)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            Employees[] newTempNormal = new Employees[tempMaestro.length - 1]; // nueva matriz con un tamaño menor a tempNormal
            System.arraycopy(tempMaestro, 0, newTempNormal, 0, indexToRemove); //  copio la matriz menos el dato en la posición i
            // copio los datos despues del dato de la posicio i
            System.arraycopy(tempMaestro, indexToRemove + 1, newTempNormal, indexToRemove, tempMaestro.length - indexToRemove - 1);

            JOptionPane.showMessageDialog(null, "La cuenta:\n" + tempMaestro[indexToRemove] + "\nSe ha eliminado correctamente");

            tempMaestro = newTempNormal;

        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario." + "\nVuelve a Intentarlo");
        }

        serizalizaDeseralizaUs.setDataB(tempMaestro, "src/Archivos_Bin/dataM.bin");
    }

    public void cerrar() {
        setVisible(false);
        new InBiblioteca();
        InBiblioteca.bCrearCuentas.setVisible(true);
        InBiblioteca.lCrearCuenta.setVisible(true);
        InBiblioteca.lDeleteUser.setVisible(true);
        InBiblioteca.bDeleteUser.setVisible(true);
        InBiblioteca.bDeleteBook.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();

        // Al precionar el botón se toman los datos con la función y muestra una ventana de aprobación
        if (jb == cuentaUsuario) {
            deleteB();

            // vaciá los JTextField
            Usuario.setText("");
            Contrasena.setText("");
        }
        if (jb == cuentaMaestro) {
            deleteM();

            // vaciá los JTextField
            Usuario.setText("");
            Contrasena.setText("");
        }
        if (jb == volver) {
            cerrar();
        }
    }
}