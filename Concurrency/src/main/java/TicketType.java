public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    static TicketType randomTickets() {
        return TicketType.values()
                [(int) (Math.random() * TicketType.values().length)];
    }
}