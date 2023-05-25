import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    // se crean las litas que van a almacenar los diferentes datos que se vana mostrar
    static List<Integer> multa = new ArrayList<>();
    static List<String> user = new ArrayList<>();
    static List<String> book = new ArrayList<>();
    static List<Integer> DiasAtraso = new ArrayList<>();
    // Se crea el constructor, al cual se le pasan los valores tomados de la interfaz dos
    public Prestamo(String user, String book, int multa){
        Prestamo.user.add(user);
        Prestamo.book.add(book);
        Prestamo.multa.add(multa);
    }

}
