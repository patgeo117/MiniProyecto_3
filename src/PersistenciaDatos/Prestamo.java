package PersistenciaDatos;

import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    // se crean las litas que van a almacenar los diferentes datos que se vana mostrar
    public static List<Integer> multa = new ArrayList<>();
    public static List<String> user = new ArrayList<>();
    public static List<String> book = new ArrayList<>();
    public static List<Integer> DiasAtraso = new ArrayList<>();
    // Se crea el constructor, al cual se le pasan los valores tomados de la interfaz dos
    public Prestamo(String user, String book, int multa){
        Prestamo.user.add(user);
        Prestamo.book.add(book);
        Prestamo.multa.add(multa);
    }

}
