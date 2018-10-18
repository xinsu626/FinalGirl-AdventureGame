/**
 *Provides the player with a list of items and/or monsters
 *in a given room.
 */
public class Inspect implements Action
{
	private Game game;
	private Item itemInRoom;
	private Monster monsterInRoom;

	public Inspect(Game game)
	{
		this.game = game;
	}

	public boolean execute()
	{
		Player player = game.getPlayer();

		itemInRoom = game.getCurrentRoom().getItem();
		monsterInRoom = game.getCurrentRoom().getMonster();

		if (itemInRoom == null){
			System.out.println("There are no items.");
		}
		else
		{
			System.out.println("You found a " + itemInRoom.getName() + " in the room!");

			if (itemInRoom.getCategory().equals("potion")){
				player.incrementHealth(itemInRoom.getAttribute());
				System.out.println(game.getCurrentRoom().getDescription()+"You drink " + itemInRoom.getName() + "! Your health increases by " + itemInRoom.getAttribute() + ".");
			}
			else if (itemInRoom.getCategory().equals("weapon")){
				System.out.println("You take the " + itemInRoom.getName() + ".");
				player.setCurrentWeapon(itemInRoom);
				player.hasPowerWeapon();
			}
			game.getCurrentRoom().killItem();
		}

		player.checkStatus();
		return false;
	}

	public String help()
	{
		return "Enter INSPECT to see the contents of the room.";
	}

	public String getCommandName(){
		return "INSPECT";
	}
}
