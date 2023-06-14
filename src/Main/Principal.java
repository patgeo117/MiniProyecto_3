package Main;

import Interfaz.InCrearLib;
import Interfaz.InLogin;
import Interfaz.InCrearUs;

import java.util.HashMap;


public class Principal {
    public static String rutaArchivo = "src/Archivos_Bin/Libros.bin";
    public static void main(String[] args) {
        // InCrearUs.setDataM();
        //ManejoArchivo.getDataRow(rutaArchivo);
        //ManejoArchivo.CrearArchivo(rutaArchivo, (Serializable) Libros.getDataRow());
        new InLogin();

       /* HashMap<String, String> s = new HashMap<>();
        //Pasamos los valores por defecto
        s.put("Master", "Master");
        InCrearUs.setDataM(s);*/
    }
}
