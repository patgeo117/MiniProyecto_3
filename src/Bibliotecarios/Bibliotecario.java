package Bibliotecarios;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario {
    private static String name;
    private static String password;

    public void setName(String name) {
        Bibliotecario.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        Bibliotecario.password = password;
    }

    public String getPassword() {
        return password;
    }
}
