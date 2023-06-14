package Bibliotecarios;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMaestro {
    private static String name;
    private static String password;

    public void setName(String name) {
        UsuarioMaestro.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        UsuarioMaestro.password = password;
    }

    public String getPassword() {
        return password;
    }
}