package Bibliotecarios;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario {
    // Se crean las listas para almacenar los usuarios y las contraseñas
    public static List<String> name = new ArrayList<>();
    public static List<String> password = new ArrayList<>();

    // se crea el constructor que recibe los datos de la interfaz 3 y los añade a la lista
    public static void Bibliotecarios(String name, String password){
        Bibliotecario.name.add(name);
        Bibliotecario.password.add(password);
    }
}