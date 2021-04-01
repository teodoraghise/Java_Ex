import java.util.List;

public class MyDelivery implements Runnable {
    List<Package> list;
    Package reference;

    public MyDelivery(List<Package> list) {
        super();
        this.list = list;
        this.reference = list.get(0);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(reference.distance * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Delivering for " + reference.location + " and date " + reference.date + " in "
                + reference.distance + " seconds");
    }

}
