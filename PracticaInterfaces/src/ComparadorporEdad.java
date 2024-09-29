/*Author: Pedro García Rodríguez
 * Date: 2024/04/06
 * Proposal: PracticaInterfaces ComparadorporEdad, Comparator where two Gimnasta age are compared
 * */
import java.util.Comparator;
public class ComparadorporEdad implements Comparator<Gimnasta> {
    public int compare(Gimnasta g1, Gimnasta g2){
        return g1.getEdad().compareTo(g2.getEdad());
    }
}
