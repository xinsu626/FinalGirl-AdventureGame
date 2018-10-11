public class Inspect implements Action
{
	public Room currentRoom;
	public String itemInRoom;
	public String monsterInRoom;
	public Player currentPlayer;

	public Inspect(Room currentRoom, Player currentPlayer)
	{
		this.currentRoom = currentRoom;
		this.currentPlayer = currentPlayer;
	}

	public boolean execute(String[] tokens)
	{
		this.itemInRoom = currentRoom.getItem();
		this.monsterInRoom = currentRoom.getMonster();
		
		if (itemInRoom != null)
		{
			System.out.println("There is a " + itemInRoom + " in room.");
			currentPlayer.strength +=  itemInRoom.attribute
			System.out.println("You now have " + currentPlayer.strength +" strength.")
		}

		if (monsterInRoom != null)
		{
			System.out.println("There is a " + monsterInRoom.getName() + " in the room.")
			System.out.println("What do you want to do? fight or run.")
		}

		return false;
	}

	public String help()
	{
		return "please just enter: inspect"
	}

	public String getCommandName(){
		return "inspect";
	}
}