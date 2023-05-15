package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Interfaz_2 {
    // Ventana
    JFrame Ventana2 = new JFrame();
    // Icono
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("Recursos/IconBiblioteca.png")));
    // panel
    JPanel panel;
    // Botones
    JButton bCrearCuentas;
    JButton bPrestarLibro;
    JButton bRetornarLibro;
    JButton bEstadoLibros;
    JButton bInformacion;
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
        // Configuración Ventana
        Ventana2.setLayout(null);
        Ventana2.setSize(700,700);
        Ventana2.setTitle("Biblioteca");
        Ventana2.setLocationRelativeTo(null);
        Ventana2.setResizable(false);
        Ventana2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Ventana2.setIconImage(img.getImage());
        Ventana2.setVisible(true);

        // Configuracion Panel
        panel = new JPanel();
        panel.setBounds(40,200,600,400);
        panel.setBackground(Color.lightGray);
        Ventana2.add(panel);

        // Configuracion Label
        lCrearCuenta = new JLabel("Crear Cuenta:");
        lCrearCuenta.setBounds(40,610,100,20);
        Ventana2.add(lCrearCuenta);

        lLibroN = new JLabel("LIBRO:");
        lLibroN.setBounds(60,180,100,20);
        Ventana2.add(lLibroN);

        lLibroC = new JLabel("CATEGORÍA:");
        lLibroC.setBounds(200,180,100,20);
        Ventana2.add(lLibroC);

        lLibroS = new JLabel("ESTADO:");
        lLibroS.setBounds(380,180,100,20);
        Ventana2.add(lLibroS);

        lCodigoLibro = new JLabel("CODIGO:");
        lCodigoLibro.setBounds(520,180,100,20);
        Ventana2.add(lCodigoLibro);

        lPrestarLibro = new JLabel("Prestar Libro:");
        lPrestarLibro.setBounds(70,80,100,20);
        Ventana2.add(lPrestarLibro);

        lRetornarLibro = new JLabel("Devolver Libro:");
        lRetornarLibro.setBounds(205,80,100,20);
        Ventana2.add(lRetornarLibro);

        lEstadoLibro = new JLabel("Ver Estado:");
        lEstadoLibro.setBounds(355,80,100,20);
        Ventana2.add(lEstadoLibro);

        lInformacionLibro = new JLabel("Ver Información:");
        lInformacionLibro.setBounds(485,80,100,20);
        Ventana2.add(lInformacionLibro);


        // Configuracion Botones
        bCrearCuentas = new JButton("Crear");
        bCrearCuentas.setBounds(40,630,100,20);
        bCrearCuentas.setBackground(Color.green);
        Ventana2.add(bCrearCuentas);

        bPrestarLibro = new JButton("Prestar");
        bPrestarLibro.setBounds(60,100,100,40);
        bPrestarLibro.setBackground(Color.RED);
        Ventana2.add(bPrestarLibro);

        bRetornarLibro = new JButton("Retornar");
        bRetornarLibro.setBounds(200,100,100,40);
        bRetornarLibro.setBackground(Color.RED);
        Ventana2.add(bRetornarLibro);

        bEstadoLibros = new JButton("Estado");
        bEstadoLibros.setBounds(340,100,100,40);
        bEstadoLibros.setBackground(Color.RED);
        Ventana2.add(bEstadoLibros);

        bInformacion = new JButton("Información");
        bInformacion.setBounds(480,100,100,40);
        bInformacion.setBackground(Color.RED);
        Ventana2.add(bInformacion);



    }

}
