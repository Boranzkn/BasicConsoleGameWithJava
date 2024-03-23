package Armors;

public abstract class Armor {
    private int price;
    private int damageBlock;
    private boolean isBought;


    public boolean isBought() {
        return isBought;
    }
    public void setBought(boolean bought) {
        isBought = bought;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getDamageBlock() {
        return damageBlock;
    }
    public void setDamageBlock(int damageBlock) {
        this.damageBlock = damageBlock;
    }

}
