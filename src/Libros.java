public class Libros {
    static boolean estado = true;
    static Object[][] data;

    public static Object[][] getData() {
        data = new Object[][] {
                {"El resplandor", "TERROR", estado, 101},
                {"It", "TERROR", estado, 102},
                {"El Exorcista", "TERROR", estado, 103},
                {"Pet Sematary", "TERROR", estado, 104},
                {"Frankenstein", "TERROR", estado, 105},
                {"Cien años de soledad", "NOVELA", estado, 106},
                {"1984", "NOVELA", estado, 107},
                {"El gran Gatsby", "NOVELA", estado, 108},
                {"Orgullo y prejuicio", "NOVELA", estado, 109},
                {"Don Quijote de la Mancha", "NOVELA", estado, 110},
                {"Circuit Analysis: Theory and Practice", "INGENIERÍA", estado, 111},
                {"Mechanics of Materials", "INGENIERÍA", estado, 112},
                {"Introduction to Chemical Engineering Thermodynamics", "INGENIERÍA", estado, 113},
                {"Structural Analysis", "INGENIERÍA", estado, 114},
                {"Introduction to Electrical Engineering", "INGENIERÍA", estado, 115}
        };
        return data;
    }

    // Crear los nombres de las columnas
    public static String[] getNomColumnas() {

        return new String[]{"Título", "Categoría", "Estado", "Código"};
    }
}

