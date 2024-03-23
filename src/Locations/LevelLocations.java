package Locations;

import Enemys.Enemy;
import Heros.Hero;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class LevelLocations extends Location {

    private String trophy;
    private Enemy enemy;
    private int level;
    private int enemyNum = 0;
    private ArrayList<Enemy> enemies;
    private Hero player;
    Scanner input = new Scanner(System.in);


    public Hero getPlayer() {
        return player;
    }
    public void setPlayer(Hero player) {
        this.player = player;
    }
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
    public int getEnemyNum() {
        return enemyNum;
    }
    public void setEnemyNum(int enemyNum) {
        if (this.enemyNum == 0) {
            this.enemyNum = enemyNum;
        }
    }
    public String getTrophy() {
        return trophy;
    }
    public void setTrophy(String trophy) {
        this.trophy = trophy;
    }
    public Enemy getEnemy() {
        return enemy;
    }
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }



    public void levelInfo(){
        System.out.println("Welcome to the " + getName());
        if (getEnemyNum() == 1){
            System.out.println("There is a " + enemy.getName() + " hear!!!");
        }else {
            System.out.println("There are " + getEnemyNum() + " " + enemy.getName() + "s hear!!!");
        }
    }

    public void battle()
    {
        int moneyPrize = getEnemyNum() * getEnemy().getMoney();
        int enemyDamage = getEnemy().getDamage() - player.getArmor();

        System.out.println("Fight is getting started!\n");

        for (int i = 0; i < getEnemyNum(); i++){

            if (i > 0)
                System.out.println("Other " + getEnemy().getName() + " is coming be careful!");

            while (true){

                input.nextLine();
                getEnemies().get(i).setHealth((getEnemies().get(i).getHealth()) - (getPlayer().getDamage()));

                if (getEnemies().get(i).getHealth() == 0){
                    System.out.println("You hit " + getEnemy().getName() + " " + getPlayer().getDamage() + " damage and killed it!");
                    break;
                }
                else
                    System.out.println("You hit " + getEnemy().getName() + " " + getPlayer().getDamage() + " damage and its health is "
                            + getEnemies().get(i).getHealth());

                input.nextLine();

                getPlayer().setHealth((getPlayer().getHealth()) - (enemyDamage));

                if (getPlayer().getHealth() <= 0){
                    System.out.println(getEnemy().getName() + " hit you " + enemyDamage + " damage and you died!!");
                    System.out.println("GAME OVER");
                    System.exit(0);
                }
                else
                    System.out.println(getEnemy().getName() + " hit you " + enemyDamage + " damage and your health is "
                            + getPlayer().getHealth());
            }
        }
        getPlayer().addMoney(moneyPrize);
        System.out.println("\nCongratulations!!! You clear the " + getName() + ", thank you. You get " + moneyPrize +
                " more money for saving us and now you have " + getPlayer().getMoney() + " money.");

        if (Objects.equals(getTrophy(), "Water"))
        {
            System.out.println("You win!!! Congratulations!!! You saved us from those monsters, thank you!!!");
            System.exit(0);
        }
        else
            System.out.println("You won one of the trophies which is " + getTrophy() + " to finish the game, well done!!!");
    }
    public abstract ArrayList<Enemy> makeEnemies();
}
