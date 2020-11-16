package exercises.challenges_section_8.PhoneChallenge;

import java.util.ArrayList;

public class Phone {
    ArrayList<Contacts> myContacts;

    public Phone(){
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean addContact(String name, String number){
        if(findContact(name)>=0){
            System.out.println("Contact " + name +" already exists.");
            return false;
        }
        myContacts.add(new Contacts(name, number));
        System.out.println(name + " added.");
        return true;
    }

    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int pos = findContact(oldContact.getName());
        if (pos>=0){
           myContacts.set(pos, newContact);
            System.out.println("Contact updated.");
           return true;
        }else{
           System.out.println("Old contact does not exist.");
           return false;
       }

    }

    public boolean removeContact(String name){
        int pos = findContact(name);
        if (pos>=0){
            myContacts.remove(pos);
            System.out.println(name + "removed.");
            return true;
        }else{
            System.out.println("Old contact does not exist.");
            return false;
        }
    }

    private int findContact(String name){
        for(int i=0; i<myContacts.size();i++){
            if(myContacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

}
