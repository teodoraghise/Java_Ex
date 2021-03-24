import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        PersonMethod method = new PersonMethod();

        //1) Write 5 different instances of that object.
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "Mirach", "Ric", 24, Nationality.IRISH, 1.70, 80, Optional.of("black")));
        personList.add(new Person(2, "Angell", "Marcel", 23, Nationality.ITALIANS, 1.80, 90, Optional.of("green")));
        personList.add(new Person(3, "Martin", "Amis", 34, Nationality.JAMAICANS, 1.40, 85, Optional.ofNullable(null)));
        personList.add(new Person(4, "Arp", "Hans", 44, Nationality.JAPONESE, 1.60, 78, Optional.of("blue")));
        personList.add(new Person(5, "Denham", "John", 54, Nationality.ISRAELIS, 1.73, 64, Optional.empty()));
        System.out.println("1. A list with 5 diferent instances" + "\n" + personList);
        System.out.println();

        //2) Find the elements containing the letter "a" that start with "M" and print them out.
        System.out.println("2. Find the elements containing the letter 'a' that start with 'M' and print them out.");
        method.hasAStartsM(personList);
        method.nameSet(personList);
        System.out.println();

        //  3) Find the "min" using a custom comparing criteria of choice
        System.out.println("3.The smallest person from the list had: " + PersonMethod.smallestHeight(personList));
        System.out.println();

        //4) Generate 5 random Strings and add them to a Set. Find the "max" (while explaining as Javadoc how comparing Strings works)
        System.out.println("4. Generate 5 random strings, add them to a set,print the max");
        method.stringLength();
        System.out.println();

        //5) Generate a random number of Integers and then count them. "Map" the exponential to the numbers and then print them out.
        System.out.println("5.Generate a random number of Integers and then count them");
        method.countNumbers();
        System.out.println();

        //6) Create a map of "n" (K,V) elements and print "how many" elements have value over 10 (the key is of your choice);
        System.out.println("6.Create a map of elements with value over 10:");
        Map<String, Integer> map = new HashMap<>();
        map.put("string1", 2);
        map.put("string2", 20);
        map.put("string3", 34);
        method.elementsWithValueOver10(map);
        System.out.println();

        //7) Sort the above Set<String> (used for max) in reverse order
        System.out.println("7.String reverse order");
        method.reverseOrder();
        System.out.println();

        //8)Sort the above List of custom objects (used for filter) in an order you consider;
        System.out.println("8. Sort the list by age: ");
        method.sortPersonByAge(personList);
        System.out.println();

        // 9) Check if any of your instances "match" a condition based on an Integer field (of your choice). What does it return ? Print it out.
        System.out.println("9.Check if the people form the list have more or less 85kg.");
        if (PersonMethod.checkIf(personList))
            System.out.println("They have less then 85 kg");
        else System.out.println("They have more then 85 kg");
        System.out.println();

        //10) What does Optional represent ? Explain through an example on your custom object;
        System.out.println("10.Optional example using isParsent:");
        // Optional is a wrapper class which makes a field optional, in this case eyes color
        System.out.println(PersonMethod.eyesColor(personList));

        //11) Fastest way to find the shortest String in a List (take the 5 random Strings generated above and find the shortest one);
        //solved at point 4


    }

}