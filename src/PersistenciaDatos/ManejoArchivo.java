package PersistenciaDatos;
import java.io.*;
public class ManejoArchivo {
    public static Object getDataRow(String rutaArchivo) {
        Object objeto = null;
        File archivoE = new File(rutaArchivo);
        if (archivoE.exists()) {
           objeto = new Object();
            try {
                FileInputStream archivo = new FileInputStream(rutaArchivo);
                ObjectInputStream entrada = new ObjectInputStream(archivo);

                // Leer objeto desde el archivo binario
                objeto = entrada.readObject();

                entrada.close();
                System.out.println("Archivo binario leído correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("No se encontró el archivo.");
        }
        return objeto;
    }

    public static String[] getNomColumnas() {
        return new String[]{"Título", "Categoría", "Estado"};
    }
}
