package exercises.challenges_section_8.BankChallenge;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String name){
        for(int i = 0; i < this.customers.size(); i++){
            if(this.customers.get(i).getName().equals(name)){
                return this.customers.get(i);
            }
        }
        return null;
    }

    public boolean newCustmer(String name, double amount){
        if(findCustomer(name)==null){
            this.customers.add(new Customer(name, amount));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String name, double amount){
        Customer c = findCustomer(name);
        if(c != null){
            c.addTransaction(amount);
            return true;
        }
        return false;
    }

}
