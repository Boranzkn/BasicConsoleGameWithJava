package Heros;

import Locations.LevelLocations;
import Locations.Location;

public abstract class Hero {

    private int ID;
    private int damage;
    private int health;
    private int maxHealth;
    private int armor = 0;
    private int money;
    private Location location;
    private int locationID = 1;
    private int levelID = 1;


    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public int getLevelID() {
        return levelID;
    }
    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }
    public int getLocationID() {
        return locationID;
    }
    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) { this.health = health; }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void addMoney(int value){
        setMoney(getMoney() + value);
    }
    public int getArmor() { return armor; }
    public void setArmor(int armor) { this.armor = armor; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    public boolean checkMoneyEnough(int i){
        return getMoney() >= i;
    }
}
