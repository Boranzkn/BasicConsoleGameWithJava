package Locations;

import Enemys.Enemy;
import Enemys.Zombie;

import java.util.ArrayList;
import java.util.Random;

public class Cave extends LevelLocations{
    public Cave() {
        setEnemy(new Zombie());
        setTrophy("Food");
        Random random = new Random();
        setEnemyNum(random.nextInt(1,4));
        setLevel(1);
        setName("Cave");
        setEnemies(makeEnemies());
    }

    @Override
    public void battle() {
        int moneyPrize = getEnemyNum() * getEnemy().getMoney();

        System.out.println("Fight is getting started!\n");

        for (int i = 0; i < getEnemyNum(); i++){

            if (i > 0)
                System.out.println("Other Zombie is coming be careful!");

            while (true){

                input.nextLine();
                getEnemies().get(i).setHealth((getEnemies().get(i).getHealth()) - (getPlayer().getDamage()));

                if (getEnemies().get(i).getHealth() == 0){
                    System.out.println("You hit Zombie " + getPlayer().getDamage() + " damage and killed it!");
                    break;
                }
                else
                    System.out.println("You hit Zombie " + getPlayer().getDamage() + " damage and its health is "
                            + getEnemies().get(i).getHealth());

                input.nextLine();

                getPlayer().setHealth((getPlayer().getHealth()) - (getEnemies().get(i).getDamage()));

                if (getPlayer().getHealth() == 0){
                    System.out.println("Zombie hit you " + getEnemies().get(i).getDamage() + " damage and you died!!");
                    System.out.println("GAME OVER");
                    System.exit(0);
                }
                else
                    System.out.println("Zombie hit you " + getEnemies().get(i).getDamage() + " damage and your health is "
                            + getPlayer().getHealth());
            }
        }
        getPlayer().addMoney(moneyPrize);
        System.out.println("\nCongratulations!!! You clear the cave, thank you. You get " + moneyPrize +
                " more money for saving us and now you have " + getPlayer().getMoney() + " money.");
        System.out.println("You won the trophy which is " + getTrophy() + " to finish the game, well done!!!");
    }

    @Override
    public ArrayList<Enemy> makeEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 1; i <= getEnemyNum(); i++) enemies.add(new Zombie());
        return enemies;
    }
}
