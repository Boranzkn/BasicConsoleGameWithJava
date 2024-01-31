package Locations;

import Enemys.Enemy;
import Heros.Hero;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class LevelLocations {

    private String trophy;
    private Enemy enemy;
    private int level;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public abstract void battle();
    public abstract ArrayList<Enemy> makeEnemies();
}
