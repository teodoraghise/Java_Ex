import java.util.Arrays;

public class SamsungGalaxyS6 extends Samsung implements Phone {
    private String color;
    private String material;
    private long imei;
    private int currentBatteryLife = super.getBatteryLife();


    private Contact[] contactList = new Contact[0];
    private Message[] messages = new Message[0];
    private String[] calles = new String[0];


    public SamsungGalaxyS6() {
        super(220);
        this.imei = 5554;
    }

    public int getCurrentBatteryLife() {
        return currentBatteryLife;
    }

    public void setCurrentBatteryLife(int currentBatteryLife) {
        this.currentBatteryLife = currentBatteryLife;
    }

    public Contact[] addContact(String nr, String phone_number, String first_name, String last_name) {
        Contact[] copy = Arrays.copyOf(contactList, contactList.length + 1);
        copy[contactList.length] = new Contact(nr, phone_number, first_name, last_name);
        contactList = Arrays.copyOf(copy, copy.length);

        return contactList;

    }

    public void listContacts() {
        for (Contact element : contactList) {
            if (element != null) {
                System.out.println(element.toString());
            }
        }
    }

    public Contact getContact(int index) {
        int newIndex = index - 1;
        try {
            return contactList[newIndex];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("It is an invalid index.");
            return null;
        }
    }

    public Message[] sendMessage(String phone_number, String message_content) {
        if (currentBatteryLife == 0) {
            System.out.println("Your battery drained.");
            return messages;

        } else {
            if (message_content.length() > 500) {
                System.out.println("Your message can have maximum 500 chars! Try again! ");
                return messages;
            } else {
                Message[] copy = Arrays.copyOf(messages, messages.length + 1);
                copy[messages.length] = new Message(phone_number, message_content);
                messages = Arrays.copyOf(copy, copy.length);
                this.setCurrentBatteryLife(currentBatteryLife - 1);
                return messages;
            }
        }
    }

    public void listMessages(String phone_number) {
        int nrOfMessages = 0;
        for (Message element : messages) {
            if (element != null && element.getPhone_number() == phone_number) {
                System.out.println(element.toString());
                nrOfMessages++;
            }
        }
        if (nrOfMessages == 0) System.out.println("Does not exist message for this contact!");

    }


    public String[] call(String phone_number) {
        if (currentBatteryLife < 2) {
            System.out.println("Your battery drained or you do not have enough battery for a new call!");
            return calles;
        } else {
            String[] copy = Arrays.copyOf(calles, calles.length + 1);
            copy[calles.length] = phone_number;
            calles = Arrays.copyOf(copy, copy.length);
            this.setCurrentBatteryLife(currentBatteryLife - 2);
            System.out.println("You are calling this phone number: " + phone_number);
            return calles;
        }
    }


    public void listCallHistory() {
        for (String element : calles) {
            if (element != null) {
                System.out.println(element);
            }
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}