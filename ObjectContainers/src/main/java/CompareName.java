import java.util.Comparator;

public class CompareName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getName().compareTo(p2.getName()) < 0) {
            return -1;
        } else if (p1.getName().compareTo(p2.getName()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
