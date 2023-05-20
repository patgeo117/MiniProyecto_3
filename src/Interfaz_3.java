import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Interfaz_3 extends JFrame {
    // icono
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Recursos/LoginIcon.png")));
    // Jlabel
    JLabel lUsuario;
    JLabel lContraseña;

    // JtextField
    JTextField Usuario;
    JTextField Contraseña;
    // Jbutton
    JButton crearCuenta;
    public Interfaz_3(){
        // Configuración Jlabel
        lUsuario = new JLabel("Usuario");
        lUsuario.setBounds(100,15,100,40);
        add(lUsuario);

        lContraseña = new JLabel("Contraseña");
        lContraseña.setBounds(100,70,100,40);
        add(lContraseña);

        // Configuración JtextField
        Usuario = new JTextField();
        Usuario.setBounds(100,50,100,25);
        add(Usuario);

        Contraseña = new JTextField();
        Contraseña.setBounds(100,105,100,25);
        add(Contraseña);

        // Configuración Jbutton
        crearCuenta = new JButton("Crear Cuenta");
        crearCuenta.setBounds(80,150,150,40);
        crearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(crearCuenta);



        // Configuración de ventana
        setLayout(null);
        setSize(300,250);
        setTitle("Crear Cuenta");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img.getImage());
        setVisible(true);
    }
}
