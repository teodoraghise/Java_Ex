import org.apache.commons.lang3.RandomStringUtils;
import java.util.*;
import java.util.stream.Collectors;

public class PersonMethod {

    //2.Add names contains "a" and start with "M" to a set
    public void hasAStartsM(ArrayList<Person> newList) {
        newList.stream()
                .filter(a -> a.getFirstName().contains("a"))
                .filter(b -> b.getFirstName().startsWith("M"))
                .forEach(person -> System.out.println(person.getFirstName()));
    }

    // add instance to a set
    public void nameSet(ArrayList<Person> person) {
        new HashSet<>(person);
    }

    //3.smallest height from the person list
    public static double smallestHeight(List<Person> personList) {
        return personList
                .stream()
                .map(Person::getHeight)
                .min(Comparator.comparing(Double::valueOf))
                .get();
    }

    //4.generate a random string and put it in a set
    //The String Comparator compares two Strings character by character
    public void generateString(HashSet<String> newSet) {
        int counter = 2;
        for (int i = 0; i < 5; i++) {
            counter += i;
            String generatedString = RandomStringUtils.randomAlphabetic(counter);
            newSet.add(generatedString.toLowerCase());
        }
        newSet.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);


    }

    public void stringLength() {
        HashSet<String> newSet = new HashSet<>();
        generateString(newSet);
        Optional<String> maxString1 = newSet.stream()
                .max(Comparator.comparing(String::length));
        System.out.println("Max string :" + maxString1);

        Optional<String> minString = newSet.stream()
                .min(Comparator.comparing(String::length));
        System.out.println("Smallest string " + minString);
    }


    //5.generate random Int no. and count them
    public void generateNumbers(ArrayList<Integer> randomNumbers) {
        for (int i = 0; i < 5; i++) {
            randomNumbers.add((int) ( Math.random() * 10 ));
        }
    }

    public void countNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        generateNumbers(randomNumbers);
        Optional<Long> randomNum = ( Optional.of((long) randomNumbers.size()) );
        System.out.println(randomNum);

        randomNumbers.stream()
                .mapToInt(e -> (int) Math.pow(e, randomNumbers.size()))
                .forEach(System.out::println);

        long number = randomNumbers
                .stream()
                .count();
        System.out.println("Count random numbers: " + number);
    }

    //6) Create a map of "n" (K,V) elements and print "how many" elements have value over 10 (the key is of your choice);
    public void elementsWithValueOver10(Map<String, Integer> newMap) {
        Optional<Long> count = Optional.of(
                newMap.entrySet()
                        .stream()
                        .filter(x -> x.getValue() > 10)
                        .count());
        System.out.println(count);

    }

    //7 String Reverse Order
    public void reverseOrder() {
        HashSet<String> newSet = new HashSet<>();
        generateString(newSet);
        newSet.stream()
                .sorted(Comparator.comparing(String::valueOf).reversed())
                .collect(Collectors.toList());

    }

    //8 Sort List
    public void sortPersonByAge(ArrayList<Person> personList) {
        personList.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
    }

    //9  Check if any of your instances "match" a condition
    public static boolean checkIf(List<Person> personList) {
        return personList
                .stream()
                .map(Person::getWeight)
                .anyMatch(s -> s > 100);
    }

    //10. Optional example
    public static List<String> eyesColor(List<Person> personList) {
        return personList
                .stream()
                .map((s) -> s.getEyescolor())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
