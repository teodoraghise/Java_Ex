public class MainPhone {
    public static void main(String[] args) {
        Phone phone = new SamsungGalaxyS6();
        phone.addContact("1", "0767525998", "Alb", "Ana");
        phone.addContact("2", "0741228169", "Negru", "Ion");
        phone.addContact("3", "0741255169", "Rosu", "Dan");
        phone.addContact("4", "0756228169", "Alb", "Maria");
        System.out.println("Phone's contaclist: ");
        phone.listContacts();
        System.out.println();

        // send a message to the first contact from the previous listed
        // max number of characters - 100"
        phone.sendMessage(phone.getContact(1).getPhone_number(),  "Primul meu mesaj pentru Alb Ana.");
        phone.sendMessage("0767525998",  "Al doilea mesaj pentru Alb Ana.");
        phone.sendMessage("0756228169", "Mesaj pentru Alb Maria.");
        System.out.println("Messages to the first contact " + phone.getContact(1).getFirst_name() + " " + phone.getContact(1).getLast_name() + ": ");
        phone.listMessages("0767525998");
        System.out.println();

        //make a call to the second contact from the previous listed
        phone.call(phone.getContact(2).getPhone_number());
        phone.call(phone.getContact(3).getPhone_number());
        System.out.println();

        System.out.println("Your call history: ");
        phone.listCallHistory();
        System.out.println();

        System.out.println("Your phone's battery life: " + ((SamsungGalaxyS6) phone).getCurrentBatteryLife());
        System.out.println();

        //new phone
        Phone phone1 = new SamsungGalaxyS7();

        phone1.addContact("1" , "0760185200", "Mereu", "Alina");
        phone1.addContact("2", "0745983256", "Lang", "Laura");
        System.out.println("Phone1's contaclist: ");
        phone1.listContacts();
        System.out.println();

        System.out.println("Your phone1's battery life: " + ((SamsungGalaxyS7) phone1).getCurrentBatteryLife());
        System.out.println();

        phone1.sendMessage(phone1.getContact(1).getPhone_number(), "Primul mesaj pentru Mereu Alina");
        phone1.sendMessage(phone1.getContact(1).getPhone_number(), "Al doilea mesaj pentru Mereu Alina");
        phone1.sendMessage("852552255", "Al treila mesaj!");
        System.out.println("Messages to the first contact " + phone1.getContact(1).getFirst_name() + " " + phone1.getContact(1).getLast_name() + ": ");
        phone1.listMessages(phone1.getContact(1).getPhone_number());
        System.out.println();

        System.out.println("Your phone1's battery life after 3 messages: " + ((SamsungGalaxyS7) phone1).getCurrentBatteryLife());
        System.out.println();

        phone1.call("0744225185");
        System.out.println("Your phone1's battery life after 2 messages and one call: " + ((SamsungGalaxyS7) phone1).getCurrentBatteryLife());
        phone1.call(phone1.getContact(2).getPhone_number());
        System.out.println();

        System.out.println("Your call history: ");
        phone1.listCallHistory();



    }
}