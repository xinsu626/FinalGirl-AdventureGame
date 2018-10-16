import java.util.Random;

public class Fight
{
	private static Random random = new Random();

	public static String fight(Player currentPlayer, Room currentRoom)
	{
		Monster currentMonster = currentRoom.getMonster();

		System.out.println(currentMonster.getName() + " is coming!!!!");
		currentPlayer.checkStatus();
		currentMonster.checkStatus();

		while (currentMonster.getCurrentHealth() > 0)
		{
			Boolean toFlee = UI.agree("Do you want to try to flee?");
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
		int damageGiven = random.nextInt(currentPlayer.getCurrentWeapon().getAttribute());
		int damageTaken = currentMonster.getCurrentStrength()*random.nextInt(5);

		currentMonster.setCurrentHealth(currentMonster.getCurrentHealth() - damageGiven);
		currentPlayer.incrementHealth(-damageTaken);

		System.out.println("You took " + damageTaken + " damage and the monster took " + damageGiven + " damage.");
		System.out.println("Your health is now " + currentPlayer.getHealth() + "\nand the monster's health is now " + currentMonster.getCurrentHealth());
		System.out.println("-----------------------");
		if (currentPlayer.getHealth() <= 0)
		{
			System.out.println("You're dead!");
			return true;
		}
		return false;
	}
}