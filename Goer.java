import java.util.Scanner;

public class Goer implements Action
{
	// declare instance variable
	private Game game;

	public Goer(Game game)
	{
		this.game = game;
	}


	public boolean execute()
	{
		/*if (tokens.length == 1)
		{
			System.out.println("Go where? Please enter: go roomName");
			return false;
		}*/

		//String roomName = tokens[1];
		//Room nextRoom = game.getNamedRoom(roomName);

		System.out.println("The rooms you can enter are:");
		for (String roomName: game.getRooms().keySet()){
			System.out.println(roomName);
		}

		Scanner in = new Scanner(System.in);
		String nameChosen = in.nextLine().toLowerCase();

		game.setCurrentRoom(game.getRooms().get(nameChosen));
		System.out.println("You are now in " + game.getCurrentRoom());

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
