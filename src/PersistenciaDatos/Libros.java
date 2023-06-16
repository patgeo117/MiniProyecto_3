package PersistenciaDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Libros implements Serializable {

    public static List<Object[]> listaLibros = new ArrayList<>();

    public static void agregarLibro(String nombre, String categoria, String estado) {
        Object[] libro = {nombre, categoria, estado};
        listaLibros.add(libro);
    }

    public static Object[][] obtenerMatrizLibros() {
        int numFilas = listaLibros.size();
        Object[][] matrizLibros = new Object[numFilas][3];
        for (int i = 0; i < numFilas; i++) {
            matrizLibros[i] = listaLibros.get(i);
        }
        return matrizLibros;
    }


    // se crea la base de datos de los libros
    public static Object[][] data = new Object[][] {
            {"El resplandor", "TERROR", true},
            {"It", "TERROR", true},
            {"El Exorcista", "TERROR", true},
            {"Pet Sematary", "TERROR", true},
            {"Frankenstein", "TERROR", true},
            {"Cien años de soledad", "NOVELA", true},
            {"1984", "NOVELA", true},
            {"El gran Gatsby", "NOVELA", true},
            {"Orgullo y prejuicio", "NOVELA", true},
            {"Don Quijote de la Mancha", "NOVELA", true},
            {"Circuit Analysis: Theory and Practice", "INGENIERÍA", true},
            {"Mechanics of Materials", "INGENIERÍA", true},
            {"Introduction to Chemical Engineering Thermodynamics", "INGENIERÍA", true},
            {"Structural Analysis", "INGENIERÍA", true},
            {"Introduction to Electrical Engineering", "INGENIERÍA", true}
    };
}

