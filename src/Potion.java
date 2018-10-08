public class Potion extends Item {

    FinalGirl player;

    public Potion() {

    }

    public void increaseHealth() {
        int health, weight;
        health = player.getHealth();
        weight = Potion.getWeight();

        player.setHealth(health + weight);

    }

}
