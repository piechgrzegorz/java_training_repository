package exercises.challenges_section_8.PhoneChallenge;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.addContact("Tim", "1234");
        phone.addContact("Bill", "67899");
        phone.addContact("Tim", "74747");
        phone.updateContact(new Contacts("Bill", ""), new Contacts("Dill", "346345"));
        phone.removeContact("Tim");

    }
    }





