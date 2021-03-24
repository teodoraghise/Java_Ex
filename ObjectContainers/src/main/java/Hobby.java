import java.util.ArrayList;
import java.util.List;

public class Hobby {
    public String hobby_name;
    public int frequency;
    List<Adress> address = new ArrayList<>();

    public Hobby(String hobby_name, int frequency, List<Adress> address) {
        this.hobby_name = hobby_name;
        this.frequency = frequency;
        this.address = address;
    }

    public String getHobby_name() {
        return hobby_name;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<Adress> getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobby_name='" + hobby_name + '\'' +
                ", frequency=" + frequency +
                ", address=" + address +
                '}';
    }
}
