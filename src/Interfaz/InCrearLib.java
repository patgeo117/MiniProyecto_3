package Interfaz;

import PersistenciaDatos.Libros;
import PersistenciaDatos.ManejoArchivo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InCrearLib extends JFrame implements ActionListener {
    // Jlabel
    JLabel lNombreLibro;
    JLabel lCategoriaLibro;
    JLabel lEstadoLibro;
    // JtextField
    public static JTextField NombreLibro;
    public static JComboBox CategoriaLibro;
    public static JTextField EstadoLibro;

    // Jbutton
    JButton AñadirLibro;
    JButton volver;

    ManejoArchivo manejoArchivo = new ManejoArchivo();

    public InCrearLib(){
        // Configuración Jlabel
        lNombreLibro = new JLabel("Nombre Del Libro");
        lNombreLibro.setBounds(100, 15, 100, 40);
        add(lNombreLibro);

        lCategoriaLibro = new JLabel("Categoría Del Libro");
        lCategoriaLibro.setBounds(100, 70, 120, 40);
        add(lCategoriaLibro);

        lEstadoLibro = new JLabel("Estado Del Libro");
        lEstadoLibro.setBounds(100, 120, 100, 40);
        add(lEstadoLibro);


        // Configuración JtextField
        NombreLibro = new JTextField();
        NombreLibro.setBounds(100, 50, 100, 25);
        add(NombreLibro);

        String[] opciones = {"TERROR", "NOVELAS", "INGENIERÍA"};
        CategoriaLibro = new JComboBox(opciones);
        CategoriaLibro.setBounds(100, 105, 100, 25);
        add(CategoriaLibro);

        EstadoLibro = new JTextField("true");
        EstadoLibro.setBounds(100, 155, 100, 25);
        EstadoLibro.setEditable(false);
        add(EstadoLibro);

        // Configuración Jbutton
        AñadirLibro = new JButton("Añadir Libro");
        AñadirLibro.setBounds(75, 200, 150, 30);
        AñadirLibro.addActionListener(this);
        add(AñadirLibro);

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
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        // Al precionar el botón se toman los datos con la función y muestra una ventana de aprobación
        if (jb == AñadirLibro) {
            String nombres = NombreLibro.getText();
            String categorias = (String) CategoriaLibro.getSelectedItem();
            String estados = EstadoLibro.getText();
            // llamo al método encargado de capturar los datos ingresados
            Libros.agregarLibro(nombres,categorias,estados);

            // Guardo los valores en él .bin
            manejoArchivo.escribirObjeto(Libros.obtenerMatrizLibros());
            // Mensaje
            JOptionPane.showMessageDialog(null, "Libro Añadido...", " ", JOptionPane.INFORMATION_MESSAGE);
            // vaciá los JTextField
            NombreLibro.setText("");
            System.out.println("Libro Creado");
        }
        if(jb == volver){
            setVisible(false);
            new InBiblioteca();
            InBiblioteca.bCrearCuentas.setVisible(true);
            InBiblioteca.lCrearCuenta.setVisible(true);
            InBiblioteca.lDeleteUser.setVisible(true);
            InBiblioteca.bDeleteUser.setVisible(true);
        }
    }
}