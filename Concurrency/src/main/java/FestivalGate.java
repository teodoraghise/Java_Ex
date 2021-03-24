import java.util.LinkedList;
import java.util.List;

public class FestivalGate {

    List<TicketType> gateAttendees = new LinkedList<>();

    public void addGateAttendees(TicketType ticketT) {
        gateAttendees.add(ticketT);
    }

    public LinkedList<TicketType> getGateAttendees() {
        return (LinkedList<TicketType>) gateAttendees;
    }
}