import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class FestivalStatistic extends Thread {
    private FestivalGate gate;

    FestivalStatistic(FestivalGate gate) {
        this.gate = gate;
    }

    public void run() {
        LinkedList<TicketType> gateAttendees;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("\n FESTIVAL MAIN GATE MONITORING \n");
        while (true) {
            synchronized (gate) {
                gateAttendees = gate.getGateAttendees();
            }

            if (gateAttendees.size() != 0) {

                long entered = gateAttendees.size();
                System.out.println("At time:" + LocalTime.now().format(dtf) + ", " + entered + " tickets were sold: ");

                long full = gateAttendees.stream().filter(t -> t == TicketType.FULL).count();
                System.out.println(full + " people have " + TicketType.FULL + " ticket.");

                long freePass = gateAttendees.stream().filter(t -> t == TicketType.FREE_PASS).count();
                System.out.println(freePass + " people have " + TicketType.FREE_PASS + " ticket.");

                long oneDay = gateAttendees.stream().filter(t -> t == TicketType.ONE_DAY).count();
                System.out.println(oneDay + " people have " + TicketType.ONE_DAY + " ticket.");

                long oneDayVip = gateAttendees.stream().filter(t -> t == TicketType.ONE_DAY_VIP).count();
                System.out.println(oneDayVip + " people have " + TicketType.ONE_DAY_VIP + " ticket.");

                long fullVip = gateAttendees.stream().filter(t -> t == TicketType.FULL_VIP).count();
                System.out.println(fullVip + " people have " + TicketType.FULL_VIP + " ticket. \n");
            }
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}