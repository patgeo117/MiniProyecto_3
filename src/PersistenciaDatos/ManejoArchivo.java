package PersistenciaDatos;
import java.io.*;
public class ManejoArchivo {
    public static void CrearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se creo el archivo");
        }catch (FileNotFoundException e){
            e.printStackTrace(System.out);
        }
    }
}
