package Interfaz;

import Bibliotecarios.Bibliotecario;
import org.w3c.dom.DOMStringList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class InCrearLib extends JFrame implements ActionListener {
    // Jlabel
    JLabel lNombreLibro;
    JLabel lCategoriaLibro;
    JLabel lEstadoLibro;
    // JtextField
    JTextField EstadoLibro;
    JTextField NombreLibro;
    JTextField CategoriaLibro;

    // Jbutton
    JButton AñadirLibro;
    JButton volver;

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

        CategoriaLibro = new JTextField();
        CategoriaLibro.setBounds(100, 105, 100, 25);
        add(CategoriaLibro);

        EstadoLibro = new JTextField(String.valueOf(true));
        EstadoLibro.setBounds(100, 155, 100, 25);
        EstadoLibro.setEditable(false);
        add(EstadoLibro);

        // Configuración Jbutton
        AñadirLibro = new JButton("Crear Bibliotecario");
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
    public void dataLibros() {
        // creo un HashMap que va a recibit los datos por defecto de getData() (método que lee el bin);
        Object[][] dataBibliotecarios = getDataB();

        // Se toma el Nombre y la categoría del JTextField
        String nombreLibro = NombreLibro.getText();
        String categoriaLibro = CategoriaLibro.getText();

        // Se toma el estado del JTestField
        String estadoLibro = EstadoLibro.getText();

        // Agrego nuevos  datos al Hasmap
        Object[] nuevoLibro = {nombreLibro,categoriaLibro,estadoLibro};
        //dataBibliotecarios.wait(nuevoLibro);

        // Guardo los datos en el bin
        setDataB(dataBibliotecarios);
    }
    public static void setDataB(Object[][] data) {

        try {
            FileOutputStream outputB = new FileOutputStream("src/Archivos_Bin/Libros.bin");
            ObjectOutputStream modifiB = new ObjectOutputStream(outputB);

            modifiB.writeObject(data);

            modifiB.close();
            outputB.close();

        } catch (Exception io) {
            io.printStackTrace();
        }
    }
    public Object[][] getDataB() {
        // creo un nuevo HasMap que captura los datos del bin
        //Object[]Ñ newObjeto = new Object();
        try {
            File file = new File("src/Archivos_Bin/Libros.bin");
            // Válido que el archivo exista
            if (file.exists()) {
                FileInputStream inputB = new FileInputStream(file);
                ObjectInputStream leerB = new ObjectInputStream(inputB);

                // leo el archivo y agregó los valores al HashMap
                //newObjeto = (Object[][]) leerB.readObject();

                leerB.close();
                inputB.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // retorno los datos del bin
        return null;
    }
    public static String[] getNomColumnas() {
        return new String[]{"Título", "Categoría", "Estado"};
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        // Al precionar el botón se toman los datos con la función y muestra una ventana de aprobación
        if (jb == AñadirLibro) {
            // llamo al método encargado de capturar los datos ingresados
            dataLibros();
            JOptionPane.showMessageDialog(null, "Libro Añadido...", " ", JOptionPane.INFORMATION_MESSAGE);
            // vaciá los JTextField
            NombreLibro.setText("");
            CategoriaLibro.setText("");
            System.out.println("Libro Creado");
        }
        if(jb == volver){
            setVisible(false);
            new InBiblioteca();
        }
    }

    public static void main(String[] args) {
        new InCrearLib();
    }
}
