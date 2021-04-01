import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Package> packages = createPackages();
        HashMap<String, List<Package>> groupPackages = groupPackages(packages);

        List<Thread> threads = new ArrayList<Thread>();
        // List<MyDelivery> deliveries = new ArrayList<MyDelivery>();
        for (String s : groupPackages.keySet()) {
            List<Package> pl = groupPackages.get(s);
           MyDelivery delivery = new MyDelivery(pl);

            threads.add(new Thread(delivery));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

        int value = 0;
        int revenue = 0;

        for (Package p : packages) {
            value += p.value;
            revenue += p.distance;
        }
        System.out.println("Total value: " + value);
        System.out.println("Total revenue:" + revenue);

    }

    public static List<Package> createPackages() {
        List<Package> list = new ArrayList<Package>();
        Charset charset = Charset.forName("UTF8");
        Path path = Paths.get("File.txt");

        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

            String line;

            while ((line = reader.readLine()) != null) {
                list.add(new Package(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static HashMap<String, List<Package>> groupPackages(List<Package> packageList) {
        HashMap<String, List<Package>> hashMap = new HashMap<String, List<Package>>();

        for (Package p : packageList) {
            String groupId = p.date + p.location;

            if (!hashMap.containsKey(groupId)) {
                List<Package> list = new ArrayList<Package>();
                list.add(p);

                hashMap.put(groupId, list);
            } else {
                hashMap.get(groupId).add(p);
            }
        }

        return hashMap;
    }

}
