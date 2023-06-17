package Interfaz;

import Bibliotecarios.*;

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
    public JTextField Usuario;
    public JPasswordField Contrasena;
    // Jbutton
    JButton cuentaUsuario;
    JButton cuentaMaestro;
    JButton volver;


    // un boolean que va permitir verificar/crear un User cuando sea true
    boolean validar = false;

    SerizalizaDeseralizaUs serizalizaDeseralizaUs = new SerizalizaDeseralizaUs();

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

    // Método para crear Usuarios normales
    public void obtenerDataB() throws IOException, ClassNotFoundException {
        // Se toma el usuario del JTextField
        String name = Usuario.getText();
        // Se toma la Contraseña del JTestField
        char[] clave = Contrasena.getPassword();
        String password = new String(clave);


        if (validar) {
            if (!name.equals("") & !password.equals("")) {
                // Obtengo los datos del archivo .bin
                Employees[] employees = serizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataB.bin");

                // obtengo los datos del bibliotecario;
                Bibliotecario bibliotecario = new Bibliotecario(name, password);

                // creo una nueva lista con el tamaño de los empleados más el nuevo que se va h agregar
                Employees[] nuevosEmployees = new Employees[employees.length + 1];

                for (int i = 0; i < employees.length; i++) {
                    nuevosEmployees[i] = employees[i];
                }
                nuevosEmployees[nuevosEmployees.length - 1] = bibliotecario;

                serizalizaDeseralizaUs.setDataB(nuevosEmployees, "src/Archivos_Bin/dataB.bin");

                JOptionPane.showMessageDialog(null, "Cuenta creada...", " ", JOptionPane.INFORMATION_MESSAGE);

                for (Employees e : nuevosEmployees) {
                    System.out.println(e);
                }
                System.out.println("\n");

            } else {
                JOptionPane.showMessageDialog(null, "Datos vacios, Ingrese los datos", " ", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    // Método para craar Usuarios Maestros
    public void obtenerDataM() throws IOException, ClassNotFoundException {
        // Se toma el usuario del JTextField
        String name = Usuario.getText();
        // Se toma la Contraseña del JTestField
        char[] clave = Contrasena.getPassword();
        String password = new String(clave);

        if (validar) {
            if (!name.equals("") & !password.equals("")) {
                // Obtengo los datos del archivo .bin
                Employees[] employees = serizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataM.bin");

                // obtengo los datos del bibliotecario;
                UsuarioMaestro usuarioMaestro = new UsuarioMaestro(name, password);

                // creo una nueva lista con el tamaño de los empleados más el nuevo que se va h agregar
                Employees[] nuevosEmployees = new Employees[employees.length + 1];

                for (int i = 0; i < employees.length; i++) {
                    nuevosEmployees[i] = employees[i];
                }
                nuevosEmployees[nuevosEmployees.length - 1] = usuarioMaestro;

                serizalizaDeseralizaUs.setDataB(nuevosEmployees, "src/Archivos_Bin/dataM.bin");

                JOptionPane.showMessageDialog(null, "Cuenta creada...", " ", JOptionPane.INFORMATION_MESSAGE);

                for (Employees e : nuevosEmployees) {
                    System.out.println(e);
                }
                System.out.println("\n");

            } else {
                JOptionPane.showMessageDialog(null, "Datos vacios, Ingrese los datos", " ", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void validarUser() {
        // Obtengo los datos de los archivos bin
        HashMap<String, String> usuarioMaestro = new HashMap<>();
        HashMap<String, String> usuarioBibliotecario = new HashMap<>();

        Employees[] tempMaestro = serizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataM.bin");
        Employees[] tempNormal = serizalizaDeseralizaUs.getDataB("src/Archivos_Bin/dataB.bin");

        for (Employees m : tempMaestro) {
            usuarioMaestro.put(m.getKey(), m.getValue());
        }
        for (Employees n : tempNormal) {
            usuarioBibliotecario.put(n.getKey(), n.getValue());
        }

        // Se toma el usuario del JTextField
        String name = Usuario.getText();

        boolean maestroExiste = userExiste(name, usuarioMaestro);
        boolean bibliotecarioExiste = userExiste(name, usuarioBibliotecario);

        if (maestroExiste || bibliotecarioExiste) {
            JOptionPane.showMessageDialog(null, "¡¡ ERROR !!, Usuario ya existe");
        } else {
            validar = true;
        }

        /*NOTA BUG:
         * Si creo dos usuarios, uno como maestro y el otro como normal con el mismo nombre, se van a
         * guardar en los dos archivos .bin.
         * Para evitar esto nos debemos devolver a la ventana anterior y ya no nos permitira guardar
         * con el mismo nombre (si ya existe)*/
    }


    // Método que me retorna si la clave ya existe
    public boolean userExiste(String nameUser, HashMap<String, String> users) {
        return users.containsKey(nameUser); // devuelve true si la calve existe y false si no
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
            validarUser();
            // llamo al método encargado de crear los usuarios
            try {
                obtenerDataB();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            // vaciá los JTextField
            Usuario.setText("");
            Contrasena.setText("");
            cerrar();


        }
        if (jb == cuentaMaestro) {
            validarUser();
            try {
                obtenerDataM();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            // vaciá los JTextField
            Usuario.setText("");
            Contrasena.setText("");
            cerrar();

        }
        if (jb == volver) {
            cerrar();
        }
    }
}
