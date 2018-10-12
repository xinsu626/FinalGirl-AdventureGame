import java.util.Scanner;
import java.util.Random;

public class Fight
{

	public static void fight(Monster currentMonster, Player currentPlayer)
	{
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		int healthPotionDropPercentage = 50; 

		System.out.println(currentMonster.getName() + " is coming!!!!");
		
		while (currentMonster.getCurrentHealth() > 0)
		{
			currentPlayer.checkStatus();
			currentMonster.checkStatus();
			System.out.println("What would you want to do?");
			System.out.println("1. Attack");
			System.out.println("2. Drink a potion");
			System.out.println("3. Run");

			String userInput = in.nextLine();

			if (userInput.equals("1"))
			{
				int damage = rand.nextInt(currentPlayer.getCurrentWeapon().getAttribute());
				int damageTaken = -rand.nextInt(currentMonster.getCurrentStrength());
				currentMonster.setCurrentHealth(currentMonster.getCurrentHealth() - damage);
				currentPlayer.incrementHealth(damageTaken);
				currentPlayer.checkStatus();
				currentMonster.checkStatus();

				if (currentPlayer.getHealth() < 1)
				{
					System.out.println("You will die soon.");
					break;
				}
			}

			else if (userInput.equals("2"))
			{
				// need to figure out how to run potion
			}

			else if (userInput.equals("3"))
			{
				System.out.println("You have run away");
				continue;
			}

			else
			{
				System.out.println("Wrong input.");
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
	}

}