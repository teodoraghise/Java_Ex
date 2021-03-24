public class FestivalMain {
    public static void main(String[] args) {

        FestivalGate gate = new FestivalGate();
        FestivalStatistic mainGate = new FestivalStatistic(gate);
        mainGate.start();

        int personAttendee = (int) (Math.random() * 1000);
        for (int i = 0; i < personAttendee; i++) {
            FestivalAttendee attendee = new FestivalAttendee(TicketType.randomTickets(), gate);
            attendee.start();
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}