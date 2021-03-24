public class FestivalAttendee extends Thread {
    private final FestivalGate gate;
    private TicketType ticketT;

    FestivalAttendee(TicketType ticketT, FestivalGate gate) {
        this.ticketT = ticketT;
        this.gate = gate;
    }

    public void run() {
        synchronized (gate) {
            gate.addGateAttendees(ticketT);
        }
    }
}