package Weapons;

public abstract class Weapon {
    private int price;
    private int damage;
    private boolean isBought;


    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public boolean isBought() {
        return isBought;
    }
    public void setBought(boolean bought) {
        isBought = bought;
    }
}
