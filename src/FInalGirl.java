import java.util.ArrayList;
import java.util.Scanner;


public class FinalGirl {

    public int health, strength;
    public String name;
    public ArrayList<Item> backpack;

    public FinalGirl() {
        this.name = name;
        backpack = new ArrayList<>();

    }


    public void setName() {
        System.out.println("Enter a name for your player:");
        Scanner keyboard = new Scanner(System.in);
        name = keyboard.nextLine();
        this.name = name;
        System.out.println("Your player's name is now " + name);

    }

     public String getName() {
        return name;

    }

    public void setHealth(int health) {
        this.health = health;

    }

    public void setStrength(int strength) {
            this.strength = strength;
    }

    public int getHealth() {
        return health;

    }


    public int getStrength() {
            return strength;
        }


    public static void main(String [] args) {
        FinalGirl player = new FinalGirl();
        player.setName();

        Weapon slingshot = new Weapon();
        slingshot.setName("slingshot");
        slingshot.setWeight(10);
        player.backpack.add(slingshot);
        System.out.println(player.backpack);




        }
}

