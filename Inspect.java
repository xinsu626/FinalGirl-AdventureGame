public class Inspect implements Action
{
	public Game game;
	public Item itemInRoom;
	public Monster monsterInRoom;

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
			System.out.print("There is a " + itemInRoom.getName() + " ");

			if (itemInRoom.getCategory().equals("potion")){
				player.incrementHealth(itemInRoom.getAttribute());
				System.out.println(game.getCurrentRoom().getDescription()+"You drink " + itemInRoom.getName() + "! Your health increases by " + itemInRoom.getAttribute());
			}
			else if (itemInRoom.getCategory().equals("weapon")){
				player.setCurrentWeapon(itemInRoom);
			}
			game.getCurrentRoom().killItem();
		}

		player.checkStatus();

//		if (monsterInRoom == null){
//			System.out.print("There are no monsters " + game.getCurrentRoom().getDescription());
//		}

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