import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Interfaz {

    // Ventanas
    JFrame Ventana1 = new JFrame();
    JFrame Ventana2 = new JFrame();
    JFrame Ventana3 = new JFrame();

    // Iconos
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("Recursos/LoginIcon.png")));


    // MenuBar
    JMenuItem Sbibliotecario;
    JMenuItem Nbibliotecario;

    // JText Field
    JTextField txtUsuario;
    JTextField txtContrasena;

    // JLabel
    JLabel lUsuario;
    JLabel lContrasena;
    JLabel lImagen;

    // Jbutton
    JButton bLogin;


    public Interfaz(){

        // Configuracion Ventana 1
        Ventana1.setLayout(null);
        Ventana1.setSize(300,325);
        Ventana1.setTitle("Login");
        Ventana1.setLocationRelativeTo(null);
        Ventana1.setResizable(false);
        Ventana1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Ventana1.setIconImage(img.getImage());
        Ventana1.setVisible(true);


        // Configuracion MenuBar
        JMenuBar mb = new JMenuBar();

        JMenu menuTipoCuenta = new JMenu("Tipo de Cuenta");

        Sbibliotecario = new JMenuItem("Maestro Bibliotecario");
        menuTipoCuenta.add(Sbibliotecario);

        Nbibliotecario = new JMenuItem("Normal Bibliotecario");
        menuTipoCuenta.add(Nbibliotecario);
        menuTipoCuenta.addSeparator();

        mb.add(menuTipoCuenta);
        Ventana1.setJMenuBar(mb);

        // JTextField
        txtUsuario = new JTextField("EMAIL ID...");
        txtUsuario.setBounds(100, 100, 100, 20);
        Ventana1.add(txtUsuario);

        txtContrasena = new JTextField("PASSWORD...");
        txtContrasena.setBounds(100, 140, 100, 20);
        Ventana1.add(txtContrasena);

        // JLabel
        lUsuario = new JLabel();
        lUsuario.setText("Username:");
        lUsuario.setBounds(100,80,100,20);
        Ventana1.add(lUsuario);

        lContrasena = new JLabel();
        lContrasena.setText("Password:");
        lContrasena.setBounds(100,120,100,20);
        Ventana1.add(lContrasena);

        lImagen = new JLabel(img);
        lImagen.setBounds(100,5,100,80);
        Ventana1.add(lImagen);

        // JButton
        bLogin = new JButton();
        bLogin.setText("Log in");
        bLogin.setBackground(Color.BLUE);
        bLogin.setBounds(100,180,100,30);
        Ventana1.add(bLogin);





    }
}
