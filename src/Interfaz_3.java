import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
    JButton crearCuenta;

    List<Bibliotecario> bibliotecarioList = new ArrayList<Bibliotecario>(); // creo una lista de tipo objecto

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
        crearCuenta = new JButton("Crear Cuenta");
        crearCuenta.setBounds(80, 150, 150, 40);
        crearCuenta.addActionListener(this);
        add(crearCuenta);


        // Configuración de ventana
        setLayout(null);
        setSize(300, 250);
        setTitle("Crear Cuenta");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img.getImage());
        setVisible(true);
    }

    public void getData() {
        String user = Usuario.getText();
        char[] clave =  Contrasena.getPassword();
        String password = new String(clave);

        Bibliotecario bibliotecario = new Bibliotecario(user, password);

        bibliotecarioList.add(bibliotecario);

        for(Bibliotecario b : bibliotecarioList){
            System.out.println(b.setName() + " "+b.setPassword());
        }
        System.out.println(" ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if (jb == crearCuenta) {
            getData();
            setVisible(false);
            new Interfaz_1();
        }
    }
}

