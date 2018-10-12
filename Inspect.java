public class Inspect implements Action
{
	public Room currentRoom;
	public Item itemInRoom;
	public Monster monsterInRoom;
	public Player currentPlayer;

	public Inspect(Room currentRoom, Player currentPlayer)
	{
		this.currentRoom = currentRoom;
		this.currentPlayer = currentPlayer;
	}

	public boolean execute()
	{
		this.itemInRoom = currentRoom.getItem();
		this.monsterInRoom = currentRoom.getMonster();

		if (itemInRoom == null){
			System.out.print("There are no items");
		}
		else
		{
			System.out.print("There is a " + itemInRoom.getName());
			currentPlayer.incrementStrength(itemInRoom.getAttribute());
			System.out.println("You now have " + currentPlayer.strength +" strength.");
		}
		System.out.println(" " + currentRoom.getDescription());

		if (monsterInRoom == null){
			System.out.println("There are no monsters");
		}
		{
			System.out.println("There is a " + monsterInRoom.getName());
			System.out.println("What do you want to do? fight or run.");
		}
		System.out.println(" " + currentRoom.getDescription());

		return false;
	}

	public String help()
	{
		return "please just enter: inspect";
	}

	public String getCommandName(){
		return "inspect";
	}
}