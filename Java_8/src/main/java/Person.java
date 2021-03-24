import java.util.Optional;

public class Person {
    private int no;
    private String firstName;
    private String lastName;
    private int age;
    private Nationality nationality;
    private double height;
    private double weight;
    private Optional<String> eyescolor;


    public Person(int no, String firstName, String lastName, int age, Nationality nationality, double height, double weight, Optional<String> eyescolor) {
        this.no = no;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.eyescolor = eyescolor;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Optional<String> getEyescolor() {
        return eyescolor;
    }

    public void setEyescolor(Optional<String> eyescolor) {
        this.eyescolor = eyescolor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", no=" + no +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nationality=" + nationality +
                ", height=" + height +
                ", weight=" + weight +
                ", eyescolor=" + eyescolor +

                '}';
    }
}
