package PersistenciaDatos;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ManejoArchivo {

    public  void escribirObjeto(Object[][] nuevosObjetos) {
        String RutaArchivo = "src/Archivos_Bin/Libros.bin";

        // Leo el archivo y lo agrego un Onjecto
        Object[][] objetosExistentes = leerObjeto();

        // Creo una colecion de datos que no se pueden repetir.
        Set<Object[]> conjuntoObjetos = new HashSet<>();

        // Valido que los datos no sean nulos 
        if (objetosExistentes != null) {
            // agrego los datos del Object a la collection
            conjuntoObjetos.addAll(Arrays.asList(objetosExistentes));
            System.out.println(conjuntoObjetos);
        }

        // itero sobre los nuevos datos
        for (Object[] objetoNuevo : nuevosObjetos) {
            // verificar si el objetoNuevo ya está en conjuntoObjetos
            boolean objetoYaExiste = false;
            // itero sobre cada dato de la colletion
            for (Object[] objetoExistente : conjuntoObjetos) {
                // verifico si los datos son iguales y si existe evito que se agregue el nuevo object
                if (Arrays.equals(objetoNuevo, objetoExistente)) {
                    objetoYaExiste = true;
                    break;
                }
            }
            // Si el dato no existe lo agrego a la collection
            if (!objetoYaExiste) {
                conjuntoObjetos.add(objetoNuevo);
            }
        }

        System.out.println(conjuntoObjetos);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(RutaArchivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Agregó la nueva collecion que contiene lso datos del .bin y lo nuevos que se van a agregar.
            objectOutputStream.writeObject(conjuntoObjetos.toArray(new Object[0][0]));

            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método que lee los datos guardados en él .bin

    public  Object[][] leerObjeto() {
        String rutaArchivo = "src/Archivos_Bin/Libros.bin";
        Object[][] objetos = null;
        try {

            FileInputStream fileInputStream = new FileInputStream(rutaArchivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            objetos = (Object[][]) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    // Método para crear el archivo .bin

    public static void CrearArchivo(String rutaArchivo) {
        File archivoE = new File(rutaArchivo);
        if (archivoE.exists()) {
            System.out.println("El archivo ya existe.");
            return;
        }
        try {
            FileOutputStream archivo = new FileOutputStream(rutaArchivo);
            ObjectOutputStream salida = new ObjectOutputStream(archivo);
            //salida.writeObject(objeto);
            salida.close();
            System.out.println("Se creo el archivo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Table-Modelo
    public String[] getNomColumnas() {
        return new String[]{"Título", "Categoría", "Estado"};
    }
}
