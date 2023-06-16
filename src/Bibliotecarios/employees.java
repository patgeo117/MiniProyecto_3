package Bibliotecarios;

public class employees {
    private String kay;
    private String value;

    public employees(String key, String value){
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
        return ("La llave es: "+this.kay+" y su valor es: "+this.value);
    }
}
