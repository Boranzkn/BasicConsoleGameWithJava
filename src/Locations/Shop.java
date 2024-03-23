package Locations;

import Armors.Armor;
import Armors.HeavyArmor;
import Armors.LightArmor;
import Armors.MediumArmor;
import Heros.Hero;
import Weapons.AK47;
import Weapons.DesertEagle;
import Weapons.LightSaber;
import Weapons.Weapon;

import java.util.Objects;
import java.util.Scanner;

public class Shop extends Location{
    public Shop()
    {
        setName("Shop");
    }
    LightArmor LArmor = new LightArmor();
    MediumArmor MArmor = new MediumArmor();
    HeavyArmor HArmor = new HeavyArmor();

    DesertEagle DE = new DesertEagle();
    AK47 AK = new AK47();
    LightSaber LS = new LightSaber();

    private Hero player;
    static Scanner input = new Scanner(System.in);
    public void setPlayer(Hero player) {
        this.player = player;
    }


    public void info(){

        boolean flag = true;

        while (flag) {
            System.out.printf("\nYou got %d money.", player.getMoney());
            System.out.println("\nWelcome to my Shop adventurer. I have some things for you.\n1- Armors\n2- Guns\n3- Exit\nWhich category do you want to buy your item from?\n");
            int category = input.nextInt();
            switch (category){
                case 1:
                    selectArmor();
                    break;
                case 2:
                    selectWeapon();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    errorMSG();
                    break;
            }
        }
    }

    private void selectArmor(){
        boolean flag = true;

        while (flag){

            System.out.println("I got very enduring armors for you. Which one do you want?");
            if (!LArmor.isBought())
                System.out.printf("1- Light Armor (damage block:%d , price: %d)\n", LArmor.getDamageBlock(), LArmor.getPrice());
            if (!MArmor.isBought())
                System.out.printf("2- Medium Armor (damage block:%d , price:%d)\n", MArmor.getDamageBlock(), MArmor.getPrice());
            if (!HArmor.isBought())
                System.out.printf("3- Heavy Armor (damage block:%d , price:%d)\n", HArmor.getDamageBlock(), HArmor.getPrice());
            System.out.println("4- Exit\n");

            int armorID = input.nextInt();

            switch (armorID){
                case 1:
                    if (LArmor.isBought()) {
                        errorMSG();
                        break;
                    }
                    buyingArmor(LArmor);
                    break;
                case 2:
                    if (MArmor.isBought()) {
                        errorMSG();
                        break;
                    }
                    buyingArmor(MArmor);
                    break;
                case 3:
                    if (HArmor.isBought()) {
                        errorMSG();
                        break;
                    }
                    buyingArmor(HArmor);
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    errorMSG();
            }
        }
    }

    private void selectWeapon(){

        boolean flag = true;

        while (flag){

            System.out.println("I got very powerful weapons for you. Which one do you want??");
            if (!DE.isBought())
                System.out.printf("1- Desert Eagle (additional damage:%d , price:%d)\n", DE.getDamage(), DE.getPrice());
            if (!AK.isBought())
                System.out.printf("2- AK47 (additional damage:%d , price:%d)\n", AK.getDamage(), AK.getPrice());
            if (!LS.isBought())
                System.out.printf("3- Light Saber (additional damage:%d , price:%d)\n", LS.getDamage(), LS.getPrice());
            System.out.println("4- Exit");

            int weaponID = input.nextInt();

            switch (weaponID){
                case 1:
                    if (DE.isBought()) {
                        errorMSG();
                        break;
                    }
                    buyingWeapon(DE);
                    break;
                case 2:
                    if (AK.isBought()) {
                        errorMSG();
                        break;
                    }
                    buyingWeapon(AK);
                    break;
                case 3:
                    if (LS.isBought()) {
                        errorMSG();
                        break;
                    }
                    buyingWeapon(LS);
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    errorMSG();
            }
        }
    }

    private void notEnoughMoney(){
        System.out.println("You do not have enough money to buy that.");
    }

    private boolean askPlayerOK(int moneyLeft){

        boolean flag = true;
        boolean returned = true;

        while (flag)
        {
            System.out.printf("\nDo you sure to buy this item? (If you buy, you have %d money left.)\n(Y/N)", moneyLeft);
            String answer = input.next();

            if (Objects.equals(answer, "Y") || Objects.equals(answer, "y")) {
                flag = false;
            }
            else if (Objects.equals(answer, "N") || Objects.equals(answer, "n")){
                returned = false;
                flag = false;
            }
            else errorMSG();
        }
        return returned;
    }

    private void buyingArmor(Armor armor)
    {
        if (player.checkMoneyEnough(armor.getPrice())){
            if (askPlayerOK(player.getMoney() - armor.getPrice()))
            {
                player.setMoney(player.getMoney() - armor.getPrice());
                player.setArmor(player.getArmor() + armor.getDamageBlock());
                armor.setBought(true);
                System.out.printf("You improved your armor to %d and you have %d money left.", player.getArmor(), player.getMoney());
            }
        }
        else
            notEnoughMoney();
    }

    private void buyingWeapon(Weapon weapon)
    {
        if (player.checkMoneyEnough(weapon.getPrice())){
            if (askPlayerOK(player.getMoney() - weapon.getPrice()))
            {
                player.setMoney(player.getMoney() - weapon.getPrice());
                player.setDamage(player.getDamage() + weapon.getDamage());
                weapon.setBought(true);
                System.out.printf("You improved your damage to %d and you have %d money left.", player.getDamage(), player.getMoney());
            }
        }
        else
            notEnoughMoney();
    }

    private void errorMSG(){ System.out.println("You entered something wrong, please try again."); }
}
