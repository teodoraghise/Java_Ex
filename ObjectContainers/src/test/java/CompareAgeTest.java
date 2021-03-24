import org.junit.Test;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;

class CompareAgeTest {
    CompareAge compareAge;
    Person p1;
    Person p2;

    @Test
    public void compare_if_person_have_the_same_age(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Alin", 25);
        Person p2 = new Person("Victor", 33);
        assertEquals(0,compareAge.compare(p1,p2));
    }

    @Test
    public void compare_if_pers1_is_younger_then_pers2(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Alin", 25);
        Person p2 = new Person("Victor", 33);
        assertEquals(-1, compareAge.compare(p1,p2));
    }

    @Test
    public void compare_if_pers1_is_older_than_pers2(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Alin", 25);
        Person p2 = new Person("Victor", 33);
        assertEquals(1, compareAge.compare(p1,p2));
    }
}