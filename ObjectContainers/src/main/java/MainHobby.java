import java.util.Arrays;

public class MainHobby {

    public static void main(String[] args) {
        //1. You need to store Persoane in a TreeSet. Define 2 Comparators
        // (one for name - nume and one for age-varsta) that will be used when creating the TreeSet;
        Methods t = new Methods();
        t.add(new Person(" Alin ",25));
        t.add(new Person(" Victor ",33));
        t.add(new Person(" Ania ",7));
        t.add(new Person(" Mircea ",22));
        System.out.println("Person list sorted by Name");
        t.printName();
        System.out.println();
        System.out.println("Person list sorted by Age");
        t.printAge();
        System.out.println();

        //2. You need to store some information about some persons: for one person, you need a list of his/her hobbies;
        //You will use a HashMap
        //Add some information to this map; for a certain Persoana, print the names of the hobbies and the countries
        // where it can be practiced

        System.out.println("List person's hobby and addresses where it can be practiced");
        t.put(new Person("Pers1",22), Arrays.asList
                (new Hobby("hobby1",2,Arrays.asList(
                        new Adress("city1","str1",2)))));

        t.put(new Person("Pers2",25), Arrays.asList
                (new Hobby("hobby1",2,Arrays.asList(
                        new Adress("city2","str2",2)))));

        t.put(new Person("Pers3",24), Arrays.asList
                (new Hobby("hobby3",3,Arrays.asList
                        (new Adress("city3","str3",3)))));
        t.print();

    }
}
