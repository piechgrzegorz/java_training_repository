package com.projects.battleships;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[][] oceanMap = new String[10][10];
    public static int playerShips = 5;
    public static int pcShips = 5;

    public static void main(String[] args) {

        prepareMap();
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println("\nRight now, the sea is empty.");
        System.out.println();
        printOceanMap();
        deployPlayersShips();
        printOceanMap();
        deployPCShips();
        playGame();
    }

    private static void prepareMap(){
        for(int x = 0; x < oceanMap.length; x++){
            for(int y = 0; y < oceanMap[x].length; y++){
                oceanMap[x][y] = " ";
            }
        }
    }

    //Player chooses where to place ships
    private static void deployPlayersShips(){
        int shipsDeployed = 0;
        int axisX = 0;
        int axisY = 0;
        Scanner shipsCoordinate = new Scanner(System.in);
        while(shipsDeployed<playerShips){
            System.out.println("Choose coordinates for ship " + (shipsDeployed + 1));
            while(true) {
                try {
                    System.out.print("Axis X: ");
                    axisX = shipsCoordinate.nextInt();
                    if(axisX<0 || axisX>9) {
                        System.out.println("Coordinates out of Ocean Map");
                        continue;
                    }
                    break;
                }catch(InputMismatchException e){
                    System.out.println("Provided value is not valid");
                    shipsCoordinate.next();
                }
            }
            while(true) {
                try {
                    System.out.print("Axis Y: ");
                    axisY = shipsCoordinate.nextInt();
                    if(axisY<0 || axisY>9) {
                        System.out.println("Coordinates out of Ocean Map");
                        continue;
                    }
                    break;
                }catch(InputMismatchException e){
                    System.out.println("Provided value is not valid");
                    shipsCoordinate.next();
                }
            }
            if(oceanMap[axisX][axisY].equals("1")){
                System.out.println("You already have ship here");
            }else {
                oceanMap[axisX][axisY] = "1";
                shipsDeployed ++;
            }
        }
    }

    //PC randomly places ships
    private static void deployPCShips(){
        Random random = new Random();
        int shipsDeployed = 0;
        int axisX = 0;
        int axisY = 0;
        while(shipsDeployed<pcShips){
            axisX = random.nextInt(10);
            axisY = random.nextInt(10);
            if(!oceanMap[axisX][axisY].equals("1") && !oceanMap[axisX][axisY].equals("2")){
                oceanMap[axisX][axisY] = "2";
                shipsDeployed++;
            }
        }

    }

    private static void playGame(){
        int round = 1;
        while(playerShips!=0 && pcShips!=0){
            System.out.println("*****************************");
            System.out.printf("********** ROUND %d **********\n", round);
            System.out.println("*****************************");
            playersTurn();
            pcTurn();
            printOceanMap();
            System.out.println("Player: " + playerShips + " ships left");
            System.out.println("Computer:  " + pcShips + " ships left");
            System.out.println();
            round++;
            //printFullOceanMap(); //prints all entries on the map for testing purposes
        }
        gameOver();
    }

    private static void playersTurn(){
        Scanner shipsCoordinate = new Scanner(System.in);
        int axisX = 0;
        int axisY = 0;
        while(true){
            System.out.println("Choose coordinates to attack");

            while(true) {
                try {
                    System.out.print("Axis X: ");
                    axisX = shipsCoordinate.nextInt();
                    break;
                }catch(InputMismatchException e){
                    System.out.println("Provided value is not a number");
                    shipsCoordinate.next();
                }
            }
            while(true) {
                try {
                    System.out.print("Axis Y: ");
                    axisY = shipsCoordinate.nextInt();
                    break;
                }catch(InputMismatchException e){
                    System.out.println("Provided value is not a number");
                    shipsCoordinate.next();
                }
            }
            if(axisX<0 || axisX>9 || axisY<0 || axisY>9){
                System.out.println("Coordinates out of Ocean Map");
            }else if(oceanMap[axisX][axisY].equals("2")){
                oceanMap[axisX][axisY] = "3";
                System.out.println("Computer loses ship.");
                pcShips--;
                break;
            }else if(oceanMap[axisX][axisY].equals("1")){
                oceanMap[axisX][axisY] = "3";
                System.out.println("You destroyed your own ship genius!");
                playerShips--;
                break;
            }else if(oceanMap[axisX][axisY].equals("3") || oceanMap[axisX][axisY].equals("O")){
                System.out.println("That place was already attacked by you or computer.\nPay more attention to map." +
                        "\nYou loose your turn.");
                break;
            }else if(oceanMap[axisX][axisY].equals(" ")){
                oceanMap[axisX][axisY] = "O";
                System.out.println("Whooops! Missed :(");
                break;
            }
        }
    }

    private static void pcTurn(){
        Random random = new Random();
        int axisX = 0;
        int axisY = 0;
        while(true){
            axisX = random.nextInt(10);
            axisY = random.nextInt(10);
            if(oceanMap[axisX][axisY].equals("1")){
                System.out.println("Computer chooses to attack X: " + axisX + ", Y: " + axisY);
                System.out.println("You loose ship.");
                oceanMap[axisX][axisY] = "3";
                playerShips--;
                break;
            }else if(oceanMap[axisX][axisY].equals(" ")){
                System.out.println("Computer chooses to attack X: " + axisX + ", Y: " + axisY);
                System.out.println("Computer missed");
                oceanMap[axisX][axisY] = "O";
                break;
            }
        }
    }

    private static void gameOver(){
        System.out.println("Outome:");
        System.out.println("Player's ships left: " + playerShips);
        System.out.println("Player's ships left: " + pcShips);
        if(playerShips>pcShips){
            System.out.println("Congratulations! You won!");
        }else if(playerShips<pcShips){
            System.out.println("You lost.");
        }else{
            System.out.println("You tied.");
        }
    }

    private static void printOceanMap(){
        System.out.println("   0123456789   ");
        for(int x = 0; x < oceanMap.length; x++){
            System.out.print(x + " |");
            for(int y = 0; y < oceanMap[x].length; y++) {
                switch (oceanMap[x][y]) {
                    case "1":
                        System.out.print("@");
                        break;
                    case "3":
                        System.out.print("X");
                        break;
                    case "O":
                        System.out.print("O");
                        break;
                    default:
                        System.out.print(" ");
                        break;
                }
            }
            System.out.println("| " + x);
        }
        System.out.println("   0123456789   ");
    }
    //For testing purposes to see all map
    private static void printFullOceanMap(){
        System.out.println("   0123456789   ");
        for(int x = 0; x < oceanMap.length; x++){
            System.out.print(x + " |");
            for(int y = 0; y < oceanMap[x].length; y++){
                System.out.print(oceanMap[x][y]);
            }
            System.out.println("| " + x);
        }
        System.out.println("   0123456789   ");
    }
}
