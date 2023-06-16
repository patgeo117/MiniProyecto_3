package Bibliotecarios;

import java.io.*;
import java.util.HashMap;

public class Bibliotecario {

    // Escribir en archivo
    public static void setDataB(HashMap<String, String> data, String archivo) {

        try {
            FileOutputStream outputB = new FileOutputStream(archivo);
            ObjectOutputStream modifiB = new ObjectOutputStream(outputB);

            modifiB.writeObject(data);

            modifiB.close();
            outputB.close();

        } catch (Exception io) {
            io.printStackTrace();
        }
    }

    // leer archivos Bibliotecario
    public HashMap<String, String> getDataB() {
        // creo un nuevo HasMap que captura los datos del bin
        HashMap<String, String> newHash = new HashMap<>();
        try {
            File file = new File("src/Archivos_Bin/dataBibliotecarios.bin");
            // Válido que el archivo exista
            if (file.exists()) {
                FileInputStream inputB = new FileInputStream(file);
                ObjectInputStream leerB = new ObjectInputStream(inputB);

                // leo el archivo y agregó los valores al HashMap
                newHash = (HashMap<String, String>) leerB.readObject();

                leerB.close();
                inputB.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // retorno los datos del bin
        return newHash;
    }
}
