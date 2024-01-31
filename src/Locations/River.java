package Locations;

import Enemys.Bear;
import Enemys.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class River extends LevelLocations{


    public River() {
        setEnemy(new Bear());
        setTrophy("Water");
        Random random = new Random();
        setEnemyNum(random.nextInt(1,4));
        setLevel(3);
        setName("River");

        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 1; i <= getEnemyNum(); i++) enemies.add(new Bear());
    }

    @Override
    public void battle() {

    }

    @Override
    public ArrayList<Enemy> makeEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 1; i <= getEnemyNum(); i++) enemies.add(new Bear());
        return enemies;
    }
}