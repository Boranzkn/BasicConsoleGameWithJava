package Locations;

import Enemys.Enemy;
import Enemys.Vampire;

import java.util.ArrayList;
import java.util.Random;

public class Forest extends LevelLocations{
    public Forest() {
        setEnemy(new Vampire());
        setTrophy("Firewood");
        Random random = new Random();
        setEnemyNum(random.nextInt(1,4));
        setLevel(2);
        setName("Forest");
        setEnemies(makeEnemies());
    }

    @Override
    public void battle() {

    }

    @Override
    public ArrayList<Enemy> makeEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 1; i <= getEnemyNum(); i++) enemies.add(new Vampire());
        return enemies;
    }
}
