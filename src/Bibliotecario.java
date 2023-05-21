import java.util.ArrayList;
import java.util.List;

public class Bibliotecario {

    static List<String> name = new ArrayList<String>();
    static List<String> password = new ArrayList<String>();

    public Bibliotecario(){
    }
    public Bibliotecario(String name, String password){
        Bibliotecario.name.add(name);
        Bibliotecario.password.add(password);
    }

   /* public String setName(){
        return name;
    }
    public void getUsuarioN(String name){
        this.name = name;
    }
    public String setPassword(){
        return password;
    }
    public void getContrasenaN(String password){
        this.password = password;
    }*/

}