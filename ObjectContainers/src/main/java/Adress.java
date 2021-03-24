public class Adress {
    public String City;
    public String Street;
    public int number;

    public Adress(String city, String street, int number) {
        City = city;
        Street = street;
        this.number = number;
    }

    public String getCity() {
        return City;
    }

    public String getStreet() {
        return Street;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "City='" + City + '\'' +
                ", Street='" + Street + '\'' +
                ", number=" + number +
                '}';
    }
}
