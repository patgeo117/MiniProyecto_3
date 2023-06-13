package PersistenciaDatos;

import java.io.Serializable;

public class Libros implements Serializable {
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
            {"Structural Analysis", "INGENIERÍA", true},
            {"Introduction to Electrical Engineering", "INGENIERÍA", true}
    };

    // Método para pasarle los datos al model y al Jtable
    public static Object[][] getDataRow() {
        return data;
    }

    // Crear los nombres de las columnas
    public static String[] getNomColumnas() {
        return new String[]{"Título", "Categoría", "Estado", "Código"};
    }
}

