package Bibliotecarios;


import java.util.ArrayList;
import java.util.List;


public class UsuarioMaestro {
    // valores por defecto para el login del usuario maestro
    public static List<String> nameMaster = new ArrayList<>();
    public static List<String> passwordMaster = new ArrayList<>();

    public UsuarioMaestro(String name, String password){
        UsuarioMaestro.nameMaster.add(name);
        UsuarioMaestro.passwordMaster.add(password);
    }
}