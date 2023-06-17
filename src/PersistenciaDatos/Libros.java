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

}

