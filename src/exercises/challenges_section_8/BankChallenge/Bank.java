package exercises.challenges_section_8.BankChallenge;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    private Branch findBranch(String name){
        for(int b = 0; b<this.branches.size(); b++){
            if(this.branches.get(b).getName().equals(name)){
                return this.branches.get(b);
            }
        }
        return null;
    }

    public boolean addBranch(String name){
        if(findBranch(name) == null){
            this.branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String custName, double amount){
        if(findBranch(branchName)!=null){
            return findBranch(branchName).newCustmer(custName, amount);
        }
        return false;
    }

    public boolean addCustTrasnaction(String branchName, String custName, double amount){
        Branch br = findBranch(branchName);
        if(br != null){
            return br.addTransaction(custName, amount);
        }
        return false;
    }


    public boolean listCustomers(String name, boolean showTr){
        Branch branch = findBranch(name);
        if(branch != null){
            System.out.println("List of customers for branch: " + branch.getName());
            ArrayList<Customer> customers = branch.getCustomers();

            for(int c=0; c<customers.size(); c++){
                ArrayList<Double> transactions = customers.get(c).getTransactions();
                System.out.println("Customer " + customers.get(c).getName());
                System.out.println("Transactions: ");
                for(int t = 0; t < transactions.size(); t++){
                    System.out.println("#"+(t+1)+"   --   " + transactions.get(t));
                }

            }
            return true;
        }
        return false;
    }







//    public boolean listCustomers(String name, boolean showTr){
//        Branch branch = findBranch(name);
//        if(branch == null){
//            return false;
//        }else{
//            //Branch bx = new Branch(name);
//            if(showTr){
//                System.out.println("aaaaaaaaaa");
//                for(b : branch){
//                    System.out.println(branch.getCustomers().get(c).getName());
//                }
//
//
//
//                for(int c = 0; c< branch.getCustomers().size();c++){
//                    System.out.println(branch.getCustomers().get(c).getName() + " - " + branch.getCustomers().get(c).getTransactions());
//                    return true;
//                }
//            }else if(!showTr){
//                for(int c = 0; c<branch.getCustomers().size() ;c++){
//                    System.out.println(branch.getCustomers().get(c).getName());
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

}



