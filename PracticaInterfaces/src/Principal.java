import java.util.ArrayList;
import java.util.List;

/*Author: Pedro García Rodríguez
* Date: 2024/04/06
* Proposal: PracticaInterfaces Main, where the methods are tested
* */
public class Principal {
    public static void main(String[] args) {
        //I start creating objects
    Gimnasta g1 = new Gimnasta("Juana", "Fernández", 23, 8.25F, "12345678L");
    Gimnasta g2 = new Gimnasta("Juana", "Fernández", 21, 7.25F, "87654321A");
    Gimnasta g3 = new Gimnasta("Gerardo", "Carmona", 18, 6.25F, "44332211D");
    Gimnasta g4 = new Gimnasta("Gerardo", "Fraile", 19, 8.15F, "11223344C" );
    //Clone method test
    Gimnasta g5 = g1.clone();
    //Testing the getters
        System.out.println("Comprobando los SETTERS");
    System.out.println(g1.getNombre());
    System.out.println(g5.getNombre());
    System.out.println(g2.getApellidos());
    System.out.println(g3.getEdad());
    System.out.println(g4.getpuntMedia());
    System.out.println(g1.getDNI());
    //Testing the compareTo
        System.out.println("Método COMPARE TO");
    System.out.println(g1.compareTo(g2));
    System.out.println(g2.compareTo(g3));
    System.out.println(g3.compareTo(g4));
        System.out.println(g1.compareTo(g5));
    //We test the Comparator method. Start creating the list
        System.out.println("Método COMPARATOR");
    List<Gimnasta> lista = new ArrayList<>(List.of(g1, g2, g3, g4));
    //After that, the Comparator method is used to obtain the list ordered by age
    lista.sort(new ComparadorporEdad());
        for (Gimnasta gim:lista
             ) {
            System.out.println(gim.getNombre() + " " + gim.getApellidos() + " " + gim.getEdad());
        }
    }
}