package exercises.challenges_section_8.BankChallenge;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("PKO");
        System.out.println(bank.addBranch("Scranton"));
        System.out.println(bank.addBranch("New York"));
        System.out.println(bank.addCustomer("Scranton", "Vance Refridgeration", 300.00));
        System.out.println(bank.addCustomer("Scranton", "Paper World", 23.00));
        System.out.println(bank.addCustomer("New York", "Tralala", 0.00));
        System.out.println(bank.addCustTrasnaction("Scranton", "Vance Refridgeration", 400.00));
        bank.listCustomers("Scranton", true);
    }
}
