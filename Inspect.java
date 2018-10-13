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
			System.out.print("There are no items");
		}
		else
		{
			System.out.print("There is a " + itemInRoom.getName());

			if (itemInRoom.getCategory().equals("potion")){
				player.incrementHealth(itemInRoom.getAttribute());
			}
			else if (itemInRoom.getCategory().equals("weapon")){
				player.setCurrentWeapon(itemInRoom);
			}
		}
		System.out.println(" " + game.getCurrentRoom().getDescription());
		player.checkStatus();

		if (monsterInRoom == null){
			System.out.print("There are no monsters " + game.getCurrentRoom().getDescription());
		}
		else {
			System.out.println("There is a " + monsterInRoom.getName() + " " + game.getCurrentRoom().getDescription());
			return Fight.fight(monsterInRoom, game.getPlayer());
		}
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