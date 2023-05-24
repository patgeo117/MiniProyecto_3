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
    // JMenuBar
    JMenuBar menuBar;
    JMenu estadoLibro;
    JMenu personasMora;
    JMenuItem mostrar;
    JMenuItem terror;
    JMenuItem novela;
    JMenuItem inge;
    // JLabel
    JLabel lCrearCuenta;

    // Crear un modelo de tabla y agregar los datos
    DefaultTableModel model = new DefaultTableModel(Libros.getData(), Libros.getNomColumnas()) {
        // Se deshabilita la opción de modificar las filas y las columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    // Crear un componente JTable con el modelo de tabla
    JTable table = new JTable(model);

    public Interfaz_2() {

        // Configuración Panel
        panel = new JPanel();
        panel.setBounds(40, 120, 600, 350);
        add(panel);

        // Configuración Jmenubar
        menuBar = new JMenuBar();

        estadoLibro = new JMenu("Estado Libros");
        personasMora = new JMenu("Personas en Mora");

        mostrar = new JMenuItem("Mostrar");
        mostrar.addActionListener(Action2);

        terror = new JMenuItem("Terror");
        terror.addActionListener(Action2);
        novela = new JMenuItem("Novela Clásica");
        novela.addActionListener(Action2);
        inge = new JMenuItem("Ingeniería");
        inge.addActionListener(Action2);

        personasMora.add(mostrar);

        estadoLibro.add(terror);
        estadoLibro.add(novela);
        estadoLibro.add(inge);

        menuBar.add(estadoLibro);
        menuBar.add(personasMora);

        this.setJMenuBar(menuBar);

        // Configuración Label
        lCrearCuenta = new JLabel("Crear Cuenta:");
        lCrearCuenta.setBounds(40, 480, 100, 20);
        lCrearCuenta.setVisible(false);
        add(lCrearCuenta);

        // Configuración Botones
        bCrearCuentas = new JButton("Crear");
        bCrearCuentas.setBounds(40, 500, 100, 20);
        bCrearCuentas.setBackground(Color.green);
        bCrearCuentas.setVisible(false);
        bCrearCuentas.addActionListener(this);
        add(bCrearCuentas);

        bPrestarLibro = new JButton("Prestar");
        bPrestarLibro.setBounds(60, 60, 100, 40);
        bPrestarLibro.setBackground(Color.RED);
        add(bPrestarLibro);

        bRetornarLibro = new JButton("Retornar");
        bRetornarLibro.setBounds(200, 60, 100, 40);
        bRetornarLibro.setBackground(Color.RED);
        add(bRetornarLibro);

        bEstadoLibros = new JButton("Estado");
        bEstadoLibros.setBounds(340, 60, 100, 40);
        bEstadoLibros.setBackground(Color.RED);
        add(bEstadoLibros);

        bInfo = new JButton("Información");
        bInfo.setBounds(480, 60, 100, 40);
        bInfo.setBackground(Color.RED);
        add(bInfo);

        bVolver = new JButton("Volver");
        bVolver.setBounds(10, 10, 75, 30);
        bVolver.setBackground(Color.green);
        bVolver.addActionListener(this);
        add(bVolver);

        // Configuración Ventana
        setLayout(null);
        setSize(700, 600);
        setTitle("Biblioteca");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(img.getImage());
        setVisible(true);


        // Se le dan las dimensiones
        table.setPreferredScrollableViewportSize(new Dimension(600, 300));
        // se añade al panel y además se le agrega el método JScroll para que se visualice de forma correcta
        panel.add(new JScrollPane(table));


    }

    public void Prestarlibro(){
        int indexRow = table.getSelectedRow();
        boolean data = (boolean) model.getValueAt(indexRow, 2);

        for(int i = 0; i<= table.getRowCount(); i++){
            if(data){
                Libros.estado = data;
                break;
            }
        }
    }

    // ActionListener para los Jmenuitem
    ActionListener Action2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Se crea un jmenuitem al cual se le asigna el jmenuitem presionado
            JMenuItem jm = (JMenuItem) e.getSource();

            // Si se presiona el jmenuitem mostrar del jmenu personasMora se
            //mostrara un cuadro de texto con las personas en mora
            if (jm == mostrar) {
                // Print de prueba (Luego se cambiara)
                System.out.println("Presionado mostrar");
            }

            // Al presionar el jmenuitem terror este mostrara un cuadro de txt donde
            // apareceran los nombre y el estado de cada libro de terror
            if (jm == terror) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + Libros.getData()[0][0] + "    Estado: " + Libros.getData()[0][2] + "\n" +
                                "Nombre: " + Libros.getData()[1][0] + "    Estado: " + Libros.getData()[1][2] + "\n" +
                                "Nombre: " + Libros.getData()[2][0] + "    Estado: " + Libros.getData()[2][2] + "\n" +
                                "Nombre: " + Libros.getData()[3][0] + "    Estado: " + Libros.getData()[3][2] + "\n" +
                                "Nombre: " + Libros.getData()[4][0] + "    Estado: " + Libros.getData()[4][2] + "\n", "Estado Libros Terror", JOptionPane.PLAIN_MESSAGE);
            }

            // Al presionar el jmenuitem novela este mostrara un cuadro de txt donde
            // apareceran los nombre y el estado de cada libro de novels Classics
            if (jm == novela) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + Libros.getData()[5][0] + "    Estado: " + Libros.getData()[5][2] + "\n" +
                                "Nombre: " + Libros.getData()[6][0] + "    Estado: " + Libros.getData()[6][2] + "\n" +
                                "Nombre: " + Libros.getData()[7][0] + "    Estado: " + Libros.getData()[7][2] + "\n" +
                                "Nombre: " + Libros.getData()[8][0] + "    Estado: " + Libros.getData()[8][2] + "\n" +
                                "Nombre: " + Libros.getData()[9][0] + "    Estado: " + Libros.getData()[9][2] + "\n", "Estado Libros Novela", JOptionPane.INFORMATION_MESSAGE);
            }

            // Al presionar el jmenuitem inge este mostrara un cuadro de txt donde
            // apareceran los nombre y el estado de cada libro de engineering
            if (jm == inge) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + Libros.getData()[10][0] + "    Estado: " + Libros.getData()[10][2] + "\n" +
                                "Nombre: " + Libros.getData()[11][0] + "    Estado: " + Libros.getData()[11][2] + "\n" +
                                "Nombre: " + Libros.getData()[12][0] + "    Estado: " + Libros.getData()[12][2] + "\n" +
                                "Nombre: " + Libros.getData()[13][0] + "    Estado: " + Libros.getData()[13][2] + "\n" +
                                "Nombre: " + Libros.getData()[14][0] + "    Estado: " + Libros.getData()[14][2] + "\n", "Estado Libros Ingeniería", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {     // ActionListener para los butones
        JButton jb = (JButton) e.getSource();
        if (jb == bCrearCuentas) {
            setVisible(false);
            new Interfaz_3();
        }
        if(jb == bPrestarLibro){
            Prestarlibro();
        }
        if (jb == bVolver) {
            setVisible(false);
            new Interfaz_1();
        }

    }
}
