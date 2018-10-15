import java.util.Random;

public class Fight
{
	private static Random random = new Random();

	public static String fight(Player currentPlayer, Room currentRoom)
	{
		Monster currentMonster = currentRoom.getMonster();

		int healthPotionDropPercentage = 50;
		System.out.println(currentMonster.getName() + " is coming!!!!");
		currentPlayer.checkStatus();
		currentMonster.checkStatus();

		while (currentMonster.getCurrentHealth() > 0)
		{
			Boolean toFlee = UI.agree("Do you want to flee?");
			System.out.println("-------------------");

			if (toFlee){
				if (random.nextBoolean()) {
					System.out.println("You successfully fled from the monster. You're back in the hallways.");
					return "fled";
				} else{
					System.out.println("You slipped and fell, and the monster got a second attack.");
					if (damageTaken(currentPlayer, currentMonster)){
						return "dead";
					}
				}
			}

			if (damageTaken(currentPlayer, currentMonster)){
				return "dead";
			}
		}

		if (currentPlayer.getHealth() < 5)
		{
			System.out.println("Your health is really low.");
		}

		System.out.println("------------------fight over-------------------------");
		System.out.println(currentMonster.getName() + " was defeated!");
		currentRoom.killMonster();
		currentPlayer.checkStatus();

		return "won";
	}

	private static boolean damageTaken(Player currentPlayer, Monster currentMonster){
		int damage = random.nextInt(currentPlayer.getCurrentWeapon().getAttribute());
		int damageTaken = -random.nextInt(currentMonster.getCurrentStrength());

		currentMonster.setCurrentHealth(currentMonster.getCurrentHealth() - damage);
		currentPlayer.incrementHealth(damageTaken);
		currentPlayer.checkStatus();
		currentMonster.checkStatus();

		if (currentPlayer.getHealth() <= 0)
		{
			System.out.println("You're dead!");
			return true;
		}
		return false;
	}
}