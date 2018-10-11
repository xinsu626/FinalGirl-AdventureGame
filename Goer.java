public class Goer implements Response
{
	// declare instance variable
	private Game game;

	public Goer(Game game)
	{
		this.game = game;
	}


	public boolean execute(String[] tokens)
	{
		if (tokens.length == 1)
		{
			System.out.println("Go where? Please enter: go roomName");
			return false;
		}

		String roomName = tokens[1];
		Room nextRoom = game.getNamedRoom(roomName);
		game.setCurrentRoom(nextRoom);
		System.out.println("You are now in " + roomName)

		return false;
	}

	public String getCommandName()
	{
		return "go";
	}

	public String help()
	{
		return "Please enter: go roomName"
	}
