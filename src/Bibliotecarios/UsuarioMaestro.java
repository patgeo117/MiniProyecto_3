package Bibliotecarios;

import java.io.*;
import java.util.HashMap;

public class UsuarioMaestro {

    // Escribir en archivo Maestro
    public static void setDataM(HashMap<String, String> data, String archivo) {

        try {
            FileOutputStream outputM = new FileOutputStream(archivo);
            ObjectOutputStream modifiM = new ObjectOutputStream(outputM);

            modifiM.writeObject(data);

            modifiM.close();
            outputM.close();

        } catch (Exception io) {
            io.printStackTrace();
        }
    }

    // leer archivo maestro
    public HashMap<String, String> getDataM() {
        // creo un nuevo HasMap que captura los datos del bin
        HashMap<String, String> newMaster = new HashMap<>();
        try {
            File file = new File("src/Archivos_Bin/dataMaestros.bin");
            // Válido que el archivo exista
            if (file.exists()) {
                FileInputStream inputM = new FileInputStream(file);
                ObjectInputStream leerM = new ObjectInputStream(inputM);

                // leo el archivo y agregó los valores al HashMap
                newMaster = (HashMap<String, String>) leerM.readObject();

                leerM.close();
                inputM.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // retorno los datos del bin
        return newMaster;
    }
}