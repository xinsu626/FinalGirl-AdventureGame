import java.util.Scanner;
import java.util.Random;

public class Fight
{
	private static Random rand = new Random();

	public static boolean fight(Monster currentMonster, Player currentPlayer)
	{
		int healthPotionDropPercentage = 50;
		System.out.println(currentMonster.getName() + " is coming!!!!");
		
		while (currentMonster.getCurrentHealth() > 0)
		{
			currentPlayer.checkStatus();
			currentMonster.checkStatus();
			Boolean toFight = UI.agree("Do you want to fight? If you decline, you will attempt to flee.");

			if (toFight)
			{
				int damage = rand.nextInt(currentPlayer.getCurrentWeapon().getAttribute());
				int damageTaken = -rand.nextInt(currentMonster.getCurrentStrength());
				currentMonster.setCurrentHealth(currentMonster.getCurrentHealth() - damage);
				currentPlayer.incrementHealth(damageTaken);
				currentPlayer.checkStatus();
				currentMonster.checkStatus();

				if (currentPlayer.getHealth() <= 0)
				{
					System.out.println("You're dead!");
					return true;
				}
			}
			else
			{
				/*public int next() {
				if (random.nextBoolean()) {
					System.out.println("You successfully fled from the monster.");
					return move.hallway;
				} else {
					System.out.println("You slipped and fell, and the monster attacked.");
					return player.health - 10;
				}*/
				;
			}
		}

		if (currentPlayer.getHealth() < 5)
		{
			System.out.println("Your health is really low.");
		}

		System.out.println("-------------------------------------------");
		System.out.println(currentMonster.getName() + " was defeated!");
		currentPlayer.checkStatus();

		if (rand.nextInt(100) < healthPotionDropPercentage)
		{
			// need to figure out how to run potion
		}

		return false;
	}

}