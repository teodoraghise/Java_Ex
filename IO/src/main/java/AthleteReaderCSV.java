import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class AthleteReaderCSV {

    List<Athlete> readAthlete(String fileName) {
        List<Athlete> athletes = new ArrayList<>();
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(fileName));

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] tokens = line.split(",");

                Athlete athlete = new Athlete(
                        Integer.parseInt(tokens[0]),
                        tokens[1],
                        tokens[2],
                        Double.parseDouble(tokens[3]),
                        tokens[4],
                        tokens[5],
                        tokens[6]

                );
                athletes.add(athlete);
                line = bufferedReader.readLine();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return athletes;
    }
}