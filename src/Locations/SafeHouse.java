package Locations;

import Heros.Hero;

public class SafeHouse extends Location{
    public SafeHouse() {
        setName("House");
    }

    private Hero player;
    public void setPlayer(Hero player) {
        this.player = player;
    }
    public void info(){
        System.out.println("\nYou rest and your health is now " + player.getHealth() + ".\n");
    }
    public void setPlayerHealth()
    {
        if (player.getHealth() + 10 <= player.getMaxHealth())
        {
            player.setHealth(player.getHealth() + 10);
        }
        else if (player.getHealth() + 10 > player.getMaxHealth())
        {
            player.setHealth(player.getMaxHealth());
        }
    }
}
