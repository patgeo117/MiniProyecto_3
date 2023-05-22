import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    JButton bInfo;
    JButton bVolver;
    // Label
    JLabel lCrearCuenta;

    public Interfaz_2(){

        // Configuración Panel
        panel = new JPanel();
        panel.setBounds(40,120,600,350);
        add(panel);

        // Configuración Label
        lCrearCuenta = new JLabel("Crear Cuenta:");
        lCrearCuenta.setBounds(40,480,100,20);
        lCrearCuenta.setVisible(false);
        add(lCrearCuenta);

        // Configuración Botones
        bCrearCuentas = new JButton("Crear");
        bCrearCuentas.setBounds(40,500,100,20);
        bCrearCuentas.setBackground(Color.green);
        bCrearCuentas.setVisible(false);
        bCrearCuentas.addActionListener(this);
        add(bCrearCuentas);

        bPrestarLibro = new JButton("Prestar");
        bPrestarLibro.setBounds(60,60,100,40);
        bPrestarLibro.setBackground(Color.RED);
        add(bPrestarLibro);

        bRetornarLibro = new JButton("Retornar");
        bRetornarLibro.setBounds(200,60,100,40);
        bRetornarLibro.setBackground(Color.RED);
        add(bRetornarLibro);

        bEstadoLibros = new JButton("Estado");
        bEstadoLibros.setBounds(340,60,100,40);
        bEstadoLibros.setBackground(Color.RED);
        add(bEstadoLibros);

        bInfo = new JButton("Información");
        bInfo.setBounds(480,60,100,40);
        bInfo.setBackground(Color.RED);
        add(bInfo);

        bVolver = new JButton("Volver");
        bVolver.setBounds(10,10,75,30);
        bVolver.setBackground(Color.green);
        bVolver.addActionListener(this);
        add(bVolver);

        // Configuración Ventana
        setLayout(null);
        setSize(700,600);
        setTitle("Biblioteca");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img.getImage());
        setVisible(true);

        // Crear los nombres de las columnas
        String[] columnNames = {"Título", "Categoría", "Estado", "Código"};
        // Crear un modelo de tabla y agregar los datos
        DefaultTableModel model = new DefaultTableModel(Libros.getData(), columnNames);
        // Crear un componente JTable con el modelo de tabla
        JTable table = new JTable(model);
        // Se le dan las dimensiones
        table.setPreferredScrollableViewportSize(new Dimension(600,300));
        // se añade al panel y además se le agrega el método JScroll para que se visualice de forma correcta
        panel.add(new JScrollPane(table));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        if(jb == bCrearCuentas){
            setVisible(false);
            new Interfaz_3();
        }
        if(jb == bVolver){
            setVisible(false);
            new Interfaz_1();
        }
    }
}
