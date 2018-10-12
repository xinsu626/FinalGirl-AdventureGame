import java.util.Random;

public class Flee {

    private Random random = new Random();

    public int next() {
        if (random.nextBoolean()) {
            System.out.println("You successfully fled from the monster.");
            return move.hallway;
        } else {
            System.out.println("You slipped and fell, and the monster attacked.");
            return player.health - 10;
        }
    }

    public static void main(String[] args) {
        Flee f = new Flee();
    }
}
