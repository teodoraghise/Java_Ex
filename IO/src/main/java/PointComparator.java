import java.util.Comparator;

public class PointComparator implements Comparator<Athlete> {

    @Override
    public int compare(Athlete o1, Athlete o2) {
        if (o1.getFinalTime() < ( o2.getFinalTime() )) {
            return -1;
        } else {
            return 1;
        }
    }
}