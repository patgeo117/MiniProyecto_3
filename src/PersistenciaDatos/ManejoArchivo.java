package PersistenciaDatos;
import java.io.*;
public class ManejoArchivo {

    public static void CrearArchivo(String rutaArchivo,Serializable objeto) {
        File archivoE = new File(rutaArchivo);
        if (archivoE.exists()) {
            System.out.println("El archivo ya existe.");
            return;
        }
        try {
            FileOutputStream archivo = new FileOutputStream(rutaArchivo);
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            salida.writeObject(objeto);
            salida.close();
            System.out.println("Se creo el archivo");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
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

                archivo.close();
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


}
