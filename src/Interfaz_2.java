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
    DefaultTableModel model = new DefaultTableModel(Libros.getDataRow(), Libros.getNomColumnas()) {
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
        bPrestarLibro.setBounds(100, 60, 100, 40);
        bPrestarLibro.setBackground(Color.RED);
        bPrestarLibro.addActionListener(this);
        add(bPrestarLibro);

        bRetornarLibro = new JButton("Retornar");
        bRetornarLibro.setBounds(240, 60, 100, 40);
        bRetornarLibro.setBackground(Color.RED);
        bRetornarLibro.addActionListener(this);
        add(bRetornarLibro);

        bInfo = new JButton("Información");
        bInfo.setBounds(380, 60, 100, 40);
        bInfo.setBackground(Color.RED);
        bInfo.addActionListener(this);
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
    public void MostrarInfo(){
        // creo un iterador para recorrer multa, ListIterator recorre en cualquier dirección la lista (es un puntero)
        ListIterator<Integer> data = Prestamo.multa.listIterator();
        // StringBuilder permite concatenar diferentes cadenas de texto sin crear un nuevo object (es mutable, permite modificar su estado)
        StringBuilder deudores = new StringBuilder();
        boolean hayDeudores = false;

        while (data.hasNext()) { // Me aseguro que recorra el data
            int multa = data.next(); // recorro el siguiente dato
            if (multa > 0) {
                hayDeudores = true;
                // Construir una cadena con la información de los deudores
                deudores.append("Usuario: ").append(Prestamo.user).append(" con el libro ").append(Prestamo.book)
                        .append(", tiene una multa: ").append(Prestamo.multa).append(" por ").append(Prestamo.DiasAtraso).append(" dias");
            }
            break;
        }
        if (hayDeudores) {
            // se añade los append a el JOpcionPanel
            JOptionPane.showMessageDialog(null, deudores.toString());
        }
    }

    public void Prestarlibro() {
        int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
        boolean data = (boolean) model.getValueAt(indexRow, 2); // obtengo el valor de la posición deseada
        for (int i = 0; i <= table.getRowCount(); i++) {
            if (data && indexRow == i){ // validó que data = true y esté seleccionada la fila = i para evitar desbordamientos
                model.setValueAt(false, indexRow, 2); // Muestro el dato en la tabla
                Libros.data[i][2] = false; // actualizo el dato en la matriz
                break; // aseguro que termine la ejecución si ejecuta el bloque de código
            } else if (!data && indexRow == i) { //
                JOptionPane.showMessageDialog(null, "El libro N0 Esta Disponible");
                break;
            }
        }

        model.fireTableDataChanged(); // Actualiza la tabla

    }

    public void RetornarLibro() {
        int indexRow = table.getSelectedRow();

        for (int i = 0; i < table.getRowCount(); i++) {
            if (indexRow == i) {
                boolean data = (boolean) model.getValueAt(i, 2);
                String usuario = JOptionPane.showInputDialog(null, "Ingresa tu nombre");

                if (!data) { // data == false
                    int dias = Integer.parseInt(JOptionPane.showInputDialog(null, "Días que fue prestado el libro"));
                    int diasAtraso = dias - 7;
                    String libro = (String) model.getValueAt(i, 0); // Obtengo el nombre del libro de acuerdo a la celda seleccionada

                    model.setValueAt(true, indexRow, 2);
                    Libros.data[i][2] = true;

                    if (diasAtraso > 0) {
                        int multa = diasAtraso * 1000;
                        Prestamo.DiasAtraso.add(diasAtraso);
                        // Mando los datos al constructor de la instancia
                        new Prestamo(usuario, libro, multa);
                        for(int ignored : Prestamo.multa){ // recorro con el forech las multas
                            JOptionPane.showMessageDialog(null, usuario + " por demora en la entrega tiene una multa de: " + multa);
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se debe cobrar ninguna multa.");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El libro ya está en la biblioteca");
                }
                break;
            }
        }
        model.fireTableDataChanged();
    }

    // ActionListener para los Jmenuitem
    ActionListener Action2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Se crea un jmenuitem al cual se le asigna el jmenuitem presionado
            JMenuItem jm = (JMenuItem) e.getSource();

            // Sí se presiona el jmenuitem mostrar del jmenu personasMora
            if (jm == mostrar) {
                // creo un iterador para recorrer multa, ListIterator recorre en cualquier dirección la lista (es un puntero)
                ListIterator<Integer> data = Prestamo.multa.listIterator();
                // StringBuilder permite concatenar diferentes cadenas de texto sin crear un nuevo object (es mutable, permite modificar su estado)
                StringBuilder deudores = new StringBuilder();
                boolean hayDeudores = false;

                while (data.hasNext()) { // Me aseguro que recorra el data
                    int multa = data.next(); // itero sobre la lista
                    if (multa > 0) {
                        hayDeudores = true;
                        // Construir una cadena con la información de los deudores con StringBuilder
                        deudores.append("Prestamo de ").append(Prestamo.book).append(" a ").append(Prestamo.user)
                                .append(", multa: ").append(Prestamo.multa).append("\n");
                    }
                    break;
                }
                // Mostrar cuadro de texto con los deudores cuando es true
                if (hayDeudores) {
                    JOptionPane.showMessageDialog(null, deudores.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Sin deudores");
                }
            }

            // Al presionar el jmenuitem terror este mostrará un cuadro de txt donde
            // apareceran los nombre y el estado de cada libro de terror
            if (jm == terror) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + Libros.data[0][0] + "    Estado: " + Libros.data[0][2] + "\n" +
                                "Nombre: " + Libros.data[1][0] + "    Estado: " + Libros.data[1][2] + "\n" +
                                "Nombre: " + Libros.data[2][0] + "    Estado: " + Libros.data[2][2] + "\n" +
                                "Nombre: " + Libros.data[3][0] + "    Estado: " + Libros.data[3][2] + "\n" +
                                "Nombre: " + Libros.data[4][0] + "    Estado: " + Libros.data[4][2] + "\n", "Estado Libros Terror", JOptionPane.PLAIN_MESSAGE);
            }

            // Al presionar el jmenuitem novela este mostrará un cuadro de txt donde
            // apareceran los nombre y el estado de cada libro de novels Classics
            if (jm == novela) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + Libros.data[5][0] + "    Estado: " + Libros.data[5][2] + "\n" +
                                "Nombre: " + Libros.data[6][0] + "    Estado: " + Libros.data[6][2] + "\n" +
                                "Nombre: " + Libros.data[7][0] + "    Estado: " + Libros.data[7][2] + "\n" +
                                "Nombre: " + Libros.data[8][0] + "    Estado: " + Libros.data[8][2] + "\n" +
                                "Nombre: " + Libros.data[9][0] + "    Estado: " + Libros.data[9][2] + "\n", "Estado Libros Novela", JOptionPane.PLAIN_MESSAGE);
            }

            // Al presionar el jmenuitem inge este mostrará un cuadro de txt donde
            // apareceran los nombre y el estado de cada libro de engineering
            if (jm == inge) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + Libros.data[10][0] + "    Estado: " + Libros.data[10][2] + "\n" +
                                "Nombre: " + Libros.data[11][0] + "    Estado: " + Libros.data[11][2] + "\n" +
                                "Nombre: " + Libros.data[12][0] + "    Estado: " + Libros.data[12][2] + "\n" +
                                "Nombre: " + Libros.data[13][0] + "    Estado: " + Libros.data[13][2] + "\n" +
                                "Nombre: " + Libros.data[14][0] + "    Estado: " + Libros.data[14][2] + "\n", "Estado Libros Ingeniería", JOptionPane.PLAIN_MESSAGE);
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {     // ActionListener para los botones
        JButton jb = (JButton) e.getSource();
        if (jb == bCrearCuentas) {
            setVisible(false);
            new Interfaz_3();
        }
        if (jb == bPrestarLibro) {
            Prestarlibro();
        }
        if (jb == bVolver) {
            setVisible(false);
            new Interfaz_1();
        }
        if (jb == bRetornarLibro) {
            RetornarLibro();
        }
        if(jb == bInfo){
            MostrarInfo();
        }
    }
}