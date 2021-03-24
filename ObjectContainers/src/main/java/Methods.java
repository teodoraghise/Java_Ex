import java.util.*;

public class Methods {

    public TreeSet<Person> personName = new TreeSet<Person>(new CompareName());
    public TreeSet<Person> personAge = new TreeSet<Person>(new CompareAge());


    public boolean add(Person person) {
        add2(person);
        return personName.add(person);
    }

    public boolean add2(Person person) {
        return personAge.add(person);

    }

    public void printName() {
        for (Person element : personName) {
            System.out.println("Name: " + element.getName() + "age: " + element.getAge());
        }
    }

    public void printAge() {
        for (Person element : personAge) {
            System.out.println("Name: " + element.getName() + "age: " + element.getAge());
        }
    }


    HashMap<Person, List<Hobby>> mapList = new HashMap<>();

    public void put(Person person, List<Hobby> list) {
        mapList.put(person, list);
    }

    public void print() {
        for (Person name : mapList.keySet()) {
            String key = name.toString();
            String value = mapList.get(name).toString();
            System.out.println(key + " " + value);
        }
    }

}
