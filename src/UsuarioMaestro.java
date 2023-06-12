import java.util.ArrayList;
import java.util.List;

public class UsuarioMaestro {
    // valores por defecto para el login del usuario maestro
        //public String setUsuario(){return "Maestro";}
        //public String setContrasena(){return "Maestro";}

    static List<String> nameMaster = new ArrayList<>();
    static List<String> passwordMaster = new ArrayList<>();

    public UsuarioMaestro(String name, String password){
        UsuarioMaestro.nameMaster.add(name);
        UsuarioMaestro.passwordMaster.add(password);
    }
}
