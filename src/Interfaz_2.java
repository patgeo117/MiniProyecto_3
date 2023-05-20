import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.lang.*;

public class Interfaz_2 extends JFrame implements ActionListener {
    // Icono
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Recursos/IconBiblioteca.png")));
    // panel
    JPanel panel;
    // Botones
    JButton bCrearCuentas;
    JButton bPrestarLibro;
    JButton bRetornarLibro;
    JButton bEstadoLibros;
    JButton bInformacion;
    JButton bVolver;
    // Label
    JLabel lCrearCuenta;
    JLabel lLibroN;
    JLabel lLibroC;
    JLabel lLibroS;
    JLabel lCodigoLibro;
    JLabel lPrestarLibro;
    JLabel lRetornarLibro;
    JLabel lEstadoLibro;
    JLabel lInformacionLibro;
    JLabel lTitulo;
    public Interfaz_2(){

        // Configuración Panel
        panel = new JPanel();
        panel.setBounds(40,200,600,400);
        panel.setBackground(Color.lightGray);
        add(panel);

        // Configuración Label
        lCrearCuenta = new JLabel("Crear Cuenta:");
        lCrearCuenta.setBounds(40,610,100,20);
        lCrearCuenta.setVisible(false);
        add(lCrearCuenta);

        lLibroN = new JLabel("LIBRO:");
        lLibroN.setBounds(60,180,100,20);
        add(lLibroN);

        lLibroC = new JLabel("CATEGORÍA:");
        lLibroC.setBounds(200,180,100,20);
        add(lLibroC);

        lLibroS = new JLabel("ESTADO:");
        lLibroS.setBounds(380,180,100,20);
        add(lLibroS);

        lCodigoLibro = new JLabel("CODIGO:");
        lCodigoLibro.setBounds(520,180,100,20);
        add(lCodigoLibro);

        lPrestarLibro = new JLabel("Prestar Libro:");
        lPrestarLibro.setBounds(70,80,100,20);
        add(lPrestarLibro);

        lRetornarLibro = new JLabel("Devolver Libro:");
        lRetornarLibro.setBounds(205,80,100,20);
        add(lRetornarLibro);

        lEstadoLibro = new JLabel("Ver Estado:");
        lEstadoLibro.setBounds(355,80,100,20);
        add(lEstadoLibro);

        lInformacionLibro = new JLabel("Ver Información:");
        lInformacionLibro.setBounds(485,80,100,20);
        add(lInformacionLibro);

        // Configuración Botones
        bCrearCuentas = new JButton("Crear");
        bCrearCuentas.setBounds(40,630,100,20);
        bCrearCuentas.setBackground(Color.green);
        bCrearCuentas.setVisible(false);
        bCrearCuentas.addActionListener(this);
        add(bCrearCuentas);

        bPrestarLibro = new JButton("Prestar");
        bPrestarLibro.setBounds(60,100,100,40);
        bPrestarLibro.setBackground(Color.RED);
        add(bPrestarLibro);

        bRetornarLibro = new JButton("Retornar");
        bRetornarLibro.setBounds(200,100,100,40);
        bRetornarLibro.setBackground(Color.RED);
        add(bRetornarLibro);

        bEstadoLibros = new JButton("Estado");
        bEstadoLibros.setBounds(340,100,100,40);
        bEstadoLibros.setBackground(Color.RED);
        add(bEstadoLibros);

        bInformacion = new JButton("Información");
        bInformacion.setBounds(480,100,100,40);
        bInformacion.setBackground(Color.RED);
        add(bInformacion);

        bVolver = new JButton("Volver");
        bVolver.setBounds(10,10,75,30);
        bVolver.setBackground(Color.green);
        bVolver.addActionListener(this);
        add(bVolver);

        // Configuración Ventana
        setLayout(null);
        setSize(700,700);
        setTitle("Biblioteca");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img.getImage());
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if(jb == bCrearCuentas){
            new Interfaz_3();
        }
        if(jb == bVolver){
            dispose();
            new Interfaz_1();
        }
    }
}
