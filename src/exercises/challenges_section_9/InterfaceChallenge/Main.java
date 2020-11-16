package exercises.challenges_section_9.InterfaceChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Bow");
        saveObject(tim);
        loadObject(tim);
        System.out.println(tim);

        ISaveable skolopendromorf = new Monster("Skolopendromorf", 24, 39);
        System.out.println("Strength = " + ((Monster) skolopendromorf).getStrength());
        saveObject(skolopendromorf);
    }
    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        boolean end = false;
        int num = 0;
        System.out.println("1: enter string \n 0: quit");
        while(!end){
            System.out.println("Choose option");
            int choice = input.nextInt();
            input.nextLine();
            switch(choice){
                case 0:
                    end = true;
                    break;
                case 1:
                    System.out.println("Enter string:");
                    String text = input.nextLine();
                    values.add(num, text);
                    num++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave){
        for (int i = 0; i<objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i));
        }
    }

    public static void loadObject(ISaveable objectToLoad ){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
