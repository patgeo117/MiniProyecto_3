package Main;

import Interfaz.InLogin;

import java.util.HashMap;

import Bibliotecarios.UsuarioMaestro;
public class Principal {
    //public static String rutaArchivo = "src/Archivos_Bin/Libros.bin";
    public static void main(String[] args) {
        // InCrearUs.setDataM();
        //ManejoArchivo.getDataRow(rutaArchivo);
        //ManejoArchivo.CrearArchivo(rutaArchivo);
        new InLogin();

        /*HashMap<String, String> s = new HashMap<>();
        //Pasamos los valores por defecto
        s.put("Master", "Master");
        UsuarioMaestro.setDataM(s, "src/Archivos_Bin/dataMaestros.bin");*/
    }
}
