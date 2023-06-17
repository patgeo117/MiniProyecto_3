package Bibliotecarios;

import java.io.Serializable;

public class Employees implements Serializable {
    private String kay;
    private String value;

    public Employees(String key, String value){
        this.kay = key;
        this.value = value;
    }
    public String getKey(){
        return this.kay;
    }
    public String getValue(){
        return this.value;
    }
    // Describción de la clase
    public String toString(){
        return ("llave =  "+this.kay+" --> valor = "+this.value);
    }
}
