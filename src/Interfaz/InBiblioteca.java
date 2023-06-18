package Interfaz;

import Filtros.filtro;
import PersistenciaDatos.ManejoArchivo;
import Customers.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InBiblioteca extends JFrame implements ActionListener {
    // Icono
    ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Imagenes/IconBiblioteca.png")));

    // panel
    JPanel panel;

    // Botones
    static JButton bCrearCuentas;
    JButton bPrestarLibro;
    JButton bRetornarLibro;
    JButton bInfo;
    JButton bVolver;
    JButton bCrearLib;
    static JButton bDeleteBook;
    static JButton bDeleteUser;

    // JMenuBar
    JMenuBar menuBar;
    JMenu estadoLibro;
    JMenu personasMora;
    JMenuItem mostrar;
    JMenuItem terror;
    JMenuItem novela;
    JMenuItem inge;

    // JLabel
    static JLabel lCrearCuenta;
    static JLabel lDeleteUser;

    // se inicializan las clases
    ArchivoCustomers archivoCustomers = new ArchivoCustomers();
    ManejoArchivo manejoArchivo = new ManejoArchivo();
    filtro filtros = new filtro();

    // Crear un modelo de tabla y agregar los datos
    DefaultTableModel model = new DefaultTableModel(manejoArchivo.leerObjeto(), manejoArchivo.getNomColumnas()) {
        // Se deshabilita la opción de modificar las filas y las columnas
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    // Crear un componente JTable con el modelo de tabla
    JTable table = new JTable(model);

    public InBiblioteca() {

        // Configuración Panel
        panel = new JPanel();
        panel.setBounds(40, 120, 620, 350);
        add(panel);

        // Configuración Jmenubar
        menuBar = new JMenuBar();

        estadoLibro = new JMenu("Estado");
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

        lDeleteUser = new JLabel("Eliminar Cuenta:");
        lDeleteUser.setBounds(160, 480, 100, 20);
        lDeleteUser.setVisible(false);
        add(lDeleteUser);

        // Configuración Botones
        bCrearCuentas = new JButton("Crear");
        bCrearCuentas.setBounds(40, 500, 100, 20);
        bCrearCuentas.setBackground(Color.green);
        bCrearCuentas.setVisible(false);
        bCrearCuentas.addActionListener(this);
        add(bCrearCuentas);

        bDeleteUser = new JButton("Eliminar");
        bDeleteUser.setBounds(160, 500, 100, 20);
        bDeleteUser.setBackground(Color.green);
        bDeleteUser.setVisible(false);
        bDeleteUser.addActionListener(this);
        add(bDeleteUser);

        bDeleteBook = new JButton("Eliminar Libro");
        bDeleteBook.setBounds(360, 500, 120, 20);
        bDeleteBook.setBackground(Color.red);
        bDeleteBook.setVisible(false);
        bDeleteBook.addActionListener(this);
        add(bDeleteBook);

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

        bCrearLib = new JButton("Añadir Libro");
        bCrearLib.setBounds(520, 60, 120, 40);
        bCrearLib.setBackground(Color.RED);
        bCrearLib.addActionListener(this);
        add(bCrearLib);

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

    public void MostrarInfo() {
        // Mostrar información
        JOptionPane.showMessageDialog(null, archivoCustomers.getDataC("src/Archivos_Bin/dataCustomers.bin"));
    }

    public Object[][] DatosTabla() {
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Obtener el número de filas y columnas en la tabla
        int numRows = model.getRowCount();
        int numCols = model.getColumnCount();

        // Crear un arreglo bidimensional para almacenar los datos
        Object[][] data = new Object[numRows][numCols];

        // Recorrer cada fila y columna de la tabla y almacenar los datos en el arreglo
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                data[row][col] = model.getValueAt(row, col);
            }
        }

        // Retornar los datos como un Object[][]
        return data;
    }


    public void Prestarlibro() {
        int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada

        if (indexRow >= 0) {
            String estado = (String) model.getValueAt(indexRow, 2); // obtengo el valor de la posición deseada
            if (Objects.equals(estado, "true")) {
                // Register customer
                Clientes[] clientes = archivoCustomers.getDataC("src/Archivos_Bin/dataCustomers.bin");

                String libro = (String) model.getValueAt(indexRow, 0);
                String cliente = JOptionPane.showInputDialog(null, "Nombre: ");
                String fechainicio = JOptionPane.showInputDialog(null, "dd / MM / yyyy");
                String id = JOptionPane.showInputDialog(null, "Ingresa tu NIT");

                if (!(cliente.equals("") || fechainicio.equals("") || id.equals(""))) {

                    Clientes addCliente = new Clientes(cliente, libro, id, fechainicio, "00/00/00", 0);

                    Clientes[] newClientes = new Clientes[clientes.length + 1];

                    for (int i = 0; i < clientes.length; i++) {
                        newClientes[i] = clientes[i];
                    }
                    newClientes[newClientes.length - 1] = addCliente; //agregó el nuevo dato en la última posición

                    archivoCustomers.setDataC(newClientes, "src/Archivos_Bin/dataCustomers.bin");

                    for (Clientes c : newClientes) {
                        System.out.println(c);
                    }
                    // Select Book
                    model.setValueAt("false", indexRow, 2); // Muestro el dato en la tabla

                    model.fireTableDataChanged(); // Actualiza la tabla
                    manejoArchivo.setObjeto(DatosTabla()); // Actualiza el .bin

                } else {
                    JOptionPane.showMessageDialog(null, "Datos vacios");
                }

            } else {
                JOptionPane.showMessageDialog(null, "El libro no se encuentra disponible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        }
    }

    public void RetornarLibro() throws ParseException {
        int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
        if (indexRow >= 0) {
            String estado = (String) model.getValueAt(indexRow, 2); // obtengo el valor de la posición deseada

            if (Objects.equals(estado, "false")) { // Valido que el estado este en  true
                // Register customer
                Clientes[] clientes = archivoCustomers.getDataC("src/Archivos_Bin/dataCustomers.bin");

                String libro = (String) model.getValueAt(indexRow, 0); // obtengo el nombre del libro
                String id = JOptionPane.showInputDialog(null, "Ingrese su nit ");

                if (!Objects.equals(id, "")) {
                    boolean clienteValido = false;
                    String fechaFin = JOptionPane.showInputDialog(null, "dd / MM / yyyy");
                    if (!Objects.equals(fechaFin, "")) {
                        for (int i = 0; i < clientes.length; i++) {
                            // valido el id y el nombre del libro correspondan
                            if (clientes[i].getId().equals(id) && clientes[i].getLibro().equals(libro)) {
                                clienteValido = true;
                                clientes[i].setFechaFin(fechaFin); // Actualizar la deuda del cliente
                                JOptionPane.showMessageDialog(null, "# " + clientes[i].getId() + " devueñve:\n" + clientes[i].getLibro());
                                break;
                            }
                        }
                    }
                    if (!clienteValido) {
                        JOptionPane.showMessageDialog(null, "Datos incorrectso");
                    } else {
                        archivoCustomers.setDataC(clientes, "src/Archivos_Bin/dataCustomers.bin");
                        model.setValueAt("true", indexRow, 2); // Muestro el dato en la tabla
                    }
                    model.fireTableDataChanged(); // Actualiza la tabla
                    manejoArchivo.setObjeto(DatosTabla()); // Actualiza el .bin
                } else {
                    JOptionPane.showMessageDialog(null, "Datos vacios");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El libro se encuentra Disponible");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila");
        }
    }

    public void EliminarLibro() {
        if (table.getSelectedRow() >= 0) {
            int indexRow = table.getSelectedRow(); // Obtengo la fila seleccionada
            String estado = (String) model.getValueAt(indexRow, 2); // obtengo el valor de la posición deseada
            //if (Objects.equals(estado, "true")) {
                model.removeRow(indexRow);
                model.fireTableDataChanged(); // Actualiza la tabla
                manejoArchivo.setObjeto(DatosTabla()); // Actualiza el .bin
            //} else {
                //JOptionPane.showMessageDialog(null, "El libro se encuentra prestado");
           // }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila en la tabla.");
        }
    }

    // ActionListener para los Jmenuitem
    ActionListener Action2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            // Se crea un jmenuitem al cual se le asigna el jmenuitem presionado
            JMenuItem jm = (JMenuItem) e.getSource();

            // Sí se presiona el Jmenuitem mostrar del jmenu personasMora
            if (jm == mostrar) {
                Clientes[] clientes = archivoCustomers.getDataC("src/Archivos_Bin/dataCustomers.bin");
                HashMap<String, Integer> deudores = new HashMap<>();
                for (Clientes cliente : clientes) {
                    try {
                        if (cliente.getDeuda() > 0) {
                            deudores.put(cliente.getId(), cliente.getDeuda());
                        }
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                StringBuilder info = new StringBuilder(); // cadena mutable
                if (!deudores.isEmpty()) { // valido que halla datos en el hasMap
                    for (Map.Entry<String, Integer> deudor : deudores.entrySet()) {
                        String key = deudor.getKey();
                        Integer value = deudor.getValue();
                        info.append("ID: ").append(key).append(" tiene una deuda de: ").append(value).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, info.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los clientes a paz y salvó");

                }
            }
            // Mostrar estado de los libros por categoría
            if (jm == terror) {
                JTable terrores = new JTable(model);// Se crea una tabla y se le pasa el modelo
                TableRowSorter<TableModel> Filtro = new TableRowSorter<>(model); // Se crea un sorter para organizar los datos
                terrores.setRowSorter(Filtro); // le aplico el filtro a la tabla
                Filtro.setRowFilter(filtros.filter1); // Llamo a la función que me filtra los datos por categoria
                terrores.setBounds(30, 20, 500, 200);
                InEstadoLibros estadoLibros = new InEstadoLibros();
                estadoLibros.panel.add(new JScrollPane(terrores));

            }
            if (jm == novela) {
                JTable novelas = new JTable(model);
                new JScrollPane(novelas);
                TableRowSorter<TableModel> Filtro = new TableRowSorter<>(model);
                novelas.setRowSorter(Filtro);
                Filtro.setRowFilter(filtros.filter2);
                novelas.setBounds(30, 20, 500, 200);
                InEstadoLibros estadoLibros = new InEstadoLibros();
                estadoLibros.panel.add(new JScrollPane(novelas));
            }
            if (jm == inge) {
                JTable ingenieria = new JTable(model);
                new JScrollPane(ingenieria);
                TableRowSorter<TableModel> Filtro = new TableRowSorter<>(model);
                ingenieria.setRowSorter(Filtro);
                Filtro.setRowFilter(filtros.filter3);
                ingenieria.setBounds(30, 20, 500, 200);
                InEstadoLibros estadoLibros = new InEstadoLibros();
                estadoLibros.panel.add(new JScrollPane(ingenieria));
            }
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {   // ActionListener para los botones
        JButton jb = (JButton) e.getSource();
        if (jb == bCrearCuentas) {
            setVisible(false);
            new InCrearUs();
        }
        if (jb == bDeleteUser) {
            setVisible(false);
            new InDeleteUs();
        }
        if (jb == bPrestarLibro) {
            try {
                Prestarlibro();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (jb == bVolver) {
            setVisible(false);
            new InLogin();
        }
        if (jb == bRetornarLibro) {
            try {
                RetornarLibro();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        if (jb == bInfo) {
            MostrarInfo();
        }
        if (jb == bCrearLib) {
            setVisible(false);
            new InCrearLib();
        }
        if (jb == bDeleteBook) {
            EliminarLibro();
        }
    }
}