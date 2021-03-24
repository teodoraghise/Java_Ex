import java.io.*;
import java.util.Collections;
import java.util.List;

public class Podium {

    public void ranking() {

        String fileName = "athlete.csv";

        AthleteReaderCSV athleteReaderCSV = new AthleteReaderCSV();
        List<Athlete> athleteList = athleteReaderCSV.readAthlete(fileName);

        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("athlete.obj"));

            objectOutputStream.writeObject(athleteList.get(1));
            objectOutputStream.flush();
            objectOutputStream.close();

            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream("athlete.obj"));
            try {
                Object o = objectInputStream.readObject();
                Athlete athlete = (Athlete) o;

                FileWriter out = new FileWriter("podium.csv");
                Collections.sort(athleteList, new PointComparator());

                out.write("Winner: " + "\n" + athleteList.get(0) + "\n" + "Runner-up: "  + "\n"
                        + athleteList.get(1) + "\n" + "Third Place: "  + "\n" + athleteList.get(2));
                out.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}