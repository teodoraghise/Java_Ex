public class Message {
    private String phone_number;
    private String message_content;

    public Message(String phone_number, String message_content) {
        this.phone_number = phone_number;
        this.message_content = message_content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_content='" + message_content + '\'' +
                '}';
    }

    public String getPhone_number() {
        return phone_number;
    }

}
