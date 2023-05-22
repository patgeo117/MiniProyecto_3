public class Libros {
    static boolean Disponible = true;
    static boolean NoDisponible = false;
    static Object[][] data;

    public static Object[][] getData() {
        data = new Object[][] {
                {"El resplandor", "TERROR", Disponible, 101},
                {"It", "TERROR", "No Disponible", 102},
                {"El Exorcista", "TERROR", "Disponible", 103},
                {"Pet Sematary", "TERROR", "Disponible", 104},
                {"Frankenstein", "TERROR", "Disponible", 105},
                {"Cien años de soledad", "NOVELA", "Disponible", 106},
                {"1984", "NOVELA", "No Disponible", 107},
                {"El gran Gatsby", "NOVELA", "Disponible", 108},
                {"Orgullo y prejuicio", "NOVELA", "Disponible", 109},
                {"Don Quijote de la Mancha", "NOVELA", "Disponible", 110},
                {"Circuit Analysis: Theory and Practice", "INGENIERÍA", "Disponible", 111},
                {"Mechanics of Materials", "INGENIERÍA", "No Disponible", 112},
                {"Introduction to Chemical Engineering Thermodynamics", "INGENIERÍA", "Disponible", 113},
                {"Structural Analysis", "INGENIERÍA", "Disponible", 114},
                {"Introduction to Electrical Engineering", "INGENIERÍA", "Disponible", 115}
        };
        return data;
    }
}
