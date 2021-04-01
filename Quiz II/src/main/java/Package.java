public class Package {

    String location;
    int distance;
    int value;
    String date;

    public Package(String l, int d, int v, String date){
        this.location = l;
        this.distance = d;
        this.value = v;
        this.date = date;
    }

    public Package(String rawLine){
        String[] args = rawLine.split(",");
        this.location = args[0];
        this.distance = Integer.parseInt(args[1]);
        this.value = Integer.parseInt(args[2]);
        this.date = args[3];
    }

}