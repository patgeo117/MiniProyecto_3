package Bibliotecarios;

import java.io.Serializable;

public class Employees implements Serializable {
    // Variables para almacenar la llave y el valor
    private String kay;
    private String value;
    // Se inicia el constructor y se le pasa la llave y el valor
    public Employees(String key, String value){
        this.kay = key;
        this.value = value;
    }
    // Retornan la llave y el valor
    public String getKey(){
        return this.kay;
    }
    public String getValue(){
        return this.value;
    }
    // Descripción de la clase
    public String toString(){
        return ("llave =  "+this.kay+" --> valor = "+this.value);
    }
}
