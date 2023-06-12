import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Interfaz_3 extends JFrame implements ActionListener {
    // icono
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Recursos/LoginIcon.png")));
    // Jlabel
    JLabel lUsuario;
    JLabel lContrasena;
    // JtextField
    JTextField Usuario;
    JPasswordField Contrasena;
    // Jbutton
    JButton cuentaUsusario;
    JButton cuentaMaestro;
    JButton volver;

    public Interfaz_3() {
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
        cuentaUsusario = new JButton("Crear Bibliotecario");
        cuentaUsusario.setBounds(75, 160, 150, 30);
        cuentaUsusario.addActionListener(this);
        add(cuentaUsusario);

        cuentaMaestro = new JButton("Crear Master");
        cuentaMaestro.setBounds(90,200,120,30);
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

    public void getDataB() {
        // Se toma el usuario del JTextField
        String name = Usuario.getText();
        // Se toma la Contraseña del JTestField
        char[] clave = Contrasena.getPassword();
        String password = new String(clave);
        // Le envió los datos a Bibliotecario
        Bibliotecario bibliotecario = new Bibliotecario(name, password);
    }
    public void getDataM(){
        // Se toma el usuario del JTextField
        String name = Usuario.getText();
        // Se toma la Contraseña del JTestField
        char[] clave = Contrasena.getPassword();
        String password = new String(clave);
        // Se le envia los datos a UsusarioMaestro
        UsuarioMaestro usuarioMaestro = new UsuarioMaestro(name,password);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        // Al precionar el boton se toman los datos con la funcion y muestra una venana de aprovación
        if (jb == cuentaUsusario) {
            getDataB();
            JOptionPane.showMessageDialog(null, "Cuenta creada...", " ",JOptionPane.INFORMATION_MESSAGE);
            // vacia los JTextField
            Usuario.setText("");
            Contrasena.setText("");
            System.out.println("Usuario normal creado");

        }
        if (jb == cuentaMaestro){
            getDataM();
            JOptionPane.showMessageDialog(null, "Cuenta creada...", " ",JOptionPane.INFORMATION_MESSAGE);
            // vacia los JTextField
            Usuario.setText("");
            Contrasena.setText("");
            System.out.println("Usuario Maestro Creado");
        }
        if (jb == volver){
            setVisible(false);
            Interfaz_2 interfaz2 = new Interfaz_2();
            interfaz2.bCrearCuentas.setVisible(true);
            interfaz2.lCrearCuenta.setVisible(true);
        }
    }
}


