public class Libros {
    static Object[][] data = new Object[][] {
        {"El resplandor", "TERROR", true, 101},
        {"It", "TERROR", true, 102},
        {"El Exorcista", "TERROR", true, 103},
        {"Pet Sematary", "TERROR", true, 104},
        {"Frankenstein", "TERROR", true, 105},
        {"Cien años de soledad", "NOVELA", true, 106},
        {"1984", "NOVELA", true, 107},
        {"El gran Gatsby", "NOVELA", true, 108},
        {"Orgullo y prejuicio", "NOVELA", true, 109},
        {"Don Quijote de la Mancha", "NOVELA", true, 110},
        {"Circuit Analysis: Theory and Practice", "INGENIERÍA", true, 111},
        {"Mechanics of Materials", "INGENIERÍA", true, 112},
        {"Introduction to Chemical Engineering Thermodynamics", "INGENIERÍA", true, 113},
        {"Structural Analysis", "INGENIERÍA", true, 114},
        {"Introduction to Electrical Engineering", "INGENIERÍA", true, 115}};

    public static Object[][] getDataRow() {
        Object[][] data1 = data;
        return data1;
    }

    // Crear los nombres de las columnas
    public static String[] getNomColumnas() {

        return new String[]{"Título", "Categoría", "Estado", "Código"};
    }
}

