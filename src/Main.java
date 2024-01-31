import Heros.Archer;
import Heros.Hero;
import Heros.Knight;
import Heros.Samurai;
import Locations.Cave;
import Locations.Forest;
import Locations.River;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Hero player = null;
    static Cave cave = new Cave();
    static Forest forest = new Forest();
    static River river = new River();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Welcome to the Game. Please, select a hero to start the journey.");

        player = selectingHero();
        setPlayerForLocations(player);

        System.out.println("\nLet's begin to the journey!!");

        System.out.println("\n\nNow you are in your safe house. You can fulfill your health while coming here.");
        locationInfo();
        levelInfo();
        System.out.println("Time to choose where you want to go : ");

        player.setLocationID(askAndCheckLocation());

        sendPlayerToLocation();
    }

    private static void sendPlayerToLocation() {
        switch (player.getLocationID()){
            case 1:
                //sonra doldur buraları safe house a göre
                break;
            case 2:
                //sonra doldur buraları shop a göre
                break;
            case 3:
                cave.levelInfo();
                cave.battle();
                break;
            case 4:
                forest.levelInfo();
                forest.battle();
                break;
            case 5:
                river.levelInfo();
                river.battle();
                break;
        }
    }

    private static int askAndCheckLocation() {
        int locationID = inputLocationID(makeAvailableLocationArray());

        while (locationID == -1){
            System.out.println("You entered something wrong please try again: ");
            locationID = inputLocationID(makeAvailableLocationArray());
        }
        return locationID;
    }

    private static int inputLocationID(ArrayList<Integer> availableLocations) {
        int locationID = input.nextInt();

        for (int i : availableLocations) {
            if (locationID == i){
                return locationID;
            }
        }
        return -1;
    }

    private static ArrayList<Integer> makeAvailableLocationArray() {
        ArrayList<Integer> availableLocations =  new ArrayList<>();

        switch (player.getLocationID()) {
            case 1 -> availableLocations.add(2);
            case 2 -> availableLocations.add(1);
            default -> {
                availableLocations.add(1);
                availableLocations.add(2);
            }
        }
        switch (player.getLevelID()) {
            case 1 -> availableLocations.add(3);
            case 2 -> availableLocations.add(4);
            case 3 -> availableLocations.add(5);
        }

        return availableLocations;
    }

    private static void locationInfo() {
        switch (player.getLocationID()) {
            case 1 -> System.out.println("2- Shop");
            case 2 -> System.out.println("1- Safe House");
            default -> System.out.println("1- Safe House\n2- Shop");
        }
    }

    private static void levelInfo() {
        switch (player.getLevelID()){
            case 1:
                System.out.println("3- Cave");
                break;
            case 2:
                System.out.println("4- Forest");
                break;
            case 3:
                System.out.println("5- River");
                break;
        }
    }

    private static Hero selectingHero() {

        boolean flag = true;

        while (flag){

            System.out.println( "1- Samurai (damage:5 , health:21 , starting money:15)" +
                                "\n2- Archer (damage:7 , health:18 , starting money:20)" +
                                "\n3- Knight (damage:8 , health:24 , starting money:5)");
            System.out.println("Which hero do you want to play with : ");
            int heroID = input.nextInt();

            switch (heroID) {
                case 1:
                    player = new Samurai();
                    flag = false;
                    break;
                case 2:
                    player = new Archer();
                    flag = false;
                    break;
                case 3:
                    player = new Knight();
                    flag = false;
                    break;
                default:
                    System.out.println("You enter a wrong number please try again.\n");
                    break;
            }
        }
        return player;
    }

    private static void setPlayerForLocations(Hero player) {
        cave.setPlayer(player);
        forest.setPlayer(player);
        river.setPlayer(player);
    }
}