package Locations;

import Heros.Hero;

public class SafeHouse {
    private Hero player;
    public void setPlayer(Hero player) {
        this.player = player;
    }
    public void info(){
        System.out.println("You rest and your health is now " + player.getHealth() + ".\n");
    }
}
