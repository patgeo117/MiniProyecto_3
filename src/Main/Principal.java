package Main;

import Bibliotecarios.*;
import Interfaz.InLogin;

import Bibliotecarios.UsuarioMaestro;
public class Principal {
    //public static String rutaArchivo = "src/Archivos_Bin/Libros.bin";
    public static void main(String[] args) {
        // InCrearUs.setDataM();
        //ManejoArchivo.getDataRow(rutaArchivo);
        //ManejoArchivo.CrearArchivo(rutaArchivo);
        new InLogin();

       /* UsuarioMaestro usuarioMaestro = new UsuarioMaestro("Master", "Master");
        Employees[] nuevosEmployees = new Employees[1];
        nuevosEmployees[0] = usuarioMaestro;

        SerizalizaDeseralizaUs serizalizaDeseralizaUs = new SerizalizaDeseralizaUs();
        serizalizaDeseralizaUs.setDataB(nuevosEmployees, "src/Archivos_Bin/dataM.bin");*/
    }
}
