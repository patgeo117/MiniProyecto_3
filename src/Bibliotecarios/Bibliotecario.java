package Bibliotecarios;

import java.util.ArrayList;
import java.util.List;

public class Bibliotecario {
    private String name;
    private String password;

    public void getName(String name) {
        this.name = name;
    }

    public String setName() {
        return name;
    }

    public void getPassword(String password) {
        this.password = password;
    }

    public String setPassword() {
        return password;
    }
}
