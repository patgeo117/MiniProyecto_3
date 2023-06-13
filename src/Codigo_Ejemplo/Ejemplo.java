package Codigo_Ejemplo;

import PersistenciaDatos.Libros;
import PersistenciaDatos.ManejoArchivo;

import java.io.*;
public class Ejemplo {
    String rutaArchivo = "src/Archivos_Bin/Libros.bin";
   // Object datosLeidos = ManejoArchivo.leerArchivoBinario(rutaArchivo);
    //ManejoArchivo.CrearArchivo(rutaArchivo,Libros.getDataRow());

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
   //  if (datosLeidos instanceof Object[][] data) {
        // Realizar operaciones con la matriz de datos leída
       // for (Object[] row : data) {
       //     for (Object value : row) {
        //        System.out.print(value + " ");
        //    }
        //    System.out.println();
       // }
   // }

    public static Object leerArchivoBinario(String rutaArchivo) {
        File archivoE = new File(rutaArchivo);
        if (archivoE.exists()) {
            Object objeto = null;
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
            return objeto;
        }else {
            System.out.println("No se encontró el archivo.");
        }
        return null;
    }
}
