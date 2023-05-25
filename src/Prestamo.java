import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    static int multa;
    static String user;
    static String book;


    public void Usuarios(String user, String book){
        Prestamo.user = user;
        Prestamo.book = book;
    }
    public void Usuarios(String user, String book, int multa){
        Prestamo.user = user;
        Prestamo.book = book;
        Prestamo.multa += multa;
    }

}
