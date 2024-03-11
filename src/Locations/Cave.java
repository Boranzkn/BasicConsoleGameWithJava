package Locations;

import Enemys.Bear;
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
    public ArrayList<Enemy> makeEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 1; i <= getEnemyNum(); i++) enemies.add(new Bear());
        return enemies;
    }
}
