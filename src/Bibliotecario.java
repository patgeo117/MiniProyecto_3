public class Bibliotecario {

    private String name;
    private String password;

    public Bibliotecario(){
    }
    public Bibliotecario(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String setName(){
        return name;
    }
    public void getUsuarioN(String name){
        this.name += name;
    }
    public String setPassword(){
        return password;
    }
    public void getContrasenaN(String password){
        this.password += password;
    }

}