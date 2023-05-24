import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    static int multa;
    static List<String> user =  new ArrayList<>();
    static List<String> libro = new ArrayList<>();
    public Prestamo() {

    }
    public Prestamo(String user, String libro){
        Prestamo.user.add(user);
        Prestamo.libro.add(libro);
    }
}
