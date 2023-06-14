package Interfaz;

import Bibliotecarios.Bibliotecario;
import Bibliotecarios.UsuarioMaestro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class InCrearUs extends JFrame implements ActionListener {
    // icono
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Imagenes/LoginIcon.png")));
    // Jlabel
    JLabel lUsuario;
    JLabel lContrasena;
    // JtextField
    JTextField Usuario;
    JPasswordField Contrasena;
    // Jbutton
    JButton cuentaUsuario;
    JButton cuentaMaestro;
    JButton volver;

    public InCrearUs() {
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
        cuentaUsuario = new JButton("Crear Bibliotecario");
        cuentaUsuario.setBounds(75, 160, 150, 30);
        cuentaUsuario.addActionListener(this);
        add(cuentaUsuario);

        cuentaMaestro = new JButton("Crear Master");
        cuentaMaestro.setBounds(90, 200, 120, 30);
        cuentaMaestro.addActionListener(this);
        add(cuentaMaestro);

        volver = new JButton("Volver");
        volver.setBounds(10, 10, 80, 20);
        volver.addActionListener(this);
        add(volver);


        // Configuración de ventana
        setLayout(null);
        setSize(300, 280);
        setTitle("Crear Cuenta");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img.getImage());
        setVisible(true);
    }

    // Método que ba a guardar
    public void dataBibliotecarios() {
        // Instancia de los bibliotecarios
        //Bibliotecario bibliotecario = new Bibliotecario();

        // creo un HashMap que va a recibit los datos por defecto  de getData() (método que lee el bin);
        HashMap<String, String> dataBibliotecarios = getDataB();

        // Se toma el usuario del JTextField
        String name = Usuario.getText();
        // Se toma la Contraseña del JTestField
        char[] clave = Contrasena.getPassword();
        String password = new String(clave);

        /*bibliotecario.setName(name);
        bibliotecario.setPassword(password);*/

        // Agrego nuevos  datos al Hasmap
        dataBibliotecarios.put(name, password);

        // Guardo los datos en el bin
        setDataB(dataBibliotecarios);

        //validarUser();
    }

    // Escribir en archivo
    public static void setDataB(HashMap<String, String> data) {

        try {
            FileOutputStream outputB = new FileOutputStream("src/Archivos_Bin/dataBibliotecarios.bin");
            ObjectOutputStream modifiB = new ObjectOutputStream(outputB);

            modifiB.writeObject(data);

            modifiB.close();
            outputB.close();

        } catch (Exception io) {
            io.printStackTrace();
        }
    }

    // leer archivos Bibliotecario
    public HashMap<String, String> getDataB() {
        // creo un nuevo HasMap que captura los datos del bin
        HashMap<String, String> newHash = new HashMap<>();
        try {
            File file = new File("src/Archivos_Bin/dataBibliotecarios.bin");
            // Válido que el archivo exista
            if (file.exists()) {
                FileInputStream inputB = new FileInputStream(file);
                ObjectInputStream leerB = new ObjectInputStream(inputB);

                // leo el archivo y agregó los valores al HashMap
                newHash = (HashMap<String, String>) leerB.readObject();

                leerB.close();
                inputB.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // retorno los datos del bin
        return newHash;
    }

    // Método que ba a guardar
    public void dataMaestros() {
        // creo un HashMap que va a recibit los datos por defecto  de getData() (método que lee el bin);
        HashMap<String, String> dataMaestro = getDataM();
        // Se toma el usuario del JTextField
        String name = Usuario.getText();
        // Se toma la Contraseña del JTestField
        char[] clave = Contrasena.getPassword();
        String password = new String(clave);

        /*bibliotecario.setName(name);
        bibliotecario.setPassword(password);*/

        // Agrego nuevos  datos al Hasmap
        dataMaestro.put(name, password);

        // Guardo los datos en el bin
        setDataM(dataMaestro);

        //validarUser();
    }

    // Escribir en archivo Maestro
    public static void setDataM(HashMap<String, String> data) {

        try {
            FileOutputStream outputM = new FileOutputStream("src/Archivos_Bin/dataMaestros.bin");
            ObjectOutputStream modifiM = new ObjectOutputStream(outputM);

            modifiM.writeObject(data);

            modifiM.close();
            outputM.close();

        } catch (Exception io) {
            io.printStackTrace();
        }
    }

    // leer archivo maestro
    public HashMap<String, String> getDataM() {
        // creo un nuevo HasMap que captura los datos del bin
        HashMap<String, String> newMaster = new HashMap<>();
        try {
            File file = new File("src/Archivos_Bin/dataMaestros.bin");
            // Válido que el archivo exista
            if (file.exists()) {
                FileInputStream inputM = new FileInputStream(file);
                ObjectInputStream leerM = new ObjectInputStream(inputM);

                // leo el archivo y agregó los valores al HashMap
                newMaster = (HashMap<String, String>) leerM.readObject();

                leerM.close();
                inputM.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // retorno los datos del bin
        return newMaster;
    }

    public boolean userExiste(String nameUser, HashMap<String, String> users) {
        return users.containsKey(nameUser); // devuelve true si la calve existe y false si no
    }

    public void validarUser() {
        // Obtengo los datos de los archivos bin
        HashMap<String, String> usuarioMaestro = getDataM();
        HashMap<String, String> usuarioBibliotecario = getDataB();

        // Se toma el usuario del JTextField
        String name = Usuario.getText();


        boolean maestroExsite = userExiste(name, usuarioMaestro);
        boolean bibliotecarioExiste = userExiste(name, usuarioBibliotecario);

        if (bibliotecarioExiste) {
            JOptionPane.showMessageDialog(null, "Usuario Bibliotecario ya existe");

        }
        if (maestroExsite) {
            JOptionPane.showMessageDialog(null, "Usuario Maestro ya existe");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();

        // Al precionar el botón se toman los datos con la función y muestra una ventana de aprobación
        if (jb == cuentaUsuario) {
            // llamo al método encargado de crear los usuarios
            dataBibliotecarios();
            JOptionPane.showMessageDialog(null, "Cuenta creada...", " ", JOptionPane.INFORMATION_MESSAGE);
            // vaciá los JTextField
            Usuario.setText("");
            Contrasena.setText("");
            System.out.println("Usuario normal creado");

        }
        if (jb == cuentaMaestro) {
            dataMaestros();
            JOptionPane.showMessageDialog(null, "Cuenta creada...", " ", JOptionPane.INFORMATION_MESSAGE);
            // vaciá los JTextField
            Usuario.setText("");
            Contrasena.setText("");
            System.out.println("Usuario Maestro Creado");
        }
        if (jb == volver) {
            setVisible(false);
            InBiblioteca interfaz2 = new InBiblioteca();
            interfaz2.bCrearCuentas.setVisible(true);
            interfaz2.lCrearCuenta.setVisible(true);
        }
    }
}


