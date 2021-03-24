public class Contact {
    private String nr;
    private String phone_number;
    private String first_name;
    private String last_name;

    public Contact(String nr, String phone_number, String first_name, String last_name) {
        this.nr = nr;
        this.phone_number = phone_number;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nr=" + nr +
                ", phone_number='" + phone_number + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}


